package dev.ashli.enchantrial.recipe.smithing

import net.minecraft.inventory.Inventory
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.nbt.NbtCompound
import net.minecraft.nbt.NbtString
import net.minecraft.recipe.*
import net.minecraft.registry.DynamicRegistryManager
import net.minecraft.util.Identifier
import net.minecraft.world.World

/**
 * Handles enchant upgrades.
 */
class SmithingEnchantRecipe(
    private val id: Identifier,
    val template: Ingredient,
    val base: Ingredient,
    val name: String
) : SmithingRecipe {
    override fun matches(inventory: Inventory, world: World): Boolean {
        return testTemplate(inventory.getStack(0)) &&
                testBase(inventory.getStack(1)) &&
                testAddition(inventory.getStack(2))
    }

    override fun craft(inventory: Inventory, registryManager: DynamicRegistryManager): ItemStack {
        // Copy the enchantable item
        val output = inventory.getStack(1).copy()

        // Does it have nbt?
        val nbtCompound = output.nbt
        if (nbtCompound != null) {
            val str = NbtString.of(name) // The NBT string that marks this upgrade as having been applied

            // Copy the nbt and check its enchantUpgrades
            val newNBT = nbtCompound.copy()
            val list = newNBT.getList("enchantUpgrades", NbtCompound.STRING_TYPE.toInt())

            // If it already has this upgrade, return an empty itemstack
            if (list.contains(str)) return ItemStack.EMPTY

            // Add this upgrade to the new item's nbt
            list.add(str)
            newNBT.put("enchantUpgrades", list)
            output.nbt = newNBT
        }

        return output
    }

    override fun getOutput(registryManager: DynamicRegistryManager?): ItemStack {
        return ItemStack(Items.IRON_CHESTPLATE) // Test
    }

    override fun getId() = id

    override fun testTemplate(stack: ItemStack) = template.test(stack)
    override fun testBase(stack: ItemStack) = base.test(stack)
    override fun testAddition(stack: ItemStack) = stack.isEmpty

    override fun getSerializer() = SmithingEnchantSerializer
}