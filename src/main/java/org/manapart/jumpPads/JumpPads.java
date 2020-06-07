package org.manapart.jumpPads;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(JumpPads.MODID)
@Mod.EventBusSubscriber(modid = JumpPads.MODID)
public class JumpPads {

    static final String MODID = "jumppads";
    static Item jumpPadsIcon = createIcon();

    private static final JumpPad JUMP_PAD = createBlock(1.5f, "jumppad");
    private static final JumpPadItem JUMP_PAD_ITEM = createItem(JUMP_PAD, "jumppaditem");

    private static final JumpPad JUMP_PAD_2 = createBlock(3f, "jumppad_2");
    private static final JumpPadItem JUMP_PAD_ITEM_2 = createItem(JUMP_PAD_2, "jumppaditem_2");

    private static final JumpPad JUMP_PAD_3 = createBlock(4f, "jumppad_3");
    private static final JumpPadItem JUMP_PAD_ITEM_3 = createItem(JUMP_PAD_3, "jumppaditem_3");

    public JumpPads() {
        MinecraftForge.EVENT_BUS.register(this);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::registerBlocks);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::registerItems);
    }

    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event) {
        System.out.println("Registering blocks");
        if (!ForgeRegistries.BLOCKS.containsKey(JUMP_PAD.getRegistryName())) {
            ForgeRegistries.BLOCKS.register(JUMP_PAD);
            ForgeRegistries.BLOCKS.register(JUMP_PAD_2);
            ForgeRegistries.BLOCKS.register(JUMP_PAD_3);
        }
    }

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
        System.out.println("Registering items");
        if (!ForgeRegistries.ITEMS.containsKey(JUMP_PAD_ITEM.getRegistryName())) {
            ForgeRegistries.ITEMS.register(jumpPadsIcon);
            ForgeRegistries.ITEMS.register(JUMP_PAD_ITEM);
            ForgeRegistries.ITEMS.register(JUMP_PAD_ITEM_2);
            ForgeRegistries.ITEMS.register(JUMP_PAD_ITEM_3);
        }
    }

    private static Item createIcon() {
        Item icon = new Item(new Item.Properties());
        icon.setRegistryName(MODID + ":jp_icon");
        return icon;
    }

    private static JumpPad createBlock(Float velocity, String id) {
        JumpPad jumpPad = new JumpPad(velocity);
        jumpPad.setRegistryName(new ResourceLocation(MODID + ":" + id));
        return jumpPad;
    }

    private static JumpPadItem createItem(JumpPad block, String id) {
        JumpPadItem teleporter = new JumpPadItem(block);
        teleporter.setRegistryName(new ResourceLocation(MODID + ":" + id));
        return teleporter;
    }


}
