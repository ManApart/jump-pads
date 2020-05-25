/*******************************************************************************
 * Copyright 2014-2019, the Biomes O' Plenty Team
 *
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 *
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/
package org.manapart.jumpPads;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ItemGroupJP extends ItemGroup {
    public static final ItemGroupJP instance = new ItemGroupJP(ItemGroup.GROUPS.length, "jumppads");

    private ItemGroupJP(int index, String label) {
        super(index, label);
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(JumpPads.jumpPadsIcon);
    }

}
