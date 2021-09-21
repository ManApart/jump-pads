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
import net.minecraft.block.material.MaterialColor
import net.minecraftforge.common.ToolType
import net.minecraft.block.SoundType
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraftforge.fml.common.Mod.EventBusSubscriber
import org.manapart.jumpPads.JumpPadItem
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.event.RegistryEvent.Register
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.registries.ForgeRegistries

@Mod(JumpPads.MODID)
@EventBusSubscriber(modid = JumpPads.MODID)
class JumpPads {
    companion object {
        const val MODID = "jumppads"
        var jumpPadsIcon = createIcon()
        val JUMP_PAD = createBlock(1.5f, "jumppad")
        val JUMP_PAD_ITEM = createItem(JUMP_PAD, "jumppaditem")
        val JUMP_PAD_2 = createBlock(3f, "jumppad_2")
        val JUMP_PAD_ITEM_2 = createItem(JUMP_PAD_2, "jumppaditem_2")
        val JUMP_PAD_3 = createBlock(4f, "jumppad_3")
        val JUMP_PAD_ITEM_3 = createItem(JUMP_PAD_3, "jumppaditem_3")
        private fun createIcon(): Item {
            val icon = Item(Item.Properties())
            icon.setRegistryName(MODID + ":jp_icon")
            return icon
        }

        private fun createBlock(velocity: Float, id: String): JumpPad {
            val jumpPad = JumpPad(velocity)
            jumpPad.setRegistryName(MODID, id)
            return jumpPad
        }

        private fun createItem(block: JumpPad, id: String): JumpPadItem {
            val item = JumpPadItem(block)
            item.setRegistryName(MODID, id)
            return item
        }
    }

    init {
        MinecraftForge.EVENT_BUS.register(this)
    }
}