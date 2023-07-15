package net.derex.critterpedia.block.listener;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.derex.critterpedia.init.CritterpediaModBlockEntities;
import net.derex.critterpedia.block.renderer.GalapgosTortoiseShellBlockTileRenderer;
import net.derex.critterpedia.CritterpediaMod;

@Mod.EventBusSubscriber(modid = CritterpediaMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientListener {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer(CritterpediaModBlockEntities.GALAPGOS_TORTOISE_SHELL_BLOCK.get(), GalapgosTortoiseShellBlockTileRenderer::new);
	}
}
