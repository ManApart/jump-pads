package org.manapart.jumpPads;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class JumpPad extends SlimeBlock {
    private final Float velocity;

    JumpPad(Float velocity) {
        super(getProps());
//        super(Block.Properties.create(Material.CORAL, MaterialColor.COLOR_GREEN).hardnessAndResistance(4f).sound(SoundType.SLIME_BLOCK));
        this.velocity = velocity;
    }

    private static AbstractBlock.Properties getProps() {
        Material padMat = new Material.Builder(MaterialColor.COLOR_GREEN).build();
        AbstractBlock.Properties props = AbstractBlock.Properties.of(padMat);
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

    @Nullable
    @Override
    public ToolType getHarvestTool(BlockState state) {
        return ToolType.PICKAXE;
    }

    @Override
    public int getHarvestLevel(BlockState state) {
        return 2; //Harvest level of 2 means it requires iron or better to harvest
    }

    private boolean isInMiddleOfBlock(BlockPos block, Entity entity) {
        double x = Math.abs(block.getX() - entity.getX());
        double z = Math.abs(block.getZ() - entity.getZ());

        return x > .2d && x < .8d && z > .2d && z < .8d;
    }

}

