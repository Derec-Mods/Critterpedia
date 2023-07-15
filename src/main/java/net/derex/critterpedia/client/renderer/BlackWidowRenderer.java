
package net.derex.critterpedia.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.derex.critterpedia.entity.model.BlackWidowModel;
import net.derex.critterpedia.entity.BlackWidowEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class BlackWidowRenderer extends GeoEntityRenderer<BlackWidowEntity> {
	public BlackWidowRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new BlackWidowModel());
		this.shadowRadius = 0.3f;
	}

	@Override
	public RenderType getRenderType(BlackWidowEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
