package com.memefarmerstudios.memecoins.gui;

import com.memefarmerstudios.memecoins.blocks.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.Container;
import net.minecraft.network.FriendlyByteBuf;
import javax.annotation.Nonnull;

public class MemeShopMenu extends AbstractContainerMenu {
    private final ContainerLevelAccess access;

    // Constructor for network registration
    public MemeShopMenu(int id, Inventory playerInventory, FriendlyByteBuf data) {
        this(id, playerInventory, new SimpleContainer(9), ContainerLevelAccess.NULL);
    }

    // Constructor called from BlockEntity
    public MemeShopMenu(int id, Inventory playerInventory, Level level, BlockPos pos) {
        this(id, playerInventory, new SimpleContainer(9), ContainerLevelAccess.create(level, pos));
    }

    // Main constructor logic
    private MemeShopMenu(int id, Inventory playerInventory, Container container, ContainerLevelAccess access) {
        super(com.memefarmerstudios.memecoins.memecoins.MEME_SHOP_MENU.get(), id);
        this.access = access;
    }

    @Override
    public boolean stillValid(@Nonnull Player player) {
        return stillValid(this.access, player, BlockRegistry.MEME_SHOP_BLOCK.get());
    }

    @Nonnull
    @Override
    public ItemStack quickMoveStack(@Nonnull Player player, int index) {
        return ItemStack.EMPTY;
    }
}
