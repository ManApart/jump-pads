package org.manapart.jumpPads

import net.minecraft.item.Item
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.Mod
import thedarkcolour.kotlinforforge.forge.MOD_BUS

const val MODID = "jumppads"
@Mod(MODID)
object JumpPads {

    init {
        ModBlocks.REGISTRY.register(MOD_BUS)
        ModItems.REGISTRY.register(MOD_BUS)
    }

    val jumpPadsIcon = Item(Item.Properties()).also { it.setRegistryName("$MODID:jp_icon") }
}