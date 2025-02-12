package net.kirvvi.theforgottenexpance.entity.client.witherarrow;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.kirvvi.theforgottenexpance.TheForgottenExpance;
import net.kirvvi.theforgottenexpance.entity.custom.WitherArrowEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class WitherArrowModel extends EntityModel<WitherArrowEntity> {
    public static final ModelLayerLocation LAYER_LOCATION
            = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(TheForgottenExpance.MODID, "wither_arrow"), "main");
    private final ModelPart wither_arrow;

    public WitherArrowModel(ModelPart root) {
        this.wither_arrow = root.getChild("bone");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(-2, 0).addBox(-0.5F, 0.5F, -8.0F, 1.0F, 0.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(10, -2).addBox(0.0F, -1.0F, -7.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(10, -1).addBox(0.0F, 1.0F, -7.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(8, 2).addBox(0.0F, -1.0F, 4.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(8, 3).addBox(0.0F, 1.0F, 4.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(8, 1).addBox(0.0F, -2.0F, 5.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(8, 4).addBox(0.0F, 2.0F, 5.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(6, 7).addBox(-0.5F, -2.0F, 7.0F, 1.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.5F, 0.0F));

        PartDefinition cube_r1 = bone.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(8, 2).addBox(-0.5F, -4.5F, 0.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 0.5F, 7.0F, 0.0F, 0.0F, -1.5708F));

        PartDefinition cube_r2 = bone.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(8, 0).addBox(-0.5F, -4.5F, 0.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.5F, 7.0F, 0.0F, 0.0F, -1.5708F));

        PartDefinition cube_r3 = bone.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(8, 8).addBox(0.0F, -0.5F, -3.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.5F, 8.0F, 0.0F, 0.0F, 1.5708F));

        PartDefinition cube_r4 = bone.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(8, 7).addBox(0.0F, -0.5F, -3.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(10, 1).addBox(0.0F, -0.5F, -14.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.5F, 7.0F, 0.0F, 0.0F, 1.5708F));

        PartDefinition cube_r5 = bone.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(8, 5).addBox(0.0F, -0.5F, -3.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(10, 0).addBox(0.0F, -0.5F, -14.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.5F, 7.0F, 0.0F, 0.0F, 1.5708F));

        PartDefinition cube_r6 = bone.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(-2, 0).addBox(-1.0F, 0.0F, -8.0F, 1.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

        PartDefinition cube_r7 = bone.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(8, 6).addBox(0.0F, -0.5F, -3.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.5F, 8.0F, 0.0F, 0.0F, 1.5708F));

        return LayerDefinition.create(meshdefinition, 16, 16);
    }

    @Override
    public void setupAnim(WitherArrowEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        wither_arrow.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }
}