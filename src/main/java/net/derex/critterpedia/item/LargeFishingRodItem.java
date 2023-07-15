
package net.derex.critterpedia.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.FishingRodItem;
import net.minecraft.world.item.CreativeModeTab;

public class LargeFishingRodItem extends FishingRodItem {
	public LargeFishingRodItem() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).durability(100));
	}

	@Override
	public int getEnchantmentValue() {
		return 2;
	}
}
