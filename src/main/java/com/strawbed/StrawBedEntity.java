package com.strawbed;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class StrawBedEntity extends BlockEntity {
    private static final String SLEPT_KEY = "HasBeenSlept";
    private boolean hasBeenSlept = false;
    private int sleepTicks = 0;

    public StrawBedEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.STRAW_BED_ENTITY.get(), pos, blockState);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, StrawBedEntity entity) {
        if (level.isClientSide) return;

        // Check if any players are sleeping on this bed
        for (Player player : level.players()) {
            if (player.isSleeping() && player.getSleepingPos().isPresent()) {
                BlockPos sleepPos = player.getSleepingPos().get();
                // Account for the fact that beds have a head and foot
                if (sleepPos.equals(pos) || sleepPos.equals(pos.relative(state.getValue(BlockStateProperties.HORIZONTAL_FACING)))) {
                    entity.hasBeenSlept = true;
                    entity.sleepTicks++;
                }
            }
        }

        // If the player wakes up from the bed and the bed was slept on, break it
        if (entity.hasBeenSlept && entity.sleepTicks > 100 && level.getBlockState(pos).getBlock() instanceof StrawBedBlock) {
            level.destroyBlock(pos, false);
            entity.hasBeenSlept = false;
            entity.sleepTicks = 0;
        }
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.hasBeenSlept = tag.getBoolean(SLEPT_KEY);
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putBoolean(SLEPT_KEY, this.hasBeenSlept);
    }
}
