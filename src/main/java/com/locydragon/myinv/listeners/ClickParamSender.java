package com.locydragon.myinv.listeners;

import com.locydragon.myinv.api.AnimatedFramePlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ClickParamSender implements Listener {
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		if (AnimatedFramePlayer.playerList.containsKey(e.getWhoClicked())
				|| AnimatedFramePlayer.openMenuTarget.containsKey(e.getWhoClicked())) {
			e.setCancelled(true);
		}
	}
}
