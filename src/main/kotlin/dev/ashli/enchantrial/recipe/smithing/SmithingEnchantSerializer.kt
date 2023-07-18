package dev.ashli.enchantrial.recipe.smithing

import com.google.gson.JsonObject
import net.minecraft.network.PacketByteBuf
import net.minecraft.recipe.Ingredient
import net.minecraft.recipe.RecipeSerializer
import net.minecraft.util.Identifier
import net.minecraft.util.JsonHelper

/**
 * Serializes and deserializes enchantment upgrades for network or storage.
 */
object SmithingEnchantSerializer : RecipeSerializer<SmithingEnchantRecipe> {
    val ID = Identifier("smithing_enchant_upgrade")

    override fun read(identifier: Identifier, jsonObject: JsonObject): SmithingEnchantRecipe {
        val template = Ingredient.fromJson(JsonHelper.getElement(jsonObject, "template"))
        val base = Ingredient.fromJson(JsonHelper.getElement(jsonObject, "base"))
        val name = JsonHelper.getElement(jsonObject, "upgrade_name").asString
        return SmithingEnchantRecipe(identifier, template, base, name)
    }

    override fun read(identifier: Identifier, packetByteBuf: PacketByteBuf): SmithingEnchantRecipe {
        val template = Ingredient.fromPacket(packetByteBuf)
        val base = Ingredient.fromPacket(packetByteBuf)
        val name = packetByteBuf.readString()
        return SmithingEnchantRecipe(identifier, template, base, name)
    }

    override fun write(packetByteBuf: PacketByteBuf, smithingTrimRecipe: SmithingEnchantRecipe) {
        smithingTrimRecipe.template.write(packetByteBuf)
        smithingTrimRecipe.base.write(packetByteBuf)
        packetByteBuf.writeString(smithingTrimRecipe.name)
    }

}