package com.Pherment.ImprovedBow.blocks.entity.client;

import com.Pherment.ImprovedBow.ImprovedBow;
import com.Pherment.ImprovedBow.blocks.entity.custom.BowChargerAnimated;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BowChargerModel extends AnimatedGeoModel<BowChargerAnimated> {

    @Override
    public ResourceLocation getModelResource(BowChargerAnimated object) {
        return new ResourceLocation(ImprovedBow.MODID, "geo/bow_charger.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BowChargerAnimated object) {
        return new ResourceLocation(ImprovedBow.MODID, "textures/block/bow_charger_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BowChargerAnimated animatable) {
        return new ResourceLocation(ImprovedBow.MODID, "animations/bow_charger.animation.json");
    }
}
