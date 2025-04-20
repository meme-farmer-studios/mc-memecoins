
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.memefarmerstudios.memeconomy.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.memefarmerstudios.memeconomy.item.MemecoinItem;
import net.memefarmerstudios.memeconomy.MemeconomyMod;

public class MemeconomyModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(MemeconomyMod.MODID);
	public static final DeferredItem<Item> MEMECOIN = REGISTRY.register("memecoin", MemecoinItem::new);
	public static final DeferredItem<Item> MEMESHOP = block(MemeconomyModBlocks.MEMESHOP);

	// Start of user code block custom items
	// End of user code block custom items
	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
