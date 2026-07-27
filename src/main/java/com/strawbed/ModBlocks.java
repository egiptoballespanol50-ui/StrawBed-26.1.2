package com.strawbed;

import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.world.level.block.Block;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(StrawBedMod.MODID);

    public static final DeferredBlock<Block> STRAW_BED = BLOCKS.register("straw_bed", () -> new StrawBedBlock());
}
