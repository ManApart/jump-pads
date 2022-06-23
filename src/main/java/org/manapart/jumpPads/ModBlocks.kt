package org.manapart.jumpPads

import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.registerObject

object ModBlocks {
    val REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID)

    val JUMP_PAD by REGISTRY.registerObject("jumppad") { JumpPad(1.5f) }
    val JUMP_PAD_2 by REGISTRY.registerObject("jumppad_2") { JumpPad(3f) }
    val JUMP_PAD_3 by REGISTRY.registerObject("jumppad_3") { JumpPad(4f) }

}