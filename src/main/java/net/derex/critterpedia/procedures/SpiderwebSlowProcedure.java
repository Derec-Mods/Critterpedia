package net.derex.critterpedia.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;

import net.derex.critterpedia.entity.BlackWidowEntity;

public class SpiderwebSlowProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof BlackWidowEntity) {
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 10, 5, (false), (false)));
		} else if (entity.getType().is(TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation("forge:bug")))) {
			entity.hurt(DamageSource.MAGIC, 50);
		}
	}
}
