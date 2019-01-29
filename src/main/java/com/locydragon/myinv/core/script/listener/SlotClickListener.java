package com.locydragon.myinv.core.script.listener;

import com.locydragon.myinv.api.MyInventoryAPI;
import com.locydragon.myinv.core.script.SlotScript;
import com.locydragon.myinv.core.script.ache.SlotScriptAche;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class SlotClickListener implements Listener {
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		if (e.getSlot() > e.getInventory().getSize() || e.getSlot() < 0) {
			return;
		}
		if (MyInventoryAPI.isOpening((Player)e.getWhoClicked())
				&& (e.getInventory().getItem(e.getSlot()) != null &&
				e.getInventory().getItem(e.getSlot()).getType() != Material.AIR)) {
			String menuName = MyInventoryAPI.getMenuOpening((Player)e.getWhoClicked()).getMenuName();
			SlotScript targetScript = SlotScriptAche.searchScript(menuName, e.getSlot());
			if (targetScript != null) {
				if (targetScript.action != null && targetScript.action.equalsIgnoreCase(e.getClick().toString())) {
					targetScript.run((Player) e.getWhoClicked(), e.getSlot());
				} else if (targetScript.action == null) {
					targetScript.run((Player) e.getWhoClicked(), e.getSlot());
				}
			}
		}
	}
}
