package com.Pherment.ImprovedBow.world.feature;

import com.Pherment.ImprovedBow.ImprovedBow;
import com.Pherment.ImprovedBow.blocks.IBBlock;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class IBConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIG_FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, ImprovedBow.MODID);

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_BLOOD_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, IBBlock.BLOOD_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, IBBlock.DEEPSLATE_BLOOD_ORE.get().defaultBlockState())
    ));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_TERANITE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, IBBlock.TERANITE_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, IBBlock.DEEPSLATE_TERANITE_ORE.get().defaultBlockState())
    ));

    public static final RegistryObject<ConfiguredFeature<?, ?>> BLOOD_ORE = CONFIG_FEATURES.register("blood_ore",
            ()-> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_BLOOD_ORES.get(), 9)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> TERANITE_ORE = CONFIG_FEATURES.register("teranite_ore",
            ()-> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_TERANITE_ORES.get(), 7)));

    public static void register(IEventBus eventBus) {
        CONFIG_FEATURES.register(eventBus);
    }
}