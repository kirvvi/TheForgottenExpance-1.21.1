package net.kirvvi.theforgottenexpance.entity.client.rock;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.kirvvi.theforgottenexpance.TheForgottenExpance;
import net.kirvvi.theforgottenexpance.entity.custom.RockProjectileEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class RockProjectileRenderer extends EntityRenderer<RockProjectileEntity> {
    private RockProjectileModel model;

    public RockProjectileRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new RockProjectileModel(context.bakeLayer(RockProjectileModel.LAYER_LOCATION));
    }

    @Override
    public void render(RockProjectileEntity pEntity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        poseStack.pushPose();

        if (!pEntity.isGrounded()) {
            float rotation = pEntity.getRenderingRotation();
            poseStack.mulPose(Axis.YP.rotationDegrees(rotation));
            poseStack.translate(0, -1.0f, 0);
        }

        VertexConsumer vertexConsumer = ItemRenderer.getFoilBufferDirect(
                buffer, this.model.renderType(this.getTextureLocation(pEntity)), false, false);
        this.model.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY);

        poseStack.popPose();
        super.render(pEntity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }


    @Override
    public ResourceLocation getTextureLocation(RockProjectileEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(TheForgottenExpance.MODID, "textures/entity/rock/rock_3d.png");
    }
}