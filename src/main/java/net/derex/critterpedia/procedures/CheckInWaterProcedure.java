package net.derex.critterpedia.procedures;

import net.minecraft.world.entity.Entity;

public class CheckInWaterProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.isInWater()) {
			return true;
		}
		return false;
	}
}
