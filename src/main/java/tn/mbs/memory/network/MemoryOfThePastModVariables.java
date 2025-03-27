package tn.mbs.memory.network;

import tn.mbs.memory.MemoryOfThePastMod;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.common.util.INBTSerializable;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.HolderLookup;

import java.util.function.Supplier;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class MemoryOfThePastModVariables {
	public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, MemoryOfThePastMod.MODID);
	public static final Supplier<AttachmentType<PlayerVariables>> PLAYER_VARIABLES = ATTACHMENT_TYPES.register("player_variables", () -> AttachmentType.serializable(() -> new PlayerVariables()).build());

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		MemoryOfThePastMod.addNetworkMessage(PlayerVariablesSyncMessage.TYPE, PlayerVariablesSyncMessage.STREAM_CODEC, PlayerVariablesSyncMessage::handleData);
	}

	@EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			PlayerVariables original = event.getOriginal().getData(PLAYER_VARIABLES);
			PlayerVariables clone = new PlayerVariables();
			clone.attribute_1 = original.attribute_1;
			clone.attribute_6 = original.attribute_6;
			clone.attribute_5 = original.attribute_5;
			clone.attribute_2 = original.attribute_2;
			clone.attribute_4 = original.attribute_4;
			clone.attribute_3 = original.attribute_3;
			clone.Level = original.Level;
			clone.SparePoints = original.SparePoints;
			clone.currentXpTLevel = original.currentXpTLevel;
			clone.nextevelXp = original.nextevelXp;
			clone.attribute_7 = original.attribute_7;
			clone.attribute_8 = original.attribute_8;
			clone.attribute_9 = original.attribute_9;
			clone.attribute_10 = original.attribute_10;
			if (!event.isWasDeath()) {
			}
			event.getEntity().setData(PLAYER_VARIABLES, clone);
		}
	}

	public static class PlayerVariables implements INBTSerializable<CompoundTag> {
		public double attribute_1 = 20.0;
		public double attribute_6 = 0.0;
		public double attribute_5 = 0.1;
		public double attribute_2 = 2.0;
		public double attribute_4 = 0;
		public double attribute_3 = 4.0;
		public double Level = 0;
		public double SparePoints = 1.0;
		public double currentXpTLevel = 0.0;
		public double nextevelXp = 100.0;
		public double attribute_7 = 0.0;
		public double attribute_8 = 0;
		public double attribute_9 = 0;
		public double attribute_10 = 0;

		@Override
		public CompoundTag serializeNBT(HolderLookup.Provider lookupProvider) {
			CompoundTag nbt = new CompoundTag();
			nbt.putDouble("attribute_1", attribute_1);
			nbt.putDouble("attribute_6", attribute_6);
			nbt.putDouble("attribute_5", attribute_5);
			nbt.putDouble("attribute_2", attribute_2);
			nbt.putDouble("attribute_4", attribute_4);
			nbt.putDouble("attribute_3", attribute_3);
			nbt.putDouble("Level", Level);
			nbt.putDouble("SparePoints", SparePoints);
			nbt.putDouble("currentXpTLevel", currentXpTLevel);
			nbt.putDouble("nextevelXp", nextevelXp);
			nbt.putDouble("attribute_7", attribute_7);
			nbt.putDouble("attribute_8", attribute_8);
			nbt.putDouble("attribute_9", attribute_9);
			nbt.putDouble("attribute_10", attribute_10);
			return nbt;
		}

		@Override
		public void deserializeNBT(HolderLookup.Provider lookupProvider, CompoundTag nbt) {
			attribute_1 = nbt.getDouble("attribute_1");
			attribute_6 = nbt.getDouble("attribute_6");
			attribute_5 = nbt.getDouble("attribute_5");
			attribute_2 = nbt.getDouble("attribute_2");
			attribute_4 = nbt.getDouble("attribute_4");
			attribute_3 = nbt.getDouble("attribute_3");
			Level = nbt.getDouble("Level");
			SparePoints = nbt.getDouble("SparePoints");
			currentXpTLevel = nbt.getDouble("currentXpTLevel");
			nextevelXp = nbt.getDouble("nextevelXp");
			attribute_7 = nbt.getDouble("attribute_7");
			attribute_8 = nbt.getDouble("attribute_8");
			attribute_9 = nbt.getDouble("attribute_9");
			attribute_10 = nbt.getDouble("attribute_10");
		}

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				PacketDistributor.sendToPlayer(serverPlayer, new PlayerVariablesSyncMessage(this));
		}
	}

	public record PlayerVariablesSyncMessage(PlayerVariables data) implements CustomPacketPayload {
		public static final Type<PlayerVariablesSyncMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MemoryOfThePastMod.MODID, "player_variables_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, PlayerVariablesSyncMessage> STREAM_CODEC = StreamCodec
				.of((RegistryFriendlyByteBuf buffer, PlayerVariablesSyncMessage message) -> buffer.writeNbt(message.data().serializeNBT(buffer.registryAccess())), (RegistryFriendlyByteBuf buffer) -> {
					PlayerVariablesSyncMessage message = new PlayerVariablesSyncMessage(new PlayerVariables());
					message.data.deserializeNBT(buffer.registryAccess(), buffer.readNbt());
					return message;
				});

		@Override
		public Type<PlayerVariablesSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final PlayerVariablesSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.enqueueWork(() -> context.player().getData(PLAYER_VARIABLES).deserializeNBT(context.player().registryAccess(), message.data.serializeNBT(context.player().registryAccess()))).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}
	}
}
