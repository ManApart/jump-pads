package org.manapart.jumpPads

import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.KDeferredRegister
import thedarkcolour.kotlinforforge.forge.registerObject

object ModItems {
    val REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, MODID)

    val JUMP_PAD_ITEM by REGISTRY.registerObject("jumppaditem") { JumpPadItem(ModBlocks.jumpPad) }
    val JUMP_PAD_ITEM_2 by REGISTRY.registerObject("jumppaditem_2") { JumpPadItem(ModBlocks.jumpPad2) }
    val JUMP_PAD_ITEM_3 by REGISTRY.registerObject("jumppaditem_3") { JumpPadItem(ModBlocks.jumpPad3) }
}