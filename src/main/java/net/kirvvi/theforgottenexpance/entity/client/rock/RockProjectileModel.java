package net.kirvvi.theforgottenexpance.entity.client.rock;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.kirvvi.theforgottenexpance.TheForgottenExpance;
import net.kirvvi.theforgottenexpance.entity.custom.RockProjectileEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class RockProjectileModel extends EntityModel<RockProjectileEntity> {
    public static final ModelLayerLocation LAYER_LOCATION
            = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(TheForgottenExpance.MODID, "rock"), "main");
    private final ModelPart rock;

    public RockProjectileModel(ModelPart root) {
        this.rock = root.getChild("rock");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition rock = partdefinition.addOrReplaceChild("rock", CubeListBuilder.create().texOffs(1, 6).addBox(-2.0F, -10.0F, -2.0F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(23, 9).addBox(-3.0F, -10.0F, -2.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r1 = rock.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -2.0F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -8.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

        PartDefinition cube_r2 = rock.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(21, 17).addBox(-2.0F, -1.0F, -2.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.0F, 1.0F, 0.3927F, 0.0F, 0.0F));

        PartDefinition cube_r3 = rock.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(11, 4).addBox(-2.0F, -1.0F, -2.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -9.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

        PartDefinition cube_r4 = rock.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(25, 16).addBox(-2.0F, -2.0F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -8.0F, -2.0F, 0.3927F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(RockProjectileEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        rock.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }
}
