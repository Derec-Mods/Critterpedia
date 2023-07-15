package net.derex.critterpedia.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import net.derex.critterpedia.CritterpediaMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CritterpediaModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		CritterpediaMod.addNetworkMessage(SavedDataSyncMessage.class, SavedDataSyncMessage::buffer, SavedDataSyncMessage::new, SavedDataSyncMessage::handler);
		CritterpediaMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level.isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level.isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level.isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.collectedEmperorScorpion = original.collectedEmperorScorpion;
			clone.collectedGalapTort = original.collectedGalapTort;
			clone.collectedPsychJelly = original.collectedPsychJelly;
			clone.collectedBlackWidow = original.collectedBlackWidow;
			clone.collectedGardenSpider = original.collectedGardenSpider;
			clone.collectedSaltwaterCroc = original.collectedSaltwaterCroc;
			clone.collectedRedKnee = original.collectedRedKnee;
			clone.collectedAmericanAlli = original.collectedAmericanAlli;
			clone.collectedCommonSnapping = original.collectedCommonSnapping;
			clone.collectedManOfWar = original.collectedManOfWar;
			clone.collectedPalmCoc = original.collectedPalmCoc;
			clone.collectedUpsideDown = original.collectedUpsideDown;
			clone.collectedMacaroni = original.collectedMacaroni;
			clone.collectedPotoo = original.collectedPotoo;
			if (!event.isWasDeath()) {
			}
		}

		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level.isClientSide()) {
				SavedData mapdata = MapVariables.get(event.getEntity().level);
				SavedData worlddata = WorldVariables.get(event.getEntity().level);
				if (mapdata != null)
					CritterpediaMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					CritterpediaMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level.isClientSide()) {
				SavedData worlddata = WorldVariables.get(event.getEntity().level);
				if (worlddata != null)
					CritterpediaMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "critterpedia_worldvars";

		public static WorldVariables load(CompoundTag tag) {
			WorldVariables data = new WorldVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level level && !level.isClientSide())
				CritterpediaMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(level::dimension), new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(e -> WorldVariables.load(e), WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "critterpedia_mapvars";
		public boolean devMode = false;

		public static MapVariables load(CompoundTag tag) {
			MapVariables data = new MapVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
			devMode = nbt.getBoolean("devMode");
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			nbt.putBoolean("devMode", devMode);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				CritterpediaMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(e -> MapVariables.load(e), MapVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class SavedDataSyncMessage {
		public int type;
		public SavedData data;

		public SavedDataSyncMessage(FriendlyByteBuf buffer) {
			this.type = buffer.readInt();
			this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
			if (this.data instanceof MapVariables _mapvars)
				_mapvars.read(buffer.readNbt());
			else if (this.data instanceof WorldVariables _worldvars)
				_worldvars.read(buffer.readNbt());
		}

		public SavedDataSyncMessage(int type, SavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(SavedDataSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeInt(message.type);
			buffer.writeNbt(message.data.save(new CompoundTag()));
		}

		public static void handler(SavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					if (message.type == 0)
						MapVariables.clientSide = (MapVariables) message.data;
					else
						WorldVariables.clientSide = (WorldVariables) message.data;
				}
			});
			context.setPacketHandled(true);
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("critterpedia", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public boolean collectedEmperorScorpion = false;
		public boolean collectedGalapTort = false;
		public boolean collectedPsychJelly = false;
		public boolean collectedBlackWidow = false;
		public boolean collectedGardenSpider = false;
		public boolean collectedSaltwaterCroc = false;
		public boolean collectedRedKnee = false;
		public boolean collectedAmericanAlli = false;
		public boolean collectedCommonSnapping = false;
		public boolean collectedManOfWar = false;
		public boolean collectedPalmCoc = false;
		public boolean collectedUpsideDown = false;
		public boolean collectedMacaroni = false;
		public boolean collectedPotoo = false;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				CritterpediaMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putBoolean("collectedEmperorScorpion", collectedEmperorScorpion);
			nbt.putBoolean("collectedGalapTort", collectedGalapTort);
			nbt.putBoolean("collectedPsychJelly", collectedPsychJelly);
			nbt.putBoolean("collectedBlackWidow", collectedBlackWidow);
			nbt.putBoolean("collectedGardenSpider", collectedGardenSpider);
			nbt.putBoolean("collectedSaltwaterCroc", collectedSaltwaterCroc);
			nbt.putBoolean("collectedRedKnee", collectedRedKnee);
			nbt.putBoolean("collectedAmericanAlli", collectedAmericanAlli);
			nbt.putBoolean("collectedCommonSnapping", collectedCommonSnapping);
			nbt.putBoolean("collectedManOfWar", collectedManOfWar);
			nbt.putBoolean("collectedPalmCoc", collectedPalmCoc);
			nbt.putBoolean("collectedUpsideDown", collectedUpsideDown);
			nbt.putBoolean("collectedMacaroni", collectedMacaroni);
			nbt.putBoolean("collectedPotoo", collectedPotoo);
			return nbt;
		}

		public void readNBT(Tag Tag) {
			CompoundTag nbt = (CompoundTag) Tag;
			collectedEmperorScorpion = nbt.getBoolean("collectedEmperorScorpion");
			collectedGalapTort = nbt.getBoolean("collectedGalapTort");
			collectedPsychJelly = nbt.getBoolean("collectedPsychJelly");
			collectedBlackWidow = nbt.getBoolean("collectedBlackWidow");
			collectedGardenSpider = nbt.getBoolean("collectedGardenSpider");
			collectedSaltwaterCroc = nbt.getBoolean("collectedSaltwaterCroc");
			collectedRedKnee = nbt.getBoolean("collectedRedKnee");
			collectedAmericanAlli = nbt.getBoolean("collectedAmericanAlli");
			collectedCommonSnapping = nbt.getBoolean("collectedCommonSnapping");
			collectedManOfWar = nbt.getBoolean("collectedManOfWar");
			collectedPalmCoc = nbt.getBoolean("collectedPalmCoc");
			collectedUpsideDown = nbt.getBoolean("collectedUpsideDown");
			collectedMacaroni = nbt.getBoolean("collectedMacaroni");
			collectedPotoo = nbt.getBoolean("collectedPotoo");
		}
	}

	public static class PlayerVariablesSyncMessage {
		public PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.collectedEmperorScorpion = message.data.collectedEmperorScorpion;
					variables.collectedGalapTort = message.data.collectedGalapTort;
					variables.collectedPsychJelly = message.data.collectedPsychJelly;
					variables.collectedBlackWidow = message.data.collectedBlackWidow;
					variables.collectedGardenSpider = message.data.collectedGardenSpider;
					variables.collectedSaltwaterCroc = message.data.collectedSaltwaterCroc;
					variables.collectedRedKnee = message.data.collectedRedKnee;
					variables.collectedAmericanAlli = message.data.collectedAmericanAlli;
					variables.collectedCommonSnapping = message.data.collectedCommonSnapping;
					variables.collectedManOfWar = message.data.collectedManOfWar;
					variables.collectedPalmCoc = message.data.collectedPalmCoc;
					variables.collectedUpsideDown = message.data.collectedUpsideDown;
					variables.collectedMacaroni = message.data.collectedMacaroni;
					variables.collectedPotoo = message.data.collectedPotoo;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
