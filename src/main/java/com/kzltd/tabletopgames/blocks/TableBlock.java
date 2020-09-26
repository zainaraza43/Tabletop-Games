package com.kzltd.tabletopgames.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraftforge.common.ToolType;

public class TableBlock extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
    
    private static final VoxelShape SHAPE_N = Stream.of(
    Block.makeCuboidShape(0, 14, 0, 16, 16, 16),
    Block.makeCuboidShape(7, 5, 7, 9, 14, 9),
    Block.makeCuboidShape(4, 0, 4, 12, 1, 12),
    Block.makeCuboidShape(6, 1, 6, 10, 5, 10),
    Block.makeCuboidShape(7, 2, 5, 9, 4, 11),
    Block.makeCuboidShape(5, 2, 7, 11, 4, 9),
    Block.makeCuboidShape(7, 1, 4, 9, 2, 12),
    Block.makeCuboidShape(4, 1, 7, 12, 2, 9)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get(); //default to north shape, although if more states are added the code can by modified

    public TableBlock() {
        super(AbstractBlock.Properties.create(Material.WOOD)
                .hardnessAndResistance(1.2f,1.0f)
                .sound(SoundType.WOOD)
                .harvestTool(ToolType.AXE)
                .harvestLevel(1));
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }
    
    @Override
    public VoxelShape getShape(Blockstate state, IBlockReader worldIn, BlockPos pos, ISelectContext context){
        return SHAPE_N;
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
    
    @Override
    public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos){
        return 0.3f;
    }
}
