package tn.mbs.memory.client.gui;

import tn.mbs.memory.world.inventory.PlayerStatsGUIMenu;
import tn.mbs.memory.procedures.ReturnNextResistanceValueProcedure;
import tn.mbs.memory.procedures.ReturnNextMovementSpeedValueProcedure;
import tn.mbs.memory.procedures.ReturnNextExplorationValueProcedure;
import tn.mbs.memory.procedures.ReturnNextAttributeTwoProcedure;
import tn.mbs.memory.procedures.ReturnNextAttributeThreeProcedure;
import tn.mbs.memory.procedures.ReturnNextAttributeOneProcedure;
import tn.mbs.memory.procedures.ReturnNextAttributeForthProcedure;
import tn.mbs.memory.procedures.ReturnExtraPointsProcedure;
import tn.mbs.memory.procedures.ReturnCurrentResistanceProcedure;
import tn.mbs.memory.procedures.ReturnCurrentMovementSpeedProcedure;
import tn.mbs.memory.procedures.ReturnCurrentLevelProcedure;
import tn.mbs.memory.procedures.ReturnCurrentExplorationProcedure;
import tn.mbs.memory.procedures.ReturnCurrentAttributeTwoProcedure;
import tn.mbs.memory.procedures.ReturnCurrentAttributeThreeProcedure;
import tn.mbs.memory.procedures.ReturnCurrentAttributeOneProcedure;
import tn.mbs.memory.procedures.ReturnCurrentAttributeForthProcedure;
import tn.mbs.memory.procedures.ReturnAttributeTwoTipProcedure;
import tn.mbs.memory.procedures.ReturnAttributeTwoNameProcedure;
import tn.mbs.memory.procedures.ReturnAttributeThreeTipProcedure;
import tn.mbs.memory.procedures.ReturnAttributeThreeNameProcedure;
import tn.mbs.memory.procedures.ReturnAttributeSixthTipProcedure;
import tn.mbs.memory.procedures.ReturnAttributeSixthNameProcedure;
import tn.mbs.memory.procedures.ReturnAttributeSeventhTipProcedure;
import tn.mbs.memory.procedures.ReturnAttributeSeventhNameProcedure;
import tn.mbs.memory.procedures.ReturnAttributeOneTipProcedure;
import tn.mbs.memory.procedures.ReturnAttributeOneNameProcedure;
import tn.mbs.memory.procedures.ReturnAttributeForthTipProcedure;
import tn.mbs.memory.procedures.ReturnAttributeForthNameProcedure;
import tn.mbs.memory.procedures.ReturnAttributeFifthTipProcedure;
import tn.mbs.memory.procedures.ReturnAttributeFifthNameProcedure;
import tn.mbs.memory.procedures.PlayerNameProcedure;
import tn.mbs.memory.procedures.GetThePlayerModelProcedure;
import tn.mbs.memory.procedures.DisplayLogicAttributeTwoProcedure;
import tn.mbs.memory.procedures.DisplayLogicAttributeThreeProcedure;
import tn.mbs.memory.procedures.DisplayLogicAttributeOneProcedure;
import tn.mbs.memory.procedures.DisplayLogicAttributeForthProcedure;
import tn.mbs.memory.procedures.DisplayLevelingLogicMSProcedure;
import tn.mbs.memory.procedures.DisplayLevelingLogicFortitudeProcedure;
import tn.mbs.memory.procedures.DisplayLevelingLogicExplorationProcedure;
import tn.mbs.memory.network.PlayerStatsGUIButtonMessage;
import tn.mbs.memory.MemoryOfThePastMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class PlayerStatsGUIScreen extends AbstractContainerScreen<PlayerStatsGUIMenu> {
	private final static HashMap<String, Object> guistate = PlayerStatsGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_pressed;
	ImageButton imagebutton_pressed3;
	ImageButton imagebutton_pressed1;
	ImageButton imagebutton_pressed2;
	ImageButton imagebutton_pressed4;
	ImageButton imagebutton_pressed5;
	ImageButton imagebutton_pressed6;

	public PlayerStatsGUIScreen(PlayerStatsGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 234;
		this.imageHeight = 166;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		if (GetThePlayerModelProcedure.execute(world, x, y, z, entity) instanceof LivingEntity livingEntity) {
			InventoryScreen.renderEntityInInventoryFollowsAngle(guiGraphics, this.leftPos + -16, this.topPos + 137, 60, 0f + (float) Math.atan((this.leftPos + -16 - mouseX) / 40.0), (float) Math.atan((this.topPos + 88 - mouseY) / 40.0),
					livingEntity);
		}
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (DisplayLogicAttributeOneProcedure.execute())
			if (mouseX > leftPos + 39 && mouseX < leftPos + 54 && mouseY > topPos + 16 && mouseY < topPos + 30)
				guiGraphics.renderTooltip(font, Component.literal(ReturnAttributeOneTipProcedure.execute()), mouseX, mouseY);
		if (DisplayLogicAttributeTwoProcedure.execute())
			if (mouseX > leftPos + 37 && mouseX < leftPos + 54 && mouseY > topPos + 34 && mouseY < topPos + 51)
				guiGraphics.renderTooltip(font, Component.literal(ReturnAttributeTwoTipProcedure.execute()), mouseX, mouseY);
		if (DisplayLogicAttributeThreeProcedure.execute())
			if (mouseX > leftPos + 38 && mouseX < leftPos + 53 && mouseY > topPos + 55 && mouseY < topPos + 72)
				guiGraphics.renderTooltip(font, Component.literal(ReturnAttributeThreeTipProcedure.execute()), mouseX, mouseY);
		if (DisplayLogicAttributeForthProcedure.execute())
			if (mouseX > leftPos + 40 && mouseX < leftPos + 55 && mouseY > topPos + 74 && mouseY < topPos + 90)
				guiGraphics.renderTooltip(font, Component.literal(ReturnAttributeForthTipProcedure.execute()), mouseX, mouseY);
		if (DisplayLevelingLogicMSProcedure.execute())
			if (mouseX > leftPos + 40 && mouseX < leftPos + 53 && mouseY > topPos + 94 && mouseY < topPos + 110)
				guiGraphics.renderTooltip(font, Component.literal(ReturnAttributeFifthTipProcedure.execute()), mouseX, mouseY);
		if (DisplayLevelingLogicFortitudeProcedure.execute())
			if (mouseX > leftPos + 39 && mouseX < leftPos + 54 && mouseY > topPos + 114 && mouseY < topPos + 131)
				guiGraphics.renderTooltip(font, Component.literal(ReturnAttributeSixthTipProcedure.execute()), mouseX, mouseY);
		if (DisplayLevelingLogicExplorationProcedure.execute())
			if (mouseX > leftPos + 38 && mouseX < leftPos + 53 && mouseY > topPos + 136 && mouseY < topPos + 152)
				guiGraphics.renderTooltip(font, Component.literal(ReturnAttributeSeventhTipProcedure.execute()), mouseX, mouseY);
		if (mouseX > leftPos + -51 && mouseX < leftPos + -41 && mouseY > topPos + 147 && mouseY < topPos + 157)
			guiGraphics.renderTooltip(font, Component.translatable("gui.memory_of_the_past.player_stats_gui.tooltip_represents_your_overall_progress"), mouseX, mouseY);
		if (mouseX > leftPos + 64 && mouseX < leftPos + 74 && mouseY > topPos + -8 && mouseY < topPos + 2)
			guiGraphics.renderTooltip(font, Component.translatable("gui.memory_of_the_past.player_stats_gui.tooltip_indicates_the_number_of_points_y"), mouseX, mouseY);
		if (DisplayLogicAttributeOneProcedure.execute())
			if (mouseX > leftPos + 234 && mouseX < leftPos + 254 && mouseY > topPos + 12 && mouseY < topPos + 32)
				guiGraphics.renderTooltip(font, Component.literal(ReturnNextAttributeOneProcedure.execute(entity)), mouseX, mouseY);
		if (DisplayLogicAttributeTwoProcedure.execute())
			if (mouseX > leftPos + 234 && mouseX < leftPos + 254 && mouseY > topPos + 32 && mouseY < topPos + 52)
				guiGraphics.renderTooltip(font, Component.literal(ReturnNextAttributeTwoProcedure.execute(entity)), mouseX, mouseY);
		if (DisplayLogicAttributeThreeProcedure.execute())
			if (mouseX > leftPos + 234 && mouseX < leftPos + 254 && mouseY > topPos + 52 && mouseY < topPos + 72)
				guiGraphics.renderTooltip(font, Component.literal(ReturnNextAttributeThreeProcedure.execute(entity)), mouseX, mouseY);
		if (DisplayLogicAttributeForthProcedure.execute())
			if (mouseX > leftPos + 234 && mouseX < leftPos + 254 && mouseY > topPos + 72 && mouseY < topPos + 92)
				guiGraphics.renderTooltip(font, Component.literal(ReturnNextAttributeForthProcedure.execute(entity)), mouseX, mouseY);
		if (DisplayLevelingLogicMSProcedure.execute())
			if (mouseX > leftPos + 234 && mouseX < leftPos + 254 && mouseY > topPos + 92 && mouseY < topPos + 112)
				guiGraphics.renderTooltip(font, Component.literal(ReturnNextMovementSpeedValueProcedure.execute(entity)), mouseX, mouseY);
		if (DisplayLevelingLogicFortitudeProcedure.execute())
			if (mouseX > leftPos + 234 && mouseX < leftPos + 254 && mouseY > topPos + 112 && mouseY < topPos + 132)
				guiGraphics.renderTooltip(font, Component.literal(ReturnNextResistanceValueProcedure.execute(entity)), mouseX, mouseY);
		if (DisplayLevelingLogicExplorationProcedure.execute())
			if (mouseX > leftPos + 234 && mouseX < leftPos + 254 && mouseY > topPos + 137 && mouseY < topPos + 157)
				guiGraphics.renderTooltip(font, Component.literal(ReturnNextExplorationValueProcedure.execute(entity)), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(new ResourceLocation("memory_of_the_past:textures/screens/player_stats_gui.png"), this.leftPos + -66, this.topPos + -18, 0, 0, 350, 200, 350, 200);

		if (DisplayLogicAttributeOneProcedure.execute()) {
			guiGraphics.blit(new ResourceLocation("memory_of_the_past:textures/screens/att_1.png"), this.leftPos + 39, this.topPos + 15, 0, 0, 16, 16, 16, 16);
		}

		guiGraphics.blit(new ResourceLocation("memory_of_the_past:textures/screens/att_7.png"), this.leftPos + 38, this.topPos + 136, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("memory_of_the_past:textures/screens/att_6.png"), this.leftPos + 38, this.topPos + 114, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("memory_of_the_past:textures/screens/att_5.png"), this.leftPos + 38, this.topPos + 94, 0, 0, 16, 16, 16, 16);

		if (DisplayLogicAttributeForthProcedure.execute()) {
			guiGraphics.blit(new ResourceLocation("memory_of_the_past:textures/screens/att_4.png"), this.leftPos + 40, this.topPos + 74, 0, 0, 16, 16, 16, 16);
		}
		if (DisplayLogicAttributeThreeProcedure.execute()) {
			guiGraphics.blit(new ResourceLocation("memory_of_the_past:textures/screens/att_3.png"), this.leftPos + 38, this.topPos + 55, 0, 0, 16, 16, 16, 16);
		}
		if (DisplayLogicAttributeTwoProcedure.execute()) {
			guiGraphics.blit(new ResourceLocation("memory_of_the_past:textures/screens/att_2.png"), this.leftPos + 38, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		if (DisplayLogicAttributeOneProcedure.execute())
			guiGraphics.drawString(this.font,

					ReturnAttributeOneNameProcedure.execute(), 59, 17, -1, false);
		if (DisplayLogicAttributeOneProcedure.execute())
			guiGraphics.drawString(this.font,

					ReturnCurrentAttributeOneProcedure.execute(entity), 204, 17, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.memory_of_the_past.player_stats_gui.label_level"), -36, 147, -1, false);
		guiGraphics.drawString(this.font,

				ReturnCurrentLevelProcedure.execute(entity), 4, 147, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.memory_of_the_past.player_stats_gui.label_available_points"), 79, -8, -1, false);
		guiGraphics.drawString(this.font,

				ReturnExtraPointsProcedure.execute(entity), 169, -8, -1, false);
		if (DisplayLevelingLogicFortitudeProcedure.execute())
			guiGraphics.drawString(this.font,

					ReturnAttributeSixthNameProcedure.execute(), 59, 117, -1, false);
		if (DisplayLevelingLogicFortitudeProcedure.execute())
			guiGraphics.drawString(this.font,

					ReturnCurrentResistanceProcedure.execute(entity), 204, 117, -1, false);
		if (DisplayLogicAttributeForthProcedure.execute())
			guiGraphics.drawString(this.font,

					ReturnAttributeForthNameProcedure.execute(), 59, 77, -1, false);
		if (DisplayLevelingLogicExplorationProcedure.execute())
			guiGraphics.drawString(this.font,

					ReturnAttributeSeventhNameProcedure.execute(), 59, 139, -1, false);
		if (DisplayLogicAttributeForthProcedure.execute())
			guiGraphics.drawString(this.font,

					ReturnCurrentAttributeForthProcedure.execute(entity), 204, 77, -1, false);
		if (DisplayLogicAttributeTwoProcedure.execute())
			guiGraphics.drawString(this.font,

					ReturnAttributeTwoNameProcedure.execute(), 59, 37, -1, false);
		if (DisplayLogicAttributeTwoProcedure.execute())
			guiGraphics.drawString(this.font,

					ReturnCurrentAttributeTwoProcedure.execute(entity), 204, 37, -1, false);
		if (DisplayLevelingLogicMSProcedure.execute())
			guiGraphics.drawString(this.font,

					ReturnAttributeFifthNameProcedure.execute(), 59, 97, -1, false);
		if (DisplayLevelingLogicMSProcedure.execute())
			guiGraphics.drawString(this.font,

					ReturnCurrentMovementSpeedProcedure.execute(entity), 204, 97, -1, false);
		if (DisplayLogicAttributeThreeProcedure.execute())
			guiGraphics.drawString(this.font,

					ReturnAttributeThreeNameProcedure.execute(), 59, 57, -1, false);
		if (DisplayLogicAttributeThreeProcedure.execute())
			guiGraphics.drawString(this.font,

					ReturnCurrentAttributeThreeProcedure.execute(entity), 204, 57, -1, false);
		if (DisplayLevelingLogicExplorationProcedure.execute())
			guiGraphics.drawString(this.font,

					ReturnCurrentExplorationProcedure.execute(entity), 204, 140, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.memory_of_the_past.player_stats_gui.label_empty7"), 69, -8, -13553359, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.memory_of_the_past.player_stats_gui.label_empty8"), -46, 147, -12829636, false);
		guiGraphics.drawString(this.font,

				PlayerNameProcedure.execute(entity), -40, 3, -1, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_pressed = new ImageButton(this.leftPos + 234, this.topPos + 12, 20, 20, 0, 0, 20, new ResourceLocation("memory_of_the_past:textures/screens/atlas/imagebutton_pressed.png"), 20, 40, e -> {
			if (DisplayLogicAttributeOneProcedure.execute()) {
				MemoryOfThePastMod.PACKET_HANDLER.sendToServer(new PlayerStatsGUIButtonMessage(0, x, y, z));
				PlayerStatsGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (DisplayLogicAttributeOneProcedure.execute())
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_pressed", imagebutton_pressed);
		this.addRenderableWidget(imagebutton_pressed);
		imagebutton_pressed3 = new ImageButton(this.leftPos + 234, this.topPos + 32, 20, 20, 0, 0, 20, new ResourceLocation("memory_of_the_past:textures/screens/atlas/imagebutton_pressed3.png"), 20, 40, e -> {
			if (DisplayLogicAttributeTwoProcedure.execute()) {
				MemoryOfThePastMod.PACKET_HANDLER.sendToServer(new PlayerStatsGUIButtonMessage(1, x, y, z));
				PlayerStatsGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (DisplayLogicAttributeTwoProcedure.execute())
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_pressed3", imagebutton_pressed3);
		this.addRenderableWidget(imagebutton_pressed3);
		imagebutton_pressed1 = new ImageButton(this.leftPos + 234, this.topPos + 52, 20, 20, 0, 0, 20, new ResourceLocation("memory_of_the_past:textures/screens/atlas/imagebutton_pressed1.png"), 20, 40, e -> {
			if (DisplayLogicAttributeThreeProcedure.execute()) {
				MemoryOfThePastMod.PACKET_HANDLER.sendToServer(new PlayerStatsGUIButtonMessage(2, x, y, z));
				PlayerStatsGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (DisplayLogicAttributeThreeProcedure.execute())
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_pressed1", imagebutton_pressed1);
		this.addRenderableWidget(imagebutton_pressed1);
		imagebutton_pressed2 = new ImageButton(this.leftPos + 234, this.topPos + 72, 20, 20, 0, 0, 20, new ResourceLocation("memory_of_the_past:textures/screens/atlas/imagebutton_pressed2.png"), 20, 40, e -> {
			if (DisplayLogicAttributeForthProcedure.execute()) {
				MemoryOfThePastMod.PACKET_HANDLER.sendToServer(new PlayerStatsGUIButtonMessage(3, x, y, z));
				PlayerStatsGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (DisplayLogicAttributeForthProcedure.execute())
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_pressed2", imagebutton_pressed2);
		this.addRenderableWidget(imagebutton_pressed2);
		imagebutton_pressed4 = new ImageButton(this.leftPos + 234, this.topPos + 92, 20, 20, 0, 0, 20, new ResourceLocation("memory_of_the_past:textures/screens/atlas/imagebutton_pressed4.png"), 20, 40, e -> {
			if (DisplayLevelingLogicMSProcedure.execute()) {
				MemoryOfThePastMod.PACKET_HANDLER.sendToServer(new PlayerStatsGUIButtonMessage(4, x, y, z));
				PlayerStatsGUIButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (DisplayLevelingLogicMSProcedure.execute())
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_pressed4", imagebutton_pressed4);
		this.addRenderableWidget(imagebutton_pressed4);
		imagebutton_pressed5 = new ImageButton(this.leftPos + 234, this.topPos + 112, 20, 20, 0, 0, 20, new ResourceLocation("memory_of_the_past:textures/screens/atlas/imagebutton_pressed5.png"), 20, 40, e -> {
			if (DisplayLevelingLogicFortitudeProcedure.execute()) {
				MemoryOfThePastMod.PACKET_HANDLER.sendToServer(new PlayerStatsGUIButtonMessage(5, x, y, z));
				PlayerStatsGUIButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (DisplayLevelingLogicFortitudeProcedure.execute())
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_pressed5", imagebutton_pressed5);
		this.addRenderableWidget(imagebutton_pressed5);
		imagebutton_pressed6 = new ImageButton(this.leftPos + 234, this.topPos + 137, 20, 20, 0, 0, 20, new ResourceLocation("memory_of_the_past:textures/screens/atlas/imagebutton_pressed6.png"), 20, 40, e -> {
			if (DisplayLevelingLogicExplorationProcedure.execute()) {
				MemoryOfThePastMod.PACKET_HANDLER.sendToServer(new PlayerStatsGUIButtonMessage(6, x, y, z));
				PlayerStatsGUIButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (DisplayLevelingLogicExplorationProcedure.execute())
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_pressed6", imagebutton_pressed6);
		this.addRenderableWidget(imagebutton_pressed6);
	}
}
