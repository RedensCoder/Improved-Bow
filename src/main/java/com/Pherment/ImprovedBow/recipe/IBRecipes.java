package com.Pherment.ImprovedBow.recipe;

import com.Pherment.ImprovedBow.ImprovedBow;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class IBRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, ImprovedBow.MODID);

    public static final RegistryObject<RecipeSerializer<BowChargerRecipe>> BOWCHARGER_SERIALIZER = SERIALIZERS.register("bow_charger",
            () -> BowChargerRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
