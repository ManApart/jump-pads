package org.manapart.jumpPads;

import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import static org.manapart.jumpPads.JumpPads.*;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBlocks {

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        if (!ForgeRegistries.BLOCKS.containsKey(JUMP_PAD.getRegistryName())) {
//            System.out.println("Registering blocks");
            ForgeRegistries.BLOCKS.register(JUMP_PAD);
            ForgeRegistries.BLOCKS.register(JUMP_PAD_2);
            ForgeRegistries.BLOCKS.register(JUMP_PAD_3);
        }
    }
}
