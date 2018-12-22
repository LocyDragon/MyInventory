package com.locydragon.myinv.util;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.regex.Pattern;

/** @author LocyDragon
 *
 */
public class ItemStackUtil {
	public static boolean isEmpty(ItemStack item) {
		return item == null || item.getType() == Material.AIR;
	}

	public static boolean equals(ItemStack one, ItemStack two) {
		return one.getType() == two.getType() && one.getAmount() == two.getAmount() && one.getItemMeta().equals(two.getItemMeta())
				&& one.getDurability() == two.getDurability();
	}

	public static boolean isInteger(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		return pattern.matcher(str).matches();
	}

	public static boolean isDouble(String str) {
		try {
			Double.valueOf(str);
			return true;
		} catch (Exception exc) {
			return false;
		}
	}
}
