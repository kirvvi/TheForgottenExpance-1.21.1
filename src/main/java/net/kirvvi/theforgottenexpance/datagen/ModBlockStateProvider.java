package net.kirvvi.theforgottenexpance.datagen;

import net.kirvvi.theforgottenexpance.TheForgottenExpance;
import net.kirvvi.theforgottenexpance.block.ModBlocks;
import net.kirvvi.theforgottenexpance.block.custom.BlueBerryBushBlock;
import net.kirvvi.theforgottenexpance.block.custom.TomatoCropBlock;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TheForgottenExpance.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.ADAMANTIUM_BLOCK);
        blockWithItem(ModBlocks.ADAMANTIUM_NETHERITE_BLOCK);
        blockWithItem(ModBlocks.NETHER_SHADOWMARE_ORE);
        blockWithItem(ModBlocks.DARK_TREE_PLANKS);
        blockWithItem(ModBlocks.DARK_DIRT);
        blockWithItem(ModBlocks.ADAMANTIUM_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_ADAMANTIUM_ORE);
        blockWithItem(ModBlocks.QUICKSAND);

        stairsBlock(ModBlocks.DARK_TREE_STAIRS.get(), blockTexture(ModBlocks.DARK_TREE_PLANKS.get()));
        stairsBlock(ModBlocks.CHISELED_SANDSTONE_STAIRS.get(), blockTexture(Blocks.CHISELED_SANDSTONE));
        stairsBlock(ModBlocks.CHISELED_BLUE_SANDSTONE_STAIRS.get(), blockTexture(ModBlocks.CHISELED_BLUE_SANDSTONE.get()));
        stairsBlock(ModBlocks.CHISELED_RED_SANDSTONE_STAIRS.get(), blockTexture(Blocks.CHISELED_RED_SANDSTONE));
        stairsBlock(ModBlocks.CUT_SANDSTONE_STAIRS.get(), blockTexture(Blocks.CUT_SANDSTONE));
        slabBlock(ModBlocks.DARK_TREE_SLAB.get(), blockTexture(ModBlocks.DARK_TREE_PLANKS.get()), blockTexture(ModBlocks.DARK_TREE_PLANKS.get()));
        buttonBlock(ModBlocks.DARK_TREE_BUTTON.get(), blockTexture(ModBlocks.DARK_TREE_PLANKS.get()));
        pressurePlateBlock(ModBlocks.DARK_TREE_PRESSURE_PLATE.get(), blockTexture(ModBlocks.DARK_TREE_PLANKS.get()));
        fenceBlock(ModBlocks.DARK_TREE_FENCE.get(), blockTexture(ModBlocks.DARK_TREE_PLANKS.get()));
        fenceGateBlock(ModBlocks.DARK_TREE_FENCE_GATE.get(), blockTexture(ModBlocks.DARK_TREE_PLANKS.get()));
        doorBlockWithRenderType(ModBlocks.DARK_TREE_DOOR.get(), modLoc("block/dark_tree_door_bottom"), modLoc("block/dark_tree_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.DARK_TREE_TRAPDOOR.get(), modLoc("block/dark_tree_trapdoor"), true, "cutout");

        logBlock(((RotatedPillarBlock) ModBlocks.DARK_TREE_LOG.get()));
        axisBlock(((RotatedPillarBlock)ModBlocks.DARK_TREE_WOOD.get()), blockTexture(ModBlocks.DARK_TREE_LOG.get()), blockTexture(ModBlocks.DARK_TREE_LOG.get()));
        logBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_DARK_TREE_LOG.get()));
        axisBlock(((RotatedPillarBlock)ModBlocks.STRIPPED_DARK_TREE_WOOD.get()), blockTexture(ModBlocks.STRIPPED_DARK_TREE_LOG.get()), blockTexture(ModBlocks.STRIPPED_DARK_TREE_LOG.get()));

        blockItem(ModBlocks.DARK_TREE_STAIRS);
        blockItem(ModBlocks.CHISELED_SANDSTONE_STAIRS);
        blockItem(ModBlocks.CHISELED_RED_SANDSTONE_STAIRS);
        blockItem(ModBlocks.CHISELED_BLUE_SANDSTONE_STAIRS);
        blockItem(ModBlocks.CUT_SANDSTONE_STAIRS);
        blockItem(ModBlocks.DARK_TREE_SLAB);
        blockItem(ModBlocks.DARK_TREE_PRESSURE_PLATE);
        blockItem(ModBlocks.DARK_TREE_FENCE_GATE);
        blockItem(ModBlocks.DARK_TREE_TRAPDOOR, "_bottom");
        blockItem(ModBlocks.DARK_TREE_LOG);
        blockItem(ModBlocks.DARK_TREE_WOOD);
        blockItem(ModBlocks.STRIPPED_DARK_TREE_LOG);
        blockItem(ModBlocks.STRIPPED_DARK_TREE_WOOD);

        leavesBlock(ModBlocks.DARK_TREE_LEAVES);
        saplingBlock(ModBlocks.DARK_TREE_SAPLING);

        columnBlock(ModBlocks.CHISELED_BLUE_SANDSTONE, "chiseled_blue_sandstone_top", "chiseled_blue_sandstone");
        complexBlock(ModBlocks.DARK_GRASS_BLOCK,
                "dark_dirt",
                "dark_grass_block_top",
                "dark_grass_block_side");
        complexBlockWithFourSides(ModBlocks.SHADOWMARE_SMITHING_TABLE,
                "shadowmare_smithing_table_bottom",
                "shadowmare_smithing_table_front",
                "shadowmare_smithing_table_side",
                "shadowmare_smithing_table_top");

        makeCrop(((CropBlock) ModBlocks.TOMATO_CROP.get()), "tomato_crop_stage", "tomato_crop_stage");
        makeBush(((SweetBerryBushBlock) ModBlocks.BLUEBERRY_BUSH.get()), "blueberry_bush_stage", "blueberry_bush_stage");
    }
    private void saplingBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
    private void leavesBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), ResourceLocation.parse("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
    public void makeBush(SweetBerryBushBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }
    private ConfiguredModel[] states(BlockState state, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().cross(modelName + state.getValue(BlueBerryBushBlock.AGE),
                ResourceLocation.fromNamespaceAndPath(TheForgottenExpance.MODID, "block/" + textureName + state.getValue(BlueBerryBushBlock.AGE))).renderType("cutout"));

        return models;
    }
    public void makeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }
    private ConfiguredModel[] states(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((TomatoCropBlock) block).getAgeProperty()),
                ResourceLocation.fromNamespaceAndPath(TheForgottenExpance.MODID, "block/" + textureName + state.getValue(((TomatoCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }
    private void blockWithItem(DeferredBlock<?> deferredBlock) {simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));}
    private void columnBlock(DeferredBlock<?> deferredBlock, String top, String side) {
        Block block = deferredBlock.get();
        String blockName = deferredBlock.getId().getPath();

        simpleBlockWithItem(block, models().cubeColumn(
                blockName,
                modLoc("block/" + side),
                modLoc("block/" + top)
        ));
    }
    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("theforgottenexpance:block/" + deferredBlock.getId().getPath()));
    }
    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("theforgottenexpance:block/" + deferredBlock.getId().getPath() + appendix));
    }
    private void complexBlock(DeferredBlock<?> deferredBlock, String bottom, String top, String side) {
        Block block = deferredBlock.get();
        String blockName = deferredBlock.getId().getPath();
        simpleBlockWithItem(block, models().cubeBottomTop(blockName,
                modLoc("block/" + side),
                modLoc("block/" + bottom),
                modLoc("block/" + top)));
    }
    private void complexBlockWithFourSides(DeferredBlock<?> deferredBlock, String bottom, String front, String side, String top) {
        Block block = deferredBlock.get();
        String blockName = deferredBlock.getId().getPath();
        simpleBlockWithItem(block, models().cube(
                blockName,
                modLoc("block/" + bottom),
                modLoc("block/" + top),
                modLoc("block/" + front),
                modLoc("block/" + side),
                modLoc("block/" + side),
                modLoc("block/" + side)
        ).texture("particle", modLoc("block/" + top)));
    }
}
