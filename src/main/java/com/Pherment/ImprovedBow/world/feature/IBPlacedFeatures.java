package com.Pherment.ImprovedBow.world.feature;

import com.Pherment.ImprovedBow.ImprovedBow;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class IBPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, ImprovedBow.MODID);

    public static final RegistryObject<PlacedFeature> BLOOD_ORE_PLACED = PLACED.register("blood_ore_placed",
            ()-> new PlacedFeature(IBConfiguredFeatures.BLOOD_ORE.getHolder().get(),
                    commonOrePlacement(7,
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-50), VerticalAnchor.aboveBottom(70)))));
    public static final RegistryObject<PlacedFeature> TERANITE_ORE_PLACED = PLACED.register("teranite_ore_placed",
            ()-> new PlacedFeature(IBConfiguredFeatures.TERANITE_ORE.getHolder().get(),
                    commonOrePlacement(5,
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-50), VerticalAnchor.aboveBottom(40)))));

    public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }
    public static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }
    public static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }

    public static void register(IEventBus eventBus) {
        PLACED.register(eventBus);
    }
}
