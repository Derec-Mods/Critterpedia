package net.derex.critterpedia.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.derex.critterpedia.entity.MacaroniPenguinEntity;

public class MacaroniPenguinModel extends AnimatedGeoModel<MacaroniPenguinEntity> {
	@Override
	public ResourceLocation getAnimationResource(MacaroniPenguinEntity entity) {
		return new ResourceLocation("critterpedia", "animations/macaronipenguin.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MacaroniPenguinEntity entity) {
		return new ResourceLocation("critterpedia", "geo/macaronipenguin.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MacaroniPenguinEntity entity) {
		return new ResourceLocation("critterpedia", "textures/entities/" + entity.getTexture() + ".png");
	}

}
