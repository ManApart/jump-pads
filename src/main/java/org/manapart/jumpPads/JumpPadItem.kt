package org.manapart.jumpPads

import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.CreativeModeTab


class JumpPadItem(block: JumpPad) : BlockItem(block, Properties().tab(CreativeModeTab.TAB_MISC))