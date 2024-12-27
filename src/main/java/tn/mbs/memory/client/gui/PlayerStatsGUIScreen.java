package tn.mbs.memory.client.gui;

import tn.mbs.memory.world.inventory.PlayerStatsGUIMenu;
import tn.mbs.memory.procedures.ReturnNextAttributeTwoProcedure;
import tn.mbs.memory.procedures.ReturnNextAttributeThreeProcedure;
import tn.mbs.memory.procedures.ReturnNextAttributeTenProcedure;
import tn.mbs.memory.procedures.ReturnNextAttributeSixthProcedure;
import tn.mbs.memory.procedures.ReturnNextAttributeSeventhProcedure;
import tn.mbs.memory.procedures.ReturnNextAttributeOneProcedure;
import tn.mbs.memory.procedures.ReturnNextAttributeNineProcedure;
import tn.mbs.memory.procedures.ReturnNextAttributeForthProcedure;
import tn.mbs.memory.procedures.ReturnNextAttributeFifthProcedure;
import tn.mbs.memory.procedures.ReturnNextAttributeEightProcedure;
import tn.mbs.memory.procedures.ReturnExtraPointsProcedure;
import tn.mbs.memory.procedures.ReturnCurrentLevelProcedure;
import tn.mbs.memory.procedures.ReturnCurrentAttributeTwoProcedure;
import tn.mbs.memory.procedures.ReturnCurrentAttributeThreeProcedure;
import tn.mbs.memory.procedures.ReturnCurrentAttributeTenProcedure;
import tn.mbs.memory.procedures.ReturnCurrentAttributeSixthProcedure;
import tn.mbs.memory.procedures.ReturnCurrentAttributeSeventhProcedure;
import tn.mbs.memory.procedures.ReturnCurrentAttributeOneProcedure;
import tn.mbs.memory.procedures.ReturnCurrentAttributeNineProcedure;
import tn.mbs.memory.procedures.ReturnCurrentAttributeForthProcedure;
import tn.mbs.memory.procedures.ReturnCurrentAttributeFifthProcedure;
import tn.mbs.memory.procedures.ReturnCurrentAttributeEightProcedure;
import tn.mbs.memory.procedures.ReturnAttributeTwoTipProcedure;
import tn.mbs.memory.procedures.ReturnAttributeThreeTipProcedure;
import tn.mbs.memory.procedures.ReturnAttributeTenTipProcedure;
import tn.mbs.memory.procedures.ReturnAttributeSixthTipProcedure;
import tn.mbs.memory.procedures.ReturnAttributeSeventhTipProcedure;
import tn.mbs.memory.procedures.ReturnAttributeOneTipProcedure;
import tn.mbs.memory.procedures.ReturnAttributeNineTipProcedure;
import tn.mbs.memory.procedures.ReturnAttributeForthTipProcedure;
import tn.mbs.memory.procedures.ReturnAttributeFifthTipProcedure;
import tn.mbs.memory.procedures.ReturnAttributeEightTipProcedure;
import tn.mbs.memory.procedures.PlayerNameProcedure;
import tn.mbs.memory.procedures.GetThePlayerModelProcedure;
import tn.mbs.memory.procedures.DisplayLogicAttributeTwoProcedure;
import tn.mbs.memory.procedures.DisplayLogicAttributeThreeProcedure;
import tn.mbs.memory.procedures.DisplayLogicAttributeTenProcedure;
import tn.mbs.memory.procedures.DisplayLogicAttributeSixthProcedure;
import tn.mbs.memory.procedures.DisplayLogicAttributeSeventhProcedure;
import tn.mbs.memory.procedures.DisplayLogicAttributeOneProcedure;
import tn.mbs.memory.procedures.DisplayLogicAttributeNineProcedure;
import tn.mbs.memory.procedures.DisplayLogicAttributeForthProcedure;
import tn.mbs.memory.procedures.DisplayLogicAttributeFifthProcedure;
import tn.mbs.memory.procedures.DisplayLogicAttributeEightProcedure;
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
	ImageButton imagebutton_button_notclicked;
	ImageButton imagebutton_button_notclicked1;
	ImageButton imagebutton_button_notclicked2;
	ImageButton imagebutton_button_notclicked3;
	ImageButton imagebutton_button_notclicked4;
	ImageButton imagebutton_button_notclicked5;
	ImageButton imagebutton_button_notclicked6;
	ImageButton imagebutton_button_notclicked7;
	ImageButton imagebutton_button_notclicked8;
	ImageButton imagebutton_button_notclicked9;

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
		if (mouseX > leftPos + -38 && mouseX < leftPos + 1 && mouseY > topPos + 147 && mouseY < topPos + 158)
			guiGraphics.renderTooltip(font, Component.translatable("gui.memory_of_the_past.player_stats_gui.tooltip_represents_your_overall_progress"), mouseX, mouseY);
		if (mouseX > leftPos + 78 && mouseX < leftPos + 167 && mouseY > topPos + -8 && mouseY < topPos + 3)
			guiGraphics.renderTooltip(font, Component.translatable("gui.memory_of_the_past.player_stats_gui.tooltip_indicates_the_number_of_points_y"), mouseX, mouseY);
		if (DisplayLogicAttributeOneProcedure.execute())
			if (mouseX > leftPos + 38 && mouseX < leftPos + 62 && mouseY > topPos + 20 && mouseY < topPos + 44)
				guiGraphics.renderTooltip(font, Component.literal(ReturnAttributeOneTipProcedure.execute()), mouseX, mouseY);
		if (DisplayLogicAttributeOneProcedure.execute())
			if (mouseX > leftPos + 128 && mouseX < leftPos + 140 && mouseY > topPos + 25 && mouseY < topPos + 37)
				guiGraphics.renderTooltip(font, Component.literal(ReturnNextAttributeOneProcedure.execute(entity)), mouseX, mouseY);
		if (DisplayLogicAttributeTwoProcedure.execute())
			if (mouseX > leftPos + 160 && mouseX < leftPos + 184 && mouseY > topPos + 20 && mouseY < topPos + 44)
				guiGraphics.renderTooltip(font, Component.literal(ReturnAttributeTwoTipProcedure.execute()), mouseX, mouseY);
		if (DisplayLogicAttributeTwoProcedure.execute())
			if (mouseX > leftPos + 250 && mouseX < leftPos + 261 && mouseY > topPos + 26 && mouseY < topPos + 37)
				guiGraphics.renderTooltip(font, Component.literal(ReturnNextAttributeTwoProcedure.execute(entity)), mouseX, mouseY);
		if (DisplayLogicAttributeThreeProcedure.execute())
			if (mouseX > leftPos + 38 && mouseX < leftPos + 62 && mouseY > topPos + 52 && mouseY < topPos + 76)
				guiGraphics.renderTooltip(font, Component.literal(ReturnAttributeThreeTipProcedure.execute()), mouseX, mouseY);
		if (DisplayLogicAttributeForthProcedure.execute())
			if (mouseX > leftPos + 160 && mouseX < leftPos + 184 && mouseY > topPos + 51 && mouseY < topPos + 75)
				guiGraphics.renderTooltip(font, Component.literal(ReturnAttributeForthTipProcedure.execute()), mouseX, mouseY);
		if (DisplayLogicAttributeFifthProcedure.execute())
			if (mouseX > leftPos + 38 && mouseX < leftPos + 62 && mouseY > topPos + 83 && mouseY < topPos + 107)
				guiGraphics.renderTooltip(font, Component.literal(ReturnAttributeFifthTipProcedure.execute()), mouseX, mouseY);
		if (DisplayLogicAttributeSixthProcedure.execute())
			if (mouseX > leftPos + 160 && mouseX < leftPos + 184 && mouseY > topPos + 83 && mouseY < topPos + 107)
				guiGraphics.renderTooltip(font, Component.literal(ReturnAttributeSixthTipProcedure.execute()), mouseX, mouseY);
		if (DisplayLogicAttributeSeventhProcedure.execute())
			if (mouseX > leftPos + 39 && mouseX < leftPos + 63 && mouseY > topPos + 114 && mouseY < topPos + 138)
				guiGraphics.renderTooltip(font, Component.literal(ReturnAttributeSeventhTipProcedure.execute()), mouseX, mouseY);
		if (DisplayLogicAttributeThreeProcedure.execute())
			if (mouseX > leftPos + 129 && mouseX < leftPos + 140 && mouseY > topPos + 58 && mouseY < topPos + 69)
				guiGraphics.renderTooltip(font, Component.literal(ReturnNextAttributeThreeProcedure.execute(entity)), mouseX, mouseY);
		if (DisplayLogicAttributeForthProcedure.execute())
			if (mouseX > leftPos + 250 && mouseX < leftPos + 262 && mouseY > topPos + 58 && mouseY < topPos + 69)
				guiGraphics.renderTooltip(font, Component.literal(ReturnNextAttributeForthProcedure.execute(entity)), mouseX, mouseY);
		if (DisplayLogicAttributeFifthProcedure.execute())
			if (mouseX > leftPos + 129 && mouseX < leftPos + 140 && mouseY > topPos + 89 && mouseY < topPos + 100)
				guiGraphics.renderTooltip(font, Component.literal(ReturnNextAttributeFifthProcedure.execute(entity)), mouseX, mouseY);
		if (DisplayLogicAttributeSixthProcedure.execute())
			if (mouseX > leftPos + 249 && mouseX < leftPos + 261 && mouseY > topPos + 88 && mouseY < topPos + 100)
				guiGraphics.renderTooltip(font, Component.literal(ReturnNextAttributeSixthProcedure.execute(entity)), mouseX, mouseY);
		if (DisplayLogicAttributeSeventhProcedure.execute())
			if (mouseX > leftPos + 129 && mouseX < leftPos + 140 && mouseY > topPos + 121 && mouseY < topPos + 132)
				guiGraphics.renderTooltip(font, Component.literal(ReturnNextAttributeSeventhProcedure.execute(entity)), mouseX, mouseY);
		if (DisplayLogicAttributeEightProcedure.execute())
			if (mouseX > leftPos + 160 && mouseX < leftPos + 184 && mouseY > topPos + 114 && mouseY < topPos + 138)
				guiGraphics.renderTooltip(font, Component.literal(ReturnAttributeEightTipProcedure.execute()), mouseX, mouseY);
		if (DisplayLogicAttributeEightProcedure.execute())
			if (mouseX > leftPos + 250 && mouseX < leftPos + 261 && mouseY > topPos + 120 && mouseY < topPos + 133)
				guiGraphics.renderTooltip(font, Component.literal(ReturnNextAttributeEightProcedure.execute(entity)), mouseX, mouseY);
		if (DisplayLogicAttributeNineProcedure.execute())
			if (mouseX > leftPos + 37 && mouseX < leftPos + 61 && mouseY > topPos + 146 && mouseY < topPos + 170)
				guiGraphics.renderTooltip(font, Component.literal(ReturnAttributeNineTipProcedure.execute()), mouseX, mouseY);
		if (DisplayLogicAttributeTenProcedure.execute())
			if (mouseX > leftPos + 160 && mouseX < leftPos + 184 && mouseY > topPos + 147 && mouseY < topPos + 171)
				guiGraphics.renderTooltip(font, Component.literal(ReturnAttributeTenTipProcedure.execute()), mouseX, mouseY);
		if (DisplayLogicAttributeNineProcedure.execute())
			if (mouseX > leftPos + 128 && mouseX < leftPos + 141 && mouseY > topPos + 150 && mouseY < topPos + 164)
				guiGraphics.renderTooltip(font, Component.literal(ReturnNextAttributeNineProcedure.execute(entity)), mouseX, mouseY);
		if (DisplayLogicAttributeTenProcedure.execute())
			if (mouseX > leftPos + 249 && mouseX < leftPos + 262 && mouseY > topPos + 151 && mouseY < topPos + 164)
				guiGraphics.renderTooltip(font, Component.literal(ReturnNextAttributeTenProcedure.execute(entity)), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(new ResourceLocation("memory_of_the_past:textures/screens/bg.png"), this.leftPos + -61, this.topPos + -23, 0, 0, 350, 210, 350, 210);

		if (DisplayLogicAttributeOneProcedure.execute()) {
			guiGraphics.blit(new ResourceLocation("memory_of_the_past:textures/screens/bg_attributes.png"), this.leftPos + 49, this.topPos + 17, 0, 0, 97, 30, 97, 30);
		}
		if (DisplayLogicAttributeOneProcedure.execute()) {
			guiGraphics.blit(new ResourceLocation("memory_of_the_past:textures/screens/iconbg.png"), this.leftPos + 38, this.topPos + 20, 0, 0, 24, 24, 24, 24);
		}
		if (DisplayLogicAttributeOneProcedure.execute()) {
			guiGraphics.blit(new ResourceLocation("memory_of_the_past:textures/screens/att_1.png"), this.leftPos + 42, this.topPos + 24, 0, 0, 16, 16, 16, 16);
		}
		if (DisplayLogicAttributeTwoProcedure.execute()) {
			guiGraphics.blit(new ResourceLocation("memory_of_the_past:textures/screens/bg_attributes.png"), this.leftPos + 170, this.topPos + 17, 0, 0, 97, 30, 97, 30);
		}
		if (DisplayLogicAttributeTwoProcedure.execute()) {
			guiGraphics.blit(new ResourceLocation("memory_of_the_past:textures/screens/iconbg.png"), this.leftPos + 160, this.topPos + 20, 0, 0, 24, 24, 24, 24);
		}
		if (DisplayLogicAttributeTwoProcedure.execute()) {
			guiGraphics.blit(new ResourceLocation("memory_of_the_past:textures/screens/att_2.png"), this.leftPos + 164, this.topPos + 24, 0, 0, 16, 16, 16, 16);
		}
		if (DisplayLogicAttributeThreeProcedure.execute()) {
			guiGraphics.blit(new ResourceLocation("memory_of_the_past:textures/screens/bg_attributes.png"), this.leftPos + 49, this.topPos + 48, 0, 0, 97, 30, 97, 30);
		}
		if (DisplayLogicAttributeFifthProcedure.execute()) {
			guiGraphics.blit(new ResourceLocation("memory_of_the_past:textures/screens/bg_attributes.png"), this.leftPos + 49, this.topPos + 79, 0, 0, 97, 30, 97, 30);
		}
		if (DisplayLogicAttributeSeventhProcedure.execute()) {
			guiGraphics.blit(new ResourceLocation("memory_of_the_past:textures/screens/bg_attributes.png"), this.leftPos + 49, this.topPos + 111, 0, 0, 97, 30, 97, 30);
		}
		if (DisplayLogicAttributeNineProcedure.execute()) {
			guiGraphics.blit(new ResourceLocation("memory_of_the_past:textures/screens/bg_attributes.png"), this.leftPos + 49, this.topPos + 143, 0, 0, 97, 30, 97, 30);
		}
		if (DisplayLogicAttributeForthProcedure.execute()) {
			guiGraphics.blit(new ResourceLocation("memory_of_the_past:textures/screens/bg_attributes.png"), this.leftPos + 170, this.topPos + 48, 0, 0, 97, 30, 97, 30);
		}
		if (DisplayLogicAttributeSixthProcedure.execute()) {
			guiGraphics.blit(new ResourceLocation("memory_of_the_past:textures/screens/bg_attributes.png"), this.leftPos + 170, this.topPos + 79, 0, 0, 97, 30, 97, 30);
		}
		if (DisplayLogicAttributeEightProcedure.execute()) {
			guiGraphics.blit(new ResourceLocation("memory_of_the_past:textures/screens/bg_attributes.png"), this.leftPos + 170, this.topPos + 111, 0, 0, 97, 30, 97, 30);
		}
		if (DisplayLogicAttributeTenProcedure.execute()) {
			guiGraphics.blit(new ResourceLocation("memory_of_the_past:textures/screens/bg_attributes.png"), this.leftPos + 170, this.topPos + 143, 0, 0, 97, 30, 97, 30);
		}
		if (DisplayLogicAttributeThreeProcedure.execute()) {
			guiGraphics.blit(new ResourceLocation("memory_of_the_past:textures/screens/iconbg.png"), this.leftPos + 38, this.topPos + 52, 0, 0, 24, 24, 24, 24);
		}
		if (DisplayLogicAttributeForthProcedure.execute()) {
			guiGraphics.blit(new ResourceLocation("memory_of_the_past:textures/screens/iconbg.png"), this.leftPos + 160, this.topPos + 51, 0, 0, 24, 24, 24, 24);
		}
		if (DisplayLogicAttributeFifthProcedure.execute()) {
			guiGraphics.blit(new ResourceLocation("memory_of_the_past:textures/screens/iconbg.png"), this.leftPos + 38, this.topPos + 83, 0, 0, 24, 24, 24, 24);
		}
		if (DisplayLogicAttributeSixthProcedure.execute()) {
			guiGraphics.blit(new ResourceLocation("memory_of_the_past:textures/screens/iconbg.png"), this.leftPos + 160, this.topPos + 83, 0, 0, 24, 24, 24, 24);
		}
		if (DisplayLogicAttributeSeventhProcedure.execute()) {
			guiGraphics.blit(new ResourceLocation("memory_of_the_past:textures/screens/iconbg.png"), this.leftPos + 38, this.topPos + 114, 0, 0, 24, 24, 24, 24);
		}
		if (DisplayLogicAttributeEightProcedure.execute()) {
			guiGraphics.blit(new ResourceLocation("memory_of_the_past:textures/screens/iconbg.png"), this.leftPos + 160, this.topPos + 114, 0, 0, 24, 24, 24, 24);
		}
		if (DisplayLogicAttributeNineProcedure.execute()) {
			guiGraphics.blit(new ResourceLocation("memory_of_the_past:textures/screens/iconbg.png"), this.leftPos + 38, this.topPos + 146, 0, 0, 24, 24, 24, 24);
		}
		if (DisplayLogicAttributeTenProcedure.execute()) {
			guiGraphics.blit(new ResourceLocation("memory_of_the_past:textures/screens/iconbg.png"), this.leftPos + 160, this.topPos + 147, 0, 0, 24, 24, 24, 24);
		}
		if (DisplayLogicAttributeThreeProcedure.execute()) {
			guiGraphics.blit(new ResourceLocation("memory_of_the_past:textures/screens/att_3.png"), this.leftPos + 42, this.topPos + 56, 0, 0, 16, 16, 16, 16);
		}
		if (DisplayLogicAttributeForthProcedure.execute()) {
			guiGraphics.blit(new ResourceLocation("memory_of_the_past:textures/screens/att_4.png"), this.leftPos + 164, this.topPos + 55, 0, 0, 16, 16, 16, 16);
		}
		if (DisplayLogicAttributeFifthProcedure.execute()) {
			guiGraphics.blit(new ResourceLocation("memory_of_the_past:textures/screens/att_5.png"), this.leftPos + 42, this.topPos + 87, 0, 0, 16, 16, 16, 16);
		}
		if (DisplayLogicAttributeSixthProcedure.execute()) {
			guiGraphics.blit(new ResourceLocation("memory_of_the_past:textures/screens/att_6.png"), this.leftPos + 164, this.topPos + 87, 0, 0, 16, 16, 16, 16);
		}
		if (DisplayLogicAttributeSeventhProcedure.execute()) {
			guiGraphics.blit(new ResourceLocation("memory_of_the_past:textures/screens/att_7.png"), this.leftPos + 43, this.topPos + 118, 0, 0, 16, 16, 16, 16);
		}
		if (DisplayLogicAttributeEightProcedure.execute()) {
			guiGraphics.blit(new ResourceLocation("memory_of_the_past:textures/screens/att_8.png"), this.leftPos + 164, this.topPos + 118, 0, 0, 16, 16, 16, 16);
		}
		if (DisplayLogicAttributeNineProcedure.execute()) {
			guiGraphics.blit(new ResourceLocation("memory_of_the_past:textures/screens/att_9.png"), this.leftPos + 42, this.topPos + 150, 0, 0, 16, 16, 16, 16);
		}
		if (DisplayLogicAttributeTenProcedure.execute()) {
			guiGraphics.blit(new ResourceLocation("memory_of_the_past:textures/screens/att_10.png"), this.leftPos + 164, this.topPos + 150, 0, 0, 16, 16, 16, 16);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.memory_of_the_past.player_stats_gui.label_level"), -36, 147, -1, false);
		guiGraphics.drawString(this.font,

				ReturnCurrentLevelProcedure.execute(entity), 4, 147, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.memory_of_the_past.player_stats_gui.label_available_points"), 79, -8, -1, false);
		guiGraphics.drawString(this.font,

				ReturnExtraPointsProcedure.execute(entity), 169, -8, -1, false);
		guiGraphics.drawString(this.font,

				PlayerNameProcedure.execute(entity), -28, -2, -1, false);
		if (DisplayLogicAttributeOneProcedure.execute())
			guiGraphics.drawString(this.font,

					ReturnCurrentAttributeOneProcedure.execute(entity), 63, 29, -1, false);
		if (DisplayLogicAttributeTwoProcedure.execute())
			guiGraphics.drawString(this.font,

					ReturnCurrentAttributeTwoProcedure.execute(entity), 186, 27, -1, false);
		if (DisplayLogicAttributeThreeProcedure.execute())
			guiGraphics.drawString(this.font,

					ReturnCurrentAttributeThreeProcedure.execute(entity), 63, 59, -1, false);
		if (DisplayLogicAttributeForthProcedure.execute())
			guiGraphics.drawString(this.font,

					ReturnCurrentAttributeForthProcedure.execute(entity), 186, 60, -1, false);
		if (DisplayLogicAttributeFifthProcedure.execute())
			guiGraphics.drawString(this.font,

					ReturnCurrentAttributeFifthProcedure.execute(entity), 63, 91, -1, false);
		if (DisplayLogicAttributeSixthProcedure.execute())
			guiGraphics.drawString(this.font,

					ReturnCurrentAttributeSixthProcedure.execute(entity), 186, 91, -1, false);
		if (DisplayLogicAttributeSeventhProcedure.execute())
			guiGraphics.drawString(this.font,

					ReturnCurrentAttributeSeventhProcedure.execute(entity), 63, 123, -1, false);
		if (DisplayLogicAttributeEightProcedure.execute())
			guiGraphics.drawString(this.font,

					ReturnCurrentAttributeEightProcedure.execute(entity), 185, 124, -1, false);
		if (DisplayLogicAttributeNineProcedure.execute())
			guiGraphics.drawString(this.font,

					ReturnCurrentAttributeNineProcedure.execute(entity), 63, 155, -1, false);
		if (DisplayLogicAttributeTenProcedure.execute())
			guiGraphics.drawString(this.font,

					ReturnCurrentAttributeTenProcedure.execute(entity), 185, 156, -1, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_button_notclicked = new ImageButton(this.leftPos + 128, this.topPos + 25, 13, 13, 0, 0, 13, new ResourceLocation("memory_of_the_past:textures/screens/atlas/imagebutton_button_notclicked.png"), 13, 26, e -> {
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
		guistate.put("button:imagebutton_button_notclicked", imagebutton_button_notclicked);
		this.addRenderableWidget(imagebutton_button_notclicked);
		imagebutton_button_notclicked1 = new ImageButton(this.leftPos + 249, this.topPos + 25, 13, 13, 0, 0, 13, new ResourceLocation("memory_of_the_past:textures/screens/atlas/imagebutton_button_notclicked1.png"), 13, 26, e -> {
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
		guistate.put("button:imagebutton_button_notclicked1", imagebutton_button_notclicked1);
		this.addRenderableWidget(imagebutton_button_notclicked1);
		imagebutton_button_notclicked2 = new ImageButton(this.leftPos + 128, this.topPos + 57, 13, 13, 0, 0, 13, new ResourceLocation("memory_of_the_past:textures/screens/atlas/imagebutton_button_notclicked2.png"), 13, 26, e -> {
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
		guistate.put("button:imagebutton_button_notclicked2", imagebutton_button_notclicked2);
		this.addRenderableWidget(imagebutton_button_notclicked2);
		imagebutton_button_notclicked3 = new ImageButton(this.leftPos + 249, this.topPos + 57, 13, 13, 0, 0, 13, new ResourceLocation("memory_of_the_past:textures/screens/atlas/imagebutton_button_notclicked3.png"), 13, 26, e -> {
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
		guistate.put("button:imagebutton_button_notclicked3", imagebutton_button_notclicked3);
		this.addRenderableWidget(imagebutton_button_notclicked3);
		imagebutton_button_notclicked4 = new ImageButton(this.leftPos + 128, this.topPos + 88, 13, 13, 0, 0, 13, new ResourceLocation("memory_of_the_past:textures/screens/atlas/imagebutton_button_notclicked4.png"), 13, 26, e -> {
			if (DisplayLogicAttributeFifthProcedure.execute()) {
				MemoryOfThePastMod.PACKET_HANDLER.sendToServer(new PlayerStatsGUIButtonMessage(4, x, y, z));
				PlayerStatsGUIButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (DisplayLogicAttributeFifthProcedure.execute())
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_button_notclicked4", imagebutton_button_notclicked4);
		this.addRenderableWidget(imagebutton_button_notclicked4);
		imagebutton_button_notclicked5 = new ImageButton(this.leftPos + 249, this.topPos + 88, 13, 13, 0, 0, 13, new ResourceLocation("memory_of_the_past:textures/screens/atlas/imagebutton_button_notclicked5.png"), 13, 26, e -> {
			if (DisplayLogicAttributeSixthProcedure.execute()) {
				MemoryOfThePastMod.PACKET_HANDLER.sendToServer(new PlayerStatsGUIButtonMessage(5, x, y, z));
				PlayerStatsGUIButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (DisplayLogicAttributeSixthProcedure.execute())
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_button_notclicked5", imagebutton_button_notclicked5);
		this.addRenderableWidget(imagebutton_button_notclicked5);
		imagebutton_button_notclicked6 = new ImageButton(this.leftPos + 128, this.topPos + 120, 13, 13, 0, 0, 13, new ResourceLocation("memory_of_the_past:textures/screens/atlas/imagebutton_button_notclicked6.png"), 13, 26, e -> {
			if (DisplayLogicAttributeSeventhProcedure.execute()) {
				MemoryOfThePastMod.PACKET_HANDLER.sendToServer(new PlayerStatsGUIButtonMessage(6, x, y, z));
				PlayerStatsGUIButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (DisplayLogicAttributeSeventhProcedure.execute())
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_button_notclicked6", imagebutton_button_notclicked6);
		this.addRenderableWidget(imagebutton_button_notclicked6);
		imagebutton_button_notclicked7 = new ImageButton(this.leftPos + 249, this.topPos + 120, 13, 13, 0, 0, 13, new ResourceLocation("memory_of_the_past:textures/screens/atlas/imagebutton_button_notclicked7.png"), 13, 26, e -> {
			if (DisplayLogicAttributeEightProcedure.execute()) {
				MemoryOfThePastMod.PACKET_HANDLER.sendToServer(new PlayerStatsGUIButtonMessage(7, x, y, z));
				PlayerStatsGUIButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (DisplayLogicAttributeEightProcedure.execute())
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_button_notclicked7", imagebutton_button_notclicked7);
		this.addRenderableWidget(imagebutton_button_notclicked7);
		imagebutton_button_notclicked8 = new ImageButton(this.leftPos + 128, this.topPos + 151, 13, 13, 0, 0, 13, new ResourceLocation("memory_of_the_past:textures/screens/atlas/imagebutton_button_notclicked8.png"), 13, 26, e -> {
			if (DisplayLogicAttributeNineProcedure.execute()) {
				MemoryOfThePastMod.PACKET_HANDLER.sendToServer(new PlayerStatsGUIButtonMessage(8, x, y, z));
				PlayerStatsGUIButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (DisplayLogicAttributeNineProcedure.execute())
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_button_notclicked8", imagebutton_button_notclicked8);
		this.addRenderableWidget(imagebutton_button_notclicked8);
		imagebutton_button_notclicked9 = new ImageButton(this.leftPos + 249, this.topPos + 151, 13, 13, 0, 0, 13, new ResourceLocation("memory_of_the_past:textures/screens/atlas/imagebutton_button_notclicked9.png"), 13, 26, e -> {
			if (DisplayLogicAttributeTenProcedure.execute()) {
				MemoryOfThePastMod.PACKET_HANDLER.sendToServer(new PlayerStatsGUIButtonMessage(9, x, y, z));
				PlayerStatsGUIButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (DisplayLogicAttributeTenProcedure.execute())
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_button_notclicked9", imagebutton_button_notclicked9);
		this.addRenderableWidget(imagebutton_button_notclicked9);
	}
}
