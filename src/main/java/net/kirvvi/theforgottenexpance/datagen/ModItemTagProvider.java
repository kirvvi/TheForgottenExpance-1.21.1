package net.kirvvi.theforgottenexpance.datagen;

import net.kirvvi.theforgottenexpance.TheForgottenExpance;
import net.kirvvi.theforgottenexpance.block.ModBlocks;
import net.kirvvi.theforgottenexpance.item.ModItems;
import net.kirvvi.theforgottenexpance.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags,  @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, TheForgottenExpance.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ItemTags.TRIM_MATERIALS)
                .add(ModItems.ADAMANTIUM.get())
                .add(ModItems.ADAMANTIUM_NETHERITE_CLUSTER.get())
                .add(ModItems.SHADOWMARE.get());

        tag(ItemTags.PIG_FOOD)
                .add(ModItems.TOMATO.get());
        tag(ItemTags.VILLAGER_PLANTABLE_SEEDS)
                .add(ModItems.TOMATO.get())
                .add(ModItems.TOMATO_SEEDS.get())
                .add(Item.byBlock(ModBlocks.TOMATO_CROP.get()));

        tag(ItemTags.SWORDS)
                .add(ModItems.ADAMANTIUM_SWORD.get())
                .add(ModItems.ADAMANTIUM_NETHERITE_SWORD.get());
        tag(ItemTags.AXES)
                .add(ModItems.ADAMANTIUM_AXE.get())
                .add(ModItems.ADAMANTIUM_NETHERITE_AXE.get());
        tag(ItemTags.PICKAXES)
                .add(ModItems.ADAMANTIUM_PICKAXE.get())
                .add(ModItems.ADAMANTIUM_NETHERITE_PICKAXE.get());
        tag(ItemTags.SHOVELS)
                .add(ModItems.ADAMANTIUM_SHOVEL.get())
                .add(ModItems.ADAMANTIUM_NETHERITE_SHOVEL.get());
        tag(ItemTags.HOES)
                .add(ModItems.ADAMANTIUM_HOE.get())
                .add(ModItems.ADAMANTIUM_NETHERITE_HOE.get());
        tag(ModTags.Items.PAXELS)
                .add(ModItems.ADAMANTIUM_PAXEL.get())
                .add(ModItems.ADAMANTIUM_NETHERITE_PAXEL.get());
        tag(ModTags.Items.HAMMERS)
                .add(ModItems.ADAMANTIUM_HAMMER.get())
                .add(ModItems.ADAMANTIUM_NETHERITE_HAMMER.get());
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.ADAMANTIUM_HELMET.get())
                .add(ModItems.ADAMANTIUM_CHESTPLATE.get())
                .add(ModItems.ADAMANTIUM_LEGGINGS.get())
                .add(ModItems.ADAMANTIUM_BOOTS.get())
                .add(ModItems.ADAMANTIUM_NETHERITE_HELMET.get())
                .add(ModItems.ADAMANTIUM_NETHERITE_CHESTPLATE.get())
                .add(ModItems.ADAMANTIUM_NETHERITE_LEGGINGS.get())
                .add(ModItems.ADAMANTIUM_NETHERITE_BOOTS.get());
        this.tag(ItemTags.TRIM_TEMPLATES)
                .add(ModItems.SHADOWMANE_SMITHING_TEMPLATE.get());

        tag(ItemTags.COMPLETES_FIND_TREE_TUTORIAL)
                .add(Item.byBlock(ModBlocks.DARK_TREE_LEAVES.get()));
        tag(ItemTags.DIRT)
                .add(Item.byBlock(ModBlocks.DARK_DIRT.get()))
                .add(Item.byBlock(ModBlocks.DARK_GRASS_BLOCK.get()));
        tag(ItemTags.LEAVES)
                .add(Item.byBlock(ModBlocks.DARK_TREE_LEAVES.get()));

        tag(ItemTags.LOGS)
                .add(Item.byBlock(ModBlocks.DARK_TREE_LOG.get()))
                .add(Item.byBlock(ModBlocks.STRIPPED_DARK_TREE_LOG.get()));
        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(Item.byBlock(ModBlocks.DARK_TREE_LOG.get()))
                .add(Item.byBlock(ModBlocks.STRIPPED_DARK_TREE_LOG.get()))
                .add(Item.byBlock(ModBlocks.DARK_TREE_WOOD.get()))
                .add(Item.byBlock(ModBlocks.STRIPPED_DARK_TREE_WOOD.get()));
        this.tag(ItemTags.PLANKS)
                .add(Item.byBlock(ModBlocks.DARK_TREE_PLANKS.get()));
        tag(ItemTags.SLABS)
                .add(Item.byBlock(ModBlocks.DARK_TREE_SLAB.get()));
        tag(ItemTags.WOODEN_SLABS)
                .add(Item.byBlock(ModBlocks.DARK_TREE_SLAB.get()));
        tag(ItemTags.WOODEN_PRESSURE_PLATES)
                .add(Item.byBlock(ModBlocks.DARK_TREE_PRESSURE_PLATE.get()));

        tag(ItemTags.WOODEN_STAIRS)
                .add(Item.byBlock(ModBlocks.DARK_TREE_STAIRS.get()));
        tag(ItemTags.STAIRS)
                .add(Item.byBlock(ModBlocks.DARK_TREE_STAIRS.get()));

        tag(ItemTags.DOORS)
                .add(Item.byBlock(ModBlocks.DARK_TREE_DOOR.get()));
        tag(ItemTags.WOODEN_DOORS)
                .add(Item.byBlock(ModBlocks.DARK_TREE_DOOR.get()));

        tag(ItemTags.TRAPDOORS)
                .add(Item.byBlock(ModBlocks.DARK_TREE_TRAPDOOR.get()));
        tag(ItemTags.WOODEN_TRAPDOORS)
                .add(Item.byBlock(ModBlocks.DARK_TREE_TRAPDOOR.get()));

        tag(ItemTags.BUTTONS)
                .add(Item.byBlock(ModBlocks.DARK_TREE_BUTTON.get()));
        tag(ItemTags.WOODEN_BUTTONS)
                .add(Item.byBlock(ModBlocks.DARK_TREE_BUTTON.get()));

        tag(ModTags.Items.ADAMANTIUM_ORES)
                .add(Item.byBlock(ModBlocks.ADAMANTIUM_ORE.get()))
                .add(Item.byBlock(ModBlocks.DEEPSLATE_ADAMANTIUM_ORE.get()));
        tag(ModTags.Items.SHADOWWOOD_LOGS)
                .add(Item.byBlock(ModBlocks.DARK_TREE_LOG.get()));


    }
}
