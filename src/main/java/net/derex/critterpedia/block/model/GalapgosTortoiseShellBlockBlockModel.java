package net.derex.critterpedia.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.derex.critterpedia.block.entity.GalapgosTortoiseShellBlockTileEntity;

public class GalapgosTortoiseShellBlockBlockModel extends AnimatedGeoModel<GalapgosTortoiseShellBlockTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(GalapgosTortoiseShellBlockTileEntity animatable) {
		return new ResourceLocation("critterpedia", "animations/galapgostortoiseblock.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GalapgosTortoiseShellBlockTileEntity animatable) {
		return new ResourceLocation("critterpedia", "geo/galapgostortoiseblock.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GalapgosTortoiseShellBlockTileEntity entity) {
		return new ResourceLocation("critterpedia", "textures/blocks/galapagos.png");
	}
}
