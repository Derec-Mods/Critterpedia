package net.derex.critterpedia.item.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.derex.critterpedia.item.BlackWidowItemItem;

public class BlackWidowItemItemModel extends AnimatedGeoModel<BlackWidowItemItem> {
	@Override
	public ResourceLocation getAnimationResource(BlackWidowItemItem animatable) {
		return new ResourceLocation("critterpedia", "animations/black_widow_gl.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BlackWidowItemItem animatable) {
		return new ResourceLocation("critterpedia", "geo/black_widow_gl.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BlackWidowItemItem animatable) {
		return new ResourceLocation("critterpedia", "textures/items/black_widow.png");
	}
}
