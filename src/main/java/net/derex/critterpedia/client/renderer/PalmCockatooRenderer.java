
package net.derex.critterpedia.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.derex.critterpedia.entity.model.PalmCockatooModel;
import net.derex.critterpedia.entity.PalmCockatooEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class PalmCockatooRenderer extends GeoEntityRenderer<PalmCockatooEntity> {
	public PalmCockatooRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new PalmCockatooModel());
		this.shadowRadius = 0.5f;
	}

	@Override
	public RenderType getRenderType(PalmCockatooEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
