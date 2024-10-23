package net.ahria.privacyglass.block;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GlassBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;

public class TintedGlassBlock extends GlassBlock {
    public static final BooleanProperty TINTED = BooleanProperty.create("tinted");
    //this class exists because of it toggling betwen tinted or nor

    public TintedGlassBlock() {
        super(Properties.copy(Blocks.GLASS));
        this.registerDefaultState(this.stateDefinition.any().setValue(TINTED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(TINTED);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide) {
            boolean isTinted = state.getValue(TINTED);
            level.setBlock(pos, state.setValue(TINTED, !isTinted), 3);
            player.sendSystemMessage(Component.translatable("message.toggle_tint", !isTinted));
        }
        return InteractionResult.SUCCESS; // Indicates that the action was successful

    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return super.getStateForPlacement(context);
    }
}
