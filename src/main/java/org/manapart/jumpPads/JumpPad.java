package org.manapart.jumpPads;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class JumpPad extends SlimeBlock {
    private final Float velocity;

    JumpPad(Float velocity) {
        super(createProps());
        this.velocity = velocity;
    }

    private static AbstractBlock.Properties createProps() {
        Material padMat = new Material.Builder(MaterialColor.COLOR_GREEN).build();
        AbstractBlock.Properties props = AbstractBlock.Properties.of(padMat);
        props.requiresCorrectToolForDrops();
        props.harvestTool(ToolType.PICKAXE);
        props.sound(SoundType.SLIME_BLOCK);
        props.strength(4);
        return props;
    }

    @Override
    public void stepOn(World worldIn, BlockPos pos, Entity entityIn) {
        entityIn.fallDistance = 0;
        super.stepOn(worldIn, pos, entityIn);
        if (!entityIn.isCrouching() && isInMiddleOfBlock(pos, entityIn)) {
            if (worldIn.isClientSide) {
                entityIn.setDeltaMovement(0, velocity, 0);
            }
        }
    }

    @Override
    public void fallOn(World worldIn, BlockPos pos, Entity entityIn, float fallDistance) {
        entityIn.fallDistance = 0;
    }

    private boolean isInMiddleOfBlock(BlockPos block, Entity entity) {
        double x = Math.abs(block.getX() - entity.getX());
        double z = Math.abs(block.getZ() - entity.getZ());

        return x > .2d && x < .8d && z > .2d && z < .8d;
    }

}

