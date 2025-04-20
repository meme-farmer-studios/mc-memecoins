
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.memefarmerstudios.memeconomy.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.memefarmerstudios.memeconomy.MemeconomyMod;

public class MemeconomyModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MemeconomyMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MEMECONOMY = REGISTRY.register("memeconomy",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.memeconomy.memeconomy")).icon(() -> new ItemStack(MemeconomyModItems.MEMECOIN.get())).displayItems((parameters, tabData) -> {
				tabData.accept(MemeconomyModItems.MEMECOIN.get());
				tabData.accept(MemeconomyModBlocks.MEMESHOP.get().asItem());
			}).build());
}
