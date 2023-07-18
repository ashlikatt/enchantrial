package dev.ashli.enchantrial

import dev.ashli.enchantrial.item.ItemRegistry
import dev.ashli.enchantrial.recipe.RecipeRegistry
import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory

/**
 * Main mod
 */
object Enchantrial : ModInitializer {
	val MODID = "enchantrial"
    val LOGGER = LoggerFactory.getLogger("enchantrial")

	override fun onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		LOGGER.info("Hello Fabric world!")

		ItemRegistry // Register items
		RecipeRegistry // Register
	}
}