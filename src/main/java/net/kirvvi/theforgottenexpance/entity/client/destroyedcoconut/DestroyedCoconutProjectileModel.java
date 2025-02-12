package net.kirvvi.theforgottenexpance.entity.client.destroyedcoconut;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.kirvvi.theforgottenexpance.TheForgottenExpance;
import net.kirvvi.theforgottenexpance.entity.custom.CrushedCoconutProjectileEntity;
import net.kirvvi.theforgottenexpance.entity.custom.DestroyedCoconutProjectileEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class DestroyedCoconutProjectileModel extends EntityModel<DestroyedCoconutProjectileEntity> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(TheForgottenExpance.MODID, "destroyedcoconut"), "main");
    private final ModelPart destroyedcoconut;

    public DestroyedCoconutProjectileModel(ModelPart root) {
        this.destroyedcoconut = root.getChild("destroyedcoconut");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition destroyedcoconut = partdefinition.addOrReplaceChild("destroyedcoconut", CubeListBuilder.create().texOffs(12, 27).addBox(-5.0F, 2.5F, -1.0F, 1.0F, 4.5F, 1.5F, new CubeDeformation(0.0F))
                .texOffs(13, 25).addBox(1.0F, 7.0F, -3.0F, 3.0F, 1.0F, 2.5F, new CubeDeformation(0.0F))
                .texOffs(10, 26).addBox(-1.0F, 7.0F, 2.0F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(14, 25).addBox(4.0F, 1.0F, 1.0F, 1.0F, 3.5F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(6, 24).addBox(-5.0F, -1.0F, 4.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(12, 25).addBox(2.0F, -2.0F, 0.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(8, 16).addBox(2.5F, -1.0F, -4.0F, 1.5F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(5, 16).addBox(0.5F, -1.0F, -4.0F, 1.5F, 1.0F, 1.5F, new CubeDeformation(0.0F))
                .texOffs(0, 15).addBox(1.0F, -1.0F, -2.0F, 3.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(1, 15).addBox(-4.0F, -1.0F, -4.0F, 4.5F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(2, 17).addBox(-4.0F, -1.0F, 1.5F, 5.0F, 1.0F, 2.5F, new CubeDeformation(0.0F))
                .texOffs(1, 25).addBox(-4.0F, -2.0F, -3.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(9, 17).addBox(-2.0F, 5.0F, 3.0F, 6.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(17, 17).addBox(-3.0F, 5.0F, 3.5F, 1.0F, 2.0F, 0.5F, new CubeDeformation(0.0F))
                .texOffs(13, 20).addBox(1.5F, 2.0F, 3.0F, 2.5F, 2.5F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(11, 39).addBox(-2.5F, 3.0F, 3.0F, 3.5F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(8, 14).addBox(3.5F, 1.0F, 3.0F, 0.5F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 18).addBox(1.0F, 0.0F, 3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(14, 44).addBox(-3.0F, 0.0F, 3.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 25).addBox(-5.0F, -1.0F, 2.0F, 1.0F, 5.5F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(7, 24).addBox(-2.0F, 5.0F, 4.0F, 6.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-3.0F, 1.0F, -2.0F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(5, 32).addBox(0.5F, 5.0F, -5.0F, 3.5F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(7, 14).addBox(-4.0F, 2.0F, -4.0F, 1.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(3, 17).addBox(-4.0F, 0.0F, -4.0F, 1.0F, 1.5F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(15, 37).addBox(-4.0F, 6.5F, 1.0F, 1.0F, 0.5F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(15, 37).addBox(-4.0F, 0.0F, 1.5F, 1.0F, 6.0F, 1.5F, new CubeDeformation(0.0F))
                .texOffs(0, 29).addBox(-4.0F, 2.0F, -5.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 40).addBox(3.0F, 4.5F, -3.0F, 1.0F, 2.5F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(20, 45).addBox(3.0F, 2.0F, -3.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 14).addBox(3.0F, 6.0F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(15, 17).addBox(3.0F, 5.0F, -2.0F, 1.0F, 1.0F, 1.5F, new CubeDeformation(0.0F))
                .texOffs(0, 15).addBox(3.0F, 4.5F, -2.0F, 1.0F, 0.5F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(13, 16).addBox(3.0F, 4.5F, -1.0F, 1.0F, 0.5F, 0.5F, new CubeDeformation(0.0F))
                .texOffs(17, 17).addBox(3.0F, 3.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(18, 41).addBox(3.0F, 2.0F, -2.0F, 1.0F, 0.5F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(9, 18).addBox(3.0F, 2.0F, -0.5F, 1.0F, 1.0F, 0.5F, new CubeDeformation(0.0F))
                .texOffs(13, 17).addBox(3.0F, 1.0F, -3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(1, 17).addBox(3.0F, 1.0F, -1.0F, 1.0F, 0.5F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(10, 16).addBox(3.0F, 5.0F, 1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(14, 16).addBox(3.0F, 1.0F, 1.0F, 1.0F, 3.5F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(14, 16).addBox(3.0F, 0.0F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(10, 17).addBox(3.0F, 0.0F, 0.0F, 1.0F, 0.5F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(9, 17).addBox(-0.5F, 6.0F, -3.0F, 3.5F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(16, 19).addBox(0.0F, 6.0F, 0.0F, 3.0F, 1.0F, 0.5F, new CubeDeformation(0.0F))
                .texOffs(12, 40).addBox(-1.0F, 6.0F, 1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(14, 17).addBox(-2.0F, 6.0F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(12, 18).addBox(-2.0F, 6.0F, 0.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(15, 37).addBox(-3.0F, 6.0F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(6, 5).addBox(-3.0F, 6.0F, 0.0F, 0.5F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 5).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(13, 25).addBox(4.0F, -1.0F, -4.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-3.0F, 1.0F, 2.0F, 6.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(2.0F, 1.0F, -3.0F, 1.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(12, 5).addBox(-3.0F, 1.0F, -3.0F, 5.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-2.0F, 5.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(6, 16).addBox(2.5F, 4.5F, -4.0F, 1.5F, 2.5F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(7, 17).addBox(2.5F, 0.0F, -4.0F, 1.5F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 37).addBox(1.0F, 4.5F, -4.0F, 1.5F, 2.5F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(10, 17).addBox(1.5F, 3.0F, -4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(9, 16).addBox(1.0F, 0.5F, -4.0F, 1.5F, 2.5F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(12, 16).addBox(-0.5F, 3.5F, -4.0F, 1.5F, 3.5F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(2, 17).addBox(-0.5F, 0.5F, -4.0F, 1.5F, 2.5F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(12, 16).addBox(-3.0F, 2.0F, -4.0F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(8, 19).addBox(-3.0F, 0.0F, -4.0F, 2.0F, 1.5F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(3, 17).addBox(-4.0F, 5.0F, 3.5F, 1.0F, 2.0F, 0.5F, new CubeDeformation(0.0F))
                .texOffs(0, 18).addBox(-4.0F, 0.0F, 3.0F, 1.0F, 4.5F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(20, 15).addBox(3.0F, 6.0F, 0.0F, 1.0F, 1.0F, 0.5F, new CubeDeformation(0.0F))
                .texOffs(13, 17).addBox(3.0F, 4.5F, 0.0F, 1.0F, 1.0F, 0.5F, new CubeDeformation(0.0F))
                .texOffs(9, 20).addBox(3.0F, 2.0F, 0.0F, 1.0F, 2.5F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(8, 19).addBox(3.0F, 1.0F, 0.5F, 1.0F, 1.0F, 0.5F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 24, 48);
    }
    @Override
    public void setupAnim(DestroyedCoconutProjectileEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        destroyedcoconut.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }
}
