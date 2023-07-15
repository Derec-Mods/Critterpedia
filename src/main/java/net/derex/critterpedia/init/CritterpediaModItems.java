
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.derex.critterpedia.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.derex.critterpedia.item.UpsidedownJellyfishBucketItem;
import net.derex.critterpedia.item.PsychedelicJellyfishBucketItem;
import net.derex.critterpedia.item.LargeFishingRodItem;
import net.derex.critterpedia.item.InsectNetItem;
import net.derex.critterpedia.item.FishingPoleItem;
import net.derex.critterpedia.item.BlackWidowItemItem;
import net.derex.critterpedia.block.display.GalapgosTortoiseShellBlockDisplayItem;
import net.derex.critterpedia.CritterpediaMod;

public class CritterpediaModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, CritterpediaMod.MODID);
	public static final RegistryObject<Item> EMPEROR_SCORPION_SPAWN_EGG = REGISTRY.register("emperor_scorpion_spawn_egg",
			() -> new ForgeSpawnEggItem(CritterpediaModEntities.EMPEROR_SCORPION, -10351723, -9558106, new Item.Properties().tab(CritterpediaModTabs.TAB_CRITTERPEDIA_EGGS)));
	public static final RegistryObject<Item> GALAPGOS_TORTOISE_SPAWN_EGG = REGISTRY.register("galapgos_tortoise_spawn_egg",
			() -> new ForgeSpawnEggItem(CritterpediaModEntities.GALAPGOS_TORTOISE, -13684939, -11052194, new Item.Properties().tab(CritterpediaModTabs.TAB_CRITTERPEDIA_EGGS)));
	public static final RegistryObject<Item> PSYCHEDELIC_JELLYFISH_SPAWN_EGG = REGISTRY.register("psychedelic_jellyfish_spawn_egg",
			() -> new ForgeSpawnEggItem(CritterpediaModEntities.PSYCHEDELIC_JELLYFISH, -11592405, -11588028, new Item.Properties().tab(CritterpediaModTabs.TAB_CRITTERPEDIA_EGGS)));
	public static final RegistryObject<Item> GALAPGOS_EGG = block(CritterpediaModBlocks.GALAPGOS_EGG, null);
	public static final RegistryObject<Item> SPIDERWEB = block(CritterpediaModBlocks.SPIDERWEB, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Item> BLACK_WIDOW_SPAWN_EGG = REGISTRY.register("black_widow_spawn_egg",
			() -> new ForgeSpawnEggItem(CritterpediaModEntities.BLACK_WIDOW, -16777216, -6750208, new Item.Properties().tab(CritterpediaModTabs.TAB_CRITTERPEDIA_EGGS)));
	public static final RegistryObject<Item> GARDEN_SPIDER_SPAWN_EGG = REGISTRY.register("garden_spider_spawn_egg",
			() -> new ForgeSpawnEggItem(CritterpediaModEntities.GARDEN_SPIDER, -6060979, -4541291, new Item.Properties().tab(CritterpediaModTabs.TAB_CRITTERPEDIA_EGGS)));
	public static final RegistryObject<Item> SALTWATER_CROCODILE_SPAWN_EGG = REGISTRY.register("saltwater_crocodile_spawn_egg",
			() -> new ForgeSpawnEggItem(CritterpediaModEntities.SALTWATER_CROCODILE, -8681630, -9340824, new Item.Properties().tab(CritterpediaModTabs.TAB_CRITTERPEDIA_EGGS)));
	public static final RegistryObject<Item> RED_KNEE_TARANTULA_SPAWN_EGG = REGISTRY.register("red_knee_tarantula_spawn_egg",
			() -> new ForgeSpawnEggItem(CritterpediaModEntities.RED_KNEE_TARANTULA, -10342130, -15724273, new Item.Properties().tab(CritterpediaModTabs.TAB_CRITTERPEDIA_EGGS)));
	public static final RegistryObject<Item> GALAPAGOS_TURTLE_BLOCK = block(CritterpediaModBlocks.GALAPAGOS_TURTLE_BLOCK, null);
	public static final RegistryObject<Item> AMERICAN_ALLIGATOR_SPAWN_EGG = REGISTRY.register("american_alligator_spawn_egg",
			() -> new ForgeSpawnEggItem(CritterpediaModEntities.AMERICAN_ALLIGATOR, -13358543, -5728889, new Item.Properties().tab(CritterpediaModTabs.TAB_CRITTERPEDIA_EGGS)));
	public static final RegistryObject<Item> PSYCHEDELIC_JELLYFISH_BUCKET = REGISTRY.register("psychedelic_jellyfish_bucket", () -> new PsychedelicJellyfishBucketItem());
	public static final RegistryObject<Item> COMMON_SNAPPING_TURTLE_SPAWN_EGG = REGISTRY.register("common_snapping_turtle_spawn_egg",
			() -> new ForgeSpawnEggItem(CritterpediaModEntities.COMMON_SNAPPING_TURTLE, -11648458, -9670578, new Item.Properties().tab(CritterpediaModTabs.TAB_CRITTERPEDIA_EGGS)));
	public static final RegistryObject<Item> MAN_OF_WAR_SPAWN_EGG = REGISTRY.register("man_of_war_spawn_egg",
			() -> new ForgeSpawnEggItem(CritterpediaModEntities.MAN_OF_WAR, -11592405, -11588028, new Item.Properties().tab(CritterpediaModTabs.TAB_CRITTERPEDIA_EGGS)));
	public static final RegistryObject<Item> GALAPGOS_TORTOISE_SHELL_BLOCK = REGISTRY.register(CritterpediaModBlocks.GALAPGOS_TORTOISE_SHELL_BLOCK.getId().getPath(),
			() -> new GalapgosTortoiseShellBlockDisplayItem(CritterpediaModBlocks.GALAPGOS_TORTOISE_SHELL_BLOCK.get(), new Item.Properties().tab(null)));
	public static final RegistryObject<Item> UPSIDE_DOWN_JELLYFISH_SPAWN_EGG = REGISTRY.register("upside_down_jellyfish_spawn_egg",
			() -> new ForgeSpawnEggItem(CritterpediaModEntities.UPSIDE_DOWN_JELLYFISH, -11592405, -11588028, new Item.Properties().tab(CritterpediaModTabs.TAB_CRITTERPEDIA_EGGS)));
	public static final RegistryObject<Item> PALM_COCKATOO_SPAWN_EGG = REGISTRY.register("palm_cockatoo_spawn_egg",
			() -> new ForgeSpawnEggItem(CritterpediaModEntities.PALM_COCKATOO, -14672099, -1880291, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> MACARONI_PENGUIN_SPAWN_EGG = REGISTRY.register("macaroni_penguin_spawn_egg",
			() -> new ForgeSpawnEggItem(CritterpediaModEntities.MACARONI_PENGUIN, -3706589, -14078666, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> POTOO_SPAWN_EGG = REGISTRY.register("potoo_spawn_egg", () -> new ForgeSpawnEggItem(CritterpediaModEntities.POTOO, -7965343, -8900305, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> LARGE_FISHING_ROD = REGISTRY.register("large_fishing_rod", () -> new LargeFishingRodItem());
	public static final RegistryObject<Item> INSECT_NET = REGISTRY.register("insect_net", () -> new InsectNetItem());
	public static final RegistryObject<Item> BLACK_WIDOW_ITEM = REGISTRY.register("black_widow_item", () -> new BlackWidowItemItem());
	public static final RegistryObject<Item> UPSIDEDOWN_JELLYFISH_BUCKET = REGISTRY.register("upsidedown_jellyfish_bucket", () -> new UpsidedownJellyfishBucketItem());
	public static final RegistryObject<Item> FISHING_POLE = REGISTRY.register("fishing_pole", () -> new FishingPoleItem());

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
