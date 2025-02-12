package net.kirvvi.theforgottenexpance.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class TeleportWand extends Item {
    private boolean isUsed = false;

    public TeleportWand(Properties properties) {
        super(properties.stacksTo(1));
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        if (!level.isClientSide && context.getHand() == InteractionHand.MAIN_HAND) {
            Player player = context.getPlayer();
            if (player != null) {
                Vec3 position = Vec3.atCenterOf(context.getClickedPos())
                        .add(context.getClickedFace().getNormal().getX() * 0.5,
                                context.getClickedFace().getNormal().getY() * 0.5,
                                context.getClickedFace().getNormal().getZ() * 0.5);

                int cooldownTicks = 20;
                player.getCooldowns().addCooldown(this, cooldownTicks);

                isUsed = true;

                player.teleportTo(position.x, position.y, position.z);

                level.playSound(null, player.getX(), player.getY(), player.getZ(),
                        SoundEvents.ENDERMAN_TELEPORT, player.getSoundSource(), 1.0F, 1.0F);

                // Эффект телепортации
                for (int i = 0; i < 32; ++i) {
                    level.addParticle(net.minecraft.core.particles.ParticleTypes.PORTAL,
                            player.getX(), player.getY() + level.random.nextDouble() * 2.0D, player.getZ(),
                            level.random.nextGaussian(), 0.0D, level.random.nextGaussian());
                }

                level.getServer().submitAsync(() -> {
                    try {
                        Thread.sleep(cooldownTicks * 50L);
                    } catch (InterruptedException ignored) {
                    }
                    resetUsed();
                });

                return InteractionResult.SUCCESS;
            }
        }

        return InteractionResult.FAIL;
    }


    public boolean isUsed() {
        return isUsed;
    }

    public void resetUsed() {
        this.isUsed = false;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.theforgottenexpance.teleport_wand.tooltip"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
