
package tn.mbs.memory.network;

import tn.mbs.memory.world.inventory.PlayerStatsGUIMenu;
import tn.mbs.memory.procedures.AddResistancePointsProcedure;
import tn.mbs.memory.procedures.AddPointsProcedureProcedure;
import tn.mbs.memory.procedures.AddMvPointsProcedure;
import tn.mbs.memory.procedures.AddExplorationPointsProcedure;
import tn.mbs.memory.procedures.AddAttackSpeedPointsProcedure;
import tn.mbs.memory.procedures.AddAttackDamagePointsProcedure;
import tn.mbs.memory.procedures.AddAromrPointsProcedure;
import tn.mbs.memory.MemoryOfThePastMod;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PlayerStatsGUIButtonMessage {
	private final int buttonID, x, y, z;

	public PlayerStatsGUIButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public PlayerStatsGUIButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(PlayerStatsGUIButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(PlayerStatsGUIButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		Level world = entity.level();
		HashMap guistate = PlayerStatsGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			AddPointsProcedureProcedure.execute(entity);
		}
		if (buttonID == 1) {

			AddAttackDamagePointsProcedure.execute(entity);
		}
		if (buttonID == 2) {

			AddAttackSpeedPointsProcedure.execute(entity);
		}
		if (buttonID == 3) {

			AddAromrPointsProcedure.execute(entity);
		}
		if (buttonID == 4) {

			AddMvPointsProcedure.execute(entity);
		}
		if (buttonID == 5) {

			AddResistancePointsProcedure.execute(entity);
		}
		if (buttonID == 6) {

			AddExplorationPointsProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MemoryOfThePastMod.addNetworkMessage(PlayerStatsGUIButtonMessage.class, PlayerStatsGUIButtonMessage::buffer, PlayerStatsGUIButtonMessage::new, PlayerStatsGUIButtonMessage::handler);
	}
}
