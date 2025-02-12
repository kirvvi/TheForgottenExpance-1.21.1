package net.kirvvi.theforgottenexpance.datagen;

import net.kirvvi.theforgottenexpance.TheForgottenExpance;
import net.kirvvi.theforgottenexpance.block.ModBlocks;
import net.kirvvi.theforgottenexpance.item.ModItems;
import net.kirvvi.theforgottenexpance.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TheForgottenExpance.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.ADAMANTIUM_BLOCK.get())
                .add(ModBlocks.ADAMANTIUM_NETHERITE_BLOCK.get())
                .add(ModBlocks.ADAMANTIUM_ORE.get())
                .add(ModBlocks.DEEPSLATE_ADAMANTIUM_ORE.get())
                .add(ModBlocks.NETHER_SHADOWMARE_ORE.get())
                .add(ModBlocks.CHISELED_BLUE_SANDSTONE.get())
                .add(ModBlocks.CHISELED_BLUE_SANDSTONE_STAIRS.get())
                .add(ModBlocks.CHISELED_SANDSTONE_STAIRS.get())
                .add(ModBlocks.CUT_SANDSTONE_STAIRS.get())
                .add(ModBlocks.CHISELED_RED_SANDSTONE_STAIRS.get())
                .add(ModBlocks.LIBRARY_STATUE.get());
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.DARK_TREE_LOG.get())
                .add(ModBlocks.DARK_TREE_PLANKS.get())
                .add(Block.byItem(ModItems.TOMATO.get()));
        tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlocks.DARK_DIRT.get())
                .add(ModBlocks.DARK_GRASS_BLOCK.get());
        tag(BlockTags.MINEABLE_WITH_HOE)
                .add(ModBlocks.DARK_DIRT.get())
                .add(ModBlocks.DARK_TREE_LEAVES.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ADAMANTIUM_BLOCK.get())
                .add(ModBlocks.ADAMANTIUM_NETHERITE_BLOCK.get())
                .add(ModBlocks.ADAMANTIUM_ORE.get())
                .add(ModBlocks.DEEPSLATE_ADAMANTIUM_ORE.get())
                .add(ModBlocks.NETHER_SHADOWMARE_ORE.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.LIBRARY_STATUE.get());

        tag(BlockTags.ANIMALS_SPAWNABLE_ON)
                .add(ModBlocks.DARK_GRASS_BLOCK.get());

        tag(BlockTags.CONVERTABLE_TO_MUD)
                .add(ModBlocks.DARK_DIRT.get());

        tag(BlockTags.DIRT)
                .add(ModBlocks.DARK_GRASS_BLOCK.get())
                .add(ModBlocks.DARK_DIRT.get());

        tag(BlockTags.FOXES_SPAWNABLE_ON)
                .add(ModBlocks.DARK_GRASS_BLOCK.get());

        tag(BlockTags.FROGS_SPAWNABLE_ON)
                .add(ModBlocks.DARK_GRASS_BLOCK.get());

        tag(BlockTags.LEAVES)
                .add(ModBlocks.DARK_TREE_LEAVES.get());

        tag(BlockTags.LOGS)
                .add(ModBlocks.DARK_TREE_LOG.get())
                .add(ModBlocks.STRIPPED_DARK_TREE_LOG.get());

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.DARK_TREE_LOG.get())
                .add(ModBlocks.STRIPPED_DARK_TREE_LOG.get())
                .add(ModBlocks.DARK_TREE_WOOD.get())
                .add(ModBlocks.STRIPPED_DARK_TREE_WOOD.get());

        tag(BlockTags.OVERWORLD_NATURAL_LOGS)
                .add(ModBlocks.DARK_TREE_LOG.get());

        tag(BlockTags.PARROTS_SPAWNABLE_ON)
                .add(ModBlocks.DARK_GRASS_BLOCK.get());

        tag(BlockTags.PLANKS)
                .add(ModBlocks.DARK_TREE_PLANKS.get());

        tag(BlockTags.RABBITS_SPAWNABLE_ON)
                .add(ModBlocks.DARK_GRASS_BLOCK.get());

        tag(BlockTags.SNIFFER_DIGGABLE_BLOCK)
                .add(ModBlocks.DARK_GRASS_BLOCK.get())
                .add(ModBlocks.DARK_DIRT.get());

        tag(BlockTags.WOLVES_SPAWNABLE_ON)
                .add(ModBlocks.DARK_GRASS_BLOCK.get());

        tag(BlockTags.MAINTAINS_FARMLAND)
                .add(Block.byItem(ModItems.TOMATO.get()));

        tag(BlockTags.BEE_GROWABLES)
                .add(Block.byItem(ModItems.TOMATO.get()));

        tag(BlockTags.CROPS)
                .add(Block.byItem(ModItems.TOMATO.get()));

        tag(BlockTags.SWORD_EFFICIENT)
                .add(Block.byItem(ModItems.TOMATO.get()));

        tag(ModTags.Blocks.ADAMANTIUM_ORES)
                .add(ModBlocks.ADAMANTIUM_ORE.get())
                .add(ModBlocks.DEEPSLATE_ADAMANTIUM_ORE.get());

        tag(ModTags.Blocks.SHADOWWOOD_LOGS)
                .add(ModBlocks.DARK_TREE_LOG.get());

        tag(BlockTags.FENCES)
                .add(ModBlocks.DARK_TREE_FENCE.get());
        tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.DARK_TREE_FENCE_GATE.get());

        tag(BlockTags.SLABS)
                .add(ModBlocks.DARK_TREE_SLAB.get());
        tag(BlockTags.WOODEN_SLABS)
                .add(ModBlocks.DARK_TREE_SLAB.get());

        tag(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.DARK_TREE_PRESSURE_PLATE.get());
        tag(BlockTags.PRESSURE_PLATES)
                .add(ModBlocks.DARK_TREE_PRESSURE_PLATE.get());
        tag(BlockTags.WALL_POST_OVERRIDE)
                .add(ModBlocks.DARK_TREE_PRESSURE_PLATE.get());

        tag(BlockTags.WOODEN_STAIRS)
                .add(ModBlocks.DARK_TREE_STAIRS.get());
        tag(BlockTags.STAIRS)
                .add(ModBlocks.DARK_TREE_STAIRS.get());

        tag(BlockTags.DOORS)
                .add(ModBlocks.DARK_TREE_DOOR.get());
        tag(BlockTags.WOODEN_DOORS)
                .add(ModBlocks.DARK_TREE_DOOR.get());

        tag(BlockTags.TRAPDOORS)
                .add(ModBlocks.DARK_TREE_TRAPDOOR.get());
        tag(BlockTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.DARK_TREE_TRAPDOOR.get());

        tag(BlockTags.BUTTONS)
                .add(ModBlocks.DARK_TREE_BUTTON.get());
        tag(BlockTags.WOODEN_BUTTONS)
                .add(ModBlocks.DARK_TREE_BUTTON.get());

        tag(ModTags.Blocks.NEEDS_ADAMANTIUM_TOOl)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);
        tag(ModTags.Blocks.INCORRECT_FOR_ADAMANTIUM_TOOl)
                .addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .remove(ModTags.Blocks.NEEDS_ADAMANTIUM_TOOl);

        tag(ModTags.Blocks.NEEDS_ADAMANTIUM_NETHERITE_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);
        tag(ModTags.Blocks.INCORRECT_FOR_ADAMANTIUM_NETHERITE_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .remove(ModTags.Blocks.NEEDS_ADAMANTIUM_NETHERITE_TOOL);

        tag(ModTags.Blocks.DROPABLE)
                .addTag(BlockTags.SLABS)
                .addTag(BlockTags.STAIRS)
                .addTag(BlockTags.TRAPDOORS)
                .addTag(BlockTags.DOORS)
                .addTag(BlockTags.WOOL_CARPETS)
                .addTag(BlockTags.BEDS)
                .addTag(BlockTags.RAILS)
                .add(Blocks.CHAIN)
                .add(Blocks.IRON_BARS)
                .add(Blocks.POINTED_DRIPSTONE)
                .add(Blocks.BIG_DRIPLEAF)
                .add(Blocks.SCULK_SHRIEKER)
                .add(Blocks.SCULK_SENSOR)
                .add(Blocks.CALIBRATED_SCULK_SENSOR)
                .add(Blocks.CACTUS)
                .add(Blocks.LANTERN)
                .add(Blocks.END_ROD)
                .add(Blocks.SOUL_LANTERN)
                .add(Blocks.CAMPFIRE)
                .add(Blocks.SOUL_CAMPFIRE)
                .add(Blocks.COMPOSTER)
                .add(Blocks.ENCHANTING_TABLE)
                .add(Blocks.BREWING_STAND)
                .add(Blocks.CAULDRON)
                .add(Blocks.CONDUIT)
                .add(Blocks.SCAFFOLDING)
                .add(Blocks.LADDER)
                .add(Blocks.DRAGON_EGG)
                .add(Blocks.FLOWER_POT)
                .add(Blocks.CREEPER_HEAD)
                .add(Blocks.PIGLIN_HEAD)
                .add(Blocks.PLAYER_HEAD)
                .add(Blocks.ZOMBIE_HEAD)
                .add(Blocks.SKELETON_SKULL)
                .add(Blocks.WITHER_SKELETON_SKULL)
                .add(Blocks.SKELETON_WALL_SKULL)
                .add(Blocks.WITHER_SKELETON_WALL_SKULL)
                .add(Blocks.CREEPER_WALL_HEAD)
                .add(Blocks.PIGLIN_WALL_HEAD)
                .add(Blocks.PLAYER_WALL_HEAD)
                .add(Blocks.ZOMBIE_WALL_HEAD)
                .add(Blocks.DRAGON_WALL_HEAD)
                .add(Blocks.DRAGON_HEAD)
                .add(Blocks.END_PORTAL_FRAME)
                .add(Blocks.REDSTONE_TORCH)
                .add(Blocks.TORCH)
                .add(Blocks.WALL_TORCH)
                .add(Blocks.SOUL_TORCH)
                .add(Blocks.SOUL_WALL_TORCH)
                .add(Blocks.REDSTONE_TORCH)
                .add(Blocks.DAYLIGHT_DETECTOR)
                .add(Blocks.REDSTONE_WALL_TORCH)
                .add(Blocks.HOPPER)
                .add(Blocks.TRIPWIRE_HOOK)
                .add(Blocks.LEVER)
                .add(Blocks.VINE)
                .add(ModBlocks.ROCK_BLOCK.get());
        tag(ModTags.Blocks.REPLACEABLE)
                .addTag(BlockTags.REPLACEABLE)
                .addTag(BlockTags.FLOWERS)
                .addTag(BlockTags.CANDLES)
                .addTag(BlockTags.COMBINATION_STEP_SOUND_BLOCKS)
                .addTag(BlockTags.BANNERS)
                .addTag(BlockTags.SAPLINGS)
                .addTag(BlockTags.UNDERWATER_BONEMEALS)
                .addTag(BlockTags.CROPS)
                .add(Blocks.SMALL_AMETHYST_BUD)
                .add(Blocks.MEDIUM_AMETHYST_BUD)
                .add(ModBlocks.ROCK_BLOCK.get())
                .add(Blocks.LARGE_AMETHYST_BUD)
                .add(Blocks.AMETHYST_CLUSTER)
                .add(Blocks.DEAD_BRAIN_CORAL)
                .add(Blocks.DEAD_BRAIN_CORAL)
                .add(Blocks.DEAD_BUBBLE_CORAL)
                .add(Blocks.DEAD_FIRE_CORAL)
                .add(Blocks.DEAD_HORN_CORAL)
                .add(Blocks.DEAD_TUBE_CORAL)
                .add(Blocks.DEAD_BRAIN_CORAL_BLOCK)
                .add(Blocks.DEAD_BUBBLE_CORAL_BLOCK)
                .add(Blocks.DEAD_FIRE_CORAL_BLOCK)
                .add(Blocks.DEAD_HORN_CORAL_BLOCK)
                .add(Blocks.DEAD_TUBE_CORAL_BLOCK)
                .add(Blocks.DEAD_BRAIN_CORAL_FAN)
                .add(Blocks.DEAD_BUBBLE_CORAL_FAN)
                .add(Blocks.DEAD_FIRE_CORAL_FAN)
                .add(Blocks.DEAD_HORN_CORAL_FAN)
                .add(Blocks.DEAD_TUBE_CORAL_FAN)
                .add(Blocks.SWEET_BERRY_BUSH)
                .add(Blocks.BROWN_MUSHROOM)
                .add(Blocks.BROWN_MUSHROOM)
                .add(Blocks.CRIMSON_FUNGUS)
                .add(Blocks.WARPED_FUNGUS)
                .add(ModBlocks.BLUEBERRY_BUSH.get());
    }
}
