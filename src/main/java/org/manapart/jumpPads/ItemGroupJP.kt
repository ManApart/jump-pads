package org.manapart.jumpPads

import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.ItemStack


class ItemGroupJP private constructor(index: Int, label: String) : CreativeModeTab(index, label) {
    override fun makeIcon(): ItemStack = ItemStack(JumpPads.jumpPadsIcon)

    companion object {
        val instance = ItemGroupJP(getGroupCountSafe(), "jumppads")
    }
}