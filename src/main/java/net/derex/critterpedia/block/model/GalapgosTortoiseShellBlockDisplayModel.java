package net.derex.critterpedia.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.derex.critterpedia.block.display.GalapgosTortoiseShellBlockDisplayItem;

public class GalapgosTortoiseShellBlockDisplayModel extends AnimatedGeoModel<GalapgosTortoiseShellBlockDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(GalapgosTortoiseShellBlockDisplayItem animatable) {
		return new ResourceLocation("critterpedia", "animations/galapgostortoiseblock.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GalapgosTortoiseShellBlockDisplayItem animatable) {
		return new ResourceLocation("critterpedia", "geo/galapgostortoiseblock.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GalapgosTortoiseShellBlockDisplayItem entity) {
		return new ResourceLocation("critterpedia", "textures/blocks/galapagos.png");
	}
}
