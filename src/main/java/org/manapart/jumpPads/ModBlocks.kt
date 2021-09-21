package org.manapart.jumpPads

import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import org.manapart.jumpPads.JumpPads
import org.manapart.jumpPads.ItemGroupJP
import net.minecraft.block.SlimeBlock
import org.manapart.jumpPads.JumpPad
import net.minecraft.world.World
import net.minecraft.util.math.BlockPos
import net.minecraft.block.AbstractBlock
import net.minecraft.block.Block
import net.minecraft.block.material.MaterialColor
import net.minecraftforge.common.ToolType
import net.minecraft.block.SoundType
import net.minecraft.item.BlockItem
import net.minecraftforge.fml.common.Mod.EventBusSubscriber
import org.manapart.jumpPads.JumpPadItem
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.event.RegistryEvent.Register
import net.minecraftforge.registries.ForgeRegistries

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
object ModBlocks {
    @SubscribeEvent
    fun registerBlocks(event: Register<Block?>?) {
        if (!ForgeRegistries.BLOCKS.containsKey(JumpPads.Companion.JUMP_PAD.getRegistryName())) {
//            System.out.println("Registering blocks");
            ForgeRegistries.BLOCKS.register(JumpPads.Companion.JUMP_PAD)
            ForgeRegistries.BLOCKS.register(JumpPads.Companion.JUMP_PAD_2)
            ForgeRegistries.BLOCKS.register(JumpPads.Companion.JUMP_PAD_3)
        }
    }
}