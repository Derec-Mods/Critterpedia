package net.derex.critterpedia.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.derex.critterpedia.init.CritterpediaModEntities;
import net.derex.critterpedia.entity.GalapgosTortoiseEntity;
import net.derex.critterpedia.CritterpediaMod;

import java.util.Comparator;

public class HatchEggProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		CritterpediaMod.queueServerWork(Mth.nextInt(RandomSource.create(), 20, 30), () -> {
			world.destroyBlock(new BlockPos(x, y, z), false);
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new GalapgosTortoiseEntity(CritterpediaModEntities.GALAPGOS_TORTOISE.get(), _level);
				entityToSpawn.moveTo(x, y, z, 0, 0);
				entityToSpawn.setYBodyRot(0);
				entityToSpawn.setYHeadRot(0);
				entityToSpawn.setDeltaMovement(0, 0, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(entityToSpawn);
			}
			((Entity) world.getEntitiesOfClass(GalapgosTortoiseEntity.class, AABB.ofSize(new Vec3(x, y, z), 1, 1, 1), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)).getPersistentData().putBoolean("hasNotHatched", (false));
			entity.getPersistentData().putDouble("Age", 0);
		});
	}
}
