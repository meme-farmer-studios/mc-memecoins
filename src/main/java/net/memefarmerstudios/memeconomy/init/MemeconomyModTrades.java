/*
*	MCreator note: This file will be REGENERATED on each build.
*/
package net.memefarmerstudios.memeconomy.init;

import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.common.BasicItemListing;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;

@EventBusSubscriber
public class MemeconomyModTrades {
	@SubscribeEvent
	public static void registerTrades(VillagerTradesEvent event) {
		if (event.getType() == MemeconomyModVillagerProfessions.MEMECONOMYTRADER.get()) {
			// TIER 1 - Selling items for memecoins (player sells items to get memecoins)
			// Basic resources
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.DIRT, 64), new ItemStack(MemeconomyModItems.MEMECOIN.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.OAK_LOG, 16), new ItemStack(MemeconomyModItems.MEMECOIN.get(), 2), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.COAL, 8), new ItemStack(MemeconomyModItems.MEMECOIN.get(), 2), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.ROTTEN_FLESH, 64), new ItemStack(MemeconomyModItems.MEMECOIN.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.SUGAR_CANE, 32), new ItemStack(MemeconomyModItems.MEMECOIN.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.BAMBOO, 64), new ItemStack(MemeconomyModItems.MEMECOIN.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.POTATO, 32), new ItemStack(MemeconomyModItems.MEMECOIN.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.BAKED_POTATO, 32), new ItemStack(MemeconomyModItems.MEMECOIN.get()), 10, 5, 0.05f));

			// TIER 2 - Selling items for memecoins
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.REDSTONE, 16), new ItemStack(MemeconomyModItems.MEMECOIN.get(), 2), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.LAPIS_LAZULI, 8), new ItemStack(MemeconomyModItems.MEMECOIN.get(), 2), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.BREAD, 8), new ItemStack(MemeconomyModItems.MEMECOIN.get(), 2), 10, 5, 0.05f));

			// TIER 3 - Selling items for memecoins
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.IRON_INGOT, 4), new ItemStack(MemeconomyModItems.MEMECOIN.get(), 3), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.COOKED_BEEF, 4), new ItemStack(MemeconomyModItems.MEMECOIN.get(), 3), 10, 5, 0.05f));

			// TIER 4 - Selling items for memecoins
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.GOLD_INGOT, 4), new ItemStack(MemeconomyModItems.MEMECOIN.get(), 4), 10, 5, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 1), new ItemStack(MemeconomyModItems.MEMECOIN.get(), 5), 10, 5, 0.05f));
			
			// TIER 5 - Selling items for memecoins
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.DIAMOND, 1), new ItemStack(MemeconomyModItems.MEMECOIN.get(), 6), 10, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.NETHERITE_SCRAP, 1), new ItemStack(MemeconomyModItems.MEMECOIN.get(), 10), 4, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.GHAST_TEAR, 1), new ItemStack(MemeconomyModItems.MEMECOIN.get(), 8), 5, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.END_CRYSTAL, 1), new ItemStack(MemeconomyModItems.MEMECOIN.get(), 15), 2, 5, 0.05f));

			// REVERSE TRADES - Buying items with memecoins (player buys items using memecoins)
			// TIER 1 - Basic resources
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MemeconomyModItems.MEMECOIN.get(), 5), new ItemStack(Items.DIRT, 64), 10, 5, 0.1f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MemeconomyModItems.MEMECOIN.get(), 6), new ItemStack(Items.OAK_LOG, 16), 10, 5, 0.1f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MemeconomyModItems.MEMECOIN.get(), 6), new ItemStack(Items.COAL, 8), 10, 5, 0.1f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MemeconomyModItems.MEMECOIN.get(), 5), new ItemStack(Items.ROTTEN_FLESH, 64), 10, 5, 0.1f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MemeconomyModItems.MEMECOIN.get(), 4), new ItemStack(Items.SUGAR_CANE, 32), 10, 5, 0.1f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MemeconomyModItems.MEMECOIN.get(), 4), new ItemStack(Items.BAMBOO, 64), 10, 5, 0.1f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MemeconomyModItems.MEMECOIN.get(), 4), new ItemStack(Items.POTATO, 32), 10, 5, 0.1f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MemeconomyModItems.MEMECOIN.get(), 5), new ItemStack(Items.BAKED_POTATO, 32), 10, 5, 0.1f));

			// TIER 2 - Reverse trades
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(MemeconomyModItems.MEMECOIN.get(), 6), new ItemStack(Items.REDSTONE, 16), 10, 5, 0.1f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(MemeconomyModItems.MEMECOIN.get(), 6), new ItemStack(Items.LAPIS_LAZULI, 8), 10, 5, 0.1f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(MemeconomyModItems.MEMECOIN.get(), 6), new ItemStack(Items.BREAD, 8), 10, 5, 0.1f));

			// TIER 3 - Reverse trades
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(MemeconomyModItems.MEMECOIN.get(), 7), new ItemStack(Items.IRON_INGOT, 4), 10, 5, 0.1f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(MemeconomyModItems.MEMECOIN.get(), 7), new ItemStack(Items.COOKED_BEEF, 4), 10, 5, 0.1f));

			// TIER 4 - Reverse trades
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(MemeconomyModItems.MEMECOIN.get(), 8), new ItemStack(Items.GOLD_INGOT, 4), 10, 5, 0.1f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(MemeconomyModItems.MEMECOIN.get(), 9), new ItemStack(Items.EMERALD, 1), 10, 5, 0.1f));
			
			// TIER 5 - Reverse trades
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(MemeconomyModItems.MEMECOIN.get(), 10), new ItemStack(Items.DIAMOND, 1), 10, 5, 0.1f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(MemeconomyModItems.MEMECOIN.get(), 15), new ItemStack(Items.NETHERITE_SCRAP, 1), 4, 5, 0.1f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(MemeconomyModItems.MEMECOIN.get(), 12), new ItemStack(Items.GHAST_TEAR, 1), 5, 5, 0.1f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(MemeconomyModItems.MEMECOIN.get(), 19), new ItemStack(Items.END_CRYSTAL, 1), 2, 5, 0.1f));
		}
	}
}
