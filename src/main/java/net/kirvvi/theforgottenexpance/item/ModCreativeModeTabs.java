package net.kirvvi.theforgottenexpance.item;

import net.kirvvi.theforgottenexpance.TheForgottenExpance;
import net.kirvvi.theforgottenexpance.block.ModBlocks;
import net.kirvvi.theforgottenexpance.event.ModEvents;
import net.kirvvi.theforgottenexpance.potion.ModPotions;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TheForgottenExpance.MODID);

    public static final Supplier<CreativeModeTab> THE_FORGOTTEN_EXPANCE = CREATIVE_MODE_TAB.register("the_forgotten_expance_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ADAMANTIUM.get()))
                    .title(Component.translatable("TFE Overworld"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.ADAMANTIUM);
                        output.accept(ModItems.QUARTZ_STICK);
                        output.accept(ModItems.QUARTZ_LEATHER_STICK);

                        output.accept(ModItems.RAW_RUBBER);
                        output.accept(ModItems.RUBBER);
                        output.accept(ModItems.TOMATO);
                        output.accept(ModItems.FLAMECOAL);
                        output.accept(ModItems.ADAMANTIUM_NETHERITE_CLUSTER);
                        output.accept(ModItems.SHADOWMANE_SMITHING_TEMPLATE);
                        output.accept(ModItems.SHADOWMARE);

                        output.accept(ModItems.TOMATO_SEEDS);
                        output.accept(ModItems.BLUEBERRY);
                        output.accept(ModItems.GECKO_SPAWN_EGG);
                        output.accept(ModItems.MUMMY_SPAWN_EGG);
                        output.accept(ModItems.PORCUPINE_SPAWN_EGG);
                        output.accept(ModItems.ROCK);
                        output.accept(ModItems.COCONUT);
                        output.accept(ModItems.CRUSHED_COCONUT);

                        output.accept(ModItems.DESTROYED_COCONUT);
                        output.accept(ModItems.COCONUT_OPENED);
                        output.accept(ModItems.COCONUT_OPENED_CLEAN);
                        output.accept(ModItems.COCONUT_PART);
                        output.accept(ModItems.QUICKSAND_BUCKET);
                        output.accept(ModBlocks.DARK_TREE_SAPLING);
                        output.accept(ModBlocks.SHELL_BLOCK);
                        output.accept(ModBlocks.LIBRARY_STATUE);
                        output.accept(ModBlocks.ALCHEMIST_STATUE);
                        output.accept(ModBlocks.WARRIOR_STATUE);
                        output.accept(ModBlocks.PRIEST_STATUE);
                        output.accept(ModItems.MUMMY_BANDAGE);
                    }).build());
    public static final Supplier<CreativeModeTab> THE_FORGOTTEN_EXPANCE_ITEMS = CREATIVE_MODE_TAB.register("the_forgotten_expance_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ADAMANTIUM_PAXEL.get()))
                    .title(Component.translatable("TFE Gear & Armor"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.TELEPORT_WAND);
                        output.accept(ModItems.CHISEL);
                        output.accept(ModItems.WITHER_ARROW);

                        output.accept(ModItems.ADAMANTIUM_AXE);
                        output.accept(ModItems.ADAMANTIUM_HOE);
                        output.accept(ModItems.ADAMANTIUM_PAXEL);
                        output.accept(ModItems.ADAMANTIUM_PICKAXE);
                        output.accept(ModItems.ADAMANTIUM_SHOVEL);
                        output.accept(ModItems.ADAMANTIUM_SWORD);
                        output.accept(ModItems.ADAMANTIUM_HAMMER);

                        output.accept(ModItems.ADAMANTIUM_NETHERITE_AXE);
                        output.accept(ModItems.ADAMANTIUM_NETHERITE_HOE);
                        output.accept(ModItems.ADAMANTIUM_NETHERITE_PAXEL);
                        output.accept(ModItems.ADAMANTIUM_NETHERITE_PICKAXE);
                        output.accept(ModItems.ADAMANTIUM_NETHERITE_SHOVEL);
                        output.accept(ModItems.ADAMANTIUM_NETHERITE_SWORD);
                        output.accept(ModItems.ADAMANTIUM_NETHERITE_HAMMER);

                        output.accept(ModItems.ADAMANTIUM_HELMET);
                        output.accept(ModItems.ADAMANTIUM_CHESTPLATE);
                        output.accept(ModItems.ADAMANTIUM_LEGGINGS);
                        output.accept(ModItems.ADAMANTIUM_BOOTS);

                        output.accept(ModItems.ADAMANTIUM_NETHERITE_HELMET);
                        output.accept(ModItems.ADAMANTIUM_NETHERITE_CHESTPLATE);
                        output.accept(ModItems.ADAMANTIUM_NETHERITE_LEGGINGS);
                        output.accept(ModItems.ADAMANTIUM_NETHERITE_BOOTS);

                        output.accept(ModItems.SHADOWMARE_BOW);
                    }).build());
    public static final Supplier<CreativeModeTab> THE_FORGOTTEN_EXPANCE_BLOCKS = CREATIVE_MODE_TAB.register("the_forgotten_expance_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.ADAMANTIUM_NETHERITE_BLOCK.get()))
                    .title(Component.translatable("TFE Blocks"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModBlocks.ADAMANTIUM_BLOCK);
                        output.accept(ModBlocks.ADAMANTIUM_ORE);
                        output.accept(ModBlocks.NETHER_SHADOWMARE_ORE);
                        output.accept(ModBlocks.DEEPSLATE_ADAMANTIUM_ORE);
                        output.accept(ModBlocks.ADAMANTIUM_NETHERITE_BLOCK);
                        output.accept(ModBlocks.CHISELED_BLUE_SANDSTONE);

                        output.accept(ModBlocks.DARK_GRASS_BLOCK);
                        output.accept(ModBlocks.DARK_DIRT);
                        output.accept(ModBlocks.DARK_TREE_LEAVES);
                        output.accept(ModBlocks.DARK_TREE_PLANKS);
                        output.accept(ModBlocks.DARK_TREE_LOG);
                        output.accept(ModBlocks.STRIPPED_DARK_TREE_LOG);
                        output.accept(ModBlocks.DARK_TREE_WOOD);
                        output.accept(ModBlocks.STRIPPED_DARK_TREE_WOOD);

                        output.accept(ModBlocks.DARK_TREE_STAIRS);
                        output.accept(ModBlocks.DARK_TREE_SLAB);
                        output.accept(ModBlocks.DARK_TREE_PRESSURE_PLATE);
                        output.accept(ModBlocks.DARK_TREE_BUTTON);
                        output.accept(ModBlocks.DARK_TREE_FENCE);
                        output.accept(ModBlocks.DARK_TREE_FENCE_GATE);
                        output.accept(ModBlocks.DARK_TREE_DOOR);
                        output.accept(ModBlocks.DARK_TREE_TRAPDOOR);

                        output.accept(ModBlocks.SHADOWMARE_SMITHING_TABLE);

                        output.accept(ModBlocks.CUT_SANDSTONE_STAIRS);
                        output.accept(ModBlocks.CHISELED_SANDSTONE_STAIRS);
                        output.accept(ModBlocks.CHISELED_RED_SANDSTONE_STAIRS);
                        output.accept(ModBlocks.CHISELED_BLUE_SANDSTONE_STAIRS);

                        output.accept(ModBlocks.PRIEST_PEDESTAL);
                        output.accept(ModBlocks.ALCHEMIST_PEDESTAL);
                        output.accept(ModBlocks.WARRIOR_PEDESTAL);
                        output.accept(ModBlocks.LIBRARY_PEDESTAL);
                        output.accept(ModBlocks.PHARAOH_SEAT);
                    }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
