
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package tn.mbs.memory.init;

import tn.mbs.memory.client.gui.PlayerStatsGUIScreen;
import tn.mbs.memory.client.gui.PlayerAttributesViewerGUIScreen;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MemoryOfThePastModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(MemoryOfThePastModMenus.PLAYER_STATS_GUI.get(), PlayerStatsGUIScreen::new);
		event.register(MemoryOfThePastModMenus.PLAYER_ATTRIBUTES_VIEWER_GUI.get(), PlayerAttributesViewerGUIScreen::new);
	}
}
