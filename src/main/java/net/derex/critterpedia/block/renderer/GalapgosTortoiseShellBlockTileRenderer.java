package net.derex.critterpedia.block.renderer;

import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.derex.critterpedia.block.model.GalapgosTortoiseShellBlockBlockModel;
import net.derex.critterpedia.block.entity.GalapgosTortoiseShellBlockTileEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class GalapgosTortoiseShellBlockTileRenderer extends GeoBlockRenderer<GalapgosTortoiseShellBlockTileEntity> {
	public GalapgosTortoiseShellBlockTileRenderer(BlockEntityRendererProvider.Context rendererDispatcherIn) {
		super(rendererDispatcherIn, new GalapgosTortoiseShellBlockBlockModel());
	}

	@Override
	public RenderType getRenderType(GalapgosTortoiseShellBlockTileEntity animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
