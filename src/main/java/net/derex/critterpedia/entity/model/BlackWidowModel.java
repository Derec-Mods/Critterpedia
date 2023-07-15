package net.derex.critterpedia.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.derex.critterpedia.entity.BlackWidowEntity;

public class BlackWidowModel extends AnimatedGeoModel<BlackWidowEntity> {
	@Override
	public ResourceLocation getAnimationResource(BlackWidowEntity entity) {
		return new ResourceLocation("critterpedia", "animations/black_widow_gl.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BlackWidowEntity entity) {
		return new ResourceLocation("critterpedia", "geo/black_widow_gl.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BlackWidowEntity entity) {
		return new ResourceLocation("critterpedia", "textures/entities/" + entity.getTexture() + ".png");
	}

}
