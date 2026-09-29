package com.supersouper.whichery.common.blocks.crops;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.supersouper.whichery.ModItems;

public class BlockCropSilphium extends BlockWhicheryCrop {

    public BlockCropSilphium(String id, int maxStage) {
        super(id, maxStage);
    }

    @Override
    public boolean canPlaceBlockOn(Block ground) {
        return ground == Blocks.sand;
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random rand) {
        if (world.isRemote) return;
        int meta = world.getBlockMetadata(x, y, z);
        if (meta >= maxStage) {
            world.setBlock(x, y, z, Blocks.deadbush);
            return;
        }

        world.setBlockMetadataWithNotify(x, y, z, meta + 1, 2);
    }

    @Override
    protected Item getSeedItem() {
        return ModItems.SILPHIUM_SEED.get();
    }

    @Override
    public void addDropsAlways(World world, int x, int y, int z, int metadata, int fortune,
        ArrayList<ItemStack> drops) {
        if (metadata <= 2) drops.add(ModItems.SILPHIUM_SEED.newItemStack(1));
        if (metadata == 2) {
            drops.add(new ItemStack(ModItems.SILPHIUM_FLOWER.get(), world.rand.nextInt(3) + 1));
            if (world.rand.nextInt(100) < 20) drops.add(ModItems.SILPHIUM_SEED.newItemStack(1));
        } else if (metadata == 3) {
            drops.add(new ItemStack(ModItems.SILPHIUM_WILTED_FLOWER.get(), world.rand.nextInt(3) + 1));
        }
    }
}
