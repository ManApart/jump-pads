package org.manapart.jumpPads;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import static org.manapart.jumpPads.JumpPads.*;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItems {

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        if (!ForgeRegistries.ITEMS.containsKey(JUMP_PAD_ITEM.getRegistryName())) {
//            System.out.println("Registering items");
            ForgeRegistries.ITEMS.register(jumpPadsIcon);
            ForgeRegistries.ITEMS.register(JUMP_PAD_ITEM);
            ForgeRegistries.ITEMS.register(JUMP_PAD_ITEM_2);
            ForgeRegistries.ITEMS.register(JUMP_PAD_ITEM_3);
        }
    }

}
