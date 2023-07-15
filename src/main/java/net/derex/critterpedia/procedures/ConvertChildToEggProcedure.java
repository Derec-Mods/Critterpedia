package net.derex.critterpedia.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

import net.derex.critterpedia.init.CritterpediaModBlocks;

public class ConvertChildToEggProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.isBaby() : false) && entity.getPersistentData().getBoolean("hasNotHatched")) {
			if (!entity.level.isClientSide())
				entity.discard();
			if (world.isEmptyBlock(new BlockPos(x, y, z))) {
				world.setBlock(new BlockPos(x, y, z), Blocks.TURTLE_EGG.defaultBlockState(), 3);
			}
		} else if (world.dayTime() >= 13670 || (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 5) {
			if (!entity.isInWater() && Mth.nextInt(RandomSource.create(), 1, 100) <= 1 && !world.isEmptyBlock(new BlockPos(x, y - 1, z))) {
				if (!entity.level.isClientSide())
					entity.discard();
				world.setBlock(new BlockPos(x, y, z), CritterpediaModBlocks.GALAPGOS_TORTOISE_SHELL_BLOCK.get().defaultBlockState(), 3);
			}
		}
	}
}
