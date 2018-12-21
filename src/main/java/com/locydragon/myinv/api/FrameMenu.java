package com.locydragon.myinv.api;

import com.locydragon.myinv.MyInventory;
import com.locydragon.myinv.reflectasm.PlaceHolderReflector;
import com.locydragon.myinv.util.ItemStackUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * @author LocyDragon
 */
public class FrameMenu implements Serializable {
	private UUID uuid = UUID.randomUUID();
	private Inventory menu;
	private static final ItemStack NULL_ITEM = new ItemStack(Material.AIR);
	public FrameMenu(Menu father) {
		menu = Bukkit.createInventory(null, father.getSize(), father.getTitle());
	}

	public void setItem(int slot, ItemStack item) {
		menu.setItem(slot, item);
	}

	public Inventory getInventory() { return this.menu; }

	public void setInventory(Inventory inv) {
		for (int i = 0;i < inv.getSize();i++) {
			if (inv.getItem(i) == null || inv.getItem(i).getType() == Material.AIR) {
				continue;
			}
			this.menu.setItem(i, inv.getItem(i));
		}
	}

	public void findDifferenceAndSet(InventoryView beforeView, Player opener) {
		Inventory before = beforeView.getTopInventory();
		if (before.getSize() != this.menu.getSize()) {
			throw new IllegalArgumentException("Illegal Inventory param!");
		}
		for (int i = 0;i < before.getSize();i++) {
			ItemStack menuItem = menu.getItem(i);
			ItemStack beforeItem = before.getItem(i);
			itemLorePlaceHolder(menuItem, opener);
			if (ItemStackUtil.isEmpty(menuItem) && ItemStackUtil.isEmpty(beforeItem)) {
				continue;
			}
			if (ItemStackUtil.isEmpty(beforeItem) && !ItemStackUtil.isEmpty(menuItem)) {
				beforeView.setItem(i, menuItem);
			} else if (!ItemStackUtil.isEmpty(beforeItem) && ItemStackUtil.isEmpty(menuItem)) {
				beforeView.setItem(i, NULL_ITEM);
			} else if (!ItemStackUtil.equals(beforeItem, menuItem)) {
				beforeView.setItem(i, menuItem);
			}
		}
	}

	private void itemLorePlaceHolder(ItemStack targetItem, Player who) {
		if (!MyInventory.usePAPI) {
			return;
		}
		if (targetItem == null || !targetItem.hasItemMeta() || !targetItem.getItemMeta().hasLore()) {
			return;
		}
		ItemMeta meta = targetItem.getItemMeta();
		List<String> newLore = new ArrayList<>();
		for (String lore : meta.getLore()) {
			if (lore.contains("%")) {
				lore = PlaceHolderReflector.invoke(who, lore);
			}
			newLore.add(lore);
		}
		meta.setLore(newLore);
		targetItem.setItemMeta(meta);
	}
}
