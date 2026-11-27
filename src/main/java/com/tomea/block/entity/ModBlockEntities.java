package com.tomea.block.entity;

import com.tomea.TomeaSWine;
import com.tomea.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class ModBlockEntities {
    public static final BlockEntityType<BeerCrateBlockEntity> BEER_CRATE_BE =
            Registry.register(
                    BuiltInRegistries.BLOCK_ENTITY_TYPE,
                    TomeaSWine.id("beer_crate_be"),
                    FabricBlockEntityTypeBuilder.create(BeerCrateBlockEntity::new, ModBlocks.BEER_CRATE).build()
            );

    public static void initialize() {
        TomeaSWine.LOGGER.info("Registering Block Entities for " + TomeaSWine.MOD_ID);
    }
}
