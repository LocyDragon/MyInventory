package com.locydragon.myinv.api;

import com.locydragon.myinv.util.ItemStackUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;


/**
 * @author LocyDragon
 */
public class FrameMenu {
	private Menu father;
	private Inventory menu;
	private static final ItemStack NULL_ITEM = new ItemStack(Material.AIR);
	public FrameMenu(Menu father) {
		this.father = father;
		menu = Bukkit.createInventory(null, father.getSize(), father.getTitle());
	}

	public void setItem(int slot, ItemStack item) {
		menu.setItem(slot, item);
	}

	public Inventory getInventory() { return this.menu; }

	public void setInventory(Inventory inv) { this.menu = inv; }

	public void findDifferenceAndSet(InventoryView beforeView) {
		Inventory before = beforeView.getTopInventory();
		if (before.getSize() != this.menu.getSize()) {
			throw new IllegalArgumentException("Illegal Inventory param!");
		}
		for (int i = 0;i < before.getSize();i++) {
			ItemStack menuItem = menu.getItem(i);
			ItemStack beforeItem = before.getItem(i);
			if (ItemStackUtil.isEmpty(menuItem) && ItemStackUtil.isEmpty(beforeItem)) {
				continue;
			}
			if (ItemStackUtil.isEmpty(beforeItem) && !ItemStackUtil.isEmpty(menuItem)) {
				before.setItem(i, menuItem);
			} else if (!ItemStackUtil.isEmpty(beforeItem) && ItemStackUtil.isEmpty(menuItem)) {
				before.setItem(i, NULL_ITEM);
			} else if (!ItemStackUtil.equals(beforeItem, menuItem)) {
				before.setItem(i, menuItem);
			}
		}
	}
}
