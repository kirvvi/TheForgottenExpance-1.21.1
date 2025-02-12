package net.kirvvi.theforgottenexpance.entity.client.mummy;

import com.mojang.blaze3d.vertex.PoseStack;
import net.kirvvi.theforgottenexpance.TheForgottenExpance;
import net.kirvvi.theforgottenexpance.entity.custom.MummyEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class MummyRenderer extends MobRenderer<MummyEntity, MummyModel<MummyEntity>> {
    public MummyRenderer(EntityRendererProvider.Context context) {
        super(context, new MummyModel<>(context.bakeLayer(MummyModel.LAYER_LOCATION)), 0.6f);
    }

    @Override
    public ResourceLocation getTextureLocation(MummyEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(TheForgottenExpance.MODID,"textures/entity/mummy/mummy.png");
    }

    @Override
    public void render(MummyEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        if(entity.isBaby()){
            poseStack.scale(0.45f, 0.45f, 0.45f);
        } else{
            poseStack.scale(1f, 1f, 1f);
        }
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}
