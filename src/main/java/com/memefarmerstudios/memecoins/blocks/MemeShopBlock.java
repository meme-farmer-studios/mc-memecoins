package com.memefarmerstudios.memecoins.blocks;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import javax.annotation.Nullable;
import javax.annotation.Nonnull;

public class MemeShopBlock extends Block implements EntityBlock {
    
    public MemeShopBlock() {
        super(BlockBehaviour.Properties
            .of()
            .strength(-1.0F, 3600000.0F)
            .noLootTable()
            .pushReaction(PushReaction.BLOCK)
        );
    }
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        }
            
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof MemeShopBlockEntity) {
            MenuProvider menuProvider = (MenuProvider) blockEntity;
            if (player instanceof ServerPlayer serverPlayer) {
                serverPlayer.openMenu(menuProvider);
                return InteractionResult.CONSUME;
            }
        }
            
        return InteractionResult.PASS;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@Nonnull BlockPos pos, @Nonnull BlockState state) {
        return new MemeShopBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@Nonnull Level level, @Nonnull BlockState state, @Nonnull BlockEntityType<T> type) {
        return level.isClientSide() ? null : createTickerHelper(type, BlockRegistry.MEME_SHOP_BLOCK_ENTITY.get(), MemeShopBlockEntity::tick);
    }

    @Nullable
    @SuppressWarnings("unchecked")
    protected static <E extends BlockEntity, A extends BlockEntity> BlockEntityTicker<A> createTickerHelper(BlockEntityType<A> requestedType, BlockEntityType<E> expectedType, BlockEntityTicker<? super E> ticker) {
        return expectedType == requestedType ? (BlockEntityTicker<A>)ticker : null;
    }
}
