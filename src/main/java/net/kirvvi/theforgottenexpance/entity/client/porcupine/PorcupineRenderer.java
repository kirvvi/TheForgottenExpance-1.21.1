package net.kirvvi.theforgottenexpance.entity.client.porcupine;

import com.mojang.blaze3d.vertex.PoseStack;
import net.kirvvi.theforgottenexpance.TheForgottenExpance;
import net.kirvvi.theforgottenexpance.entity.custom.PorcupineEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class PorcupineRenderer extends MobRenderer<PorcupineEntity, PorcupineModel<PorcupineEntity>> {
    public PorcupineRenderer(EntityRendererProvider.Context context) {
        super(context, new PorcupineModel<>(context.bakeLayer(PorcupineModel.LAYER_LOCATION)), 0.4f);
    }

    @Override
    public ResourceLocation getTextureLocation(PorcupineEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(TheForgottenExpance.MODID,"textures/entity/porcupine/porcupine.png");
    }

    @Override
    public void render(PorcupineEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        if (entity.isBaby()){
            poseStack.scale(0.45f, 0.45f, 0.45f);
        }else {
            poseStack.scale(1f, 1f, 1f);
        }
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}
