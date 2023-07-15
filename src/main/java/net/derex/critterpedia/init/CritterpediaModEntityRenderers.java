
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.derex.critterpedia.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.derex.critterpedia.client.renderer.UpsideDownJellyfishRenderer;
import net.derex.critterpedia.client.renderer.SaltwaterCrocodileRenderer;
import net.derex.critterpedia.client.renderer.RedKneeTarantulaRenderer;
import net.derex.critterpedia.client.renderer.PsychedelicJellyfishRenderer;
import net.derex.critterpedia.client.renderer.PotooRenderer;
import net.derex.critterpedia.client.renderer.PalmCockatooRenderer;
import net.derex.critterpedia.client.renderer.ManOfWarRenderer;
import net.derex.critterpedia.client.renderer.MacaroniPenguinRenderer;
import net.derex.critterpedia.client.renderer.GardenSpiderRenderer;
import net.derex.critterpedia.client.renderer.GalapgosTortoiseRenderer;
import net.derex.critterpedia.client.renderer.EmperorScorpionRenderer;
import net.derex.critterpedia.client.renderer.CommonSnappingTurtleRenderer;
import net.derex.critterpedia.client.renderer.BlackWidowRenderer;
import net.derex.critterpedia.client.renderer.AmericanAlligatorRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CritterpediaModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(CritterpediaModEntities.EMPEROR_SCORPION.get(), EmperorScorpionRenderer::new);
		event.registerEntityRenderer(CritterpediaModEntities.GALAPGOS_TORTOISE.get(), GalapgosTortoiseRenderer::new);
		event.registerEntityRenderer(CritterpediaModEntities.PSYCHEDELIC_JELLYFISH.get(), PsychedelicJellyfishRenderer::new);
		event.registerEntityRenderer(CritterpediaModEntities.BLACK_WIDOW.get(), BlackWidowRenderer::new);
		event.registerEntityRenderer(CritterpediaModEntities.GARDEN_SPIDER.get(), GardenSpiderRenderer::new);
		event.registerEntityRenderer(CritterpediaModEntities.SALTWATER_CROCODILE.get(), SaltwaterCrocodileRenderer::new);
		event.registerEntityRenderer(CritterpediaModEntities.RED_KNEE_TARANTULA.get(), RedKneeTarantulaRenderer::new);
		event.registerEntityRenderer(CritterpediaModEntities.AMERICAN_ALLIGATOR.get(), AmericanAlligatorRenderer::new);
		event.registerEntityRenderer(CritterpediaModEntities.COMMON_SNAPPING_TURTLE.get(), CommonSnappingTurtleRenderer::new);
		event.registerEntityRenderer(CritterpediaModEntities.MAN_OF_WAR.get(), ManOfWarRenderer::new);
		event.registerEntityRenderer(CritterpediaModEntities.UPSIDE_DOWN_JELLYFISH.get(), UpsideDownJellyfishRenderer::new);
		event.registerEntityRenderer(CritterpediaModEntities.PALM_COCKATOO.get(), PalmCockatooRenderer::new);
		event.registerEntityRenderer(CritterpediaModEntities.MACARONI_PENGUIN.get(), MacaroniPenguinRenderer::new);
		event.registerEntityRenderer(CritterpediaModEntities.POTOO.get(), PotooRenderer::new);
	}
}
