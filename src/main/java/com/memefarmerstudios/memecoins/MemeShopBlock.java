package com.memefarmerstudios.memecoins;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import java.util.Map;

public class MemeShopBlock extends Block {

    private String tradeItem = "minecraft:air"; // Default trade item

    public MemeShopBlock(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (level.isClientSide) {
            System.out.println("MemeShopBlock: Right-click detected on client side.");
            return InteractionResult.SUCCESS;
        }

        System.out.println("MemeShopBlock: Right-click detected on server side.");

        if (player.isCreative()) {
            // Creative mode: Set the trade item
            ItemStack heldItem = player.getItemInHand(hand);
            if (!heldItem.isEmpty()) {
                tradeItem = BuiltInRegistries.ITEM.getKey(heldItem.getItem()).toString();
                player.displayClientMessage(Component.literal("Trade item set to: " + tradeItem), true);
            }
        } else {
            // Survival mode: Trade logic
            Map<String, Object> memeconomyData = Config.loadMemeconomyData();
            if (memeconomyData.containsKey(tradeItem)) {
                int memecoinValue = (int) memeconomyData.get(tradeItem);
                ItemStack heldItem = player.getItemInHand(hand);

                if (BuiltInRegistries.ITEM.getKey(heldItem.getItem()).toString().equals(tradeItem) && heldItem.getCount() >= 1) {
                    heldItem.shrink(1); // Consume one trade item
                    player.addItem(new ItemStack(memecoins.MEMECOIN.get(), memecoinValue));
                    player.displayClientMessage(Component.literal("Traded 1 " + tradeItem + " for " + memecoinValue + " memecoins!"), true);
                } else {
                    player.displayClientMessage(Component.literal("You need at least 1 " + tradeItem + " to trade!"), true);
                }
            } else {
                player.displayClientMessage(Component.literal("This block is not configured for trading."), true);
            }
        }

        return InteractionResult.SUCCESS;
    }
}