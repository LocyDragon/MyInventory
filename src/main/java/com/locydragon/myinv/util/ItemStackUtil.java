package com.locydragon.myinv.util;

import com.locydragon.myinv.MaterialControl;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.regex.Pattern;

/** @author LocyDragon
 *
 */
public class ItemStackUtil {
	public static final ItemStack AIR = new ItemStack(Material.AIR);
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

	public static int itemAmountInInventory(String itemName, Inventory target) {
		itemName = ChatColor.translateAlternateColorCodes('&', itemName);
		int amount = 0;
		for (ItemStack item : target) {
			if (item != null && item.hasItemMeta() && item.getItemMeta().hasDisplayName()) {
				if (item.getItemMeta().getDisplayName().equals(itemName)) {
					amount += item.getAmount();
				}
			}
		}
		return amount;
	}

	public static boolean take(String itemName, Inventory target, int takeAmount) {
		itemName = ChatColor.translateAlternateColorCodes('&', itemName);
		if (takeAmount > itemAmountInInventory(itemName, target)) {
			return false;
		}
		for (int slot = 0;slot < target.getSize();slot++) {
			ItemStack slotItem = target.getItem(slot);
			if (slotItem != null && slotItem.hasItemMeta() && slotItem.getItemMeta().hasDisplayName()
					&& slotItem.getItemMeta().getDisplayName().equals(itemName)) {
				if (takeAmount - slotItem.getAmount() <= 0) {
					slotItem.setAmount(slotItem.getAmount() - takeAmount);
					target.setItem(slot, slotItem);
					break;
				} else {
					takeAmount -= slotItem.getAmount();
					target.setItem(slot, AIR);
				}
			}
		}
		return true;
	}

	public static int itemAmountInInventoryByID(String itemID, Inventory target) {
		Material targetMaterial = MaterialControl.fromString(itemID).parseMaterial();
		int amount = 0;
		for (ItemStack item : target) {
			if (item != null && item.hasItemMeta() && item.getItemMeta().hasDisplayName()) {
				if (item.getType() == targetMaterial || item.getType().equals(targetMaterial)) {
					amount += item.getAmount();
				}
			}
		}
		return amount;
	}

	public static boolean takeByName(String itemID, Inventory target, int amount) {
		Material targetMaterial = MaterialControl.fromString(itemID).parseMaterial();
		if (amount > itemAmountInInventoryByID(itemID, target)) {
			return false;
		}
		for (int slot = 0;slot < target.getSize();slot++) {
			ItemStack slotItem = target.getItem(slot);
			if (slotItem != null && (slotItem.getType() == targetMaterial || slotItem.getType()
					.equals(targetMaterial))) {
				if (amount - slotItem.getAmount() <= 0) {
					slotItem.setAmount(slotItem.getAmount() - amount);
					target.setItem(slot, slotItem);
					break;
				} else {
					amount -= slotItem.getAmount();
					target.setItem(slot, AIR);
				}
			}
		}
		return true;
	}
}
