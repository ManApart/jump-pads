package org.manapart.jumpPads

import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.KDeferredRegister
import thedarkcolour.kotlinforforge.forge.registerObject

object ModBlocks {
    val jumpPad = JumpPad(1.5f)
    val jumpPad2 = JumpPad(3f)
    val jumpPad3 = JumpPad(4f)

    val REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID)

    val JUMP_PAD by REGISTRY.registerObject("jumppad") { jumpPad }
    val JUMP_PAD_2 by REGISTRY.registerObject("jumppad_2") { jumpPad2 }
    val JUMP_PAD_3 by REGISTRY.registerObject("jumppad_3") { jumpPad3 }

}