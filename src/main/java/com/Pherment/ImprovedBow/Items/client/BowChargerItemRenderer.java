package com.Pherment.ImprovedBow.Items.client;

import com.Pherment.ImprovedBow.Items.custom.BowChargerItemAnimated;
import com.Pherment.ImprovedBow.blocks.entity.custom.BowChargerAnimated;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class BowChargerItemRenderer extends GeoItemRenderer<BowChargerItemAnimated> {
    public BowChargerItemRenderer() {
        super(new BowChargerItemModel());
    }
}
