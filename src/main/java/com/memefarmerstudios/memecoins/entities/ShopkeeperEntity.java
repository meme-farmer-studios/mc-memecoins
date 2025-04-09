package com.memefarmerstudios.memecoins.entities;

import com.memefarmerstudios.memecoins.gui.ShopkeeperScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import javax.annotation.Nonnull;

public class ShopkeeperEntity extends Mob {

    public static final EntityType<ShopkeeperEntity> SHOPKEEPER = EntityType.Builder.of(ShopkeeperEntity::new, MobCategory.MISC)
            .sized(0.6F, 1.8F) // Default player size
            .build("shopkeeper");

    // Removed the static block with `setRegistryName` as it is no longer supported.
    // EntityType registration is now handled directly in `memecoins.java`.

    public ShopkeeperEntity(EntityType<? extends Mob> type, Level level) {
        super(type, level);
    }

    @Override
    public InteractionResult mobInteract(@Nonnull Player player, @Nonnull InteractionHand hand) {
        if (!this.getCommandSenderWorld().isClientSide) {
            player.sendSystemMessage(Component.literal("Shopkeeper: Welcome to the Memeconomy!"));
        } else {
            Minecraft.getInstance().setScreen(new ShopkeeperScreen(Component.literal("Memeconomy Shop")));
        }
        return InteractionResult.SUCCESS;
    }
}
