package com.Pherment.ImprovedBow;

import com.Pherment.ImprovedBow.Items.IBItems;
import com.Pherment.ImprovedBow.blocks.IBBlock;
import com.Pherment.ImprovedBow.blocks.entity.IBBlockEntities;
import com.Pherment.ImprovedBow.blocks.entity.client.BowChargerRenderer;
import com.Pherment.ImprovedBow.recipe.IBRecipes;
import com.Pherment.ImprovedBow.screen.BowChargerScreen;
import com.Pherment.ImprovedBow.screen.IBMenutypes;
import com.Pherment.ImprovedBow.util.IBItemProperties;
import com.Pherment.ImprovedBow.world.feature.IBConfiguredFeatures;
import com.Pherment.ImprovedBow.world.feature.IBPlacedFeatures;
import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;
import software.bernie.geckolib3.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ImprovedBow.MODID)
public class ImprovedBow
{
    public static final String MODID = "improvedbow";
    private static final Logger LOGGER = LogUtils.getLogger();

    public ImprovedBow()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);

        IBItems.register(modEventBus);
        IBBlock.register(modEventBus);
        IBBlockEntities.register(modEventBus);
        IBMenutypes.register(modEventBus);
        IBRecipes.register(modEventBus);

        GeckoLib.initialize();

        IBConfiguredFeatures.register(modEventBus);
        IBPlacedFeatures.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("HELLO FROM COMMON SETUP");
        LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        LOGGER.info("HELLO from server starting");
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            IBItemProperties.addCustomItemProperties();
            BlockEntityRenderers.register(IBBlockEntities.BOW_CHARGER.get(), BowChargerRenderer::new);

            MenuScreens.register(IBMenutypes.BOWCHARGER_MENU.get(), BowChargerScreen::new);
        }
    }
}
