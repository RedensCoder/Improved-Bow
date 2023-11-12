package com.Pherment.ImprovedBow.Items.client;

import com.Pherment.ImprovedBow.ImprovedBow;
import com.Pherment.ImprovedBow.Items.custom.BowChargerItemAnimated;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class BowChargerItemModel extends GeoModel<BowChargerItemAnimated> {
    @Override
    public ResourceLocation getModelResource(BowChargerItemAnimated object) {
        return new ResourceLocation(ImprovedBow.MODID, "geo/bow_charger.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BowChargerItemAnimated object) {
        return new ResourceLocation(ImprovedBow.MODID, "textures/block/bow_charger_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BowChargerItemAnimated animatable) {
        return new ResourceLocation(ImprovedBow.MODID, "animations/bow_charger.animation.json");
    }
}
