
package tn.mbs.memory.client.screens;

import tn.mbs.memory.procedures.YouHavePointsProcedure;
import tn.mbs.memory.procedures.ReturnCurrentLevelProcedure;
import tn.mbs.memory.procedures.DisplayXpOverlayProcedure;
import tn.mbs.memory.procedures.DisplayOverlayProcedure;
import tn.mbs.memory.procedures.CurrentXpToLevelProcedure;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.Component;
import net.minecraft.client.Minecraft;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class LevelOverlayOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		if (true) {
			if (DisplayXpOverlayProcedure.execute())
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						CurrentXpToLevelProcedure.execute(entity), 3, h - 16, -3381760, false);
			if (DisplayOverlayProcedure.execute())
				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.memory_of_the_past.level_overlay.label_experience"), 3, h - 28, -1, false);
			if (DisplayOverlayProcedure.execute())
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						ReturnCurrentLevelProcedure.execute(entity), 41, h - 29, -1, false);
			if (YouHavePointsProcedure.execute(entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.memory_of_the_past.level_overlay.label_available_points"), 3, h - 41, -1, false);
		}
	}
}
