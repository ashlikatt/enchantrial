package dev.ashli.enchantrial

import net.minecraft.text.MutableText
import net.minecraft.text.Text

/**
 * Create an upgrade resource key for this mod.
 */
fun upgradeKey(key: String): MutableText =
    Text.translatable("upgrade.${Enchantrial.MODID}.$key")

/**
 * Create an item resource key for this mod.
 */
fun itemKey(key: String): MutableText =
    Text.translatable("item.${Enchantrial.MODID}.$key")