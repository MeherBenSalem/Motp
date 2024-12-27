
package tn.mbs.memory.network;

import tn.mbs.memory.world.inventory.PlayerStatsGUIMenu;
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
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MemoryOfThePastMod.addNetworkMessage(PlayerStatsGUIButtonMessage.class, PlayerStatsGUIButtonMessage::buffer, PlayerStatsGUIButtonMessage::new, PlayerStatsGUIButtonMessage::handler);
	}
}
