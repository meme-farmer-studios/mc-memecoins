
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.memefarmerstudios.memeconomy.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import net.memefarmerstudios.memeconomy.block.MemeshopBlock;
import net.memefarmerstudios.memeconomy.MemeconomyMod;

public class MemeconomyModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(MemeconomyMod.MODID);
	public static final DeferredBlock<Block> MEMESHOP = REGISTRY.register("memeshop", MemeshopBlock::new);
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
