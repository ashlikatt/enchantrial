package dev.ashli.enchantrial.mixin;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.trim.ArmorTrim;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import net.minecraft.nbt.NbtString;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

// TODO Remove this and find a non-mixin or library way to display the item's enchantability.
@Mixin(ItemStack.class)
public class EnchantableItemTooltipMixin<T> {
	@Inject(at = @At(value = "INVOKE",
			target = "Lnet/minecraft/item/trim/ArmorTrim;appendTooltip(Lnet/minecraft/item/ItemStack;Lnet/minecraft/registry/DynamicRegistryManager;Ljava/util/List;)V"),
			method = "getTooltip",
			locals = LocalCapture.CAPTURE_FAILHARD)
	private void init(PlayerEntity player, TooltipContext context, CallbackInfoReturnable<List<Text>> cir, List<Text> list, MutableText mutableText, int i) {
		ItemStack ths = (ItemStack)(Object)this;

		NbtList upgrades = ths.getOrCreateNbt().getList("enchantUpgrades", NbtCompound.STRING_TYPE);

		if (!upgrades.isEmpty()) {
			list.add(Text.translatable("item.enchantrial.smithing_template.enchant_upgrade.upgrade").formatted(Formatting.GRAY));
			MutableText text = ScreenTexts.space();
			for (int l = 0; l < upgrades.size(); l++) {
				if (l > 0) text.append(", ");
				text.append(Text.translatable("item.enchantrial.tooltip." + upgrades.get(l).asString()));
			}
			list.add(text.formatted(Formatting.DARK_AQUA));
		}
	}
}