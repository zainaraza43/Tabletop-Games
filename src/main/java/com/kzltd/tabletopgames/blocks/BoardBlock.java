package com.kzltd.tabletopgames.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class BoardBlock extends Block {
    public BoardBlock() {
        super(AbstractBlock.Properties.create(Material.CAKE)
                .hardnessAndResistance(2.0f,2.0f)
                .sound(SoundType.WOOD)
                .harvestLevel(0)
                .harvestTool(ToolType.AXE));
    }
}
