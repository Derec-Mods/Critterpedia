
package net.derex.critterpedia.block;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.derex.critterpedia.procedures.TurtleExitShellProcedure;
import net.derex.critterpedia.init.CritterpediaModBlockEntities;

import javax.annotation.Nullable;

public class GalapgosTortoiseShellBlockBlock extends BaseEntityBlock implements EntityBlock {
	public static final IntegerProperty ANIMATION = IntegerProperty.create("animation", 0, 1);
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public GalapgosTortoiseShellBlockBlock() {
		super(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.GRAVEL).strength(-1, 3600000).noOcclusion().isRedstoneConductor((bs, br, bp) -> false).noLootTable());
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@Override
	public RenderShape getRenderShape(BlockState state) {
		return RenderShape.ENTITYBLOCK_ANIMATED;
	}

	@Nullable
	@Override
	public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
		return CritterpediaModBlockEntities.GALAPGOS_TORTOISE_SHELL_BLOCK.get().create(blockPos, blockState);
	}

	@Override
	public boolean shouldDisplayFluidOverlay(BlockState state, BlockAndTintGetter world, BlockPos pos, FluidState fluidstate) {
		return true;
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(ANIMATION, FACING);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public void attack(BlockState blockstate, Level world, BlockPos pos, Player entity) {
		super.attack(blockstate, world, pos, entity);
		TurtleExitShellProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate);
	}
}
