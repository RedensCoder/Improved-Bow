package com.Pherment.ImprovedBow;

import com.Pherment.ImprovedBow.Items.IBItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class IBCreativeTab {
    public static final CreativeModeTab TAB = new CreativeModeTab("ib_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(IBItems.BLOOD_BOW.get());
        }
    };
}
