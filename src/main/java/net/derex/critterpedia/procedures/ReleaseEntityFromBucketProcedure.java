package net.derex.critterpedia.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.derex.critterpedia.init.CritterpediaModItems;
import net.derex.critterpedia.init.CritterpediaModEntities;
import net.derex.critterpedia.entity.UpsideDownJellyfishEntity;
import net.derex.critterpedia.entity.PsychedelicJellyfishEntity;

public class ReleaseEntityFromBucketProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Direction direction, Entity entity, ItemStack itemstack) {
		if (direction == null || entity == null)
			return;
		double raytrace_y = 0;
		double raytrace_x = 0;
		double raytrace_z = 0;
		BlockState clickedBlock = Blocks.AIR.defaultBlockState();
		if ((new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
				} else if (_ent.level.isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
				}
				return false;
			}
		}.checkGamemode(entity)) == false) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = itemstack;
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(Items.BUCKET);
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		}
		if (Math.random() > 5) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.empty_fish")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.empty_fish")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
		} else {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.empty_fish")), SoundSource.NEUTRAL, 1, (float) 0.9);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.empty_fish")), SoundSource.NEUTRAL, 1, (float) 0.9, false);
				}
			}
		}
		if (direction == Direction.UP && ((world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == Blocks.WATER || (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == Blocks.WATER
				|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == Blocks.BUBBLE_COLUMN || (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == Blocks.AIR
				|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == Blocks.CAVE_AIR)) {
			world.setBlock(new BlockPos(x, y + 1, z), Blocks.WATER.defaultBlockState(), 3);
			if (itemstack.getItem() == CritterpediaModItems.PSYCHEDELIC_JELLYFISH_BUCKET.get()) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new PsychedelicJellyfishEntity(CritterpediaModEntities.PSYCHEDELIC_JELLYFISH.get(), _level);
					entityToSpawn.moveTo((x + 0.5), (y + 1), (z + 0.5), 0, 0);
					entityToSpawn.setYBodyRot(0);
					entityToSpawn.setYHeadRot(0);
					entityToSpawn.setDeltaMovement(0, 0, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					world.addFreshEntity(entityToSpawn);
				}
			} else if (itemstack.getItem() == CritterpediaModItems.UPSIDEDOWN_JELLYFISH_BUCKET.get()) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new UpsideDownJellyfishEntity(CritterpediaModEntities.UPSIDE_DOWN_JELLYFISH.get(), _level);
					entityToSpawn.moveTo((x + 0.5), (y + 1), (z + 0.5), 0, 0);
					entityToSpawn.setYBodyRot(0);
					entityToSpawn.setYHeadRot(0);
					entityToSpawn.setDeltaMovement(0, 0, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					world.addFreshEntity(entityToSpawn);
				}
			}
		} else if (direction == Direction.DOWN && ((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.WATER || (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.WATER
				|| (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.BUBBLE_COLUMN || (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.AIR
				|| (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.CAVE_AIR)) {
			world.setBlock(new BlockPos(x, y - 1, z), Blocks.WATER.defaultBlockState(), 3);
			if (itemstack.getItem() == CritterpediaModItems.PSYCHEDELIC_JELLYFISH_BUCKET.get()) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new PsychedelicJellyfishEntity(CritterpediaModEntities.PSYCHEDELIC_JELLYFISH.get(), _level);
					entityToSpawn.moveTo((x + 0.5), (y - 1), (z + 0.5), 0, 0);
					entityToSpawn.setYBodyRot(0);
					entityToSpawn.setYHeadRot(0);
					entityToSpawn.setDeltaMovement(0, 0, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					world.addFreshEntity(entityToSpawn);
				}
			} else if (itemstack.getItem() == CritterpediaModItems.UPSIDEDOWN_JELLYFISH_BUCKET.get()) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new UpsideDownJellyfishEntity(CritterpediaModEntities.UPSIDE_DOWN_JELLYFISH.get(), _level);
					entityToSpawn.moveTo((x + 0.5), (y - 1), (z + 0.5), 0, 0);
					entityToSpawn.setYBodyRot(0);
					entityToSpawn.setYHeadRot(0);
					entityToSpawn.setDeltaMovement(0, 0, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					world.addFreshEntity(entityToSpawn);
				}
			}
		} else if (direction == Direction.NORTH && ((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.WATER || (world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.WATER
				|| (world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.BUBBLE_COLUMN || (world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.AIR
				|| (world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.CAVE_AIR)) {
			world.setBlock(new BlockPos(x, y, z - 1), Blocks.WATER.defaultBlockState(), 3);
			if (itemstack.getItem() == CritterpediaModItems.PSYCHEDELIC_JELLYFISH_BUCKET.get()) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new PsychedelicJellyfishEntity(CritterpediaModEntities.PSYCHEDELIC_JELLYFISH.get(), _level);
					entityToSpawn.moveTo((x + 0.5), y, (z - 0.5), 0, 0);
					entityToSpawn.setYBodyRot(0);
					entityToSpawn.setYHeadRot(0);
					entityToSpawn.setDeltaMovement(0, 0, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					world.addFreshEntity(entityToSpawn);
				}
			} else if (itemstack.getItem() == CritterpediaModItems.UPSIDEDOWN_JELLYFISH_BUCKET.get()) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new UpsideDownJellyfishEntity(CritterpediaModEntities.UPSIDE_DOWN_JELLYFISH.get(), _level);
					entityToSpawn.moveTo((x + 0.5), y, (z - 0.5), 0, 0);
					entityToSpawn.setYBodyRot(0);
					entityToSpawn.setYHeadRot(0);
					entityToSpawn.setDeltaMovement(0, 0, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					world.addFreshEntity(entityToSpawn);
				}
			}
		} else if (direction == Direction.EAST && ((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == Blocks.WATER || (world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == Blocks.WATER
				|| (world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == Blocks.BUBBLE_COLUMN || (world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == Blocks.AIR
				|| (world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == Blocks.CAVE_AIR)) {
			world.setBlock(new BlockPos(x + 1, y, z), Blocks.WATER.defaultBlockState(), 3);
			if (itemstack.getItem() == CritterpediaModItems.PSYCHEDELIC_JELLYFISH_BUCKET.get()) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new PsychedelicJellyfishEntity(CritterpediaModEntities.PSYCHEDELIC_JELLYFISH.get(), _level);
					entityToSpawn.moveTo((x + 1.5), y, (z + 0.5), 0, 0);
					entityToSpawn.setYBodyRot(0);
					entityToSpawn.setYHeadRot(0);
					entityToSpawn.setDeltaMovement(0, 0, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					world.addFreshEntity(entityToSpawn);
				}
			} else if (itemstack.getItem() == CritterpediaModItems.UPSIDEDOWN_JELLYFISH_BUCKET.get()) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new UpsideDownJellyfishEntity(CritterpediaModEntities.UPSIDE_DOWN_JELLYFISH.get(), _level);
					entityToSpawn.moveTo((x + 1.5), y, (z + 0.5), 0, 0);
					entityToSpawn.setYBodyRot(0);
					entityToSpawn.setYHeadRot(0);
					entityToSpawn.setDeltaMovement(0, 0, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					world.addFreshEntity(entityToSpawn);
				}
			}
		} else if (direction == Direction.SOUTH && ((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == Blocks.WATER || (world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == Blocks.WATER
				|| (world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == Blocks.BUBBLE_COLUMN || (world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == Blocks.AIR
				|| (world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == Blocks.CAVE_AIR)) {
			world.setBlock(new BlockPos(x, y, z + 1), Blocks.WATER.defaultBlockState(), 3);
			if (itemstack.getItem() == CritterpediaModItems.PSYCHEDELIC_JELLYFISH_BUCKET.get()) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new PsychedelicJellyfishEntity(CritterpediaModEntities.PSYCHEDELIC_JELLYFISH.get(), _level);
					entityToSpawn.moveTo((x + 0.5), y, (z + 1.5), 0, 0);
					entityToSpawn.setYBodyRot(0);
					entityToSpawn.setYHeadRot(0);
					entityToSpawn.setDeltaMovement(0, 0, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					world.addFreshEntity(entityToSpawn);
				}
			} else if (itemstack.getItem() == CritterpediaModItems.UPSIDEDOWN_JELLYFISH_BUCKET.get()) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new UpsideDownJellyfishEntity(CritterpediaModEntities.UPSIDE_DOWN_JELLYFISH.get(), _level);
					entityToSpawn.moveTo((x + 0.5), y, (z + 1.5), 0, 0);
					entityToSpawn.setYBodyRot(0);
					entityToSpawn.setYHeadRot(0);
					entityToSpawn.setDeltaMovement(0, 0, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					world.addFreshEntity(entityToSpawn);
				}
			}
		} else if (direction == Direction.WEST && ((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == Blocks.WATER || (world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == Blocks.WATER
				|| (world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == Blocks.BUBBLE_COLUMN || (world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == Blocks.AIR
				|| (world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == Blocks.CAVE_AIR)) {
			world.setBlock(new BlockPos(x - 1, y, z), Blocks.WATER.defaultBlockState(), 3);
			if (itemstack.getItem() == CritterpediaModItems.PSYCHEDELIC_JELLYFISH_BUCKET.get()) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new PsychedelicJellyfishEntity(CritterpediaModEntities.PSYCHEDELIC_JELLYFISH.get(), _level);
					entityToSpawn.moveTo((x - 0.5), y, (z + 0.5), 0, 0);
					entityToSpawn.setYBodyRot(0);
					entityToSpawn.setYHeadRot(0);
					entityToSpawn.setDeltaMovement(0, 0, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					world.addFreshEntity(entityToSpawn);
				}
			} else if (itemstack.getItem() == CritterpediaModItems.UPSIDEDOWN_JELLYFISH_BUCKET.get()) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new UpsideDownJellyfishEntity(CritterpediaModEntities.UPSIDE_DOWN_JELLYFISH.get(), _level);
					entityToSpawn.moveTo((x - 0.5), y, (z + 0.5), 0, 0);
					entityToSpawn.setYBodyRot(0);
					entityToSpawn.setYHeadRot(0);
					entityToSpawn.setDeltaMovement(0, 0, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					world.addFreshEntity(entityToSpawn);
				}
			}
		}
	}
}
