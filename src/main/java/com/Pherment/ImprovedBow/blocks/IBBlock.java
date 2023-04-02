package com.Pherment.ImprovedBow.blocks;

import com.Pherment.ImprovedBow.ImprovedBow;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class IBBlock {
    public static final DeferredRegister<Block> BLOCK = DeferredRegister.create(ForgeRegistries.BLOCKS, ImprovedBow.MODID);

    public static final RegistryObject<Block> BLOOD_ORE = BLOCK.register("blood_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(7f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> DEEPSLATE_BLOOD_ORE = BLOCK.register("deepslate_blood_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(9f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> TERANITE_ORE = BLOCK.register("teranite_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(7f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> DEEPSLATE_TERANITE_ORE = BLOCK.register("deepslate_teranite_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(9f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> TERABLOOD_BLOCK = BLOCK.register("terablood_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(5f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> BOW_CHARGER = BLOCK.register("bow_charger",
            ()-> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(5f).requiresCorrectToolForDrops()));

    public static void register(IEventBus eventBus) {
        BLOCK.register(eventBus);
    }
}
