package net.derex.critterpedia.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.derex.critterpedia.entity.PotooEntity;

public class PotooModel extends AnimatedGeoModel<PotooEntity> {
	@Override
	public ResourceLocation getAnimationResource(PotooEntity entity) {
		return new ResourceLocation("critterpedia", "animations/potoo_gl.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(PotooEntity entity) {
		return new ResourceLocation("critterpedia", "geo/potoo_gl.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(PotooEntity entity) {
		return new ResourceLocation("critterpedia", "textures/entities/" + entity.getTexture() + ".png");
	}

}
