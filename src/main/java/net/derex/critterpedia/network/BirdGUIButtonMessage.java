
package net.derex.critterpedia.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.derex.critterpedia.world.inventory.BirdGUIMenu;
import net.derex.critterpedia.procedures.OpenSeaGUIProcedure;
import net.derex.critterpedia.procedures.OpenReptileGUIProcedure;
import net.derex.critterpedia.procedures.OpenMammalGUIProcedure;
import net.derex.critterpedia.procedures.OpenFishGUIProcedure;
import net.derex.critterpedia.procedures.OpenBugGUIProcedure;
import net.derex.critterpedia.CritterpediaMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BirdGUIButtonMessage {
	private final int buttonID, x, y, z;

	public BirdGUIButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public BirdGUIButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(BirdGUIButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(BirdGUIButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level;
		HashMap guistate = BirdGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			OpenReptileGUIProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			OpenFishGUIProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			OpenBugGUIProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			OpenSeaGUIProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			OpenMammalGUIProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		CritterpediaMod.addNetworkMessage(BirdGUIButtonMessage.class, BirdGUIButtonMessage::buffer, BirdGUIButtonMessage::new, BirdGUIButtonMessage::handler);
	}
}
