package net.derex.critterpedia.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.derex.critterpedia.entity.CommonSnappingTurtleEntity;

public class CommonSnappingTurtleModel extends AnimatedGeoModel<CommonSnappingTurtleEntity> {
	@Override
	public ResourceLocation getAnimationResource(CommonSnappingTurtleEntity entity) {
		return new ResourceLocation("critterpedia", "animations/commonsnappingturtle_gl.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CommonSnappingTurtleEntity entity) {
		return new ResourceLocation("critterpedia", "geo/commonsnappingturtle_gl.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CommonSnappingTurtleEntity entity) {
		return new ResourceLocation("critterpedia", "textures/entities/" + entity.getTexture() + ".png");
	}

}
