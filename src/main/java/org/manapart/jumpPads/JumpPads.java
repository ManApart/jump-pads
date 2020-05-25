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

    public static final String MODID = "jumppads";
    public static final JumpPad JUMP_PAD = createBlock();
    public static final JumpPadItem JUMP_PAD_ITEM = createItem(JUMP_PAD);
    public static Item jumpPadsIcon = createIcon();

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
        }
    }

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
        System.out.println("Registering items");
        if (!ForgeRegistries.ITEMS.containsKey(JUMP_PAD_ITEM.getRegistryName())) {
            ForgeRegistries.ITEMS.register(JUMP_PAD_ITEM);
            ForgeRegistries.ITEMS.register(jumpPadsIcon);
        }
    }

    private static Item createIcon() {
        Item icon = new Item(new Item.Properties());
        icon.setRegistryName(MODID + ":jp_icon");
        return icon;
    }

    private static JumpPad createBlock() {
        JumpPad jumpPad = new JumpPad();
        jumpPad.setRegistryName(new ResourceLocation(MODID + ":jumppad"));
        return jumpPad;
    }

    private static JumpPadItem createItem(JumpPad block) {
        JumpPadItem teleporter = new JumpPadItem(block);
        teleporter.setRegistryName(new ResourceLocation(MODID + ":jumppaditem"));
        return teleporter;
    }


}
