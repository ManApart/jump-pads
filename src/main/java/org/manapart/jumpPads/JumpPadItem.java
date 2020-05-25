package org.manapart.jumpPads;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class JumpPadItem extends BlockItem {
    public JumpPadItem(JumpPad block) {
        super(block, new Item.Properties().group(ItemGroupJP.instance));
    }

}
