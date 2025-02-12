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
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

public class RockProjectileEntity extends AbstractArrow {
    private float rotation;

    public RockProjectileEntity(EntityType<? extends AbstractArrow> entityType, Level level) {
        super(entityType, level);
    }

    public RockProjectileEntity(LivingEntity shooter, Level level) {
        super(ModEntities.ROCK.get(), shooter, level, new ItemStack(ModItems.ROCK.get()), null);
    }

    @Override
    protected ItemStack getDefaultPickupItem() {
        return new ItemStack(ModItems.ROCK.get());
    }

    public float getRenderingRotation() {
        rotation += 15.0f;
        if (rotation >= 360) {
            rotation = 0;
        }
        return rotation;
    }

    public boolean isGrounded() {
        return inGround;
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        Entity entity = result.getEntity();
        entity.hurt(this.damageSources().thrown(this, this.getOwner()), 2);

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

            double speedFactor = 1.0 / 3.0;
            boolean isDropable = this.level().getBlockState(hitPos).is(ModTags.Blocks.DROPABLE);

            if (isDropable) {
                double dx = this.getDeltaMovement().x;
                double dy = this.getDeltaMovement().y;
                double dz = this.getDeltaMovement().z;

                switch (hitFace) {
                    case EAST:
                    case WEST:
                        dx = -dx * speedFactor;
                        break;
                    case UP:
                    case DOWN:
                        dy = -dy * speedFactor;
                        break;
                    case NORTH:
                    case SOUTH:
                        dz = -dz * speedFactor;
                        break;
                }
                this.setDeltaMovement(dx, dy, dz);
                this.hasImpulse = true;
            } else {
                if (this.level().getBlockState(placePos.below()).isAir()) {
                    this.setDeltaMovement(0, -0.1, 0);
                    this.hasImpulse = true;
                } else {
                    boolean canPlaceBlock = this.level().getBlockState(placePos).canBeReplaced();
                    if (canPlaceBlock) {
                        Direction[] horizontalDirections = {Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST};
                        Direction randomDirection = horizontalDirections[this.level().random.nextInt(horizontalDirections.length)];

                        this.level().setBlock(placePos, ModBlocks.ROCK_BLOCK.get()
                                .defaultBlockState()
                                .setValue(BlockStateProperties.HORIZONTAL_FACING, randomDirection), 3);

                        this.level().playSound(null, placePos, SoundEvents.STONE_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
                    } else {
                        this.spawnAtLocation(ModItems.ROCK.get());
                    }
                    this.discard();
                }
            }
        }
    }

}
