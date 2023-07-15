package net.derex.critterpedia.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.Minecraft;

import net.derex.critterpedia.world.inventory.GUITemplateMenu;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class GUITemplateScreen extends AbstractContainerScreen<GUITemplateMenu> {
	private final static HashMap<String, Object> guistate = GUITemplateMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public GUITemplateScreen(GUITemplateMenu container, Inventory inventory, Component text) {
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

		RenderSystem.setShaderTexture(0, new ResourceLocation("critterpedia:textures/screens/guiblank.png"));
		this.blit(ms, this.leftPos + -29, this.topPos + -2, 0, 0, 236, 157, 236, 157);

		RenderSystem.setShaderTexture(0, new ResourceLocation("critterpedia:textures/screens/reptile-amphibian_icon_unclicked.png"));
		this.blit(ms, this.leftPos + -40, this.topPos + 2, 0, 0, 20, 20, 20, 20);

		RenderSystem.setShaderTexture(0, new ResourceLocation("critterpedia:textures/screens/fishiconunclicked.png"));
		this.blit(ms, this.leftPos + -40, this.topPos + 23, 0, 0, 20, 20, 20, 20);

		RenderSystem.setShaderTexture(0, new ResourceLocation("critterpedia:textures/screens/bird_icon_unclicked.png"));
		this.blit(ms, this.leftPos + -40, this.topPos + 44, 0, 0, 20, 20, 20, 20);

		RenderSystem.setShaderTexture(0, new ResourceLocation("critterpedia:textures/screens/bug_icon_unclicked.png"));
		this.blit(ms, this.leftPos + -40, this.topPos + 65, 0, 0, 20, 20, 20, 20);

		RenderSystem.setShaderTexture(0, new ResourceLocation("critterpedia:textures/screens/sea_creature_icon_unclicked.png"));
		this.blit(ms, this.leftPos + -40, this.topPos + 86, 0, 0, 20, 20, 20, 20);

		RenderSystem.setShaderTexture(0, new ResourceLocation("critterpedia:textures/screens/mammal_icon_unclicked.png"));
		this.blit(ms, this.leftPos + -40, this.topPos + 107, 0, 0, 20, 20, 20, 20);

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
		this.font.draw(poseStack, Component.translatable("gui.critterpedia.gui_template.label_welcome_to_critterpedia"), -4, 19, -1);
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
	}
}
