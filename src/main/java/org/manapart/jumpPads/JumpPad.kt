package org.manapart.jumpPads

import net.minecraft.core.BlockPos
import net.minecraft.world.entity.Entity
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.SlimeBlock
import net.minecraft.world.level.block.SoundType
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.material.Material
import net.minecraft.world.level.material.MaterialColor
import kotlin.math.abs

private fun createProps(): BlockBehaviour.Properties {
    val padMat = Material.Builder(MaterialColor.COLOR_GREEN).build()
    val props = BlockBehaviour.Properties.of(padMat)
//    props.requiresCorrectToolForDrops()
//    props.harvestTool(ToolType.PICKAXE)
    props.sound(SoundType.SLIME_BLOCK)
    props.strength(4f)
    return props
}

class JumpPad internal constructor(private val velocity: Float) : SlimeBlock(createProps()) {
    override fun stepOn(worldIn: Level, pos: BlockPos, state: BlockState, entityIn: Entity) {
        entityIn.fallDistance = 0f
        super.stepOn(worldIn, pos, state, entityIn)
        if (!entityIn.isCrouching && isInMiddleOfBlock(pos, entityIn)) {
            if (worldIn.isClientSide) {
                entityIn.setDeltaMovement(0.0, velocity.toDouble(), 0.0)
            }
        }
    }

    override fun fallOn(worldIn: Level, state: BlockState, pos: BlockPos, entityIn: Entity, p_154571_: Float) {
        entityIn.fallDistance = 0f
    }

    private fun isInMiddleOfBlock(block: BlockPos, entity: Entity): Boolean {
        val x = abs(block.x - entity.x)
        val z = abs(block.z - entity.z)
        return x > .2 && x < .8 && z > .2 && z < .8
    }

}