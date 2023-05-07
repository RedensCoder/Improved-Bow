package com.Pherment.ImprovedBow.events;

import com.Pherment.ImprovedBow.ImprovedBow;
import com.Pherment.ImprovedBow.blocks.entity.IBBlockEntities;
import com.Pherment.ImprovedBow.blocks.entity.client.BowChargerRenderer;
import com.Pherment.ImprovedBow.client.SoulHudOverlay;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ImprovedBow.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientEvents {
        @SubscribeEvent
        public static void registerGuiOverlay(RegisterGuiOverlaysEvent event) {
            event.registerBelowAll("souls", SoulHudOverlay.HUD_SOUL);
        }

        @SubscribeEvent
        public static void registerRenders(final EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(IBBlockEntities.BOW_CHARGER.get(), BowChargerRenderer::new);
        }
}
