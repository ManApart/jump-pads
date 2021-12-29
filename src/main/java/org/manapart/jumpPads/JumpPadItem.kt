package org.manapart.jumpPads

import net.minecraft.world.item.BlockItem


class JumpPadItem(block: JumpPad) : BlockItem(block, Properties().tab(ItemGroupJP.instance))