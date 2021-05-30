package org.manapart.jumpPads;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod(JumpPads.MODID)
@Mod.EventBusSubscriber(modid = JumpPads.MODID)
public class JumpPads {

    public static final String MODID = "jumppads";
    static Item jumpPadsIcon = createIcon();

    public static final JumpPad JUMP_PAD = createBlock(1.5f, "jumppad");
    public static final JumpPadItem JUMP_PAD_ITEM = createItem(JUMP_PAD, "jumppaditem");

    public static final JumpPad JUMP_PAD_2 = createBlock(3f, "jumppad_2");
    public static final JumpPadItem JUMP_PAD_ITEM_2 = createItem(JUMP_PAD_2, "jumppaditem_2");

    public static final JumpPad JUMP_PAD_3 = createBlock(4f, "jumppad_3");
    public static final JumpPadItem JUMP_PAD_ITEM_3 = createItem(JUMP_PAD_3, "jumppaditem_3");

    public JumpPads() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    private static Item createIcon() {
        Item icon = new Item(new Item.Properties());
        icon.setRegistryName(MODID + ":jp_icon");
        return icon;
    }

    private static JumpPad createBlock(Float velocity, String id) {
        JumpPad jumpPad = new JumpPad(velocity);
        jumpPad.setRegistryName(MODID, id);
        return jumpPad;
    }

    private static JumpPadItem createItem(JumpPad block, String id) {
        JumpPadItem item = new JumpPadItem(block);
        item.setRegistryName(MODID, id);
        return item;
    }


}
