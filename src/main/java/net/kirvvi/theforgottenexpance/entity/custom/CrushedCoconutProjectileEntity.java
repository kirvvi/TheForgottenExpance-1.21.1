package net.kirvvi.theforgottenexpance.entity.custom;

import net.kirvvi.theforgottenexpance.block.ModBlocks;
import net.kirvvi.theforgottenexpance.entity.ModEntities;
import net.kirvvi.theforgottenexpance.item.ModItems;
import net.kirvvi.theforgottenexpance.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

public class CrushedCoconutProjectileEntity extends AbstractArrow {

    public CrushedCoconutProjectileEntity(EntityType<? extends AbstractArrow> entityType, Level level) {
        super(entityType, level);
    }

    public CrushedCoconutProjectileEntity(LivingEntity shooter, Level level) {
        super(ModEntities.CRUSHED_COCONUT.get(), shooter, level, new ItemStack(ModItems.CRUSHED_COCONUT.get()), null);
    }

    @Override
    protected ItemStack getDefaultPickupItem() {
        return new ItemStack(ModItems.CRUSHED_COCONUT.get());
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        Entity entity = result.getEntity();
        entity.hurt(this.damageSources().thrown(this, this.getOwner()), 4);

        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte) 3);
            this.discard();
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        if (!this.level().isClientSide) {
            BlockPos hitPos = result.getBlockPos();
            Direction hitFace = result.getDirection();
            BlockPos placePos = hitPos.relative(hitFace);

            this.level().levelEvent(2001, this.blockPosition(), Block.getId(Blocks.WHITE_CONCRETE.defaultBlockState()));

            double speedFactor = 1.0 / 3.0;
            boolean isDropable = this.level().getBlockState(hitPos).is(ModTags.Blocks.DROPABLE);

            if (isDropable) {
                double dx = this.getDeltaMovement().x;
                double dy = this.getDeltaMovement().y;
                double dz = this.getDeltaMovement().z;

                switch (hitFace) {
                    case EAST, WEST -> dx = -dx * speedFactor;
                    case UP, DOWN -> dy = -dy * speedFactor;
                    case NORTH, SOUTH -> dz = -dz * speedFactor;
                }

                this.setDeltaMovement(dx, dy, dz);
                this.hasImpulse = true;
            } else {
                if (this.level().getBlockState(placePos.below()).isAir()) {
                    this.setDeltaMovement(0, -0.1, 0);
                    this.hasImpulse = true;
                } else {
                    double chance = this.random.nextDouble();
                    if (chance < 0.8) {
                        this.level().setBlock(placePos, ModBlocks.DESTROYED_COCONUT_BLOCK.get()
                                .defaultBlockState(), 3);
                        this.spawnAtLocation(ModItems.COCONUT_PART.get());
                    } else if (chance < 0.9) {
                        this.level().setBlock(placePos, ModBlocks.CRUSHED_COCONUT_BLOCK.get()
                                .defaultBlockState(), 3);
                    } else {
                        this.spawnAtLocation(ModItems.COCONUT_OPENED.get());
                        this.spawnAtLocation(ModItems.COCONUT_OPENED.get());
                    }

                    this.level().playSound(null, placePos, SoundEvents.WOOD_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
                    this.discard();
                }
            }
        }
    }
}
