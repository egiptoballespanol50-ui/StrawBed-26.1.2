package com.strawbed;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = 
        DeferredRegister.create(net.minecraft.core.registries.Registries.BLOCK_ENTITY_TYPE, StrawBedMod.MODID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<StrawBedEntity>> STRAW_BED_ENTITY =
        BLOCK_ENTITIES.register("straw_bed",
            () -> BlockEntityType.Builder.of(StrawBedEntity::new, ModBlocks.STRAW_BED.get()).build(null));
}
