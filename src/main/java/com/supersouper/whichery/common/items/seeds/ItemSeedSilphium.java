package com.supersouper.whichery.common.items.seeds;

import net.minecraft.block.Block;

import com.supersouper.whichery.ModBlocks;

public class ItemSeedSilphium extends ItemWhicherySeed {

    public ItemSeedSilphium() {
        super("silphium");
    }

    @Override
    protected Block getCropBlock() {
        return ModBlocks.SILPHIUM.get();
    }
}
