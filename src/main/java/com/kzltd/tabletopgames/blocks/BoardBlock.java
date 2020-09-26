package com.kzltd.tabletopgames.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class BoardBlock extends Block {
    public BoardBlock() {
        super(AbstractBlock.Properties.create(Material.CAKE)
                .hardnessAndResistance(1.2f,1.0f)
                .sound(SoundType.WOOD)
                .harvestTool(ToolType.AXE)
                .harvestLevel(1));
    }
}
