package com.supersouper.whichery.common.blocks.crops;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.supersouper.whichery.ModBlocks;
import com.supersouper.whichery.ModItems;

public class BlockCropFirePoppy extends BlockWhicheryCrop {

    public BlockCropFirePoppy(String id, int maxStage) {
        super(id, maxStage);
    }

    @Override
    public boolean canPlaceBlockOn(Block ground) {
        return ground == Blocks.grass || ground == Blocks.dirt || ground == Blocks.sand;
    }

    @Override
    protected Item getSeedItem() {
        return ModItems.FIRE_POPPY_SEED.get();
    }

    @Override
    public void addDropsGrown(World world, int x, int y, int z, int metadata, int fortune, ArrayList<ItemStack> drops) {
        drops.add(new ItemStack(getSeedItem(), 1));
    }

    @Override
    public void addDropsAlways(World world, int x, int y, int z, int metadata, int fortune,
        ArrayList<ItemStack> drops) {}

    @Override
    public void onBlockHarvested(World worldIn, int x, int y, int z, int meta, EntityPlayer player) {
        super.onBlockHarvested(worldIn, x, y, z, meta, player);
        if (meta < maxStage) return;
        if (worldIn.getBlock(x + 1, y, z) == Blocks.air && canPlaceBlockOn(worldIn.getBlock(x + 1, y - 1, z))) {
            if (worldIn.rand.nextInt(100) < 20) worldIn.setBlock(x + 1, y, z, ModBlocks.FIRE_POPPY.get());
        }
        if (worldIn.getBlock(x - 1, y, z) == Blocks.air && canPlaceBlockOn(worldIn.getBlock(x - 1, y - 1, z))) {
            if (worldIn.rand.nextInt(100) < 20) worldIn.setBlock(x - 1, y, z, ModBlocks.FIRE_POPPY.get());
        }
        if (worldIn.getBlock(x, y, z + 1) == Blocks.air && canPlaceBlockOn(worldIn.getBlock(x, y - 1, z + 1))) {
            if (worldIn.rand.nextInt(100) < 20) worldIn.setBlock(x, y, z + 1, ModBlocks.FIRE_POPPY.get());
        }
        if (worldIn.getBlock(x, y, z - 1) == Blocks.air && canPlaceBlockOn(worldIn.getBlock(x, y - 1, z - 1))) {
            if (worldIn.rand.nextInt(100) < 20) worldIn.setBlock(x, y, z - 1, ModBlocks.FIRE_POPPY.get());
        }
    }
}
