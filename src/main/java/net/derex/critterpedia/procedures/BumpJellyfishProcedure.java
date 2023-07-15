package net.derex.critterpedia.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;

public class BumpJellyfishProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		sourceentity.hurt(DamageSource.SWEET_BERRY_BUSH, 1);
		entity.setDeltaMovement(new Vec3((sourceentity.getDeltaMovement().x() * (-1) * 3), (entity.getDeltaMovement().y()), (sourceentity.getDeltaMovement().z() * (-1) * 3)));
		sourceentity.setDeltaMovement(new Vec3((sourceentity.getDeltaMovement().x()), (sourceentity.getDeltaMovement().y()), (sourceentity.getDeltaMovement().z())));
	}
}
