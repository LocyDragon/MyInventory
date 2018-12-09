package com.locydragon.myinv.listeners;

import com.locydragon.myinv.api.AnimatedFramePlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class InventoryProtectListener implements Listener {
	@EventHandler
	public void onPlayerClose(InventoryCloseEvent e) {
		if (AnimatedFramePlayer.playerList.containsKey(e.getPlayer())) {
			AnimatedFramePlayer.playerList.get(e.getPlayer()).cancel();
			AnimatedFramePlayer.playerList.remove(e.getPlayer());
		}
	}

	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		if (AnimatedFramePlayer.playerList.containsKey(e.getPlayer())) {
			AnimatedFramePlayer.playerList.get(e.getPlayer()).cancel();
			AnimatedFramePlayer.playerList.remove(e.getPlayer());
		}
	}

	@EventHandler
	public void onBeingKicked(PlayerKickEvent e) {
		if (AnimatedFramePlayer.playerList.containsKey(e.getPlayer())) {
			AnimatedFramePlayer.playerList.get(e.getPlayer()).cancel();
			AnimatedFramePlayer.playerList.remove(e.getPlayer());
		}
	}
}