package net.kirvvi.theforgottenexpance.datagen;

import net.kirvvi.theforgottenexpance.block.ModBlocks;
import net.kirvvi.theforgottenexpance.block.custom.TomatoCropBlock;
import net.kirvvi.theforgottenexpance.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.ADAMANTIUM_BLOCK.get());
        dropSelf(ModBlocks.ADAMANTIUM_NETHERITE_BLOCK.get());

        dropSelf(ModBlocks.DARK_DIRT.get());

        this.dropSelf(ModBlocks.DARK_TREE_LOG.get());
        this.dropSelf(ModBlocks.DARK_TREE_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_DARK_TREE_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_DARK_TREE_WOOD.get());
        this.dropSelf(ModBlocks.DARK_TREE_PLANKS.get());
        this.dropSelf(ModBlocks.DARK_TREE_SAPLING.get());
        this.add(ModBlocks.DARK_TREE_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.DARK_TREE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        dropSelf(ModBlocks.DARK_TREE_STAIRS.get());
        dropSelf(ModBlocks.CHISELED_RED_SANDSTONE_STAIRS.get());
        dropSelf(ModBlocks.CHISELED_BLUE_SANDSTONE_STAIRS.get());
        dropSelf(ModBlocks.DARK_TREE_SLAB.get());
        dropSelf(ModBlocks.DARK_TREE_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.DARK_TREE_BUTTON.get());
        dropSelf(ModBlocks.SHADOWMARE_SMITHING_TABLE.get());
        dropSelf(ModBlocks.CHISELED_SANDSTONE_STAIRS.get());
        dropSelf(ModBlocks.CUT_SANDSTONE_STAIRS.get());
        dropSelf(ModBlocks.LIBRARY_STATUE.get()); 
        dropSelf(ModBlocks.ALCHEMIST_STATUE.get());
        dropSelf(ModBlocks.WARRIOR_STATUE.get());
        dropSelf(ModBlocks.PRIEST_STATUE.get());
        dropSelf(ModBlocks.SHELL_BLOCK.get());
        dropSelf(ModBlocks.PHARAOH_SEAT.get());

        dropSelf(ModBlocks.PRIEST_PEDESTAL.get());
        dropSelf(ModBlocks.ALCHEMIST_PEDESTAL.get());
        dropSelf(ModBlocks.WARRIOR_PEDESTAL.get());
        dropSelf(ModBlocks.LIBRARY_PEDESTAL.get());

        dropSelf(ModBlocks.CHISELED_BLUE_SANDSTONE.get());
        dropSelf(ModBlocks.DARK_TREE_FENCE.get());
        dropSelf(ModBlocks.DARK_TREE_FENCE_GATE.get());
        dropSelf(ModBlocks.DARK_TREE_TRAPDOOR.get());

        add(ModBlocks.DARK_TREE_DOOR.get(),
                block -> createDoorTable(ModBlocks.DARK_TREE_DOOR.get()));

        add(ModBlocks.ADAMANTIUM_ORE.get(), block -> createOreDrop(ModBlocks.ADAMANTIUM_ORE.get(), ModItems.ADAMANTIUM.get()));
        add(ModBlocks.DEEPSLATE_ADAMANTIUM_ORE.get(), block -> createOreDrop(ModBlocks.DEEPSLATE_ADAMANTIUM_ORE.get(), ModItems.ADAMANTIUM.get()));
        add(ModBlocks.DARK_GRASS_BLOCK.get(), block -> createBlockDrops(ModBlocks.DARK_GRASS_BLOCK.get(), ModBlocks.DARK_DIRT.get()));
        add(ModBlocks.NETHER_SHADOWMARE_ORE.get(), block -> createOreDrop(ModBlocks.NETHER_SHADOWMARE_ORE.get(), ModItems.SHADOWMARE.get()));
        add(ModBlocks.NETHER_SHADOWMARE_ORE.get(), block -> createOreDrop(ModBlocks.NETHER_SHADOWMARE_ORE.get(), ModItems.SHADOWMARE.get()));
        add(ModBlocks.ROCK_BLOCK.get(), block -> createOreDrop(ModBlocks.ROCK_BLOCK.get(), ModItems.ROCK.get()));
        add(ModBlocks.COCONUT_BLOCK.get(), block -> createOreDrop(ModBlocks.COCONUT_BLOCK.get(), ModItems.COCONUT.get()));
        add(ModBlocks.CRUSHED_COCONUT_BLOCK.get(), block -> createOreDrop(ModBlocks.CRUSHED_COCONUT_BLOCK.get(), ModItems.CRUSHED_COCONUT.get()));
        add(ModBlocks.DESTROYED_COCONUT_BLOCK.get(), block -> createOreDrop(ModBlocks.DESTROYED_COCONUT_BLOCK.get(), ModItems.DESTROYED_COCONUT.get()));
        add(ModBlocks.QUICKSAND.get(), block -> createBlockDrops(ModBlocks.QUICKSAND.get(), Blocks.SAND));

        LootItemCondition.Builder lootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.TOMATO_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(TomatoCropBlock.AGE, 3));

        this.add(ModBlocks.TOMATO_CROP.get(), this.createCropDrops(ModBlocks.TOMATO_CROP.get(),
                ModItems.TOMATO.get(), ModItems.TOMATO_SEEDS.get(), lootItemConditionBuilder));
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);

        this.add(ModBlocks.BLUEBERRY_BUSH.get(), block -> this.applyExplosionDecay(
                block,LootTable.lootTable().withPool(LootPool.lootPool().when(
                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.BLUEBERRY_BUSH.get())
                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 3))
                                ).add(LootItem.lootTableItem(ModItems.BLUEBERRY.get()))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F)))
                                .apply(ApplyBonusCount.addUniformBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                ).withPool(LootPool.lootPool().when(
                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.BLUEBERRY_BUSH.get())
                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 2))
                                ).add(LootItem.lootTableItem(ModItems.BLUEBERRY.get()))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                                .apply(ApplyBonusCount.addUniformBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )));
    }


    protected LootTable.Builder createBlockDrops(Block fromBlock, Block dropBlock) {
        return LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(dropBlock))
                );
    }


    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
