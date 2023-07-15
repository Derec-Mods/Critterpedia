
package net.derex.critterpedia.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.derex.critterpedia.world.inventory.FishGUIMenu;
import net.derex.critterpedia.procedures.OpenSeaGUIProcedure;
import net.derex.critterpedia.procedures.OpenReptileGUIProcedure;
import net.derex.critterpedia.procedures.OpenMammalGUIProcedure;
import net.derex.critterpedia.procedures.OpenBugGUIProcedure;
import net.derex.critterpedia.procedures.OpenBirdGUIProcedure;
import net.derex.critterpedia.CritterpediaMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class FishGUIButtonMessage {
	private final int buttonID, x, y, z;

	public FishGUIButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public FishGUIButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(FishGUIButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(FishGUIButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = FishGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			OpenBirdGUIProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			OpenBugGUIProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			OpenSeaGUIProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			OpenMammalGUIProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			OpenReptileGUIProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		CritterpediaMod.addNetworkMessage(FishGUIButtonMessage.class, FishGUIButtonMessage::buffer, FishGUIButtonMessage::new, FishGUIButtonMessage::handler);
	}
}
