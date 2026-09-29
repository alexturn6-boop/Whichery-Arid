package com.supersouper.whichery.common.items.seeds;

import com.supersouper.whichery.ModBlocks;
import net.minecraft.block.Block;

public class ItemSeedSilphium extends ItemWhicherySeed{
    public ItemSeedSilphium() {
        super("silphium");
    }

    @Override
    protected Block getCropBlock() {
        return ModBlocks.SILPHIUM.get();
    }
}
