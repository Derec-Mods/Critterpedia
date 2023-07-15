
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.derex.critterpedia.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.derex.critterpedia.world.inventory.SeaGUIMenu;
import net.derex.critterpedia.world.inventory.PrototypeGUIMenu;
import net.derex.critterpedia.world.inventory.MammalGUIMenu;
import net.derex.critterpedia.world.inventory.GUITemplateMenu;
import net.derex.critterpedia.world.inventory.GUIBaseMenu;
import net.derex.critterpedia.world.inventory.FishGUIMenu;
import net.derex.critterpedia.world.inventory.BugGUIMenu;
import net.derex.critterpedia.world.inventory.BirdGUIMenu;
import net.derex.critterpedia.world.inventory.AmphGUIMenu;
import net.derex.critterpedia.CritterpediaMod;

public class CritterpediaModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, CritterpediaMod.MODID);
	public static final RegistryObject<MenuType<PrototypeGUIMenu>> PROTOTYPE_GUI = REGISTRY.register("prototype_gui", () -> IForgeMenuType.create(PrototypeGUIMenu::new));
	public static final RegistryObject<MenuType<GUITemplateMenu>> GUI_TEMPLATE = REGISTRY.register("gui_template", () -> IForgeMenuType.create(GUITemplateMenu::new));
	public static final RegistryObject<MenuType<AmphGUIMenu>> AMPH_GUI = REGISTRY.register("amph_gui", () -> IForgeMenuType.create(AmphGUIMenu::new));
	public static final RegistryObject<MenuType<GUIBaseMenu>> GUI_BASE = REGISTRY.register("gui_base", () -> IForgeMenuType.create(GUIBaseMenu::new));
	public static final RegistryObject<MenuType<FishGUIMenu>> FISH_GUI = REGISTRY.register("fish_gui", () -> IForgeMenuType.create(FishGUIMenu::new));
	public static final RegistryObject<MenuType<BirdGUIMenu>> BIRD_GUI = REGISTRY.register("bird_gui", () -> IForgeMenuType.create(BirdGUIMenu::new));
	public static final RegistryObject<MenuType<BugGUIMenu>> BUG_GUI = REGISTRY.register("bug_gui", () -> IForgeMenuType.create(BugGUIMenu::new));
	public static final RegistryObject<MenuType<MammalGUIMenu>> MAMMAL_GUI = REGISTRY.register("mammal_gui", () -> IForgeMenuType.create(MammalGUIMenu::new));
	public static final RegistryObject<MenuType<SeaGUIMenu>> SEA_GUI = REGISTRY.register("sea_gui", () -> IForgeMenuType.create(SeaGUIMenu::new));
}
