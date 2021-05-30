package org.manapart.jumpPads;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class JumpPadItem extends BlockItem {
    public JumpPadItem(JumpPad block) {
        super(block, new Item.Properties().tab(ItemGroupJP.instance));
    }

}
