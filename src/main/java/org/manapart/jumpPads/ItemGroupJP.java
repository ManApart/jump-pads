package org.manapart.jumpPads;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ItemGroupJP extends ItemGroup {
    public static final ItemGroupJP instance = new ItemGroupJP(ItemGroup.getGroupCountSafe(), "jumppads");

    private ItemGroupJP(int index, String label) {
        super(index, label);
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(JumpPads.jumpPadsIcon);
    }

}
