package com.tomea;

import net.fabricmc.fabric.api.registry.FabricPotionBrewingBuilder;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;

public class ModPotions {
    public static final Holder<Potion> WINE = Registry.registerForHolder(
            BuiltInRegistries.POTION,
            TomeaSWine.id("wine"),
            new Potion("wine",
                    new MobEffectInstance(MobEffects.REGENERATION, 250, 1),
                    new MobEffectInstance(MobEffects.NAUSEA, 250, 0)
            )
    );

    public static final Holder<Potion> BEER = Registry.registerForHolder(
            BuiltInRegistries.POTION,
            TomeaSWine.id("beer"),
            new Potion("beer",
                    new MobEffectInstance(MobEffects.STRENGTH, 200, 1),
                    new MobEffectInstance(MobEffects.NAUSEA, 200, 0)
            )
    );

    public static final Holder<Potion> WHISKEY = Registry.registerForHolder(
            BuiltInRegistries.POTION,
            TomeaSWine.id("whiskey"),
            new Potion("whiskey",
                    new MobEffectInstance(MobEffects.STRENGTH, 400, 1),
                    new MobEffectInstance(MobEffects.NAUSEA, 300, 1),
                    new MobEffectInstance(MobEffects.RESISTANCE, 300, 1)
            )
    );

    public static final Holder<Potion> BRANDY = Registry.registerForHolder(
            BuiltInRegistries.POTION,
            TomeaSWine.id("brandy"),
            new Potion("brandy",
                    new MobEffectInstance(MobEffects.REGENERATION, 400, 1),
                    new MobEffectInstance(MobEffects.SPEED, 400, 1),
                    new MobEffectInstance(MobEffects.NAUSEA, 301, 1)
            )
    );

    public static final Holder<Potion> VODKA = Registry.registerForHolder(
            BuiltInRegistries.POTION,
            TomeaSWine.id("vodka"),
            new Potion("vodka",
                    new MobEffectInstance(MobEffects.STRENGTH, 300, 2),
                    new MobEffectInstance(MobEffects.SPEED, 300, 1),
                    new MobEffectInstance(MobEffects.NAUSEA, 400, 1)
            )
    );

    public static void initialize() {
        FabricPotionBrewingBuilder.BUILD.register(builder -> {
            // Wine Recipe: Water Bottle + Sweet Berries
            builder.registerPotionRecipe(Potions.WATER, Ingredient.of(Items.SWEET_BERRIES), WINE);

            // Beer Recipe: Water Bottle + Wheat
            builder.registerPotionRecipe(Potions.WATER, Ingredient.of(Items.WHEAT), BEER);

            // Whiskey Recipe = Beer + Sugar
            builder.registerPotionRecipe(BEER, Ingredient.of(Items.SUGAR), WHISKEY);

            // Brandy = Wine + Sugar
            builder.registerPotionRecipe(WINE, Ingredient.of(Items.SUGAR), BRANDY);

            // Vodka = Water + Poisonous Potato
            builder.registerPotionRecipe(Potions.WATER, Ingredient.of(Items.POISONOUS_POTATO), VODKA);
        });
    }
}
