package com.Pherment.ImprovedBow.screen;

import com.Pherment.ImprovedBow.ImprovedBow;
import com.Pherment.ImprovedBow.client.ClientNeedSCData;
import com.Pherment.ImprovedBow.client.ClientSCData;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
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
    }

    @Override
    protected void renderBg(PoseStack pPoseStack, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        this.blit(pPoseStack, x, y, 0, 0, imageWidth, imageHeight);
        renderProgressArrow(pPoseStack, x, y);

        if(!menu.isCrafting()) {
            if (ClientNeedSCData.getNeedSC() > ClientSCData.getPlayerSC()) {
                drawString(pPoseStack, Minecraft.getInstance().font, Component.literal("Cost " + ClientNeedSCData.getNeedSC() + " SoulCollector"), 11, 20, 0xFFFFFF);
            }
        }
    }

    private void renderProgressArrow(PoseStack pPoseStack, int x, int y) {
        if(menu.isCrafting()) {
            blit(pPoseStack, x + 105, y + 33, 176, 0, 8, menu.getScaledProgress());
        }
    }

    @Override
    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        renderBackground(pPoseStack);
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        renderTooltip(pPoseStack, pMouseX, pMouseY);
    }
}
