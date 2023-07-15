package net.derex.critterpedia.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.derex.critterpedia.entity.RedKneeTarantulaEntity;

public class RedKneeTarantulaModel extends AnimatedGeoModel<RedKneeTarantulaEntity> {
	@Override
	public ResourceLocation getAnimationResource(RedKneeTarantulaEntity entity) {
		return new ResourceLocation("critterpedia", "animations/red_knee_tarantulagl.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(RedKneeTarantulaEntity entity) {
		return new ResourceLocation("critterpedia", "geo/red_knee_tarantulagl.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(RedKneeTarantulaEntity entity) {
		return new ResourceLocation("critterpedia", "textures/entities/" + entity.getTexture() + ".png");
	}

}
