package net.kirvvi.theforgottenexpance.datagen;

import net.kirvvi.theforgottenexpance.TheForgottenExpance;
import net.kirvvi.theforgottenexpance.block.ModBlocks;
import net.kirvvi.theforgottenexpance.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.LinkedHashMap;

public class ModItemModelProvider extends ItemModelProvider {
    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TheForgottenExpance.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.ADAMANTIUM.get());
        basicItem(ModItems.ADAMANTIUM_NETHERITE_CLUSTER.get());
        basicItem(ModItems.SHADOWMARE.get());

        basicItem(ModItems.RUBBER.get());
        basicItem(ModItems.RAW_RUBBER.get());
        basicItem(ModItems.BLUEBERRY.get());
        basicItem(ModItems.TOMATO.get());
        basicItem(ModItems.TOMATO_SEEDS.get());
        basicItem(ModItems.SHADOWMANE_SMITHING_TEMPLATE.get());
        basicItem(ModItems.COCONUT_OPENED.get());
        basicItem(ModItems.COCONUT_PART.get());
        basicItem(ModItems.COCONUT_OPENED_CLEAN.get());
        basicItem(ModItems.SHELL.get());
        basicItem(ModItems.LIBRARY_STATUEI.get());
        basicItem(ModItems.ALCHEMIST_STATUEI.get());
        basicItem(ModItems.WARRIOR_STATUEI.get());
        basicItem(ModItems.PRIEST_STATUEI.get());
        basicItem(ModItems.QUICKSAND_BUCKET.get());
        basicItem(ModItems.MUMMY_BANDAGE.get());

        handheldItem(ModItems.CHISEL.get());

        handheldItem(ModItems.QUARTZ_STICK.get());
        handheldItem(ModItems.QUARTZ_LEATHER_STICK.get());
        handheldItem(ModItems.WITHER_ARROW.get());

        handheldItem(ModItems.ADAMANTIUM_AXE.get());
        handheldItem(ModItems.ADAMANTIUM_HOE.get());
        handheldItem(ModItems.ADAMANTIUM_PAXEL.get());
        handheldItem(ModItems.ADAMANTIUM_PICKAXE.get());
        handheldItem(ModItems.ADAMANTIUM_SHOVEL.get());
        handheldItem(ModItems.ADAMANTIUM_SWORD.get());
        handheldItem(ModItems.ADAMANTIUM_HAMMER.get());

        handheldItem(ModItems.ADAMANTIUM_NETHERITE_AXE.get());
        handheldItem(ModItems.ADAMANTIUM_NETHERITE_HOE.get());
        handheldItem(ModItems.ADAMANTIUM_NETHERITE_PAXEL.get());
        handheldItem(ModItems.ADAMANTIUM_NETHERITE_PICKAXE.get());
        handheldItem(ModItems.ADAMANTIUM_NETHERITE_SHOVEL.get());
        handheldItem(ModItems.ADAMANTIUM_NETHERITE_SWORD.get());
        handheldItem(ModItems.ADAMANTIUM_NETHERITE_HAMMER.get());

        buttonItem(ModBlocks.DARK_TREE_BUTTON, ModBlocks.DARK_TREE_PLANKS);
        fenceItem(ModBlocks.DARK_TREE_FENCE, ModBlocks.DARK_TREE_PLANKS);

        basicItem(ModBlocks.DARK_TREE_DOOR.asItem());

        trimmedArmorItem(ModItems.ADAMANTIUM_HELMET);
        trimmedArmorItem(ModItems.ADAMANTIUM_CHESTPLATE);
        trimmedArmorItem(ModItems.ADAMANTIUM_LEGGINGS);
        trimmedArmorItem(ModItems.ADAMANTIUM_BOOTS);
        trimmedArmorItem(ModItems.ADAMANTIUM_NETHERITE_HELMET);
        trimmedArmorItem(ModItems.ADAMANTIUM_NETHERITE_CHESTPLATE);
        trimmedArmorItem(ModItems.ADAMANTIUM_NETHERITE_LEGGINGS);
        trimmedArmorItem(ModItems.ADAMANTIUM_NETHERITE_BOOTS);

        saplingItem(ModBlocks.DARK_TREE_SAPLING);
        withExistingParent(ModItems.GECKO_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.MUMMY_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.PORCUPINE_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }

    private ItemModelBuilder saplingItem(DeferredBlock<Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(TheForgottenExpance.MODID,"block/" + item.getId().getPath()));
    }
    // Shoutout to El_Redstoniano for making this
    private void trimmedArmorItem(DeferredItem<ArmorItem> itemDeferredItem) {
        final String MOD_ID = TheForgottenExpance.MODID;

        if(itemDeferredItem.get() instanceof ArmorItem armorItem) {
            trimMaterials.forEach((trimMaterial, value) -> {
                float trimValue = value;

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = armorItem.toString();
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = ResourceLocation.parse(armorItemPath);
                ResourceLocation trimResLoc = ResourceLocation.parse(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = ResourceLocation.parse(currentTrimName);

                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc.getNamespace() + ":item/" + armorItemResLoc.getPath())
                        .texture("layer1", trimResLoc);

                this.withExistingParent(itemDeferredItem.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc.getNamespace()  + ":item/" + trimNameResLoc.getPath()))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                ResourceLocation.fromNamespaceAndPath(MOD_ID,
                                        "item/" + itemDeferredItem.getId().getPath()));
            });
        }
    }
    public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(TheForgottenExpance.MODID,
                        "block/" + baseBlock.getId().getPath()));
    }
    public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(TheForgottenExpance.MODID,
                        "block/" + baseBlock.getId().getPath()));
    }
    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(TheForgottenExpance.MODID,
                        "block/" + baseBlock.getId().getPath()));
    }
}
