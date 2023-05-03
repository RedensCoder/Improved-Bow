package com.Pherment.ImprovedBow.Items;

import com.Pherment.ImprovedBow.IBCreativeTab;
import com.Pherment.ImprovedBow.ImprovedBow;
import com.Pherment.ImprovedBow.Items.custom.BloodBow;
import com.Pherment.ImprovedBow.Items.custom.BowChargerItemAnimated;
import com.Pherment.ImprovedBow.blocks.IBBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class IBItems {
    public static final DeferredRegister<Item> ITEM = DeferredRegister.create(ForgeRegistries.ITEMS, ImprovedBow.MODID);

    // ITEMS
    public static final RegistryObject<Item> BLOOD = ITEM.register("blood",
            ()-> new Item(new Item.Properties().tab(IBCreativeTab.TAB)));
    public static final RegistryObject<Item> TERANITE = ITEM.register("teranite",
            ()-> new Item(new Item.Properties().tab(IBCreativeTab.TAB)));
    // ARTIFACTS
    public static final RegistryObject<Item> TERABLOOD = ITEM.register("terablood",
            ()-> new Item(new Item.Properties().tab(IBCreativeTab.TAB)));
    public static final RegistryObject<Item> TERASCOPE = ITEM.register("terascope",
            ()-> new Item(new Item.Properties().tab(IBCreativeTab.TAB)));
    public static final RegistryObject<Item> DRGON_EYE = ITEM.register("dragon_eye",
            ()-> new Item(new Item.Properties().tab(IBCreativeTab.TAB)));
    // BOWS
    public static final RegistryObject<Item> BLOOD_BOW = ITEM.register("blood_bow",
            () -> new BloodBow(new Item.Properties().tab(IBCreativeTab.TAB), 0.0D, 19.0F, 1));
    public static final RegistryObject<Item> BLOOD_BOW_LVL2 = ITEM.register("blood_bow_lvl2",
            () -> new BloodBow(new Item.Properties().tab(IBCreativeTab.TAB), 0.1D, 19.0F, 2));
    public static final RegistryObject<Item> BLOOD_BOW_LVL3 = ITEM.register("blood_bow_lvl3",
            () -> new BloodBow(new Item.Properties().tab(IBCreativeTab.TAB), 0.1D, 18.0F, 3));
    public static final RegistryObject<Item> BLOOD_BOW_LVL4 = ITEM.register("blood_bow_lvl4",
            () -> new BloodBow(new Item.Properties().tab(IBCreativeTab.TAB), 0.2D, 18.0F, 4));
    public static final RegistryObject<Item> BLOOD_BOW_LVL5 = ITEM.register("blood_bow_lvl5",
            () -> new BloodBow(new Item.Properties().tab(IBCreativeTab.TAB), 0.2D, 18.0F, 5));
    public static final RegistryObject<Item> BLOOD_BOW_LVL6 = ITEM.register("blood_bow_lvl6",
            () -> new BloodBow(new Item.Properties().tab(IBCreativeTab.TAB), 0.2D, 18.0F, 6));
    public static final RegistryObject<Item> BLOOD_BOW_LVL7 = ITEM.register("blood_bow_lvl7",
            () -> new BloodBow(new Item.Properties().tab(IBCreativeTab.TAB), 0.3D, 16.0F, 7));
    public static final RegistryObject<Item> BLOOD_BOW_LVL8 = ITEM.register("blood_bow_lvl8",
            () -> new BloodBow(new Item.Properties().tab(IBCreativeTab.TAB), 0.3D, 16.0F, 8));
    public static final RegistryObject<Item> BLOOD_BOW_LVL9 = ITEM.register("blood_bow_lvl9",
            () -> new BloodBow(new Item.Properties().tab(IBCreativeTab.TAB), 1.3D, 6.0F, 9));
    public static final RegistryObject<Item> BLOOD_BOW_LVL10 = ITEM.register("blood_bow_lvl10",
            () -> new BloodBow(new Item.Properties().tab(IBCreativeTab.TAB), 3.2D, 1.0F, 10));

    // BLOCKS
    public static final RegistryObject<Item> BLOOD_ORE = ITEM.register("blood_ore",
            ()-> new BlockItem(IBBlock.BLOOD_ORE.get() ,new Item.Properties().tab(IBCreativeTab.TAB)));
    public static final RegistryObject<Item> DEEPSLATE_BLOOD_ORE = ITEM.register("deepslate_blood_ore",
            ()-> new BlockItem(IBBlock.DEEPSLATE_BLOOD_ORE.get() ,new Item.Properties().tab(IBCreativeTab.TAB)));
    public static final RegistryObject<Item> TERANITE_ORE = ITEM.register("teranite_ore",
            ()-> new BlockItem(IBBlock.TERANITE_ORE.get() ,new Item.Properties().tab(IBCreativeTab.TAB)));
    public static final RegistryObject<Item> DEEPSLATE_TERANITE_ORE = ITEM.register("deepslate_teranite_ore",
            ()-> new BlockItem(IBBlock.DEEPSLATE_TERANITE_ORE.get() ,new Item.Properties().tab(IBCreativeTab.TAB)));
    public static final RegistryObject<Item> TERABLOOD_BLOCK = ITEM.register("terablood_block",
            ()-> new BlockItem(IBBlock.TERABLOOD_BLOCK.get() ,new Item.Properties().tab(IBCreativeTab.TAB)));
    public static final RegistryObject<Item> BOW_CHARGER = ITEM.register("bow_charger",
            ()-> new BowChargerItemAnimated(IBBlock.BOW_CHARGER.get() ,new Item.Properties().tab(IBCreativeTab.TAB)));

    public static void register(IEventBus eventBus) {
        ITEM.register(eventBus);
    }
}