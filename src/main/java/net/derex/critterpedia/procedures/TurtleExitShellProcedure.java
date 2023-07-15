package net.derex.critterpedia.procedures;

import net.minecraftforge.server.ServerLifecycleHooks;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.MinecraftServer;
import net.minecraft.network.chat.Component;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.derex.critterpedia.network.CritterpediaModVariables;
import net.derex.critterpedia.init.CritterpediaModEntities;
import net.derex.critterpedia.entity.GalapgosTortoiseEntity;
import net.derex.critterpedia.CritterpediaMod;

public class TurtleExitShellProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if (!((blockstate.getBlock().getStateDefinition().getProperty("animation") instanceof IntegerProperty _getip1 ? blockstate.getValue(_getip1) : -1) == 1)) {
			{
				int _value = 1;
				BlockPos _pos = new BlockPos(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("animation") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
			CritterpediaMod.queueServerWork(150, () -> {
				world.destroyBlock(new BlockPos(x, y, z), false);
				if (CritterpediaModVariables.MapVariables.get(world).devMode) {
					if (!world.isClientSide()) {
						MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
						if (_mcserv != null)
							_mcserv.getPlayerList().broadcastSystemMessage(Component.literal(("Direction: " + (new Object() {
								public Direction getDirection(BlockState _bs) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
									if (_prop instanceof DirectionProperty _dp)
										return _bs.getValue(_dp);
									_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
									return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
											? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
											: Direction.NORTH;
								}
							}.getDirection(blockstate)))), false);
					}
				}
				if ((new Object() {
					public Direction getDirection(BlockState _bs) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (_prop instanceof DirectionProperty _dp)
							return _bs.getValue(_dp);
						_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
						return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
								? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
								: Direction.NORTH;
					}
				}.getDirection(blockstate)) == Direction.SOUTH) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = new GalapgosTortoiseEntity(CritterpediaModEntities.GALAPGOS_TORTOISE.get(), _level);
						entityToSpawn.moveTo((x + 0.5), y, (z - 0.5), 0, 0);
						entityToSpawn.setYBodyRot(0);
						entityToSpawn.setYHeadRot(0);
						entityToSpawn.setDeltaMovement(0, 0, 0);
						if (entityToSpawn instanceof Mob _mobToSpawn)
							_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
						world.addFreshEntity(entityToSpawn);
					}
				} else if ((new Object() {
					public Direction getDirection(BlockState _bs) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (_prop instanceof DirectionProperty _dp)
							return _bs.getValue(_dp);
						_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
						return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
								? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
								: Direction.NORTH;
					}
				}.getDirection(blockstate)) == Direction.WEST) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = new GalapgosTortoiseEntity(CritterpediaModEntities.GALAPGOS_TORTOISE.get(), _level);
						entityToSpawn.moveTo((x + 0.5), y, (z + 0.5), 90, 0);
						entityToSpawn.setYBodyRot(90);
						entityToSpawn.setYHeadRot(90);
						entityToSpawn.setDeltaMovement(0, 0, 0);
						if (entityToSpawn instanceof Mob _mobToSpawn)
							_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
						world.addFreshEntity(entityToSpawn);
					}
				} else if ((new Object() {
					public Direction getDirection(BlockState _bs) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (_prop instanceof DirectionProperty _dp)
							return _bs.getValue(_dp);
						_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
						return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
								? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
								: Direction.NORTH;
					}
				}.getDirection(blockstate)) == Direction.NORTH) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = new GalapgosTortoiseEntity(CritterpediaModEntities.GALAPGOS_TORTOISE.get(), _level);
						entityToSpawn.moveTo((x + 0.5), y, (z + 0.5), 180, 0);
						entityToSpawn.setYBodyRot(180);
						entityToSpawn.setYHeadRot(180);
						entityToSpawn.setDeltaMovement(0, 0, 0);
						if (entityToSpawn instanceof Mob _mobToSpawn)
							_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
						world.addFreshEntity(entityToSpawn);
					}
				} else if ((new Object() {
					public Direction getDirection(BlockState _bs) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (_prop instanceof DirectionProperty _dp)
							return _bs.getValue(_dp);
						_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
						return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
								? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
								: Direction.NORTH;
					}
				}.getDirection(blockstate)) == Direction.EAST) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = new GalapgosTortoiseEntity(CritterpediaModEntities.GALAPGOS_TORTOISE.get(), _level);
						entityToSpawn.moveTo((x + 0.5), y, (z + 0.5), -90, 0);
						entityToSpawn.setYBodyRot(-90);
						entityToSpawn.setYHeadRot(-90);
						entityToSpawn.setDeltaMovement(0, 0, 0);
						if (entityToSpawn instanceof Mob _mobToSpawn)
							_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
						world.addFreshEntity(entityToSpawn);
					}
				}
			});
		}
	}
}
