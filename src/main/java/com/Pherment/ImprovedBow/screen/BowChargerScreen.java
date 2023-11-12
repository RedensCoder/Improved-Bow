package com.Pherment.ImprovedBow.screen;

import com.Pherment.ImprovedBow.ImprovedBow;
import com.Pherment.ImprovedBow.client.ClientNeedSCData;
import com.Pherment.ImprovedBow.client.ClientSCData;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class BowChargerScreen extends AbstractContainerScreen<BowChargerMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(ImprovedBow.MODID,"textures/gui/bowcharger_gui.png");

    public BowChargerScreen(BowChargerMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        super.init();
        this.inventoryLabelY = 10000;
        this.titleLabelY = 10000;
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(TEXTURE,x, y, 0, 0, imageWidth, imageHeight);

        renderProgressArrow(guiGraphics, x, y);

        if(!menu.isCrafting()) {
            if (ClientNeedSCData.getNeedSC() > ClientSCData.getPlayerSC()) {
                guiGraphics.drawString(Minecraft.getInstance().font, Component.literal("Cost " + ClientNeedSCData.getNeedSC() + " SoulCollector"), 11, 20, 0xFFFFFF);
            }
        }
    }

    private void renderProgressArrow(GuiGraphics guiGraphics, int x, int y) {
        if(menu.isCrafting()) {
            guiGraphics.blit(TEXTURE,x + 105, y + 33, 176, 0, 8, menu.getScaledProgress());
        }
    }

    @Override
    public void render(GuiGraphics guiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        renderBackground(guiGraphics);
        super.render(guiGraphics, pMouseX, pMouseY, pPartialTick);
        renderTooltip(guiGraphics, pMouseX, pMouseY);
    }
}
