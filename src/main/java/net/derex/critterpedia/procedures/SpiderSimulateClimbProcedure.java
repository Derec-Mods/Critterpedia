package net.derex.critterpedia.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.derex.critterpedia.init.CritterpediaModParticleTypes;

public class SpiderSimulateClimbProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean climbing = false;
		climbing = false;
		if ((entity.getDirection()) == Direction.NORTH) {
			if (world.getBlockState(new BlockPos(x, y, z - 0.4)).canOcclude()) {
				climbing = true;
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), 0.2, (entity.getDeltaMovement().z())));
			}
		} else if ((entity.getDirection()) == Direction.SOUTH) {
			if (world.getBlockState(new BlockPos(x, y, z + 0.4)).canOcclude()) {
				climbing = true;
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), 0.2, (entity.getDeltaMovement().z())));
			}
		} else if ((entity.getDirection()) == Direction.EAST) {
			if (world.getBlockState(new BlockPos(x + 0.4, y, z)).canOcclude()) {
				climbing = true;
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), 0.2, (entity.getDeltaMovement().z())));
			}
		} else if ((entity.getDirection()) == Direction.WEST) {
			if (world.getBlockState(new BlockPos(x - 0.4, y, z)).canOcclude()) {
				climbing = true;
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), 0.2, (entity.getDeltaMovement().z())));
			}
		}
		if (!climbing && world.isEmptyBlock(new BlockPos(x, y, z)) && world.isEmptyBlock(new BlockPos(x, y - 1, z)) && world.isEmptyBlock(new BlockPos(x, y - 2, z))) {
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 60, 2, (false), (false)));
			entity.fallDistance = 5;
			world.addParticle((SimpleParticleType) (CritterpediaModParticleTypes.SPIDERWEB_PARTICLE.get()), x, y, z, 0, 0, 0);
		}
	}
}
