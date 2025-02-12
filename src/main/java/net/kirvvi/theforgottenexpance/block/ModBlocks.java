package net.kirvvi.theforgottenexpance.block;

import net.kirvvi.theforgottenexpance.TheForgottenExpance;
import net.kirvvi.theforgottenexpance.block.custom.*;
import net.kirvvi.theforgottenexpance.item.ModItems;
import net.kirvvi.theforgottenexpance.worldgen.tree.ModTreeGrowers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.SmithingMenu;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;


public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(TheForgottenExpance.MODID);

    public static final DeferredBlock<Block> ADAMANTIUM_BLOCK = registerBlock("adamantium_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> ADAMANTIUM_NETHERITE_BLOCK = registerBlock("adamantium_netherite_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<ShadowmareSmithingTableBlock> SHADOWMARE_SMITHING_TABLE = registerBlock("shadowmare_smithing_table",
            () -> new ShadowmareSmithingTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SMITHING_TABLE)) {
                @Override
                public MenuProvider getMenuProvider(BlockState state, Level world, BlockPos pos) {
                    return new MenuProvider() {
                        @Override
                        public Component getDisplayName() {
                            return Component.translatable("container.shadowmare_smithing_table");
                        }

                        @Override
                        public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                            return new SmithingMenu(id, inventory, ContainerLevelAccess.create(world, pos));
                        }
                    };
                }
            });

    public static final DeferredBlock<Block> DARK_GRASS_BLOCK = registerBlock("dark_grass_block",
            () -> new GrassBlock(BlockBehaviour.Properties.of().mapColor(MapColor.GRASS).randomTicks()
                    .strength(0.6F).sound(SoundType.GRASS)));
    public static final DeferredBlock<Block> DARK_DIRT = registerBlock("dark_dirt",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT)
                    .strength(0.5F).sound(SoundType.GRAVEL)));

    public static final DeferredBlock<Block> DARK_TREE_LOG = registerBlock("dark_tree_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<Block> DARK_TREE_WOOD = registerBlock("dark_tree_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<Block> STRIPPED_DARK_TREE_LOG = registerBlock("stripped_dark_tree_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
    public static final DeferredBlock<Block> STRIPPED_DARK_TREE_WOOD = registerBlock("stripped_dark_tree_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> DARK_TREE_PLANKS = registerBlock("dark_tree_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final DeferredBlock<Block> DARK_TREE_LEAVES = registerBlock("dark_tree_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });

     public static final DeferredBlock<Block> DARK_TREE_SAPLING = registerBlock("dark_tree_sapling",
           () -> new SaplingBlock(ModTreeGrowers.SHADOWWOOD, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

   public static final DeferredBlock<Block> ADAMANTIUM_ORE = registerBlock("adamantium_ore",
           () -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of().strength(3f).mapColor(MapColor.STONE)
                   .instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));
   public static final DeferredBlock<Block> DEEPSLATE_ADAMANTIUM_ORE = registerBlock("deepslate_adamantium_ore",
            () -> new  DropExperienceBlock(UniformInt.of(3, 6), BlockBehaviour.Properties.of().strength(4f).mapColor(MapColor.DEEPSLATE)
                    .strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> NETHER_SHADOWMARE_ORE = registerBlock("nether_shadowmare_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of().strength(2f).mapColor(MapColor.NETHER)
                    .instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().sound(SoundType.NETHER_ORE).strength(2.0F, 3.0F)));

    public static final DeferredBlock<StairBlock> DARK_TREE_STAIRS = registerBlock("dark_tree_stairs",
            () -> new StairBlock(ModBlocks.DARK_TREE_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<SlabBlock> DARK_TREE_SLAB = registerBlock("dark_tree_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<PressurePlateBlock> DARK_TREE_PRESSURE_PLATE = registerBlock("dark_tree_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<ButtonBlock> DARK_TREE_BUTTON= registerBlock("dark_tree_button",
            () -> new ButtonBlock(BlockSetType.OAK, 20, BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().noCollission()));

    public static final DeferredBlock<FenceBlock> DARK_TREE_FENCE = registerBlock("dark_tree_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<FenceGateBlock> DARK_TREE_FENCE_GATE = registerBlock("dark_tree_fence_gate",
            () -> new FenceGateBlock(WoodType.OAK,  BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<DoorBlock> DARK_TREE_DOOR = registerBlock("dark_tree_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.of()
                    .strength(2f)
                    .requiresCorrectToolForDrops()
                    .isViewBlocking((state, level, pos) -> false)
                    .isSuffocating((state, level, pos) -> false)
                    .noOcclusion()
            ));

    public static final DeferredBlock<TrapDoorBlock> DARK_TREE_TRAPDOOR = registerBlock("dark_tree_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.of()
                    .strength(2f)
                    .requiresCorrectToolForDrops()
                    .isViewBlocking((state, level, pos) -> false)
                    .isSuffocating((state, level, pos) -> false)
                    .noOcclusion()
            ));

    public static final DeferredBlock<Block> TOMATO_CROP = BLOCKS.register("tomato_crop",
            () -> new TomatoCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT)));

   /* public static final DeferredBlock<SignBlock> DARK_TREE_SIGN= registerBlock("dark_tree_sign",
            () -> new SignBlock(WoodType.OAK,  BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().noCollission()) {
                @Override
                protected MapCodec<? extends SignBlock> codec() {
                    return null;
                }

                @Override
                public float getYRotationDegrees(BlockState state) {
                    return 0;
                }
            });*/
    public static final DeferredBlock<Block> BLUEBERRY_BUSH = BLOCKS.register("blueberry_bush",
           () -> new BlueBerryBushBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH)));

    public static final DeferredBlock<Block> ROCK_BLOCK = registerBlock("rock_block",
            () -> new RockBlock(BlockBehaviour.Properties.of()
                    .strength(0.5f, 1.0f)
                    .noCollission()));

    public static final DeferredBlock<Block> COCONUT_BLOCK = registerBlock("coconut_block",
            () -> new CoconutBlock(BlockBehaviour.Properties.of()
                    .strength(1.2f, 1.0f).sound(SoundType.BONE_BLOCK)));
    public static final DeferredBlock<Block> CRUSHED_COCONUT_BLOCK = registerBlock("crushed_coconut_block",
            () -> new CoconutBlock(BlockBehaviour.Properties.of()
                    .strength(1f, 0.7f).sound(SoundType.BONE_BLOCK)));
    public static final DeferredBlock<Block> DESTROYED_COCONUT_BLOCK = registerBlock("destroyed_coconut_block",
            () -> new CoconutBlock(BlockBehaviour.Properties.of()
                    .strength(0.7f, 0.5f).sound(SoundType.BONE_BLOCK)));

    public static final DeferredBlock<Block> SHELL_BLOCK = registerBlock("shell_block",
            () -> new ShellBlock(BlockBehaviour.Properties.of()
                    .strength(0.25f, 0.5f)
                    .noCollission()));


    public static final DeferredBlock<Block> CHISELED_BLUE_SANDSTONE = registerBlock("chiseled_blue_sandstone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));

    public static final DeferredBlock<StairBlock> CHISELED_BLUE_SANDSTONE_STAIRS = registerBlock("chiseled_blue_sandstone_stairs",
            () -> new StairBlock(ModBlocks.CHISELED_BLUE_SANDSTONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<StairBlock> CHISELED_SANDSTONE_STAIRS = registerBlock("chiseled_sandstone_stairs",
            () -> new StairBlock(Blocks.CHISELED_SANDSTONE.defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<StairBlock> CHISELED_RED_SANDSTONE_STAIRS = registerBlock("chiseled_red_sandstone_stairs",
            () -> new StairBlock(Blocks.CHISELED_RED_SANDSTONE.defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<StairBlock> CUT_SANDSTONE_STAIRS = registerBlock("cut_sandstone_stairs",
            () -> new StairBlock(Blocks.CUT_SANDSTONE.defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> LIBRARY_STATUE = registerBlock("library_statue",
            () -> new StatueBlock(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.NETHERITE_BLOCK)
                    .lightLevel(state -> 12)));
    public static final DeferredBlock<Block> ALCHEMIST_STATUE = registerBlock("alchemist_statue",
            () -> new StatueBlock(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.NETHERITE_BLOCK)
                    .lightLevel(state -> 12)));
    public static final DeferredBlock<Block> WARRIOR_STATUE = registerBlock("warrior_statue",
            () -> new StatueBlock(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.NETHERITE_BLOCK)
                    .lightLevel(state -> 12)));
    public static final DeferredBlock<Block> PRIEST_STATUE = registerBlock("priest_statue",
            () -> new StatueBlock(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.NETHERITE_BLOCK)
                    .lightLevel(state -> 12)));

    public static final DeferredBlock<Block> LIBRARY_PEDESTAL = registerBlock("library_pedestal",
            () -> new LibPedestal(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> ALCHEMIST_PEDESTAL = registerBlock("alchemist_pedestal",
            () -> new AlchPedestal(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> WARRIOR_PEDESTAL = registerBlock("warrior_pedestal",
            () -> new WarPedestal(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> PRIEST_PEDESTAL = registerBlock("priest_pedestal",
            () -> new PriPedestal(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));

    public static final DeferredBlock<Block> QUICKSAND = registerBlock("quicksand",
            () -> new QuickSandBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND)
                    .strength(0.25F).sound(SoundType.SAND).dynamicShape()
                    .isRedstoneConductor((state, world, pos) -> false)));

    public static final DeferredBlock<Block> PHARAOH_SEAT = registerBlock("pharaoh_seat",
            () -> new PharaohSeatBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block){
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
    private static boolean never(BlockState state, BlockGetter blockGetter, BlockPos pos) {
        return false;
    }
}
