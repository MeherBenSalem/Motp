
package tn.mbs.memory.network;

import tn.mbs.memory.world.inventory.PlayerStatsGUIMenu;
import tn.mbs.memory.procedures.OpenAttributesDisplayGUIProcedure;
import tn.mbs.memory.procedures.AddPointsAttributeTwoProcedure;
import tn.mbs.memory.procedures.AddPointsAttributeThreeProcedure;
import tn.mbs.memory.procedures.AddPointsAttributeTenProcedure;
import tn.mbs.memory.procedures.AddPointsAttributeSixthProcedure;
import tn.mbs.memory.procedures.AddPointsAttributeSeventhProcedure;
import tn.mbs.memory.procedures.AddPointsAttributeOneProcedure;
import tn.mbs.memory.procedures.AddPointsAttributeNineProcedure;
import tn.mbs.memory.procedures.AddPointsAttributeForthProcedure;
import tn.mbs.memory.procedures.AddPointsAttributeFifthProcedure;
import tn.mbs.memory.procedures.AddPointsAttributeEightProcedure;
import tn.mbs.memory.MemoryOfThePastMod;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.BlockPos;

import java.util.HashMap;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record PlayerStatsGUIButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<PlayerStatsGUIButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MemoryOfThePastMod.MODID, "player_stats_gui_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, PlayerStatsGUIButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, PlayerStatsGUIButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new PlayerStatsGUIButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<PlayerStatsGUIButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final PlayerStatsGUIButtonMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
				Player entity = context.player();
				int buttonID = message.buttonID;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleButtonAction(entity, buttonID, x, y, z);
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = PlayerStatsGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			AddPointsAttributeOneProcedure.execute(entity);
		}
		if (buttonID == 1) {

			AddPointsAttributeTwoProcedure.execute(entity);
		}
		if (buttonID == 2) {

			AddPointsAttributeThreeProcedure.execute(entity);
		}
		if (buttonID == 3) {

			AddPointsAttributeForthProcedure.execute(entity);
		}
		if (buttonID == 4) {

			AddPointsAttributeFifthProcedure.execute(entity);
		}
		if (buttonID == 5) {

			AddPointsAttributeSixthProcedure.execute(entity);
		}
		if (buttonID == 6) {

			AddPointsAttributeSeventhProcedure.execute(entity);
		}
		if (buttonID == 7) {

			AddPointsAttributeEightProcedure.execute(entity);
		}
		if (buttonID == 8) {

			AddPointsAttributeNineProcedure.execute(entity);
		}
		if (buttonID == 9) {

			AddPointsAttributeTenProcedure.execute(entity);
		}
		if (buttonID == 10) {

			OpenAttributesDisplayGUIProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MemoryOfThePastMod.addNetworkMessage(PlayerStatsGUIButtonMessage.TYPE, PlayerStatsGUIButtonMessage.STREAM_CODEC, PlayerStatsGUIButtonMessage::handleData);
	}
}
