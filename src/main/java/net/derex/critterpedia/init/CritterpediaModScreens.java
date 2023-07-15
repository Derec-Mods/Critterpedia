
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.derex.critterpedia.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.derex.critterpedia.client.gui.SeaGUIScreen;
import net.derex.critterpedia.client.gui.PrototypeGUIScreen;
import net.derex.critterpedia.client.gui.MammalGUIScreen;
import net.derex.critterpedia.client.gui.GUITemplateScreen;
import net.derex.critterpedia.client.gui.GUIBaseScreen;
import net.derex.critterpedia.client.gui.FishGUIScreen;
import net.derex.critterpedia.client.gui.BugGUIScreen;
import net.derex.critterpedia.client.gui.BirdGUIScreen;
import net.derex.critterpedia.client.gui.AmphGUIScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CritterpediaModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(CritterpediaModMenus.PROTOTYPE_GUI.get(), PrototypeGUIScreen::new);
			MenuScreens.register(CritterpediaModMenus.GUI_TEMPLATE.get(), GUITemplateScreen::new);
			MenuScreens.register(CritterpediaModMenus.AMPH_GUI.get(), AmphGUIScreen::new);
			MenuScreens.register(CritterpediaModMenus.GUI_BASE.get(), GUIBaseScreen::new);
			MenuScreens.register(CritterpediaModMenus.FISH_GUI.get(), FishGUIScreen::new);
			MenuScreens.register(CritterpediaModMenus.BIRD_GUI.get(), BirdGUIScreen::new);
			MenuScreens.register(CritterpediaModMenus.BUG_GUI.get(), BugGUIScreen::new);
			MenuScreens.register(CritterpediaModMenus.MAMMAL_GUI.get(), MammalGUIScreen::new);
			MenuScreens.register(CritterpediaModMenus.SEA_GUI.get(), SeaGUIScreen::new);
		});
	}
}
