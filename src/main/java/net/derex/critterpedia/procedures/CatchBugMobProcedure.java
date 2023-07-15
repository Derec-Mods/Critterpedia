package net.derex.critterpedia.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.derex.critterpedia.init.CritterpediaModItems;
import net.derex.critterpedia.entity.GardenSpiderEntity;
import net.derex.critterpedia.entity.EmperorScorpionEntity;
import net.derex.critterpedia.entity.BlackWidowEntity;

public class CatchBugMobProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == CritterpediaModItems.INSECT_NET.get()) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.fill_fish")), SoundSource.NEUTRAL, 1, Mth.nextInt(RandomSource.create(), 1, 2));
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.fill_fish")), SoundSource.NEUTRAL, 1, Mth.nextInt(RandomSource.create(), 1, 2), false);
				}
			}
			if (entity instanceof BlackWidowEntity) {
				if (!entity.level.isClientSide())
					entity.discard();
				if (sourceentity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(CritterpediaModItems.BLACK_WIDOW_ITEM.get());
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			} else if (entity instanceof EmperorScorpionEntity) {
				if (!entity.level.isClientSide())
					entity.discard();
			} else if (entity instanceof GardenSpiderEntity) {
				if (!entity.level.isClientSide())
					entity.discard();
			}
		}
	}
}
