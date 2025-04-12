package com.memefarmerstudios.memecoins.blocks;

import com.memefarmerstudios.memecoins.memecoins;
import com.mojang.datafixers.DSL; // Import DSL
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

public class BlockRegistry {

    // Create the DeferredRegister for Blocks
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, memecoins.MODID);

    // Create the DeferredRegister for BlockEntityTypes
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, memecoins.MODID);

    // Register the MemeShopBlock
    public static final DeferredHolder<Block, MemeShopBlock> MEME_SHOP_BLOCK =
            BLOCKS.register("meme_shop_block", MemeShopBlock::new);

    // Register the MemeShopBlockEntity Type
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<MemeShopBlockEntity>> MEME_SHOP_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("meme_shop_block_entity", () ->
                    // Pass DSL.remainderType() instead of null
                    BlockEntityType.Builder.of(MemeShopBlockEntity::new, MEME_SHOP_BLOCK.get()).build(DSL.remainderType()));

    // Method to register the blocks and block entities with the event bus
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        BLOCK_ENTITIES.register(eventBus); // Register block entities
    }
}
