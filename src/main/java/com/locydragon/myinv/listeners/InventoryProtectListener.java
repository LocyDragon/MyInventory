package com.locydragon.myinv.listeners;

import com.locydragon.myinv.api.AnimatedFramePlayer;
import com.locydragon.myinv.core.audio.AudioPlayerOut;
import com.locydragon.myinv.core.script.SlotScript;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class InventoryProtectListener implements Listener {
	@EventHandler
	public void onPlayerClose(InventoryCloseEvent e) {
		SlotScript.waitingQueue.remove(e.getPlayer().getName().toUpperCase());
		if (AnimatedFramePlayer.playerList.containsKey(e.getPlayer())) {
			AnimatedFramePlayer.playerList.get(e.getPlayer()).cancel();
			AnimatedFramePlayer.playerList.remove(e.getPlayer());
			AnimatedFramePlayer.openMenuTarget.remove(e.getPlayer());
			AudioPlayerOut.stop((Player) e.getPlayer());
		}
	}

	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		if (AnimatedFramePlayer.playerList.containsKey(e.getPlayer())) {
			AnimatedFramePlayer.playerList.get(e.getPlayer()).cancel();
			AnimatedFramePlayer.playerList.remove(e.getPlayer());
			AnimatedFramePlayer.openMenuTarget.remove(e.getPlayer());
		}
	}

	@EventHandler
	public void onBeingKicked(PlayerKickEvent e) {
		if (AnimatedFramePlayer.playerList.containsKey(e.getPlayer())) {
			AnimatedFramePlayer.playerList.get(e.getPlayer()).cancel();
			AnimatedFramePlayer.playerList.remove(e.getPlayer());
			AnimatedFramePlayer.openMenuTarget.remove(e.getPlayer());
		}
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		if (AnimatedFramePlayer.playerList.containsKey(e.getPlayer())) {
			AnimatedFramePlayer.playerList.get(e.getPlayer()).cancel();
			AnimatedFramePlayer.playerList.remove(e.getPlayer());
			AnimatedFramePlayer.openMenuTarget.remove(e.getPlayer());
		}
		if (AnimatedFramePlayer.openMenuTarget.containsKey(e.getPlayer())) {
			AnimatedFramePlayer.openMenuTarget.remove(e.getPlayer());
		}
	}
}
