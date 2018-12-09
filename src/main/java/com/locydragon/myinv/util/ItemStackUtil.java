package com.locydragon.myinv.util;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.regex.Pattern;

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

	public static boolean isInteger(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		return pattern.matcher(str).matches();
	}
}
