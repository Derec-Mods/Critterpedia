package net.derex.critterpedia.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.Minecraft;

import net.derex.critterpedia.world.inventory.AmphGUIMenu;
import net.derex.critterpedia.network.AmphGUIButtonMessage;
import net.derex.critterpedia.CritterpediaMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class AmphGUIScreen extends AbstractContainerScreen<AmphGUIMenu> {
	private final static HashMap<String, Object> guistate = AmphGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_fishiconunclicked;
	ImageButton imagebutton_bird_icon_unclicked;
	ImageButton imagebutton_bug_icon_unclicked;
	ImageButton imagebutton_sea_creature_icon_unclicked;
	ImageButton imagebutton_mammal_icon_unclicked;
	ImageButton imagebutton_alligator_snapping_turtle;
	ImageButton imagebutton_american_alligator;
	ImageButton imagebutton_salt_water_crocodile;
	ImageButton imagebutton_bearded_dragon;
	ImageButton imagebutton_common_snapping_turtle;
	ImageButton imagebutton_aldabra_tortoise;
	ImageButton imagebutton_sulcata_tortoise;
	ImageButton imagebutton_pixie_frog;

	public AmphGUIScreen(AmphGUIMenu container, Inventory inventory, Component text) {
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

		RenderSystem.setShaderTexture(0, new ResourceLocation("critterpedia:textures/screens/reptile_amphibian_icon_clcked.png"));
		this.blit(ms, this.leftPos + -40, this.topPos + 2, 0, 0, 20, 20, 20, 20);

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
		imagebutton_fishiconunclicked = new ImageButton(this.leftPos + -40, this.topPos + 23, 20, 20, 0, 0, 20, new ResourceLocation("critterpedia:textures/screens/atlas/imagebutton_fishiconunclicked.png"), 20, 40, e -> {
			if (true) {
				CritterpediaMod.PACKET_HANDLER.sendToServer(new AmphGUIButtonMessage(0, x, y, z));
				AmphGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_fishiconunclicked", imagebutton_fishiconunclicked);
		this.addRenderableWidget(imagebutton_fishiconunclicked);
		imagebutton_bird_icon_unclicked = new ImageButton(this.leftPos + -40, this.topPos + 44, 20, 20, 0, 0, 20, new ResourceLocation("critterpedia:textures/screens/atlas/imagebutton_bird_icon_unclicked.png"), 20, 40, e -> {
			if (true) {
				CritterpediaMod.PACKET_HANDLER.sendToServer(new AmphGUIButtonMessage(1, x, y, z));
				AmphGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_bird_icon_unclicked", imagebutton_bird_icon_unclicked);
		this.addRenderableWidget(imagebutton_bird_icon_unclicked);
		imagebutton_bug_icon_unclicked = new ImageButton(this.leftPos + -40, this.topPos + 65, 20, 20, 0, 0, 20, new ResourceLocation("critterpedia:textures/screens/atlas/imagebutton_bug_icon_unclicked.png"), 20, 40, e -> {
			if (true) {
				CritterpediaMod.PACKET_HANDLER.sendToServer(new AmphGUIButtonMessage(2, x, y, z));
				AmphGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_bug_icon_unclicked", imagebutton_bug_icon_unclicked);
		this.addRenderableWidget(imagebutton_bug_icon_unclicked);
		imagebutton_sea_creature_icon_unclicked = new ImageButton(this.leftPos + -40, this.topPos + 86, 20, 20, 0, 0, 20, new ResourceLocation("critterpedia:textures/screens/atlas/imagebutton_sea_creature_icon_unclicked.png"), 20, 40, e -> {
			if (true) {
				CritterpediaMod.PACKET_HANDLER.sendToServer(new AmphGUIButtonMessage(3, x, y, z));
				AmphGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_sea_creature_icon_unclicked", imagebutton_sea_creature_icon_unclicked);
		this.addRenderableWidget(imagebutton_sea_creature_icon_unclicked);
		imagebutton_mammal_icon_unclicked = new ImageButton(this.leftPos + -40, this.topPos + 107, 20, 20, 0, 0, 20, new ResourceLocation("critterpedia:textures/screens/atlas/imagebutton_mammal_icon_unclicked.png"), 20, 40, e -> {
			if (true) {
				CritterpediaMod.PACKET_HANDLER.sendToServer(new AmphGUIButtonMessage(4, x, y, z));
				AmphGUIButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:imagebutton_mammal_icon_unclicked", imagebutton_mammal_icon_unclicked);
		this.addRenderableWidget(imagebutton_mammal_icon_unclicked);
		imagebutton_alligator_snapping_turtle = new ImageButton(this.leftPos + 23, this.topPos + 18, 22, 15, 0, 0, 15, new ResourceLocation("critterpedia:textures/screens/atlas/imagebutton_alligator_snapping_turtle.png"), 22, 30, e -> {
		});
		guistate.put("button:imagebutton_alligator_snapping_turtle", imagebutton_alligator_snapping_turtle);
		this.addRenderableWidget(imagebutton_alligator_snapping_turtle);
		imagebutton_american_alligator = new ImageButton(this.leftPos + 94, this.topPos + 103, 35, 14, 0, 0, 14, new ResourceLocation("critterpedia:textures/screens/atlas/imagebutton_american_alligator.png"), 35, 28, e -> {
		});
		guistate.put("button:imagebutton_american_alligator", imagebutton_american_alligator);
		this.addRenderableWidget(imagebutton_american_alligator);
		imagebutton_salt_water_crocodile = new ImageButton(this.leftPos + 49, this.topPos + 103, 39, 16, 0, 0, 16, new ResourceLocation("critterpedia:textures/screens/atlas/imagebutton_salt_water_crocodile.png"), 39, 32, e -> {
		});
		guistate.put("button:imagebutton_salt_water_crocodile", imagebutton_salt_water_crocodile);
		this.addRenderableWidget(imagebutton_salt_water_crocodile);
		imagebutton_bearded_dragon = new ImageButton(this.leftPos + 23, this.topPos + 39, 23, 11, 0, 0, 11, new ResourceLocation("critterpedia:textures/screens/atlas/imagebutton_bearded_dragon.png"), 23, 22, e -> {
		});
		guistate.put("button:imagebutton_bearded_dragon", imagebutton_bearded_dragon);
		this.addRenderableWidget(imagebutton_bearded_dragon);
		imagebutton_common_snapping_turtle = new ImageButton(this.leftPos + -8, this.topPos + 9, 22, 16, 0, 0, 16, new ResourceLocation("critterpedia:textures/screens/atlas/imagebutton_common_snapping_turtle.png"), 22, 32, e -> {
		});
		guistate.put("button:imagebutton_common_snapping_turtle", imagebutton_common_snapping_turtle);
		this.addRenderableWidget(imagebutton_common_snapping_turtle);
		imagebutton_aldabra_tortoise = new ImageButton(this.leftPos + 52, this.topPos + 28, 26, 22, 0, 0, 22, new ResourceLocation("critterpedia:textures/screens/atlas/imagebutton_aldabra_tortoise.png"), 26, 44, e -> {
		});
		guistate.put("button:imagebutton_aldabra_tortoise", imagebutton_aldabra_tortoise);
		this.addRenderableWidget(imagebutton_aldabra_tortoise);
		imagebutton_sulcata_tortoise = new ImageButton(this.leftPos + 23, this.topPos + 54, 19, 14, 0, 0, 14, new ResourceLocation("critterpedia:textures/screens/atlas/imagebutton_sulcata_tortoise.png"), 19, 28, e -> {
		});
		guistate.put("button:imagebutton_sulcata_tortoise", imagebutton_sulcata_tortoise);
		this.addRenderableWidget(imagebutton_sulcata_tortoise);
		imagebutton_pixie_frog = new ImageButton(this.leftPos + 52, this.topPos + 52, 18, 16, 0, 0, 16, new ResourceLocation("critterpedia:textures/screens/atlas/imagebutton_pixie_frog.png"), 18, 32, e -> {
		});
		guistate.put("button:imagebutton_pixie_frog", imagebutton_pixie_frog);
		this.addRenderableWidget(imagebutton_pixie_frog);
	}
}
