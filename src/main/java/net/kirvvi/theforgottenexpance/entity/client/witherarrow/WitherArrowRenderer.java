package net.kirvvi.theforgottenexpance.entity.client.witherarrow;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.kirvvi.theforgottenexpance.TheForgottenExpance;
import net.kirvvi.theforgottenexpance.entity.custom.WitherArrowEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class WitherArrowRenderer extends EntityRenderer<WitherArrowEntity> {
    private WitherArrowModel model;

    public WitherArrowRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new WitherArrowModel(context.bakeLayer(WitherArrowModel.LAYER_LOCATION));
    }

    @Override
    public void render(WitherArrowEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        poseStack.pushPose();

        poseStack.translate(0, -0.5f, 0);

        VertexConsumer vertexConsumer = ItemRenderer.getFoilBufferDirect(
                buffer, this.model.renderType(this.getTextureLocation(entity)), false, false);

        this.model.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY);

        poseStack.popPose();
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(WitherArrowEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(TheForgottenExpance.MODID, "textures/entity/wither_arrow/wither_arrow.png");
    }
}
