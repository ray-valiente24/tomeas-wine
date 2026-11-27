package com.tomea.mixin;

import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PotionContents.class)
public class ExampleMixin {

	@Inject(method = "onConsume", at = @At("HEAD"))
	private void broadcastDrunkenMessage(Level level, LivingEntity user, ItemStack stack, Consumable consumable, CallbackInfo ci) {
		if (!level.isClientSide() && user instanceof ServerPlayer player) {
			PotionContents contents = stack.get(DataComponents.POTION_CONTENTS);

			if (contents != null && contents.potion().isPresent()) {
				var potionKey = contents.potion().get().unwrapKey();

				if (potionKey.isPresent() && potionKey.get().identifier().getNamespace().equals("tomeas-wine")) {
					Component liquorName = stack.getHoverName();

					Component message = Component.literal("")
							.append(player.getDisplayName())
							.append(" got drunken by ")
							.append(liquorName);

					player.level().getServer().getPlayerList().broadcastSystemMessage(message, false);
				}
			}
		}
	}
}
