package com.locydragon.myinv.util;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventorySerialization {
	public static void serialization(FileConfiguration config, Inventory inventory, String head) {
		for (int i = 0;i < inventory.getSize();i++) {
			ItemStack targetItem = inventory.getItem(i);
			if (targetItem != null) {
				config.set(head + "." + i, targetItem);
			}
		}
	}

	public static Inventory deSerialization(FileConfiguration config, String head, int size, String title) {
		Inventory inventory = Bukkit.createInventory(null, size, title);
		for (int i = 0;i < inventory.getSize();i++) {
			ItemStack targetItem = config.getItemStack(head + "." + i, new ItemStack(Material.AIR));
			inventory.setItem(i, targetItem);
		}
		return inventory;
	}

	public static Inventory cloneInventory(Inventory target) {
		Inventory inv = Bukkit.createInventory(null, target.getSize(), target.getTitle());
		for (int i = 0;i < target.getSize();i++) {
			if (target.getItem(i) != null && target.getItem(i).getType() != Material.AIR) {
				inv.setItem(i, target.getItem(i));
			}
		}
		return inv;
	}
}