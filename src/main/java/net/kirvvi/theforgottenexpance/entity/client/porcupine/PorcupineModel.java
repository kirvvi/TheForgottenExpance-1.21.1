package net.kirvvi.theforgottenexpance.entity.client.porcupine;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.kirvvi.theforgottenexpance.TheForgottenExpance;
import net.kirvvi.theforgottenexpance.entity.custom.PorcupineEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class PorcupineModel<T extends PorcupineEntity> extends HierarchicalModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(TheForgottenExpance.MODID, "porcupine"), "main");
    private final ModelPart porcupine;
    private final ModelPart body;
    private final ModelPart torso;
    private final ModelPart tail;
    private final ModelPart head;
    private final ModelPart skull;
    private final ModelPart hair;
    private final ModelPart left_eyelid;
    private final ModelPart right_eyelid;
    private final ModelPart spikes;
    private final ModelPart spike;
    private final ModelPart spike2;
    private final ModelPart spike5;
    private final ModelPart spike3;
    private final ModelPart spike4;
    private final ModelPart spikes2;
    private final ModelPart spike6;
    private final ModelPart spike7;
    private final ModelPart spike8;
    private final ModelPart spike9;
    private final ModelPart spike10;
    private final ModelPart spikes3;
    private final ModelPart spike11;
    private final ModelPart spike12;
    private final ModelPart spike13;
    private final ModelPart spike14;
    private final ModelPart spike15;
    private final ModelPart spikes4;
    private final ModelPart spike16;
    private final ModelPart spike17;
    private final ModelPart spike18;
    private final ModelPart spike19;
    private final ModelPart spike20;
    private final ModelPart spikes5;
    private final ModelPart spike21;
    private final ModelPart spike22;
    private final ModelPart spike23;
    private final ModelPart spike24;
    private final ModelPart spike25;
    private final ModelPart spikes6;
    private final ModelPart spike26;
    private final ModelPart spike27;
    private final ModelPart spike28;
    private final ModelPart spike29;
    private final ModelPart spike30;
    private final ModelPart spikes7;
    private final ModelPart spike31;
    private final ModelPart spike32;
    private final ModelPart spike33;
    private final ModelPart spike34;
    private final ModelPart spike35;
    private final ModelPart spikes8;
    private final ModelPart spike36;
    private final ModelPart spike37;
    private final ModelPart spike38;
    private final ModelPart spike39;
    private final ModelPart spike40;
    private final ModelPart left_front_leg;
    private final ModelPart right_front_leg;
    private final ModelPart right_back_leg;
    private final ModelPart left_back_leg;

    public PorcupineModel(ModelPart root) {
        this.porcupine = root.getChild("porcupine");
        this.body = this.porcupine.getChild("body");
        this.torso = this.body.getChild("torso");
        this.tail = this.torso.getChild("tail");
        this.head = this.torso.getChild("head");
        this.skull = this.head.getChild("skull");
        this.hair = this.skull.getChild("hair");
        this.left_eyelid = this.skull.getChild("left_eyelid");
        this.right_eyelid = this.skull.getChild("right_eyelid");
        this.spikes = this.torso.getChild("spikes");
        this.spike = this.spikes.getChild("spike");
        this.spike2 = this.spikes.getChild("spike2");
        this.spike5 = this.spikes.getChild("spike5");
        this.spike3 = this.spikes.getChild("spike3");
        this.spike4 = this.spikes.getChild("spike4");
        this.spikes2 = this.torso.getChild("spikes2");
        this.spike6 = this.spikes2.getChild("spike6");
        this.spike7 = this.spikes2.getChild("spike7");
        this.spike8 = this.spikes2.getChild("spike8");
        this.spike9 = this.spikes2.getChild("spike9");
        this.spike10 = this.spikes2.getChild("spike10");
        this.spikes3 = this.torso.getChild("spikes3");
        this.spike11 = this.spikes3.getChild("spike11");
        this.spike12 = this.spikes3.getChild("spike12");
        this.spike13 = this.spikes3.getChild("spike13");
        this.spike14 = this.spikes3.getChild("spike14");
        this.spike15 = this.spikes3.getChild("spike15");
        this.spikes4 = this.torso.getChild("spikes4");
        this.spike16 = this.spikes4.getChild("spike16");
        this.spike17 = this.spikes4.getChild("spike17");
        this.spike18 = this.spikes4.getChild("spike18");
        this.spike19 = this.spikes4.getChild("spike19");
        this.spike20 = this.spikes4.getChild("spike20");
        this.spikes5 = this.torso.getChild("spikes5");
        this.spike21 = this.spikes5.getChild("spike21");
        this.spike22 = this.spikes5.getChild("spike22");
        this.spike23 = this.spikes5.getChild("spike23");
        this.spike24 = this.spikes5.getChild("spike24");
        this.spike25 = this.spikes5.getChild("spike25");
        this.spikes6 = this.torso.getChild("spikes6");
        this.spike26 = this.spikes6.getChild("spike26");
        this.spike27 = this.spikes6.getChild("spike27");
        this.spike28 = this.spikes6.getChild("spike28");
        this.spike29 = this.spikes6.getChild("spike29");
        this.spike30 = this.spikes6.getChild("spike30");
        this.spikes7 = this.torso.getChild("spikes7");
        this.spike31 = this.spikes7.getChild("spike31");
        this.spike32 = this.spikes7.getChild("spike32");
        this.spike33 = this.spikes7.getChild("spike33");
        this.spike34 = this.spikes7.getChild("spike34");
        this.spike35 = this.spikes7.getChild("spike35");
        this.spikes8 = this.torso.getChild("spikes8");
        this.spike36 = this.spikes8.getChild("spike36");
        this.spike37 = this.spikes8.getChild("spike37");
        this.spike38 = this.spikes8.getChild("spike38");
        this.spike39 = this.spikes8.getChild("spike39");
        this.spike40 = this.spikes8.getChild("spike40");
        this.left_front_leg = this.body.getChild("left_front_leg");
        this.right_front_leg = this.body.getChild("right_front_leg");
        this.right_back_leg = this.body.getChild("right_back_leg");
        this.left_back_leg = this.body.getChild("left_back_leg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition porcupine = partdefinition.addOrReplaceChild("porcupine", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition body = porcupine.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition torso = body.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -3.0F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition tail = torso.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offsetAndRotation(0.5F, -1.251F, 4.0F, -0.4363F, 0.0F, 0.0F));

        PartDefinition cube_r1 = tail.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(11, 25).addBox(-6.0F, -0.499F, -1.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.25F, 0.0F, 0.0F, 0.9599F, 0.0F));

        PartDefinition cube_r2 = tail.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(11, 25).addBox(-6.0F, 0.001F, -1.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.25F, 0.0F, 0.0F, 0.6109F, 0.0F));

        PartDefinition head = torso.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -1.0F, -4.0F, 0.0F, -0.0436F, 0.0F));

        PartDefinition skull = head.addOrReplaceChild("skull", CubeListBuilder.create().texOffs(0, 13).addBox(-2.0F, -2.0F, -4.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 14).addBox(1.1F, -0.75F, -3.25F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(12, 13).addBox(1.425F, -0.975F, -3.025F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F))
                .texOffs(0, 14).mirror().addBox(-2.1F, -0.75F, -3.25F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(12, 13).mirror().addBox(-2.425F, -0.975F, -3.025F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)).mirror(false)
                .texOffs(16, 18).addBox(-1.0F, -0.25F, -5.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition hair = skull.addOrReplaceChild("hair", CubeListBuilder.create().texOffs(0, 16).addBox(0.0F, -4.0F, 0.0F, 0.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -4.0F, 0.5236F, 0.0F, 0.0F));

        PartDefinition cube_r3 = hair.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 16).addBox(0.0F, -4.0F, 0.0F, 0.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

        PartDefinition cube_r4 = hair.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 16).addBox(0.0F, -4.0F, 0.0F, 0.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

        PartDefinition left_eyelid = skull.addOrReplaceChild("left_eyelid", CubeListBuilder.create().texOffs(24, 0).addBox(0.1F, -1.75F, -7.25F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.4F)), PartPose.offset(-0.4F, 0.5F, 3.5F));

        PartDefinition right_eyelid = skull.addOrReplaceChild("right_eyelid", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-2.1F, -1.75F, -7.25F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.4F)).mirror(false), PartPose.offset(0.4F, 0.5F, 3.5F));

        PartDefinition spikes = torso.addOrReplaceChild("spikes", CubeListBuilder.create(), PartPose.offset(0.0F, -3.0F, -3.5F));

        PartDefinition spike = spikes.addOrReplaceChild("spike", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -7.0F, 0.0F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.0436F));

        PartDefinition spike2 = spikes.addOrReplaceChild("spike2", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -7.0F, 0.0F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0873F));

        PartDefinition spike5 = spikes.addOrReplaceChild("spike5", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -7.0F, 0.0F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.3491F));

        PartDefinition spike3 = spikes.addOrReplaceChild("spike3", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -7.0F, 0.0F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1309F));

        PartDefinition spike4 = spikes.addOrReplaceChild("spike4", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -7.0F, 0.0F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.4363F));

        PartDefinition spikes2 = torso.addOrReplaceChild("spikes2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.5F, -3.0F, -2.5F, 0.3054F, 0.0F, 0.0F));

        PartDefinition spike6 = spikes2.addOrReplaceChild("spike6", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -7.0F, 0.0F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -1.0F));

        PartDefinition spike7 = spikes2.addOrReplaceChild("spike7", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -7.0F, 0.0F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, -1.5F, 0.0F, 0.0F, 0.2618F));

        PartDefinition spike8 = spikes2.addOrReplaceChild("spike8", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -7.0F, 0.0F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.4363F));

        PartDefinition spike9 = spikes2.addOrReplaceChild("spike9", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -7.0F, 0.0F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, -1.5F, 0.0F, 0.0F, -0.3054F));

        PartDefinition spike10 = spikes2.addOrReplaceChild("spike10", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -7.0F, 0.0F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, -1.0F, 0.0F, 0.0F, -0.6545F));

        PartDefinition spikes3 = torso.addOrReplaceChild("spikes3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.5F, -3.0F, -2.5F, -0.1745F, 0.0F, 0.0F));

        PartDefinition spike11 = spikes3.addOrReplaceChild("spike11", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -7.0F, 0.0F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.1309F));

        PartDefinition spike12 = spikes3.addOrReplaceChild("spike12", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -7.0F, 0.0F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

        PartDefinition spike13 = spikes3.addOrReplaceChild("spike13", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -7.0F, 0.0F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.2618F));

        PartDefinition spike14 = spikes3.addOrReplaceChild("spike14", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -7.0F, 0.0F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.0436F));

        PartDefinition spike15 = spikes3.addOrReplaceChild("spike15", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -7.0F, 0.0F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.1745F));

        PartDefinition spikes4 = torso.addOrReplaceChild("spikes4", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -3.0F, -2.0F, -0.5672F, 0.0F, 0.0F));

        PartDefinition spike16 = spikes4.addOrReplaceChild("spike16", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -6.0F, 0.0F, 0.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.5F));

        PartDefinition spike17 = spikes4.addOrReplaceChild("spike17", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -6.0F, 0.0F, 0.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition spike18 = spikes4.addOrReplaceChild("spike18", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -6.0F, 0.0F, 0.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.2182F));

        PartDefinition spike19 = spikes4.addOrReplaceChild("spike19", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -6.0F, 0.0F, 0.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.0873F));

        PartDefinition spike20 = spikes4.addOrReplaceChild("spike20", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -6.0F, 0.0F, 0.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.1309F));

        PartDefinition spikes5 = torso.addOrReplaceChild("spikes5", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition spike21 = spikes5.addOrReplaceChild("spike21", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -6.0F, 0.0F, 0.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.5F));

        PartDefinition spike22 = spikes5.addOrReplaceChild("spike22", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -6.0F, 0.0F, 0.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.4363F));

        PartDefinition spike23 = spikes5.addOrReplaceChild("spike23", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -6.0F, 0.0F, 0.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.7854F));

        PartDefinition spike24 = spikes5.addOrReplaceChild("spike24", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -6.0F, 0.0F, 0.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

        PartDefinition spike25 = spikes5.addOrReplaceChild("spike25", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -6.0F, 0.0F, 0.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.5672F));

        PartDefinition spikes6 = torso.addOrReplaceChild("spikes6", CubeListBuilder.create(), PartPose.offsetAndRotation(0.5F, -3.0F, -0.5F, -0.6545F, 0.0F, 0.0F));

        PartDefinition spike26 = spikes6.addOrReplaceChild("spike26", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -5.0F, 0.0F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.5F));

        PartDefinition spike27 = spikes6.addOrReplaceChild("spike27", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -5.0F, 0.0F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

        PartDefinition spike28 = spikes6.addOrReplaceChild("spike28", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -5.0F, 0.0F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.48F));

        PartDefinition spike29 = spikes6.addOrReplaceChild("spike29", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -5.0F, 0.0F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2182F));

        PartDefinition spike30 = spikes6.addOrReplaceChild("spike30", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -5.0F, 0.0F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.48F));

        PartDefinition spikes7 = torso.addOrReplaceChild("spikes7", CubeListBuilder.create(), PartPose.offsetAndRotation(0.5F, -3.0F, 1.5F, -0.9599F, 0.0F, 0.0F));

        PartDefinition spike31 = spikes7.addOrReplaceChild("spike31", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -4.0F, 0.0F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.5F));

        PartDefinition spike32 = spikes7.addOrReplaceChild("spike32", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -4.0F, 0.0F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

        PartDefinition spike33 = spikes7.addOrReplaceChild("spike33", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -4.0F, 0.0F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.3491F));

        PartDefinition spike34 = spikes7.addOrReplaceChild("spike34", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -4.0F, 0.0F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1309F));

        PartDefinition spike35 = spikes7.addOrReplaceChild("spike35", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -4.0F, 0.0F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.3054F));

        PartDefinition spikes8 = torso.addOrReplaceChild("spikes8", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -3.0F, 3.0F, -1.0472F, 0.0F, 0.0F));

        PartDefinition spike36 = spikes8.addOrReplaceChild("spike36", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -3.0F, 0.0F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.1309F));

        PartDefinition spike37 = spikes8.addOrReplaceChild("spike37", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -3.0F, 0.0F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 0.0F, 0.0F));

        PartDefinition spike38 = spikes8.addOrReplaceChild("spike38", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -3.0F, 0.0F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.3927F));

        PartDefinition spike39 = spikes8.addOrReplaceChild("spike39", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -3.0F, 0.0F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 0.0F, 0.0F));

        PartDefinition spike40 = spikes8.addOrReplaceChild("spike40", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -3.0F, 0.0F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.3054F));

        PartDefinition left_front_leg = body.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 0.0F, -2.5F));

        PartDefinition right_front_leg = body.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.0F, -1.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 0.0F, -2.5F));

        PartDefinition right_back_leg = body.addOrReplaceChild("right_back_leg", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.0F, -1.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 0.0F, 2.5F));

        PartDefinition left_back_leg = body.addOrReplaceChild("left_back_leg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 0.0F, 2.5F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(PorcupineEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

        this.animateWalk(PorcupineAnimations.PORCUPINE_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.animate(entity.idleAnimationState, PorcupineAnimations.PORCUPINE_IDLE, ageInTicks, 1f);
    }

    private void applyHeadRotation(float headYaw, float headPitch) {
        headYaw = Mth.clamp(headYaw, -30f, 30f);
        headPitch = Mth.clamp(headPitch, -25f, 45);

        this.head.yRot = headYaw * ((float)Math.PI / 180f);
        this.head.xRot = headPitch *  ((float)Math.PI / 180f);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        porcupine.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart root() {
        return porcupine;
    }
}
