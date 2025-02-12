package net.kirvvi.theforgottenexpance.entity.client.destroyedcoconut;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.kirvvi.theforgottenexpance.TheForgottenExpance;
import net.kirvvi.theforgottenexpance.entity.client.crushedcoconut.CrushedCoconutProjectileModel;
import net.kirvvi.theforgottenexpance.entity.custom.CrushedCoconutProjectileEntity;
import net.kirvvi.theforgottenexpance.entity.custom.DestroyedCoconutProjectileEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class DestroyedCoconutProjectileRenderer extends EntityRenderer<DestroyedCoconutProjectileEntity> {
    private DestroyedCoconutProjectileModel model;

    public DestroyedCoconutProjectileRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new DestroyedCoconutProjectileModel(context.bakeLayer(DestroyedCoconutProjectileModel.LAYER_LOCATION));
    }

    @Override
    public void render(DestroyedCoconutProjectileEntity pEntity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        poseStack.pushPose();

        poseStack.translate(0, -1.0f, 0);

        VertexConsumer vertexConsumer = ItemRenderer.getFoilBufferDirect(
                buffer, this.model.renderType(this.getTextureLocation(pEntity)), false, false);
        this.model.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY);

        poseStack.popPose();
        super.render(pEntity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(DestroyedCoconutProjectileEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(TheForgottenExpance.MODID, "textures/entity/coconut/destroyed_coconut_3d.png");
    }
}
