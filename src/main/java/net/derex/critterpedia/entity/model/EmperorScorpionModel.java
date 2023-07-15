package net.derex.critterpedia.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.derex.critterpedia.entity.EmperorScorpionEntity;

public class EmperorScorpionModel extends AnimatedGeoModel<EmperorScorpionEntity> {
	@Override
	public ResourceLocation getAnimationResource(EmperorScorpionEntity entity) {
		return new ResourceLocation("critterpedia", "animations/emperor_scorpion_gl.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(EmperorScorpionEntity entity) {
		return new ResourceLocation("critterpedia", "geo/emperor_scorpion_gl.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(EmperorScorpionEntity entity) {
		return new ResourceLocation("critterpedia", "textures/entities/" + entity.getTexture() + ".png");
	}

}
