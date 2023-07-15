
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.derex.critterpedia.init;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class CritterpediaModTabs {
	public static CreativeModeTab TAB_CRITTERPEDIA_EGGS;

	public static void load() {
		TAB_CRITTERPEDIA_EGGS = new CreativeModeTab("tabcritterpedia_eggs") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(Blocks.TURTLE_EGG);
			}

			@Override
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundSuffix("item_search.png");
	}
}
