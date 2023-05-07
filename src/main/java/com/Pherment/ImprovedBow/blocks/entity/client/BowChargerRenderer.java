package com.Pherment.ImprovedBow.blocks.entity.client;

import com.Pherment.ImprovedBow.blocks.entity.custom.BowChargerAnimated;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;

public class BowChargerRenderer extends GeoBlockRenderer<BowChargerAnimated> {
    public BowChargerRenderer(BlockEntityRendererProvider.Context context) {
        super(context, new BowChargerModel());
    }

    @Override
    public RenderType getRenderType(BowChargerAnimated animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer, @Nullable VertexConsumer vertexBuilder,
                                    int packedLightIn, ResourceLocation textureLocation) {
        return RenderType.entityTranslucent(getTextureLocation(animatable));
    }
}
