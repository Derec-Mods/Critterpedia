
package net.derex.critterpedia.item;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.InteractionResult;

import net.derex.critterpedia.procedures.ReleaseEntityFromBucketProcedure;

public class PsychedelicJellyfishBucketItem extends Item {
	public PsychedelicJellyfishBucketItem() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		ReleaseEntityFromBucketProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getClickedFace(), context.getPlayer(), context.getItemInHand());
		return InteractionResult.SUCCESS;
	}
}
