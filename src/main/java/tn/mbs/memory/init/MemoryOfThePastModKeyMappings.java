
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package tn.mbs.memory.init;

import tn.mbs.memory.network.OpenStatsMenuKeybindMessage;

import org.lwjgl.glfw.GLFW;

import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class MemoryOfThePastModKeyMappings {
	public static final KeyMapping OPEN_STATS_MENU_KEYBIND = new KeyMapping("key.memory_of_the_past.open_stats_menu_keybind", GLFW.GLFW_KEY_O, "key.categories.motp") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new OpenStatsMenuKeybindMessage(0, 0));
				OpenStatsMenuKeybindMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(OPEN_STATS_MENU_KEYBIND);
	}

	@EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(ClientTickEvent.Post event) {
			if (Minecraft.getInstance().screen == null) {
				OPEN_STATS_MENU_KEYBIND.consumeClick();
			}
		}
	}
}
