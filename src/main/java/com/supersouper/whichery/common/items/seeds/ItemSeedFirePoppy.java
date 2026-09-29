package com.supersouper.whichery.common.items.seeds;

import com.supersouper.whichery.ModBlocks;
import net.minecraft.block.Block;

public class ItemSeedFirePoppy extends ItemWhicherySeed{
    public ItemSeedFirePoppy() {
        super("fire_poppy");
    }

    @Override
    protected Block getCropBlock() {
        return ModBlocks.FIRE_POPPY.get();
    }
}
