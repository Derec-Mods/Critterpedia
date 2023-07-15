package net.derex.critterpedia.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class CheckEntityDepthProcedure {
	public static boolean execute(LevelAccessor world, double x, double z) {
		double i = 0;
		i = 0;
		for (int index0 = 0; index0 < (int) (3); index0++) {
			if (world.isEmptyBlock(new BlockPos(x, i, z))) {
				return true;
			}
			i = i + 1;
		}
		return false;
	}
}
