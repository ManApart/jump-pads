package org.manapart.jumpPads

import net.minecraft.block.AbstractBlock
import net.minecraft.block.SlimeBlock
import net.minecraft.block.SoundType
import net.minecraft.block.material.Material
import net.minecraft.block.material.MaterialColor
import net.minecraft.entity.Entity
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import net.minecraftforge.common.ToolType
import kotlin.math.abs

private fun createProps(): AbstractBlock.Properties {
    val padMat = Material.Builder(MaterialColor.COLOR_GREEN).build()
    val props = AbstractBlock.Properties.of(padMat)
    props.requiresCorrectToolForDrops()
    props.harvestTool(ToolType.PICKAXE)
    props.sound(SoundType.SLIME_BLOCK)
    props.strength(4f)
    return props
}

class JumpPad internal constructor(private val velocity: Float) : SlimeBlock(createProps()) {
    override fun stepOn(worldIn: World, pos: BlockPos, entityIn: Entity) {
        entityIn.fallDistance = 0f
        super.stepOn(worldIn, pos, entityIn)
        if (!entityIn.isCrouching && isInMiddleOfBlock(pos, entityIn)) {
            if (worldIn.isClientSide) {
                entityIn.setDeltaMovement(0.0, velocity.toDouble(), 0.0)
            }
        }
    }

    override fun fallOn(worldIn: World, pos: BlockPos, entityIn: Entity, fallDistance: Float) {
        entityIn.fallDistance = 0f
    }

    private fun isInMiddleOfBlock(block: BlockPos, entity: Entity): Boolean {
        val x = abs(block.x - entity.x)
        val z = abs(block.z - entity.z)
        return x > .2 && x < .8 && z > .2 && z < .8
    }

}