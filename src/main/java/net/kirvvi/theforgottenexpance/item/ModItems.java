package net.kirvvi.theforgottenexpance.item;

import net.kirvvi.theforgottenexpance.TheForgottenExpance;
import net.kirvvi.theforgottenexpance.block.ModBlocks;
import net.kirvvi.theforgottenexpance.entity.ModEntities;
import net.kirvvi.theforgottenexpance.item.custom.*;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.*;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TheForgottenExpance.MODID);

    public static final DeferredItem<Item> ADAMANTIUM = ITEMS.register("adamantium",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> QUARTZ_STICK = ITEMS.register("quartz_stick",
            () -> new Item(new Item.Properties().stacksTo(32)));
    public static final DeferredItem<Item> QUARTZ_LEATHER_STICK = ITEMS.register("quartz_leather_stick",
            () -> new Item(new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> RUBBER = ITEMS.register("rubber",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_RUBBER = ITEMS.register("raw_rubber",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ADAMANTIUM_NETHERITE_CLUSTER = ITEMS.register("adamantium_netherite_cluster",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TELEPORT_WAND = ITEMS.register("teleport_wand",
            () -> new TeleportWand(new Item.Properties().durability(256)));
    public static final DeferredItem<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties().durability(48)));
    public static final DeferredItem<Item> TOMATO = ITEMS.register("tomato",
            () -> new Item(new Item.Properties().food(ModFoodProperties.TOMATO)));
    public static final DeferredItem<Item> FLAMECOAL = ITEMS.register("flamecoal",
            () -> new FlameCoal(new Item.Properties(), 20000) {
                @Override
                public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.theforgottenexpance.flamecoal.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> SHADOWMARE = ITEMS.register("shadowmare",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<WitherArrowItem> WITHER_ARROW = ITEMS.register("wither_arrow",
            () -> new WitherArrowItem(new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> SHADOWMARE_BOW = ITEMS.register("shadowmare_bow",
            () -> new ShadowmareBow(new Item.Properties().durability(500)){
                @Override
                public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.theforgottenexpance.shadowmare_bow"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);}});
    public static final DeferredItem<Item> TOMATO_SEEDS = ITEMS.register("tomato_seeds",
            () -> new ItemNameBlockItem(ModBlocks.TOMATO_CROP.get(), new Item.Properties()));
    public static final DeferredItem<Item> BLUEBERRY = ITEMS.register("blueberry",
            () -> new ItemNameBlockItem(ModBlocks.BLUEBERRY_BUSH.get(), new Item.Properties().food(ModFoodProperties.BLUEBERRY)));
    public static final DeferredItem<SwordItem> ADAMANTIUM_SWORD = ITEMS.register("adamantium_sword",
            () -> new SwordItem(ModToolTiers.ADAMANTIUM, new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.ADAMANTIUM, 4, -2.4F))));
    public static final DeferredItem<SwordItem> ADAMANTIUM_NETHERITE_SWORD = ITEMS.register("adamantium_netherite_sword",
            () -> new SwordItem(ModToolTiers.ADAMANTIUM_NETHERITE, new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.ADAMANTIUM_NETHERITE, 5, -2.4F))));

    public static final DeferredItem<PickaxeItem> ADAMANTIUM_PICKAXE = ITEMS.register("adamantium_pickaxe",
            () -> new PickaxeItem(ModToolTiers.ADAMANTIUM, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.ADAMANTIUM, 4.0F, -2.8F))));
    public static final DeferredItem<PickaxeItem> ADAMANTIUM_NETHERITE_PICKAXE = ITEMS.register("adamantium_netherite_pickaxe",
            () -> new PickaxeItem(ModToolTiers.ADAMANTIUM_NETHERITE, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.ADAMANTIUM_NETHERITE, 4, -2.8F))));

    public static final DeferredItem<ShovelItem> ADAMANTIUM_SHOVEL = ITEMS.register("adamantium_shovel",
            () -> new ShovelItem(ModToolTiers.ADAMANTIUM, new Item.Properties().attributes(ShovelItem.createAttributes(ModToolTiers.ADAMANTIUM, 1.5F, -3f))));
    public static final DeferredItem<ShovelItem> ADAMANTIUM_NETHERITE_SHOVEL = ITEMS.register("adamantium_netherite_shovel",
            () -> new ShovelItem(ModToolTiers.ADAMANTIUM_NETHERITE, new Item.Properties().attributes(ShovelItem.createAttributes(ModToolTiers.ADAMANTIUM_NETHERITE, 0.5F, -3.0F))));

    public static final DeferredItem<AxeItem> ADAMANTIUM_AXE = ITEMS.register("adamantium_axe",
            () -> new AxeItem(ModToolTiers.ADAMANTIUM, new Item.Properties().attributes(AxeItem.createAttributes(ModToolTiers.ADAMANTIUM, 6.0F, -3.1F))));
    public static final DeferredItem<AxeItem> ADAMANTIUM_NETHERITE_AXE = ITEMS.register("adamantium_netherite_axe",
            () -> new AxeItem(ModToolTiers.ADAMANTIUM_NETHERITE, new Item.Properties().attributes(AxeItem.createAttributes(ModToolTiers.ADAMANTIUM_NETHERITE, 7F, -3.1F))));

    public static final DeferredItem<HoeItem> ADAMANTIUM_HOE = ITEMS.register("adamantium_hoe",
            () -> new HoeItem(ModToolTiers.ADAMANTIUM, new Item.Properties().attributes(HoeItem.createAttributes(ModToolTiers.ADAMANTIUM, -2.0F, -1.0F))));
    public static final DeferredItem<HoeItem> ADAMANTIUM_NETHERITE_HOE = ITEMS.register("adamantium_netherite_hoe",
            () -> new HoeItem(ModToolTiers.ADAMANTIUM_NETHERITE, new Item.Properties().attributes(HoeItem.createAttributes(ModToolTiers.ADAMANTIUM_NETHERITE, -2.0F, -1.0F))));

    public static final DeferredItem<PaxelItem> ADAMANTIUM_PAXEL = ITEMS.register("adamantium_paxel",
            () -> new PaxelItem(ModToolTiers.ADAMANTIUM, new Item.Properties().attributes(PaxelItem.createAttributes(ModToolTiers.ADAMANTIUM, 5.0F, -3.0F))));
    public static final DeferredItem<PaxelItem> ADAMANTIUM_NETHERITE_PAXEL = ITEMS.register("adamantium_netherite_paxel",
            () -> new PaxelItem(ModToolTiers.ADAMANTIUM_NETHERITE, new Item.Properties().attributes(PaxelItem.createAttributes(ModToolTiers.ADAMANTIUM_NETHERITE, 6.0F, -3.0F))));

    public static final DeferredItem<HammerItem> ADAMANTIUM_HAMMER = ITEMS.register("adamantium_hammer",
            () -> new HammerItem(ModToolTiers.ADAMANTIUM, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.ADAMANTIUM, 5.0F, -3.5F))));
    public static final DeferredItem<HammerItem> ADAMANTIUM_NETHERITE_HAMMER = ITEMS.register("adamantium_netherite_hammer",
            () -> new HammerItem(ModToolTiers.ADAMANTIUM_NETHERITE, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.ADAMANTIUM_NETHERITE, 5, -3.5F))));

    public static final DeferredItem<ArmorItem> ADAMANTIUM_HELMET = ITEMS.register("adamantium_helmet",
            () -> new ModArmorItem(ModArmorMaterials.ADAMANTIUM_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(35))) {
                @Override
                public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.theforgottenexpance.adamantium_helmet"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<ArmorItem> ADAMANTIUM_NETHERITE_HELMET = ITEMS.register("adamantium_netherite_helmet",
            () -> new ModArmorItem(ModArmorMaterials.ADAMANTIUM_NETHERITE_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(52))) {
                @Override
                public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.theforgottenexpance.adamantium_netherite_helmet"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<ArmorItem> ADAMANTIUM_CHESTPLATE = ITEMS.register("adamantium_chestplate",
            () -> new ModArmorItem(ModArmorMaterials.ADAMANTIUM_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(35))) {
                @Override
                public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.theforgottenexpance.adamantium_chestplate"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);}});
    public static final DeferredItem<ArmorItem> ADAMANTIUM_NETHERITE_CHESTPLATE = ITEMS.register("adamantium_netherite_chestplate",
            () -> new ModArmorItem(ModArmorMaterials.ADAMANTIUM_NETHERITE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(52))) {
                @Override
                public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.theforgottenexpance.adamantium_netherite_chestplate"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);}});

    public static final DeferredItem<ArmorItem> ADAMANTIUM_LEGGINGS = ITEMS.register("adamantium_leggings",
            () -> new ModArmorItem(ModArmorMaterials.ADAMANTIUM_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(35))) {
                @Override
                public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.theforgottenexpance.adamantium_leggings"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);}});
    public static final DeferredItem<ArmorItem> ADAMANTIUM_NETHERITE_LEGGINGS = ITEMS.register("adamantium_netherite_leggings",
            () -> new ModArmorItem(ModArmorMaterials.ADAMANTIUM_NETHERITE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(52))) {
                @Override
                public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.theforgottenexpance.adamantium_netherite_leggings"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);}});

    public static final DeferredItem<ArmorItem> ADAMANTIUM_BOOTS = ITEMS.register("adamantium_boots",
            () -> new ModArmorItem(ModArmorMaterials.ADAMANTIUM_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(35))) {
                @Override
                public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.theforgottenexpance.adamantium_boots"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);}});
    public static final DeferredItem<ArmorItem> ADAMANTIUM_NETHERITE_BOOTS = ITEMS.register("adamantium_netherite_boots",
            () -> new ModArmorItem(ModArmorMaterials.ADAMANTIUM_NETHERITE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(52))) {
                @Override
                public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.theforgottenexpance.adamantium_netherite_boots"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);}});

    public static final DeferredItem<Item> SHADOWMANE_SMITHING_TEMPLATE = ITEMS.register("shadowmane_armor_trim_smithing_template",
            () ->  SmithingTemplateItem.createArmorTrimTemplate(ResourceLocation.fromNamespaceAndPath(TheForgottenExpance.MODID, "shadowmane")));

    public static final DeferredItem<Item> GECKO_SPAWN_EGG = ITEMS.register("gecko_spawn_egg",
            () ->  new DeferredSpawnEggItem(ModEntities.GECKO, 0x31afaf, 0xffac00,
                    new Item.Properties()));
    public static final DeferredItem<Item> MUMMY_SPAWN_EGG = ITEMS.register("mummy_spawn_egg",
            () ->  new DeferredSpawnEggItem(ModEntities.MUMMY, 0xC2B280, 0xA78C5F,
                    new Item.Properties()));
    public static final DeferredItem<Item> PORCUPINE_SPAWN_EGG = ITEMS.register("porcupine_spawn_egg",
            () ->  new DeferredSpawnEggItem(ModEntities.PORCUPINE, 0x5D4631, 0xF2E6D0,
                    new Item.Properties()));

    public static final DeferredItem<Item> ROCK = ITEMS.register("rock",
            () -> new RockItem(new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> COCONUT = ITEMS.register("coconut",
            () -> new CoconutItem(new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> CRUSHED_COCONUT = ITEMS.register("crushed_coconut",
            () -> new CrushedCoconutItem(new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> DESTROYED_COCONUT = ITEMS.register("destroyed_coconut",
            () -> new DestroyedCoconutItem(new Item.Properties().stacksTo(16)));

    public static final DeferredItem<Item> COCONUT_OPENED = ITEMS.register("coconut_opened",
            () -> new CoconutFoodItem(new Item.Properties().food(ModFoodProperties.COCONUT_OPENED)));
    public static final DeferredItem<Item> COCONUT_OPENED_CLEAN = ITEMS.register("coconut_opened_clean",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> COCONUT_PART = ITEMS.register("coconut_part",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SHELL = ITEMS.register("shell",
            () -> new BlockItem(ModBlocks.SHELL_BLOCK.get(), new Item.Properties()));

    public static final DeferredItem<Item> LIBRARY_STATUEI = ITEMS.register("library_statuei",
            () -> new BlockItem(ModBlocks.LIBRARY_STATUE.get(), new Item.Properties()));
    public static final DeferredItem<Item> ALCHEMIST_STATUEI = ITEMS.register("alchemist_statuei",
            () -> new BlockItem(ModBlocks.ALCHEMIST_STATUE.get(), new Item.Properties()));
    public static final DeferredItem<Item> WARRIOR_STATUEI = ITEMS.register("warrior_statuei",
            () -> new BlockItem(ModBlocks.WARRIOR_STATUE.get(), new Item.Properties()));
    public static final DeferredItem<Item> PRIEST_STATUEI = ITEMS.register("priest_statuei",
            () -> new BlockItem(ModBlocks.PRIEST_STATUE.get(), new Item.Properties()));

    public static final DeferredItem<Item> QUICKSAND_BUCKET = ITEMS.register("quicksand_bucket",
            () ->  new SolidBucketItem(ModBlocks.QUICKSAND.get(), SoundEvents.SUSPICIOUS_SAND_PLACE, new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> MUMMY_BANDAGE = ITEMS.register("mummy_bandage",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
