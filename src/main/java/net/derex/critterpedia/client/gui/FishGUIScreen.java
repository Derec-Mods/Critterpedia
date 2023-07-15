package net.derex.critterpedia.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.Minecraft;

import net.derex.critterpedia.world.inventory.FishGUIMenu;
import net.derex.critterpedia.network.FishGUIButtonMessage;
import net.derex.critterpedia.CritterpediaMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class FishGUIScreen extends AbstractContainerScreen<FishGUIMenu> {
	private final static HashMap<String, Object> guistate = FishGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_bird_icon_unclicked;
	ImageButton imagebutton_bug_icon_unclicked;
	ImageButton imagebutton_sea_creature_icon_unclicked;
	ImageButton imagebutton_mammal_icon_unclicked;
	ImageButton imagebutton_reptileamphibian_icon_unclicked;

	public FishGUIScreen(FishGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		RenderSystem.setShaderTexture(0, new ResourceLocation("critterpedia:textures/screens/fish_icon_clicked.png"));
		this.blit(ms, this.leftPos + -40, this.topPos + 23, 0, 0, 20, 20, 20, 20);

		RenderSystem.setShaderTexture(0, new ResourceLocation("critterpedia:textures/screens/guiblank.png"));
		this.blit(ms, this.leftPos + -22, this.topPos + -2, 0, 0, 236, 157, 236, 157);

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
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		imagebutton_bird_icon_unclicked = new ImageButton(this.leftPos + -40, this.topPos + 44, 20, 20, 0, 0, 20, new ResourceLocation("critterpedia:textures/screens/atlas/imagebutton_bird_icon_unclicked.png"), 20, 40, e -> {
			if (true) {
				CritterpediaMod.PACKET_HANDLER.sendToServer(new FishGUIButtonMessage(0, x, y, z));
				FishGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_bird_icon_unclicked", imagebutton_bird_icon_unclicked);
		this.addRenderableWidget(imagebutton_bird_icon_unclicked);
		imagebutton_bug_icon_unclicked = new ImageButton(this.leftPos + -40, this.topPos + 65, 20, 20, 0, 0, 20, new ResourceLocation("critterpedia:textures/screens/atlas/imagebutton_bug_icon_unclicked.png"), 20, 40, e -> {
			if (true) {
				CritterpediaMod.PACKET_HANDLER.sendToServer(new FishGUIButtonMessage(1, x, y, z));
				FishGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_bug_icon_unclicked", imagebutton_bug_icon_unclicked);
		this.addRenderableWidget(imagebutton_bug_icon_unclicked);
		imagebutton_sea_creature_icon_unclicked = new ImageButton(this.leftPos + -40, this.topPos + 86, 20, 20, 0, 0, 20, new ResourceLocation("critterpedia:textures/screens/atlas/imagebutton_sea_creature_icon_unclicked.png"), 20, 40, e -> {
			if (true) {
				CritterpediaMod.PACKET_HANDLER.sendToServer(new FishGUIButtonMessage(2, x, y, z));
				FishGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_sea_creature_icon_unclicked", imagebutton_sea_creature_icon_unclicked);
		this.addRenderableWidget(imagebutton_sea_creature_icon_unclicked);
		imagebutton_mammal_icon_unclicked = new ImageButton(this.leftPos + -40, this.topPos + 107, 20, 20, 0, 0, 20, new ResourceLocation("critterpedia:textures/screens/atlas/imagebutton_mammal_icon_unclicked.png"), 20, 40, e -> {
			if (true) {
				CritterpediaMod.PACKET_HANDLER.sendToServer(new FishGUIButtonMessage(3, x, y, z));
				FishGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_mammal_icon_unclicked", imagebutton_mammal_icon_unclicked);
		this.addRenderableWidget(imagebutton_mammal_icon_unclicked);
		imagebutton_reptileamphibian_icon_unclicked = new ImageButton(this.leftPos + -40, this.topPos + 2, 20, 20, 0, 0, 20, new ResourceLocation("critterpedia:textures/screens/atlas/imagebutton_reptileamphibian_icon_unclicked.png"), 20, 40, e -> {
			if (true) {
				CritterpediaMod.PACKET_HANDLER.sendToServer(new FishGUIButtonMessage(4, x, y, z));
				FishGUIButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:imagebutton_reptileamphibian_icon_unclicked", imagebutton_reptileamphibian_icon_unclicked);
		this.addRenderableWidget(imagebutton_reptileamphibian_icon_unclicked);
	}
}
