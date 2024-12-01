package tn.mbs.memory.network;

import tn.mbs.memory.MemoryOfThePastMod;

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

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MemoryOfThePastModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		MemoryOfThePastMod.addNetworkMessage(SavedDataSyncMessage.class, SavedDataSyncMessage::buffer, SavedDataSyncMessage::new, SavedDataSyncMessage::handler);
		MemoryOfThePastMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.max_health = original.max_health;
			clone.knockback_resistance = original.knockback_resistance;
			clone.movement_speed = original.movement_speed;
			clone.attack_damage = original.attack_damage;
			clone.armor = original.armor;
			clone.attack_speed = original.attack_speed;
			clone.Level = original.Level;
			clone.SparePoints = original.SparePoints;
			clone.currentXpTLevel = original.currentXpTLevel;
			clone.nextevelXp = original.nextevelXp;
			clone.exploration = original.exploration;
			if (!event.isWasDeath()) {
			}
		}

		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData mapdata = MapVariables.get(event.getEntity().level());
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (mapdata != null)
					MemoryOfThePastMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					MemoryOfThePastMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (worlddata != null)
					MemoryOfThePastMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "memory_of_the_past_worldvars";

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
				MemoryOfThePastMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(level::dimension), new SavedDataSyncMessage(1, this));
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
		public static final String DATA_NAME = "memory_of_the_past_mapvars";
		public String CurrentHealth = "0";
		public String CurrentResistance = "0";
		public String CurrentMovementSpeed = "\"\"";
		public String CurrentAttackDamage = "\"\"";
		public String CurrentArmor = "\"\"";
		public String CurrentAttackSpeed = "\"\"";
		public String CurrentLevel = "\"\"";
		public String CurrentSparePoints = "\"\"";
		public String currentXpString = "\"\"";
		public String CurrentExploration = "\"\"";

		public static MapVariables load(CompoundTag tag) {
			MapVariables data = new MapVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
			CurrentHealth = nbt.getString("CurrentHealth");
			CurrentResistance = nbt.getString("CurrentResistance");
			CurrentMovementSpeed = nbt.getString("CurrentMovementSpeed");
			CurrentAttackDamage = nbt.getString("CurrentAttackDamage");
			CurrentArmor = nbt.getString("CurrentArmor");
			CurrentAttackSpeed = nbt.getString("CurrentAttackSpeed");
			CurrentLevel = nbt.getString("CurrentLevel");
			CurrentSparePoints = nbt.getString("CurrentSparePoints");
			currentXpString = nbt.getString("currentXpString");
			CurrentExploration = nbt.getString("CurrentExploration");
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			nbt.putString("CurrentHealth", CurrentHealth);
			nbt.putString("CurrentResistance", CurrentResistance);
			nbt.putString("CurrentMovementSpeed", CurrentMovementSpeed);
			nbt.putString("CurrentAttackDamage", CurrentAttackDamage);
			nbt.putString("CurrentArmor", CurrentArmor);
			nbt.putString("CurrentAttackSpeed", CurrentAttackSpeed);
			nbt.putString("CurrentLevel", CurrentLevel);
			nbt.putString("CurrentSparePoints", CurrentSparePoints);
			nbt.putString("currentXpString", currentXpString);
			nbt.putString("CurrentExploration", CurrentExploration);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				MemoryOfThePastMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new SavedDataSyncMessage(0, this));
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
		private final int type;
		private SavedData data;

		public SavedDataSyncMessage(FriendlyByteBuf buffer) {
			this.type = buffer.readInt();
			CompoundTag nbt = buffer.readNbt();
			if (nbt != null) {
				this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
				if (this.data instanceof MapVariables mapVariables)
					mapVariables.read(nbt);
				else if (this.data instanceof WorldVariables worldVariables)
					worldVariables.read(nbt);
			}
		}

		public SavedDataSyncMessage(int type, SavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(SavedDataSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeInt(message.type);
			if (message.data != null)
				buffer.writeNbt(message.data.save(new CompoundTag()));
		}

		public static void handler(SavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer() && message.data != null) {
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
				event.addCapability(new ResourceLocation("memory_of_the_past", "player_variables"), new PlayerVariablesProvider());
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
		public double max_health = 20.0;
		public double knockback_resistance = 0.0;
		public double movement_speed = 0.1;
		public double attack_damage = 2.0;
		public double armor = 0;
		public double attack_speed = 4.0;
		public double Level = 0;
		public double SparePoints = 1.0;
		public double currentXpTLevel = 0.0;
		public double nextevelXp = 100.0;
		public double exploration = 0;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				MemoryOfThePastMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putDouble("max_health", max_health);
			nbt.putDouble("knockback_resistance", knockback_resistance);
			nbt.putDouble("movement_speed", movement_speed);
			nbt.putDouble("attack_damage", attack_damage);
			nbt.putDouble("armor", armor);
			nbt.putDouble("attack_speed", attack_speed);
			nbt.putDouble("Level", Level);
			nbt.putDouble("SparePoints", SparePoints);
			nbt.putDouble("currentXpTLevel", currentXpTLevel);
			nbt.putDouble("nextevelXp", nextevelXp);
			nbt.putDouble("exploration", exploration);
			return nbt;
		}

		public void readNBT(Tag tag) {
			CompoundTag nbt = (CompoundTag) tag;
			max_health = nbt.getDouble("max_health");
			knockback_resistance = nbt.getDouble("knockback_resistance");
			movement_speed = nbt.getDouble("movement_speed");
			attack_damage = nbt.getDouble("attack_damage");
			armor = nbt.getDouble("armor");
			attack_speed = nbt.getDouble("attack_speed");
			Level = nbt.getDouble("Level");
			SparePoints = nbt.getDouble("SparePoints");
			currentXpTLevel = nbt.getDouble("currentXpTLevel");
			nextevelXp = nbt.getDouble("nextevelXp");
			exploration = nbt.getDouble("exploration");
		}
	}

	public static class PlayerVariablesSyncMessage {
		private final PlayerVariables data;

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
					variables.max_health = message.data.max_health;
					variables.knockback_resistance = message.data.knockback_resistance;
					variables.movement_speed = message.data.movement_speed;
					variables.attack_damage = message.data.attack_damage;
					variables.armor = message.data.armor;
					variables.attack_speed = message.data.attack_speed;
					variables.Level = message.data.Level;
					variables.SparePoints = message.data.SparePoints;
					variables.currentXpTLevel = message.data.currentXpTLevel;
					variables.nextevelXp = message.data.nextevelXp;
					variables.exploration = message.data.exploration;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
