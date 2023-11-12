package com.Pherment.ImprovedBow;

import com.Pherment.ImprovedBow.Items.IBItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class IBCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CreativeTab = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ImprovedBow.MODID);

    public static final RegistryObject<CreativeModeTab> IBTab = CreativeTab.register("ib_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(IBItems.BLOOD_BOW.get()))
                    .title(Component.translatable("itemGroup.ib_tab"))
                    .displayItems(((pParameters, pOutput) -> {
                        pOutput.accept(IBItems.BLOOD_ORE.get());
                        pOutput.accept(IBItems.DEEPSLATE_BLOOD_ORE.get());
                        pOutput.accept(IBItems.TERANITE_ORE.get());
                        pOutput.accept(IBItems.DEEPSLATE_TERANITE_ORE.get());
                        pOutput.accept(IBItems.BLOOD.get());
                        pOutput.accept(IBItems.TERANITE.get());
                        pOutput.accept(IBItems.TERABLOOD.get());
                        pOutput.accept(IBItems.TERASCOPE.get());
                        pOutput.accept(IBItems.TERABLOOD_BLOCK.get());
                        pOutput.accept(IBItems.DRGON_EYE.get());
                        pOutput.accept(IBItems.BOW_CHARGER.get());
                        pOutput.accept(IBItems.BLOOD_BOW.get());
                        pOutput.accept(IBItems.BLOOD_BOW_LVL2.get());
                        pOutput.accept(IBItems.BLOOD_BOW_LVL3.get());
                        pOutput.accept(IBItems.BLOOD_BOW_LVL4.get());
                        pOutput.accept(IBItems.BLOOD_BOW_LVL5.get());
                        pOutput.accept(IBItems.BLOOD_BOW_LVL6.get());
                        pOutput.accept(IBItems.BLOOD_BOW_LVL7.get());
                        pOutput.accept(IBItems.BLOOD_BOW_LVL8.get());
                        pOutput.accept(IBItems.BLOOD_BOW_LVL9.get());
                        pOutput.accept(IBItems.BLOOD_BOW_LVL10.get());
                    }))
                    .build());

    public static void register(IEventBus eventBus) {
        CreativeTab.register(eventBus);
    }
}
