
package net.derex.critterpedia.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.derex.critterpedia.entity.model.EmperorScorpionModel;
import net.derex.critterpedia.entity.EmperorScorpionEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class EmperorScorpionRenderer extends GeoEntityRenderer<EmperorScorpionEntity> {
	public EmperorScorpionRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new EmperorScorpionModel());
		this.shadowRadius = 0.3f;
	}

	@Override
	public RenderType getRenderType(EmperorScorpionEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
