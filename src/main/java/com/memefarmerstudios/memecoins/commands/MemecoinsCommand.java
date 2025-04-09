package com.memefarmerstudios.memecoins.commands;

import com.memefarmerstudios.memecoins.entities.ShopkeeperEntity;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.phys.Vec3;

public class MemecoinsCommand {

    public static void register(com.mojang.brigadier.CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("memecoins")
                .requires(source -> source.hasPermission(2)) // Operator-only
                .then(Commands.literal("shop")
                        .executes(MemecoinsCommand::spawnShopkeeper)));
    }

    private static int spawnShopkeeper(CommandContext<CommandSourceStack> context) {
        CommandSourceStack source = context.getSource();
        ServerPlayer player;
        try {
            player = source.getPlayerOrException();
        } catch (com.mojang.brigadier.exceptions.CommandSyntaxException e) {
            source.sendFailure(net.minecraft.network.chat.Component.literal("Failed to get player: " + e.getMessage()));
            return 0; // Return failure
        }
        ServerLevel level = source.getLevel(); // Corrected to use CommandSourceStack's getLevel() method

        // Calculate spawn position (1 block in front of the player)
        Vec3 lookDirection = player.getLookAngle();
        BlockPos spawnPos = BlockPos.containing(player.getX() + lookDirection.x, player.getY(), player.getZ() + lookDirection.z);

        // Spawn the ShopkeeperEntity
        ShopkeeperEntity shopkeeper = new ShopkeeperEntity(ShopkeeperEntity.SHOPKEEPER, level);
        shopkeeper.setPos(spawnPos.getX() + 0.5, spawnPos.getY(), spawnPos.getZ() + 0.5);
        shopkeeper.setYRot(player.getYRot()); // Face the player
        level.addFreshEntity(shopkeeper);

        source.sendSuccess(() -> net.minecraft.network.chat.Component.literal("Shopkeeper spawned!"), true);
        return Command.SINGLE_SUCCESS;
    }
}
