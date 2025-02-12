package net.kirvvi.theforgottenexpance.util;

import net.kirvvi.theforgottenexpance.TheForgottenExpance;
import net.kirvvi.theforgottenexpance.item.ModItems;
import net.kirvvi.theforgottenexpance.item.custom.FlameCoal;
import net.kirvvi.theforgottenexpance.item.custom.TeleportWand;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class ModItemProperties {
    public static void addCustomItemProperties() {
        ItemProperties.register(
                ModItems.TELEPORT_WAND.get(),
                ResourceLocation.fromNamespaceAndPath(TheForgottenExpance.MODID, "used"),
                (stack, level, entity, seed) -> {
                    if (stack.getItem() instanceof TeleportWand wand) {
                        return wand.isUsed() ? 1.0F : 0.0F;}
                    return 0.0F;});
        ItemProperties.register(
                ModItems.FLAMECOAL.get(),
                ResourceLocation.fromNamespaceAndPath(TheForgottenExpance.MODID, "cycle_state"),
                (stack, level, entity, seed) -> {
                    if (level != null && stack.getItem() instanceof FlameCoal flameCoal) {
                        long worldTime = level.getGameTime();
                        return flameCoal.getCycleState(stack, worldTime);}
                    return 0.0F;});
        makeCustomBow(ModItems.SHADOWMARE_BOW.get());
    }
    public static void makeCustomBow(Item item) {
        ItemProperties.register(item, ResourceLocation.withDefaultNamespace("pull"), (p_344163_, p_344164_, p_344165_, p_344166_) -> {
            if (p_344165_ == null) {
                return 0.0F;
            } else {
                return p_344165_.getUseItem() != p_344163_ ? 0.0F :
                        (float) (p_344163_.getUseDuration(p_344165_) - p_344165_.getUseItemRemainingTicks()) / (20.0F / 1.5F);
            }
        });

        ItemProperties.register(
                item,
                ResourceLocation.withDefaultNamespace("pulling"),
                (p_174630_, p_174631_, p_174632_, p_174633_) -> p_174632_ != null && p_174632_.isUsingItem() && p_174632_.getUseItem() == p_174630_ ? 1.0F : 0.0F
        );
    }
}
