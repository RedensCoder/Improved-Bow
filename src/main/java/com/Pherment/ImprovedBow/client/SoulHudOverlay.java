package com.Pherment.ImprovedBow.client;

import com.Pherment.ImprovedBow.ImprovedBow;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

public class SoulHudOverlay {
    public static final ResourceLocation SOUL = new ResourceLocation(ImprovedBow.MODID,
            "textures/soul/soul.png");
    public static final ResourceLocation EMPTY_SOUL = new ResourceLocation(ImprovedBow.MODID,
            "textures/soul/empty_soul.png");

    public static final IGuiOverlay HUD_SOUL = ((gui, poseStack, partialTick, screenWidth, screenHeight) -> {
        int x = screenWidth / 2;
        int y = screenHeight;

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        RenderSystem.setShaderTexture(0, EMPTY_SOUL);

        for (int i = 0; i < 10; i++) {
            poseStack.blit(EMPTY_SOUL, x - 230 + (i * 12), y - 13, 0, 0, 12, 5, 12, 5);
        }

        RenderSystem.setShaderTexture(0, SOUL);

        for (int i = 0; i < ClientSoulData.getPlayerSouls(); i++) {
            poseStack.blit(SOUL, x - 230 + (i * 12), y - 13, 0, 0, 12, 5, 12, 5);
        }

        poseStack.drawString(Minecraft.getInstance().font, Component.literal(ClientSCData.getPlayerSC() + " SoulCollector"), x - 210, y - 25, 0xFFCC5500);
    });
}
