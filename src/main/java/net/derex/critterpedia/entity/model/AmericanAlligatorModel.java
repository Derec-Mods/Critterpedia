package net.derex.critterpedia.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.derex.critterpedia.entity.AmericanAlligatorEntity;

public class AmericanAlligatorModel extends AnimatedGeoModel<AmericanAlligatorEntity> {
	@Override
	public ResourceLocation getAnimationResource(AmericanAlligatorEntity entity) {
		return new ResourceLocation("critterpedia", "animations/americanalligator_gl.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AmericanAlligatorEntity entity) {
		return new ResourceLocation("critterpedia", "geo/americanalligator_gl.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AmericanAlligatorEntity entity) {
		return new ResourceLocation("critterpedia", "textures/entities/" + entity.getTexture() + ".png");
	}

}
