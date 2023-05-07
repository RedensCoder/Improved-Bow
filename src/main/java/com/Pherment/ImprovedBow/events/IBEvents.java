package com.Pherment.ImprovedBow.events;

import com.Pherment.ImprovedBow.ImprovedBow;
import com.Pherment.ImprovedBow.client.ClientSCData;
import com.Pherment.ImprovedBow.client.ClientSoulData;
import com.Pherment.ImprovedBow.soulcollectors.PlayerSC;
import com.Pherment.ImprovedBow.soulcollectors.PlayerSCProvider;
import com.Pherment.ImprovedBow.souls.PlayerSouls;
import com.Pherment.ImprovedBow.souls.PlayerSoulsProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ImprovedBow.MODID)
public class IBEvents {
    @SubscribeEvent
    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof Player) {
            if (!event.getObject().getCapability(PlayerSoulsProvider.PLAYER_SOULS).isPresent()) {
                event.addCapability(new ResourceLocation(ImprovedBow.MODID, "properties"), new PlayerSoulsProvider());
            }
            if (!event.getObject().getCapability(PlayerSCProvider.PLAYER_SC).isPresent()) {
                event.addCapability(new ResourceLocation(ImprovedBow.MODID, "properties_sc"), new PlayerSCProvider());
            }

            event.getObject().getCapability(PlayerSCProvider.PLAYER_SC).ifPresent(sc -> {
                ClientSCData.set(sc.getSC());
            });
        }
    }

    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        if (event.isWasDeath()) {
            event.getOriginal().getCapability(PlayerSoulsProvider.PLAYER_SOULS).ifPresent(oldStore -> {
                event.getOriginal().getCapability(PlayerSoulsProvider.PLAYER_SOULS).ifPresent(newStore -> {
                    newStore.copyForm(oldStore);
                });
            });
            event.getOriginal().getCapability(PlayerSCProvider.PLAYER_SC).ifPresent(oldStore -> {
                event.getOriginal().getCapability(PlayerSCProvider.PLAYER_SC).ifPresent(newStore -> {
                    newStore.copyForm(oldStore);
                    ClientSCData.set(newStore.getSC());
                });
            });
        }
    }

    @SubscribeEvent
    public static void onRegisterCapabilitites(RegisterCapabilitiesEvent event) {
        event.register(PlayerSouls.class);
        event.register(PlayerSC.class);
    }

    @SubscribeEvent
    public static void onEntityKill(LivingDeathEvent event) {
        if (event.getSource().getEntity() instanceof Player player) {
            player.getCapability(PlayerSoulsProvider.PLAYER_SOULS).ifPresent(souls -> {
                souls.addSouls(1);
                if (souls.getSouls() >= 10) {
                    player.getCapability(PlayerSCProvider.PLAYER_SC).ifPresent(sc -> {
                        sc.setSc(ClientSCData.getPlayerSC());
                        sc.addSC(1);
                        ClientSCData.set(sc.getSC());
                    });
                    souls.subSouls(10);
                }
                ClientSoulData.set(souls.getSouls());
            });
        }
    }
}
