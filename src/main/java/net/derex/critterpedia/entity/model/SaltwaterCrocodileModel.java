package net.derex.critterpedia.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.derex.critterpedia.entity.SaltwaterCrocodileEntity;

public class SaltwaterCrocodileModel extends AnimatedGeoModel<SaltwaterCrocodileEntity> {
	@Override
	public ResourceLocation getAnimationResource(SaltwaterCrocodileEntity entity) {
		return new ResourceLocation("critterpedia", "animations/saltwatercrocgl.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SaltwaterCrocodileEntity entity) {
		return new ResourceLocation("critterpedia", "geo/saltwatercrocgl.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SaltwaterCrocodileEntity entity) {
		return new ResourceLocation("critterpedia", "textures/entities/" + entity.getTexture() + ".png");
	}

}
