package net.kirvvi.theforgottenexpance.entity.client.coconut;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.kirvvi.theforgottenexpance.TheForgottenExpance;
import net.kirvvi.theforgottenexpance.entity.custom.CoconutProjectileEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class CoconutProjectileModel extends EntityModel<CoconutProjectileEntity> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(TheForgottenExpance.MODID, "coconut"), "main");
    private final ModelPart coconut;

    public CoconutProjectileModel(ModelPart root) {
        this.coconut = root.getChild("coconut");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition coconut = partdefinition.addOrReplaceChild("coconut", CubeListBuilder.create().texOffs(0, 13).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(2, 13).addBox(-5.0F, -1.0F, 4.0F, 9.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(4, 1).addBox(-5.0F, -1.0F, -5.0F, 1.0F, 8.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-4.0F, 7.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(4, 4).addBox(4.0F, -1.0F, -4.0F, 1.0F, 8.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(0, 2).addBox(-4.0F, -1.0F, -5.0F, 9.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 24, 24);
    }

    @Override
    public void setupAnim(CoconutProjectileEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        coconut.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }
}
