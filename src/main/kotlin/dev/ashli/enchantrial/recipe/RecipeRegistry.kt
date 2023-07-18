package dev.ashli.enchantrial.recipe

import dev.ashli.enchantrial.recipe.smithing.SmithingEnchantSerializer
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry

object RecipeRegistry {
    init {
        Registry.register(Registries.RECIPE_SERIALIZER, SmithingEnchantSerializer.ID, SmithingEnchantSerializer)
    }
}
