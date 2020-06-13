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
        super(Block.Properties.create(Material.ORGANIC, MaterialColor.GREEN).hardnessAndResistance(4f).sound(SoundType.SLIME));
        this.velocity = velocity;
    }

    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        entityIn.fallDistance = 0;
        super.onEntityWalk(worldIn, pos, entityIn);
        if (!entityIn.isCrouching() && isInMiddleOfBlock(pos, entityIn)) {
            if (worldIn.isRemote) {
                entityIn.setVelocity(0, velocity, 0);
            }
        }
    }

    @Override
    public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance) {
        entityIn.fallDistance = 0;
    }

    @Override
    public void onLanded(IBlockReader worldIn, Entity entityIn) {
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
        double x = Math.abs(block.getX() - entity.getPosX());
        double z = Math.abs(block.getZ() - entity.getPosZ());

        return x > .2d && x < .8d && z > .2d && z < .8d;
    }

}
