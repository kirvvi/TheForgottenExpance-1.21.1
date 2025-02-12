package net.kirvvi.theforgottenexpance.entity.client.crushedcoconut;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.kirvvi.theforgottenexpance.TheForgottenExpance;
import net.kirvvi.theforgottenexpance.entity.custom.CoconutProjectileEntity;
import net.kirvvi.theforgottenexpance.entity.custom.CrushedCoconutProjectileEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class CrushedCoconutProjectileModel extends EntityModel<CrushedCoconutProjectileEntity> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(TheForgottenExpance.MODID, "crushedcoconut"), "main");
    private final ModelPart crushedcoconut;

    public CrushedCoconutProjectileModel(ModelPart root) {
        this.crushedcoconut = root.getChild("crushedcoconut");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition group = partdefinition.addOrReplaceChild("crushedcoconut", CubeListBuilder.create().texOffs(2, 1).addBox(-4.0F, -2.0F, -1.5F, 3.5F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-1.0F, 1.0F, 4.0F, 3.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-2.0F, 3.5F, 4.0F, 1.0F, 2.5F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-3.5F, 5.5F, 4.0F, 1.5F, 0.5F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-3.5F, 3.0F, 4.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-2.0F, 3.0F, 4.0F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-3.5F, 1.0F, 4.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-1.0F, -0.5F, 4.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(3, 1).addBox(-3.5F, -0.5F, 4.0F, 2.5F, 1.5F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(15, 3).addBox(-5.0F, 1.5F, -1.0F, 1.0F, 5.5F, 1.5F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(2.5F, 7.0F, -4.0F, 1.5F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(0.0F, 7.0F, -3.5F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-4.0F, 7.0F, -4.0F, 4.0F, 1.0F, 4.5F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-4.0F, 7.0F, 1.0F, 6.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(4.0F, 6.0F, -4.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(12, 1).addBox(4.0F, 2.5F, -4.0F, 1.0F, 3.5F, 4.5F, new CubeDeformation(0.0F))
                .texOffs(12, 3).addBox(4.0F, 2.0F, 1.0F, 1.0F, 3.5F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(13, 2).addBox(4.0F, -1.0F, -4.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(13, 0).addBox(4.0F, -1.0F, 0.0F, 1.0F, 2.5F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(5, 1).addBox(4.0F, -1.0F, 4.5F, 1.0F, 3.0F, 0.5F, new CubeDeformation(0.0F))
                .texOffs(8, 2).addBox(-4.0F, -1.0F, -5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(7, 4).addBox(-3.5F, -2.0F, 0.0F, 4.5F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(3.0F, -2.0F, -4.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(3, 1).addBox(1.5F, -2.0F, -4.0F, 1.5F, 1.0F, 7.5F, new CubeDeformation(0.0F))
                .texOffs(0, 13).addBox(-4.0F, -1.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(10, 3).addBox(0.0F, -2.0F, -4.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(9, 3).addBox(-4.0F, -2.0F, -4.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 14).addBox(-4.0F, 0.0F, 3.0F, 8.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(15, 7).addBox(-1.0F, -1.0F, 4.0F, 3.5F, 0.5F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(13, 2).addBox(-5.0F, -1.0F, 3.0F, 1.0F, 6.5F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(19, 2).addBox(2.5F, 0.0F, 4.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-4.0F, 6.0F, 4.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(4, 8).addBox(-4.0F, 0.0F, -4.0F, 1.0F, 7.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(12, 0).addBox(-5.0F, -1.0F, 1.0F, 1.0F, 7.5F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(17, 0).addBox(-5.0F, -0.5F, -3.0F, 1.0F, 7.5F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(19, 4).addBox(-5.0F, 1.5F, -4.0F, 1.0F, 5.5F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(15, 3).addBox(-5.0F, -0.5F, -0.5F, 1.0F, 1.5F, 1.5F, new CubeDeformation(0.0F))
                .texOffs(7, 7).addBox(0.5F, 5.0F, -5.0F, 3.5F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(5, 6).addBox(0.0F, 2.5F, -5.0F, 4.0F, 2.5F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(18, 7).addBox(-2.0F, 5.5F, -5.0F, 2.0F, 1.5F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(3, 5).addBox(-1.5F, 2.0F, -5.0F, 1.5F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(5, 2).addBox(0.5F, -1.0F, -5.0F, 3.5F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(2, 1).addBox(-3.0F, -1.0F, -5.0F, 3.5F, 2.5F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 14).addBox(-3.0F, 0.0F, -4.0F, 7.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 5).addBox(-4.0F, 2.0F, -5.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-4.0F, 6.0F, -5.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(3.5F, 0.0F, 4.0F, 0.5F, 5.5F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 9).addBox(3.0F, 0.0F, -3.0F, 1.0F, 7.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 15).addBox(-3.0F, 6.0F, -3.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 24, 24);
    }
    @Override
    public void setupAnim(CrushedCoconutProjectileEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        crushedcoconut.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }
}
