package dev.ashli.enchantrial.item

import dev.ashli.enchantrial.Enchantrial
import dev.ashli.enchantrial.item.impl.*
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemGroups
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.util.Identifier

/**
 * Handle the registration of items.
 */
object ItemRegistry {
    val AMETHYST_UPGRADE =
        register("amethyst_upgrade", ItemGroups.INGREDIENTS, AmethystUpgradeItem())
    val BLAZE_UPGRADE =
        register("blaze_upgrade", ItemGroups.INGREDIENTS, BlazeUpgradeItem())
    val PURPUR_UPGRADE =
        register("purpur_upgrade", ItemGroups.INGREDIENTS, PurpurUpgradeItem())
    val PRISMARINE_UPGRADE =
        register("prismarine_upgrade", ItemGroups.INGREDIENTS, PrismarineUpgradeItem())
    val SCULK_UPGRADE =
        register("sculk_upgrade", ItemGroups.INGREDIENTS, SculkUpgradeItem())

    /**
     * Helper function for registering simple items in a concise format
     */
    private fun register(name: String, category: RegistryKey<ItemGroup>, item: Item): Item {
        Registry.register(Registries.ITEM, Identifier(Enchantrial.MODID, name), item)
        ItemGroupEvents.modifyEntriesEvent(category).register {
            it.add(item)
        }
        return item
    }
}
