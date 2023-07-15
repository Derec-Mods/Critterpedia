
package net.derex.critterpedia.entity;

import software.bernie.geckolib3.util.GeckoLibUtil;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.builder.ILoopType.EDefaultLoopTypes;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.IAnimatable;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.common.ForgeMod;

import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.protocol.Packet;
import net.minecraft.core.BlockPos;

import net.derex.critterpedia.procedures.ConvertChildToEggProcedure;
import net.derex.critterpedia.init.CritterpediaModEntities;

import java.util.List;

public class CommonSnappingTurtleEntity extends Animal implements IAnimatable {
	public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(CommonSnappingTurtleEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(CommonSnappingTurtleEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(CommonSnappingTurtleEntity.class, EntityDataSerializers.STRING);
	private AnimationFactory factory = GeckoLibUtil.createFactory(this);
	private boolean swinging;
	private boolean lastloop;
	private long lastSwing;
	public String animationprocedure = "empty";

	public CommonSnappingTurtleEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(CritterpediaModEntities.COMMON_SNAPPING_TURTLE.get(), world);
	}

	public CommonSnappingTurtleEntity(EntityType<CommonSnappingTurtleEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);
		this.setPathfindingMalus(BlockPathTypes.WATER, 0);
		this.moveControl = new MoveControl(this) {
			@Override
			public void tick() {
				if (CommonSnappingTurtleEntity.this.isInWater())
					CommonSnappingTurtleEntity.this.setDeltaMovement(CommonSnappingTurtleEntity.this.getDeltaMovement().add(0, 0.005, 0));
				if (this.operation == MoveControl.Operation.MOVE_TO && !CommonSnappingTurtleEntity.this.getNavigation().isDone()) {
					double dx = this.wantedX - CommonSnappingTurtleEntity.this.getX();
					double dy = this.wantedY - CommonSnappingTurtleEntity.this.getY();
					double dz = this.wantedZ - CommonSnappingTurtleEntity.this.getZ();
					float f = (float) (Mth.atan2(dz, dx) * (double) (180 / Math.PI)) - 90;
					float f1 = (float) (this.speedModifier * CommonSnappingTurtleEntity.this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());
					CommonSnappingTurtleEntity.this.setYRot(this.rotlerp(CommonSnappingTurtleEntity.this.getYRot(), f, 10));
					CommonSnappingTurtleEntity.this.yBodyRot = CommonSnappingTurtleEntity.this.getYRot();
					CommonSnappingTurtleEntity.this.yHeadRot = CommonSnappingTurtleEntity.this.getYRot();
					if (CommonSnappingTurtleEntity.this.isInWater()) {
						CommonSnappingTurtleEntity.this.setSpeed((float) CommonSnappingTurtleEntity.this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());
						float f2 = -(float) (Mth.atan2(dy, (float) Math.sqrt(dx * dx + dz * dz)) * (180 / Math.PI));
						f2 = Mth.clamp(Mth.wrapDegrees(f2), -85, 85);
						CommonSnappingTurtleEntity.this.setXRot(this.rotlerp(CommonSnappingTurtleEntity.this.getXRot(), f2, 5));
						float f3 = Mth.cos(CommonSnappingTurtleEntity.this.getXRot() * (float) (Math.PI / 180.0));
						CommonSnappingTurtleEntity.this.setZza(f3 * f1);
						CommonSnappingTurtleEntity.this.setYya((float) (f1 * dy));
					} else {
						CommonSnappingTurtleEntity.this.setSpeed(f1 * 0.05F);
					}
				} else {
					CommonSnappingTurtleEntity.this.setSpeed(0);
					CommonSnappingTurtleEntity.this.setYya(0);
					CommonSnappingTurtleEntity.this.setZza(0);
				}
			}
		};
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(SHOOT, false);
		this.entityData.define(ANIMATION, "undefined");
		this.entityData.define(TEXTURE, "commonsnappingturtle");
	}

	public void setTexture(String texture) {
		this.entityData.set(TEXTURE, texture);
	}

