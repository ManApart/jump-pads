package org.manapart.jumpPads;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class JumpPad extends SlabBlock {
    private final Float velocity;

    public JumpPad(Float velocity) {
        super(Block.Properties.create(Material.IRON, MaterialColor.BLUE).hardnessAndResistance(4f).sound(SoundType.METAL));
        this.velocity = velocity;
    }

    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        super.onEntityWalk(worldIn, pos, entityIn);
        entityIn.fallDistance = 0;
        entityIn.addVelocity(0, velocity, 0);
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

}
