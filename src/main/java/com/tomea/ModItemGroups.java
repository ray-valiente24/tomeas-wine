package com.tomea;

import com.tomea.block.ModBlocks;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;

public class ModItemGroups {
    public static final CreativeModeTab TOMEAS_WINE_TAB = Registry.register(
            BuiltInRegistries.CREATIVE_MODE_TAB,
            TomeaSWine.id("tomeas_wine_tab"),
            FabricCreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.tomeas-wine.tomeas_wine_tab"))
                    .icon(() -> PotionContents.createItemStack(Items.POTION, ModPotions.WINE))
                    .displayItems((context, entries) -> {

                        entries.accept(ModBlocks.BEER_CRATE);

                        entries.accept(PotionContents.createItemStack(Items.POTION, ModPotions.WINE));
                        entries.accept(PotionContents.createItemStack(Items.POTION, ModPotions.BEER));
                        entries.accept(PotionContents.createItemStack(Items.POTION, ModPotions.WHISKEY));
                        entries.accept(PotionContents.createItemStack(Items.POTION, ModPotions.BRANDY));
                        entries.accept(PotionContents.createItemStack(Items.POTION, ModPotions.VODKA));

                        entries.accept(PotionContents.createItemStack(Items.SPLASH_POTION, ModPotions.WINE));
                        entries.accept(PotionContents.createItemStack(Items.SPLASH_POTION, ModPotions.BEER));
                        entries.accept(PotionContents.createItemStack(Items.SPLASH_POTION, ModPotions.WHISKEY));
                        entries.accept(PotionContents.createItemStack(Items.SPLASH_POTION, ModPotions.BRANDY));
                        entries.accept(PotionContents.createItemStack(Items.SPLASH_POTION, ModPotions.VODKA));
                    })

                    .build()
    );

    public static void initialize() {
        TomeaSWine.LOGGER.info("Registering Creative Tabs for " + TomeaSWine.MOD_ID);
    }
}