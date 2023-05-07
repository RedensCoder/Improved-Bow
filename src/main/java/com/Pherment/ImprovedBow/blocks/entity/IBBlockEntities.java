package com.Pherment.ImprovedBow.blocks.entity;

import com.Pherment.ImprovedBow.ImprovedBow;
import com.Pherment.ImprovedBow.blocks.IBBlock;
import com.Pherment.ImprovedBow.blocks.entity.custom.BowChargerAnimated;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class IBBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCKENTITY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ImprovedBow.MODID);

    public static final RegistryObject<BlockEntityType<BowChargerAnimated>> BOW_CHARGER =
            BLOCKENTITY.register("bow_charger", () ->
                    BlockEntityType.Builder.of(BowChargerAnimated::new,
                            IBBlock.BOW_CHARGER.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCKENTITY.register(eventBus);
    }
}