	public String getTexture() {
		return this.entityData.get(TEXTURE);
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected PathNavigation createNavigation(Level world) {
		return new WaterBoundPathNavigation(this, world);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false) {
			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth();
			}
		});
		this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(3, new RandomSwimmingGoal(this, 5, 40));
		this.goalSelector.addGoal(4, new BreedGoal(this, 1));
	}

	@Override
	public MobType getMobType() {
		return MobType.WATER;
	}

	@Override
	public SoundEvent getAmbientSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.turtle.ambient_land"));
	}

	@Override
	public void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.turtle.shamble")), 0.15f, 1);
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.turtle.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.turtle.death"));
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		if (source == DamageSource.DROWN)
			return false;
		return super.hurt(source, amount);
	}

	@Override
	public void baseTick() {
		super.baseTick();
		ConvertChildToEggProcedure.execute(this.level, this.getX(), this.getY(), this.getZ(), this);
		this.refreshDimensions();
	}

	@Override
	public EntityDimensions getDimensions(Pose p_33597_) {
		return super.getDimensions(p_33597_).scale((float) 1);
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
		CommonSnappingTurtleEntity retval = CritterpediaModEntities.COMMON_SNAPPING_TURTLE.get().create(serverWorld);
		retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null, null);
		return retval;
	}

	@Override
	public boolean isFood(ItemStack stack) {
		return List.of(Blocks.SEAGRASS.asItem()).contains(stack.getItem());
	}

	@Override
	public boolean canBreatheUnderwater() {
		return true;
	}

	@Override
	public boolean checkSpawnObstruction(LevelReader world) {
		return world.isUnobstructed(this);
	}

	@Override
	public boolean isPushedByFluid() {
		return false;
	}

	@Override
	public void aiStep() {
		super.aiStep();
		this.updateSwingTime();
	}

	public static void init() {
		SpawnPlacements.register(CritterpediaModEntities.COMMON_SNAPPING_TURTLE.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos, random) -> (world.getBlockState(pos).is(Blocks.WATER) && world.getBlockState(pos.above()).is(Blocks.WATER)));
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.19999999999999998);
		builder = builder.add(Attributes.MAX_HEALTH, 10);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		builder = builder.add(ForgeMod.SWIM_SPEED.get(), 0.19999999999999998);
		return builder;
	}

	private <E extends IAnimatable> PlayState movementPredicate(AnimationEvent<E> event) {
		if (this.animationprocedure.equals("empty")) {
			if ((event.isMoving() || !(event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F))

			) {
				event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.CommonSnappingTurtle.walk", EDefaultLoopTypes.LOOP));
				return PlayState.CONTINUE;
			}
			if (this.isInWaterOrBubble()) {
				event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.CommonSnappingTurtle.swim", EDefaultLoopTypes.LOOP));
				return PlayState.CONTINUE;
			}
			if (this.isSprinting()) {
				event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.CommonSnappingTurtle.walk", EDefaultLoopTypes.LOOP));
				return PlayState.CONTINUE;
			}
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.CommonSnappingTurtle.idle", EDefaultLoopTypes.LOOP));
			return PlayState.CONTINUE;
		}
		return PlayState.STOP;
	}

	private <E extends IAnimatable> PlayState attackingPredicate(AnimationEvent<E> event) {
		double d1 = this.getX() - this.xOld;
		double d0 = this.getZ() - this.zOld;
		float velocity = (float) Math.sqrt(d1 * d1 + d0 * d0);
		if (getAttackAnim(event.getPartialTick()) > 0f && !this.swinging) {
			this.swinging = true;
			this.lastSwing = level.getGameTime();
		}
		if (this.swinging && this.lastSwing + 15L <= level.getGameTime()) {
			this.swinging = false;
		}
		if (this.swinging && event.getController().getAnimationState().equals(software.bernie.geckolib3.core.AnimationState.Stopped)) {
			event.getController().markNeedsReload();
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.CommonSnappingTurtle.attack", EDefaultLoopTypes.PLAY_ONCE));
			return PlayState.CONTINUE;
		}
		return PlayState.CONTINUE;
	}

	private <E extends IAnimatable> PlayState procedurePredicate(AnimationEvent<E> event) {
		Entity entity = this;
		Level world = entity.level;
		boolean loop = false;
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		if (!loop && this.lastloop) {
			this.lastloop = false;
			event.getController().setAnimation(new AnimationBuilder().addAnimation(this.animationprocedure, EDefaultLoopTypes.PLAY_ONCE));
			event.getController().clearAnimationCache();
			return PlayState.STOP;
		}
		if (!this.animationprocedure.equals("empty") && event.getController().getAnimationState().equals(software.bernie.geckolib3.core.AnimationState.Stopped)) {
			if (!loop) {
				event.getController().setAnimation(new AnimationBuilder().addAnimation(this.animationprocedure, EDefaultLoopTypes.PLAY_ONCE));
				if (event.getController().getAnimationState().equals(software.bernie.geckolib3.core.AnimationState.Stopped)) {
					this.animationprocedure = "empty";
					event.getController().markNeedsReload();
				}
			} else {
				event.getController().setAnimation(new AnimationBuilder().addAnimation(this.animationprocedure, EDefaultLoopTypes.LOOP));
				this.lastloop = true;
			}
		}
		return PlayState.CONTINUE;
	}

	@Override
	protected void tickDeath() {
		++this.deathTime;
		if (this.deathTime == 20) {
			this.remove(CommonSnappingTurtleEntity.RemovalReason.KILLED);
			this.dropExperience();
		}
	}

	public String getSyncedAnimation() {
		return this.entityData.get(ANIMATION);
	}

	public void setAnimation(String animation) {
		this.entityData.set(ANIMATION, animation);
	}

	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController<>(this, "movement", 4, this::movementPredicate));
		data.addAnimationController(new AnimationController<>(this, "attacking", 4, this::attackingPredicate));
		data.addAnimationController(new AnimationController<>(this, "procedure", 4, this::procedurePredicate));
	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}
}
