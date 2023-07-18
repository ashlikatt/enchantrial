package dev.ashli.enchantrial.item.impl

import dev.ashli.enchantrial.itemKey
import net.minecraft.item.SmithingTemplateItem
import net.minecraft.text.MutableText
import net.minecraft.util.Formatting
import net.minecraft.util.Identifier


val TITLE_FORMATTING = Formatting.GRAY
val DESCRIPTION_FORMATTING = Formatting.BLUE;

/**
 * An item that may be used to add an enchantability point to items
 */
open class EnchantUpgradeItem(title: MutableText) : SmithingTemplateItem(
    itemKey("smithing_template.enchant_upgrade.applies_to").formatted(DESCRIPTION_FORMATTING), // Applies to
    itemKey("smithing_template.enchant_upgrade.ingredients").formatted(DESCRIPTION_FORMATTING), // Ingredients
    title.formatted(TITLE_FORMATTING), // Title
    itemKey("smithing_template.enchant_upgrade.base_slot_description"), // Base Slot Description
    itemKey("smithing_template.enchant_upgrade.additions_slot_description"), // Additions Slot Description
    listOf(
        Identifier("item/empty_armor_slot_helmet"),
        Identifier("item/empty_armor_slot_chestplate"),
        Identifier("item/empty_armor_slot_leggings"),
        Identifier("item/empty_armor_slot_boots"),
        Identifier("item/empty_slot_hoe"),
        Identifier("item/empty_slot_axe"),
        Identifier("item/empty_slot_sword"),
        Identifier("item/empty_slot_shovel"),
        Identifier("item/empty_slot_pickaxe")
    ), // Empty Base Slot Texture
    emptyList() // Empty Additions Slot Texture (None)
)

