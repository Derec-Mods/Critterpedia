package net.derex.critterpedia.block.renderer;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.derex.critterpedia.block.model.GalapgosTortoiseShellBlockDisplayModel;
import net.derex.critterpedia.block.display.GalapgosTortoiseShellBlockDisplayItem;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class GalapgosTortoiseShellBlockDisplayItemRenderer extends GeoItemRenderer<GalapgosTortoiseShellBlockDisplayItem> {
	public GalapgosTortoiseShellBlockDisplayItemRenderer() {
		super(new GalapgosTortoiseShellBlockDisplayModel());
	}

	@Override
	public RenderType getRenderType(GalapgosTortoiseShellBlockDisplayItem animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
