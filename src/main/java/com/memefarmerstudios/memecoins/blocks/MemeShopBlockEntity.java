package com.memefarmerstudios.memecoins.blocks;

import com.memefarmerstudios.memecoins.gui.MemeShopMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level; // Import Level
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nonnull; // Import Nonnull
import javax.annotation.Nullable;

// Implement MenuProvider
public class MemeShopBlockEntity extends BlockEntity implements MenuProvider {

    public MemeShopBlockEntity(BlockPos pos, BlockState state) {
        super(BlockRegistry.MEME_SHOP_BLOCK_ENTITY.get(), pos, state);
    }

    // --- MenuProvider Implementation ---
    @Nonnull // Add Nonnull
    @Override
    public Component getDisplayName() {
        // Use the block's name as the GUI title
        return Component.translatable(BlockRegistry.MEME_SHOP_BLOCK.get().getDescriptionId());
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int containerId, @Nonnull Inventory playerInventory, @Nonnull Player player) {
        // Pass level and worldPosition to the correct constructor
        return new MemeShopMenu(containerId, playerInventory, this.level, this.worldPosition);
    }
    // --- End MenuProvider ---

    // Static tick method required by getTicker
    public static void tick(Level level, BlockPos pos, BlockState state, MemeShopBlockEntity blockEntity) {
        // Trading logic will be implemented here later
        // Example: if (level.getGameTime() % 20 == 0) { System.out.println("Tick!"); }
    }

    // Instance tick method (optional, can be called from static tick or used for client-side ticks if needed)
    public void tick() {
        // This method is not directly used by the server-side ticker mechanism
        // but can be kept for other purposes if needed.
    }
}
