package net.kirvvi.theforgottenexpance.entity.client.mummy;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.kirvvi.theforgottenexpance.TheForgottenExpance;
import net.kirvvi.theforgottenexpance.entity.client.gecko.GeckoAnimations;
import net.kirvvi.theforgottenexpance.entity.custom.MummyEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class MummyModel <T extends MummyEntity> extends HierarchicalModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION =
            new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(TheForgottenExpance.MODID, "mummy"), "main");

    private final ModelPart root2;
    private final ModelPart rightleg;
    private final ModelPart leftleg;
    private final ModelPart body2;
    private final ModelPart tors;
    private final ModelPart righthand;
    private final ModelPart bone1;
    private final ModelPart head;
    private final ModelPart bone;
    private final ModelPart lefthand2;
    private final ModelPart bone2;

    public MummyModel(ModelPart root) {
        this.root2 = root.getChild("root2");
        this.rightleg = this.root2.getChild("rightleg");
        this.leftleg = this.root2.getChild("leftleg");
        this.body2 = this.root2.getChild("body2");
        this.tors = this.body2.getChild("tors");
        this.righthand = this.body2.getChild("righthand");
        this.bone1 = this.righthand.getChild("bone1");
        this.head = this.body2.getChild("head");
        this.bone = this.head.getChild("bone");
        this.lefthand2 = this.body2.getChild("lefthand2");
        this.bone2 = this.lefthand2.getChild("bone2");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root2 = partdefinition.addOrReplaceChild("root2", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition rightleg = root2.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(32, 48).addBox(-3.0F, -1.0F, -4.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(6, 50).addBox(-2.0F, 0.0F, -3.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -11.0F, 2.0F));

        PartDefinition leftleg = root2.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(48, 48).addBox(-1.0F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(6, 50).addBox(0.0F, 0.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -11.0F, 0.0F));

        PartDefinition body2 = root2.addOrReplaceChild("body2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition tors = body2.addOrReplaceChild("tors", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -12.0F, -3.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(2, 50).addBox(-3.5F, -11.0F, -2.0F, 6.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, -12.0F, 1.0F));

        PartDefinition righthand = body2.addOrReplaceChild("righthand", CubeListBuilder.create().texOffs(35, 19).addBox(-20.0F, -5.0F, -1.0F, 10.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -18.0F, 0.0F));

        PartDefinition cube_r1 = righthand.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -12.0F, -3.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, -5.0F, -1.0F, 3.1416F, 0.0F, 1.5708F));

        PartDefinition bone1 = righthand.addOrReplaceChild("bone1", CubeListBuilder.create().texOffs(4, 6).addBox(-16.0F, -2.0F, 0.0F, 2.0F, 5.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(4, 3).addBox(-19.0F, -2.0F, 2.0F, 1.0F, 5.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(15, 40).addBox(-13.0F, -2.0F, 1.0F, 3.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r2 = bone1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(4, 36).addBox(1.0F, -2.0F, -3.0F, 0.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-19.0F, 0.0F, -2.0F, 3.1416F, -1.4835F, 3.1416F));

        PartDefinition cube_r3 = bone1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(5, 6).addBox(1.0F, -2.0F, -1.0F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, 0.0F, -3.0F, 3.1416F, -1.4835F, 3.1416F));

        PartDefinition head = body2.addOrReplaceChild("head", CubeListBuilder.create().texOffs(6, 19).addBox(-6.0F, -6.0F, 0.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(30, 27).addBox(-7.0F, -7.0F, -1.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -25.0F, -3.0F));

        PartDefinition bone = head.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(22, 34).mirror().addBox(1.0F, -2.0F, -1.0F, 3.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(20, 34).addBox(2.0F, -2.0F, -9.0F, 2.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 3.0F, 8.0F));

        PartDefinition lefthand2 = body2.addOrReplaceChild("lefthand2", CubeListBuilder.create().texOffs(34, 19).addBox(14.0F, -7.0F, 0.0F, 10.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-9.0F, -16.0F, -1.0F));

        PartDefinition cube_r4 = lefthand2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(40, 0).addBox(-1.0F, -12.0F, -3.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.0F, -5.0F, 0.0F, -3.1416F, 0.0F, -1.5708F));

        PartDefinition bone2 = lefthand2.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(4, 35).addBox(14.0F, -4.0F, 2.0F, 7.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r5 = bone2.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(48, 7).addBox(1.0F, -2.0F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(24.0F, -2.0F, 4.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r6 = bone2.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(13, 9).addBox(1.0F, -2.0F, -1.0F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0F, -2.0F, -1.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r7 = bone2.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(48, 7).addBox(1.0F, -2.0F, -1.0F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(21.0F, -2.0F, -2.0F, 0.0F, -1.5708F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);
        if (limbSwingAmount > 0.1F) {
            this.animate(entity.idleAnimationState, MummyAnimations.MODEL_WALKING, ageInTicks);
        } else {
            this.animate(entity.idleAnimationState, MummyAnimations.MODEL_IDLE, ageInTicks);
        }

        if (entity.attackAnimationState1.isStarted()) {
            this.animate(entity.attackAnimationState1, MummyAnimations.MODEL_ATTACK1, ageInTicks);
        }
        if (entity.attackAnimationState2.isStarted()) {
            this.animate(entity.attackAnimationState2, MummyAnimations.MODEL_ATTACK2, ageInTicks);
        }

    }



    private void applyHeadRotation(float headYaw, float headPitch) {
        headYaw = Mth.clamp(headYaw, -30f, 30f);
        headPitch = Mth.clamp(headPitch, -25f, 45);

        this.head.yRot = headYaw * ((float)Math.PI / 180f);
        this.head.xRot = headPitch *  ((float)Math.PI / 180f);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        root2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart root() {
        return root2;
    }
}
