package net.derex.critterpedia.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.derex.critterpedia.entity.GardenSpiderEntity;

public class GardenSpiderModel extends AnimatedGeoModel<GardenSpiderEntity> {
	@Override
	public ResourceLocation getAnimationResource(GardenSpiderEntity entity) {
		return new ResourceLocation("critterpedia", "animations/garden_spider_gl.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GardenSpiderEntity entity) {
		return new ResourceLocation("critterpedia", "geo/garden_spider_gl.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GardenSpiderEntity entity) {
		return new ResourceLocation("critterpedia", "textures/entities/" + entity.getTexture() + ".png");
	}

}
