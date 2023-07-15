
package net.derex.critterpedia.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.derex.critterpedia.world.inventory.GUIBaseMenu;
import net.derex.critterpedia.network.GUIBaseButtonMessage;
import net.derex.critterpedia.CritterpediaMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.components.ImageButton;

public class GUIBaseScreen extends AbstractContainerScreen<GUIBaseMenu> {
	private final static HashMap<String, Object> guistate = GUIBaseMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private static final ResourceLocation MYIMAGE = new ResourceLocation("critterpedia:textures/guibuttons.png");

	public GUIBaseScreen(GUIBaseMenu container, Inventory inventory, Component text) {
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
		this.font.draw(poseStack, Component.translatable("gui.critterpedia.gui_base.label_welcome_to_critterpedia"), -4, 19, -1);
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
//		this.addRenderableWidget(new Button(this.leftPos + -40, this.topPos + 2, 18, 20, Component.translatable("gui.critterpedia.gui_base.button_rep"), e -> {
//			if (true) {
//				CritterpediaMod.PACKET_HANDLER.sendToServer(new GUIBaseButtonMessage(0, x, y, z));
//				GUIBaseButtonMessage.handleButtonAction(entity, 0, x, y, z);
//			}
//		}));
        this.addRenderableWidget(new ImageButton(this.leftPos + -40, this.topPos + 2, 18, 20, 0, 0, 20, MYIMAGE, e -> {
         if (true) {
                CritterpediaMod.PACKET_HANDLER.sendToServer(new GUIBaseButtonMessage(0, x, y, z));
                GUIBaseButtonMessage.handleButtonAction(entity, 0, x, y, z); 
            }

         ((ImageButton)e).setPosition(this.leftPos + -40, this.topPos + 2);
      }));
//		this.addRenderableWidget(new Button(this.leftPos + -40, this.topPos + 23, 18, 20, Component.translatable("gui.critterpedia.gui_base.button_fish"), e -> {
//			if (true) {
//				CritterpediaMod.PACKET_HANDLER.sendToServer(new GUIBaseButtonMessage(1, x, y, z));
//				GUIBaseButtonMessage.handleButtonAction(entity, 1, x, y, z);
//			}
//		}));
        this.addRenderableWidget(new ImageButton(this.leftPos + -40, this.topPos + 23, 18, 20, 0, 40, 20, MYIMAGE, e -> {
         if (true) {
                CritterpediaMod.PACKET_HANDLER.sendToServer(new GUIBaseButtonMessage(1, x, y, z));
                GUIBaseButtonMessage.handleButtonAction(entity, 1, x, y, z); 
            }

         ((ImageButton)e).setPosition(this.leftPos + -40, this.topPos + 23);
      }));
//		this.addRenderableWidget(new Button(this.leftPos + -40, this.topPos + 44, 18, 20, Component.translatable("gui.critterpedia.gui_base.button_bird"), e -> {
//			if (true) {
//				CritterpediaMod.PACKET_HANDLER.sendToServer(new GUIBaseButtonMessage(2, x, y, z));
//				GUIBaseButtonMessage.handleButtonAction(entity, 2, x, y, z);
//			}
//		}));
        this.addRenderableWidget(new ImageButton(this.leftPos + -40, this.topPos + 44, 18, 20, 0, 80, 20, MYIMAGE, e -> {
         if (true) {
                CritterpediaMod.PACKET_HANDLER.sendToServer(new GUIBaseButtonMessage(2, x, y, z));
                GUIBaseButtonMessage.handleButtonAction(entity, 2, x, y, z); 
            }

         ((ImageButton)e).setPosition(this.leftPos + -40, this.topPos + 44);
      }));
//		this.addRenderableWidget(new Button(this.leftPos + -40, this.topPos + 65, 18, 20, Component.translatable("gui.critterpedia.gui_base.button_bug"), e -> {
//			if (true) {
//				CritterpediaMod.PACKET_HANDLER.sendToServer(new GUIBaseButtonMessage(3, x, y, z));
//				GUIBaseButtonMessage.handleButtonAction(entity, 3, x, y, z);
//			}
//		}));
        this.addRenderableWidget(new ImageButton(this.leftPos + -40, this.topPos + 65, 18, 20, 0, 120, 20, MYIMAGE, e -> {
         if (true) {
                CritterpediaMod.PACKET_HANDLER.sendToServer(new GUIBaseButtonMessage(3, x, y, z));
                GUIBaseButtonMessage.handleButtonAction(entity, 3, x, y, z); 
            }

         ((ImageButton)e).setPosition(this.leftPos + -40, this.topPos + 65);
      }));
//		this.addRenderableWidget(new Button(this.leftPos + -40, this.topPos + 86, 18, 20, Component.translatable("gui.critterpedia.gui_base.button_sea"), e -> {
//			if (true) {
//				CritterpediaMod.PACKET_HANDLER.sendToServer(new GUIBaseButtonMessage(4, x, y, z));
//				GUIBaseButtonMessage.handleButtonAction(entity, 4, x, y, z);
//			}
//		}));
        this.addRenderableWidget(new ImageButton(this.leftPos + -40, this.topPos + 86, 18, 20, 0, 160, 20, MYIMAGE, e -> {
         if (true) {
                CritterpediaMod.PACKET_HANDLER.sendToServer(new GUIBaseButtonMessage(4, x, y, z));
                GUIBaseButtonMessage.handleButtonAction(entity, 4, x, y, z); 
            }

         ((ImageButton)e).setPosition(this.leftPos + -40, this.topPos + 86);
      }));
//		this.addRenderableWidget(new Button(this.leftPos + -40, this.topPos + 107, 18, 20, Component.translatable("gui.critterpedia.gui_base.button_mam"), e -> {
//			if (true) {
//				CritterpediaMod.PACKET_HANDLER.sendToServer(new GUIBaseButtonMessage(5, x, y, z));
//				GUIBaseButtonMessage.handleButtonAction(entity, 5, x, y, z);
//			}
//		}));
        this.addRenderableWidget(new ImageButton(this.leftPos + -40, this.topPos + 107, 18, 20, 0, 200, 20, MYIMAGE, e -> {
         if (true) {
                CritterpediaMod.PACKET_HANDLER.sendToServer(new GUIBaseButtonMessage(5, x, y, z));
                GUIBaseButtonMessage.handleButtonAction(entity, 5, x, y, z); 
            }

         ((ImageButton)e).setPosition(this.leftPos + -40, this.topPos + 107);
      }));
	}
}
