package com.locydragon.myinv.core.script.listener;

import com.locydragon.myinv.api.MyInventoryAPI;
import com.locydragon.myinv.core.script.SlotScript;
import com.locydragon.myinv.core.script.ache.SlotScriptAche;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class SlotClickListener implements Listener {
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		if (MyInventoryAPI.isOpening((Player)e.getWhoClicked())) {
			String menuName = MyInventoryAPI.getMenuOpening((Player)e.getWhoClicked()).getMenuName();
			SlotScript targetScript = SlotScriptAche.searchScript(menuName, e.getSlot());
			if (targetScript != null) {
				targetScript.run((Player)e.getWhoClicked(), e.getSlot());
			}
		}
	}
}
