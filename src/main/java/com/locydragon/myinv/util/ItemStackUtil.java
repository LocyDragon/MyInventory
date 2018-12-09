package com.locydragon.myinv.util;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

/** @author LocyDragon
 *
 */
public class ItemStackUtil {
	public static boolean isEmpty(ItemStack item) {
		return item == null || item.getType() == Material.AIR || !item.hasItemMeta();
	}

	public static boolean equals(ItemStack one, ItemStack two) {
		return one.isSimilar(two) && one.getAmount() == two.getAmount();
	}
}
