package net.derex.critterpedia.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.derex.critterpedia.entity.PalmCockatooEntity;

public class PalmCockatooModel extends AnimatedGeoModel<PalmCockatooEntity> {
	@Override
	public ResourceLocation getAnimationResource(PalmCockatooEntity entity) {
		return new ResourceLocation("critterpedia", "animations/palm_cockatoo.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(PalmCockatooEntity entity) {
		return new ResourceLocation("critterpedia", "geo/palm_cockatoo.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(PalmCockatooEntity entity) {
		return new ResourceLocation("critterpedia", "textures/entities/" + entity.getTexture() + ".png");
	}

}
