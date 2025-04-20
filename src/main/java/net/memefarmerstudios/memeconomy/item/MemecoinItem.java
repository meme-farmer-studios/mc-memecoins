
package net.memefarmerstudios.memeconomy.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class MemecoinItem extends Item {
	public MemecoinItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
