
package net.derex.critterpedia.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.derex.critterpedia.entity.model.SaltwaterCrocodileModel;
import net.derex.critterpedia.entity.SaltwaterCrocodileEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class SaltwaterCrocodileRenderer extends GeoEntityRenderer<SaltwaterCrocodileEntity> {
	public SaltwaterCrocodileRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new SaltwaterCrocodileModel());
		this.shadowRadius = 0.5f;
	}

	@Override
	public RenderType getRenderType(SaltwaterCrocodileEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
