package com.cursee.more_useful_copper.core.client.entity.renderer;

import com.cursee.more_useful_copper.Constants;
import com.cursee.more_useful_copper.core.client.entity.model.CopperGolemModel;
import com.cursee.more_useful_copper.core.entity.CopperGolem;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CopperGolemRenderer extends MobRenderer<CopperGolem, CopperGolemModel<CopperGolem>> {

    public static final ResourceLocation COPPER_GOLEM_LOCATION = new ResourceLocation(Constants.MOD_ID, "textures/entity/copper_golem/copper_golem.png");

    public CopperGolemRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new CopperGolemModel<CopperGolem>(pContext.bakeLayer(CopperGolem.LAYER_LOCATION)), 1.0F);
    }

    @Override
    public ResourceLocation getTextureLocation(CopperGolem copperGolemEntity) {
        return COPPER_GOLEM_LOCATION;
    }
}
