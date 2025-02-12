package net.kirvvi.theforgottenexpance.datagen;

import net.kirvvi.theforgottenexpance.TheForgottenExpance;
import net.kirvvi.theforgottenexpance.block.ModBlocks;
import net.kirvvi.theforgottenexpance.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> ADAMANTIUM_SMELTABLES = List.of(ModBlocks.ADAMANTIUM_ORE, ModBlocks.DEEPSLATE_ADAMANTIUM_ORE);
        List<ItemLike> RUBBER_SMELTABLES = List.of(ModItems.RAW_RUBBER);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ADAMANTIUM_BLOCK.get())
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', ModItems.ADAMANTIUM.get())
                .unlockedBy("has_adamantium", has(ModItems.ADAMANTIUM)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ADAMANTIUM_NETHERITE_BLOCK.get())
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', ModItems.ADAMANTIUM_NETHERITE_CLUSTER.get())
                .unlockedBy("has_adamantium_netherite_cluster", has(ModItems.ADAMANTIUM_NETHERITE_CLUSTER)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ADAMANTIUM_NETHERITE_CLUSTER.get(), 4)
                .pattern("##")
                .pattern(" X")
                .define('#', ModItems.ADAMANTIUM.get())
                .define('X', Items.NETHERITE_INGOT)
                .unlockedBy("has_adamantium", has(ModItems.ADAMANTIUM))
                .unlockedBy("has_netherite", has(Items.NETHERITE_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CHISEL.get())
                .pattern(" #")
                .pattern("X ")
                .define('#', Items.IRON_INGOT)
                .define('X', Items.STICK)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .unlockedBy("has_stick", has(Items.STICK))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FLAMECOAL.get())
                .pattern("###")
                .pattern("#X#")
                .pattern("###")
                .define('#', Items.BLAZE_POWDER)
                .define('X', Items.COAL)
                .unlockedBy("has_blaze_powder", has(Items.BLAZE_POWDER))
                .unlockedBy("has_coal", has(Items.COAL))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.NAUTILUS_SHELL)
                .pattern("##")
                .pattern("##")
                .define('#', ModBlocks.SHELL_BLOCK)
                .unlockedBy("has_shell", has(ModBlocks.SHELL_BLOCK))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.QUARTZ_STICK.get(), 2)
                .pattern("#")
                .pattern("#")
                .define('#', Items.QUARTZ)
                .unlockedBy("has_quartz", has(Items.QUARTZ))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.DARK_TREE_WOOD.get(), 3)
                .pattern("##")
                .pattern("##")
                .define('#', ModBlocks.DARK_TREE_LOG)
                .unlockedBy("has_dark_tree_log", has(ModBlocks.DARK_TREE_LOG))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.QUARTZ_LEATHER_STICK.get())
                .pattern("#")
                .pattern("X")
                .define('#', ModItems.QUARTZ_STICK.get())
                .define('X', Items.LEATHER)
                .unlockedBy("has_quartz_stick", has(ModItems.QUARTZ_STICK))
                .unlockedBy("has_leather", has(Items.LEATHER))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RAW_RUBBER.get())
                .pattern("##")
                .pattern(" X")
                .define('#', Items.COAL)
                .define('X', Items.BONE_MEAL)
                .unlockedBy("has_coal", has(Items.COAL))
                .unlockedBy("has_bone_meal", has(Items.BONE_MEAL))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SHADOWMARE_SMITHING_TABLE.get())
                .pattern("##")
                .pattern("XX")
                .pattern("XX")
                .define('#', ModItems.SHADOWMARE)
                .define('X', ModBlocks.DARK_TREE_PLANKS)
                .unlockedBy("has_shadowmare", has(ModItems.SHADOWMARE))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TELEPORT_WAND.get())
                .pattern(" XS")
                .pattern(" #X")
                .pattern("X  ")
                .define('#', ModItems.QUARTZ_STICK.get())
                .define('X', ModItems.ADAMANTIUM.get())
                .define('S', Items.ENDER_PEARL)
                .unlockedBy("has_quartz_stick", has(ModItems.QUARTZ_STICK))
                .unlockedBy("has_adamantium", has(ModItems.ADAMANTIUM))
                .unlockedBy("has_ender_pearl", has(Items.ENDER_PEARL))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.ADAMANTIUM_SWORD.get())
                .pattern(" # ")
                .pattern(" # ")
                .pattern(" X ")
                .define('#', ModItems.ADAMANTIUM.get())
                .define('X', Items.STICK)
                .unlockedBy("has_adamantium", has(ModItems.ADAMANTIUM))
                .save(recipeOutput);


        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.ADAMANTIUM_NETHERITE_SWORD.get())
                .pattern(" # ")
                .pattern(" # ")
                .pattern(" X ")
                .define('#', ModItems.ADAMANTIUM_NETHERITE_CLUSTER.get())
                .define('X', ModItems.QUARTZ_LEATHER_STICK)
                .unlockedBy("has_adamantium_netherite_cluster", has(ModItems.ADAMANTIUM_NETHERITE_CLUSTER))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ADAMANTIUM_PICKAXE.get())
                .pattern("###")
                .pattern(" X ")
                .pattern(" X ")
                .define('#', ModItems.ADAMANTIUM.get())
                .define('X', ModItems.QUARTZ_STICK)
                .unlockedBy("has_adamantium", has(ModItems.ADAMANTIUM))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ADAMANTIUM_NETHERITE_PICKAXE.get())
                .pattern("###")
                .pattern(" X ")
                .pattern(" X ")
                .define('#', ModItems.ADAMANTIUM_NETHERITE_CLUSTER.get())
                .define('X', ModItems.QUARTZ_LEATHER_STICK)
                .unlockedBy("has_adamantium_netherite_cluster", has(ModItems.ADAMANTIUM_NETHERITE_CLUSTER))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ADAMANTIUM_SHOVEL.get())
                .pattern(" # ")
                .pattern(" X ")
                .pattern(" X ")
                .define('#', ModItems.ADAMANTIUM.get())
                .define('X', ModItems.QUARTZ_STICK)
                .unlockedBy("has_adamantium", has(ModItems.ADAMANTIUM))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ADAMANTIUM_NETHERITE_SHOVEL.get())
                .pattern(" # ")
                .pattern(" X ")
                .pattern(" X ")
                .define('#', ModItems.ADAMANTIUM_NETHERITE_CLUSTER.get())
                .define('X', ModItems.QUARTZ_LEATHER_STICK)
                .unlockedBy("has_adamantium_netherite_cluster", has(ModItems.ADAMANTIUM_NETHERITE_CLUSTER))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ADAMANTIUM_AXE.get())
                .pattern("## ")
                .pattern("#X ")
                .pattern(" X ")
                .define('#', ModItems.ADAMANTIUM.get())
                .define('X', ModItems.QUARTZ_STICK)
                .unlockedBy("has_adamantium", has(ModItems.ADAMANTIUM))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ADAMANTIUM_NETHERITE_AXE.get())
                .pattern("## ")
                .pattern("#X ")
                .pattern(" X ")
                .define('#', ModItems.ADAMANTIUM_NETHERITE_CLUSTER.get())
                .define('X', ModItems.QUARTZ_LEATHER_STICK)
                .unlockedBy("has_adamantium_netherite_cluster", has(ModItems.ADAMANTIUM_NETHERITE_CLUSTER))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ADAMANTIUM_HOE.get())
                .pattern("## ")
                .pattern(" X ")
                .pattern(" X ")
                .define('#', ModItems.ADAMANTIUM.get())
                .define('X', ModItems.QUARTZ_STICK)
                .unlockedBy("has_adamantium", has(ModItems.ADAMANTIUM))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ADAMANTIUM_NETHERITE_HOE.get())
                .pattern("## ")
                .pattern(" X ")
                .pattern(" X ")
                .define('#', ModItems.ADAMANTIUM_NETHERITE_CLUSTER.get())
                .define('X', ModItems.QUARTZ_LEATHER_STICK)
                .unlockedBy("has_adamantium_netherite_cluster", has(ModItems.ADAMANTIUM_NETHERITE_CLUSTER))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ADAMANTIUM_PAXEL.get())
                .pattern("A#S")
                .pattern(" X ")
                .pattern(" X ")
                .define('#', ModItems.ADAMANTIUM_AXE.get())
                .define('A', ModItems.ADAMANTIUM_SHOVEL.get())
                .define('S', ModItems.ADAMANTIUM_PICKAXE.get())
                .define('X', ModItems.QUARTZ_STICK)
                .unlockedBy("has_adamantium_pickaxe", has(ModItems.ADAMANTIUM_PICKAXE))
                .unlockedBy("has_adamantium_axe", has(ModItems.ADAMANTIUM_AXE))
                .unlockedBy("has_adamantium_shovel", has(ModItems.ADAMANTIUM_SHOVEL))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ADAMANTIUM_NETHERITE_PAXEL.get())
                .pattern("A#S")
                .pattern(" X ")
                .pattern(" X ")
                .define('#', ModItems.ADAMANTIUM_NETHERITE_AXE.get())
                .define('A', ModItems.ADAMANTIUM_NETHERITE_SHOVEL.get())
                .define('S', ModItems.ADAMANTIUM_NETHERITE_PICKAXE.get())
                .define('X', ModItems.QUARTZ_LEATHER_STICK)
                .unlockedBy("has_adamantium_pickaxe", has(ModItems.ADAMANTIUM_NETHERITE_PICKAXE))
                .unlockedBy("has_adamantium_netherite_axe", has(ModItems.ADAMANTIUM_NETHERITE_AXE))
                .unlockedBy("has_adamantium_netherite_shovel", has(ModItems.ADAMANTIUM_NETHERITE_SHOVEL))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ADAMANTIUM_HAMMER.get())
                .pattern("###")
                .pattern("#X#")
                .pattern(" X ")
                .define('#', ModItems.ADAMANTIUM.get())
                .define('X', ModItems.QUARTZ_STICK)
                .unlockedBy("has_adamantium", has(ModItems.ADAMANTIUM))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ADAMANTIUM_NETHERITE_HAMMER.get())
                .pattern("###")
                .pattern("#X#")
                .pattern(" X ")
                .define('#', ModItems.ADAMANTIUM_NETHERITE_CLUSTER.get())
                .define('X', ModItems.QUARTZ_LEATHER_STICK)
                .unlockedBy("has_adamantium_netherite_cluster", has(ModItems.ADAMANTIUM_NETHERITE_CLUSTER))
                .save(recipeOutput);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ADAMANTIUM.get(), 9)
                .requires(ModBlocks.ADAMANTIUM_BLOCK)
                .unlockedBy("has_adamantium_block", has(ModBlocks.ADAMANTIUM_BLOCK))
                .save(recipeOutput, "theforgottenexpance:adamantium_from_adamantium_block");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ADAMANTIUM_NETHERITE_CLUSTER.get(), 9)
                .requires(ModBlocks.ADAMANTIUM_NETHERITE_BLOCK)
                .unlockedBy("has_adamantium_netherite_block", has(ModBlocks.ADAMANTIUM_NETHERITE_BLOCK))
                .save(recipeOutput, "theforgottenexpance:adamantium_netherite_cluster_from_adamantium_netherite_block");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.DARK_TREE_PLANKS.get(), 4)
                .requires(ModBlocks.DARK_TREE_LOG)
                .unlockedBy("has_dark_tree_log", has(ModBlocks.DARK_TREE_LOG)).save(recipeOutput);


        oreSmelting(recipeOutput, ADAMANTIUM_SMELTABLES, RecipeCategory.MISC, ModItems.ADAMANTIUM.get(), 1f, 100, "adamantium");
        oreBlasting(recipeOutput, ADAMANTIUM_SMELTABLES, RecipeCategory.MISC, ModItems.ADAMANTIUM.get(), 1f, 100, "adamantium");
        oreSmelting(recipeOutput, RUBBER_SMELTABLES, RecipeCategory.MISC, ModItems.RUBBER.get(), 0.7f, 100, "rubber");

        trimSmithing(recipeOutput, ModItems.SHADOWMANE_SMITHING_TEMPLATE.get(), ResourceLocation.fromNamespaceAndPath(TheForgottenExpance.MODID, "shadowmane"));


        stairBuilder(ModBlocks.DARK_TREE_STAIRS.get(), Ingredient.of(ModBlocks.DARK_TREE_PLANKS)).group("dark_tree_planks")
                .unlockedBy("has_dark_tree_planks", has(ModBlocks.DARK_TREE_PLANKS)).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_TREE_SLAB.get(), ModBlocks.DARK_TREE_PLANKS.get());

        buttonBuilder(ModBlocks.DARK_TREE_BUTTON.get(), Ingredient.of(ModBlocks.DARK_TREE_PLANKS)).group("dark_tree_planks")
                .unlockedBy("has_dark_tree_planks", has(ModBlocks.DARK_TREE_PLANKS)).save(recipeOutput);
        pressurePlate(recipeOutput, ModBlocks.DARK_TREE_PRESSURE_PLATE.get(), ModBlocks.DARK_TREE_PLANKS.get());

        fenceBuilder(ModBlocks.DARK_TREE_FENCE.get(), Ingredient.of(ModBlocks.DARK_TREE_PLANKS)).group("dark_tree_planks")
                .unlockedBy("has_dark_tree_planks", has(ModBlocks.DARK_TREE_PLANKS)).save(recipeOutput);
        fenceGateBuilder(ModBlocks.DARK_TREE_FENCE_GATE.get(), Ingredient.of(ModBlocks.DARK_TREE_PLANKS)).group("dark_tree_planks")
                .unlockedBy("has_dark_tree_planks", has(ModBlocks.DARK_TREE_PLANKS)).save(recipeOutput);

        doorBuilder(ModBlocks.DARK_TREE_DOOR.get(), Ingredient.of(ModBlocks.DARK_TREE_PLANKS)).group("dark_tree_planks")
                .unlockedBy("has_dark_tree_planks", has(ModBlocks.DARK_TREE_PLANKS)).save(recipeOutput);
        trapdoorBuilder(ModBlocks.DARK_TREE_TRAPDOOR.get(),Ingredient.of(ModBlocks.DARK_TREE_PLANKS)).group("dark_tree_planks")
                .unlockedBy("has_dark_tree_planks", has(ModBlocks.DARK_TREE_PLANKS)).save(recipeOutput);
    }




    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, TheForgottenExpance.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
