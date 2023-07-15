package net.derex.critterpedia.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.derex.critterpedia.entity.GalapgosTortoiseEntity;

public class GalapgosTortoiseModel extends AnimatedGeoModel<GalapgosTortoiseEntity> {
	@Override
	public ResourceLocation getAnimationResource(GalapgosTortoiseEntity entity) {
		return new ResourceLocation("critterpedia", "animations/galapgostortoise.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GalapgosTortoiseEntity entity) {
		return new ResourceLocation("critterpedia", "geo/galapgostortoise.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GalapgosTortoiseEntity entity) {
		return new ResourceLocation("critterpedia", "textures/entities/" + entity.getTexture() + ".png");
	}

}
