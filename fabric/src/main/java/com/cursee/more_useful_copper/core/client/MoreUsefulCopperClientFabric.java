package com.cursee.more_useful_copper.core.client;

import com.cursee.more_useful_copper.core.client.entity.model.CopperGolemModel;
import com.cursee.more_useful_copper.core.client.entity.renderer.CopperGolemRenderer;
import com.cursee.more_useful_copper.core.entity.CopperGolem;
import com.cursee.more_useful_copper.core.registry.ModBlocksFabric;
import com.cursee.more_useful_copper.core.registry.ModEntityTypesFabric;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.renderer.RenderType;

public class MoreUsefulCopperClientFabric implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocksFabric.COPPER_CHAIN, RenderType.cutout());

        EntityModelLayerRegistry.registerModelLayer(CopperGolem.LAYER_LOCATION, CopperGolemModel::createBodyLayer);
        EntityRendererRegistry.register(ModEntityTypesFabric.COPPER_GOLEM, CopperGolemRenderer::new);

        // EntityElderGuardianSplitFix ??? todo: investigate
    }
}
