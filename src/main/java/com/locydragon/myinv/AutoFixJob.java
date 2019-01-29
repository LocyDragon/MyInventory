package com.locydragon.myinv;

import com.locydragon.myinv.api.MyInventoryAPI;
import com.locydragon.myinv.core.script.SlotScript;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class AutoFixJob extends BukkitRunnable{
	@Override
	public void run() {
		for (Player player : Bukkit.getOnlinePlayers()) {
			if (MyInventoryAPI.getMenuOpening(player) == null && SlotScript.waitingQueue
					.contains(player.getName().toUpperCase())) {
				SlotScript.waitingQueue.remove(player.getName().toUpperCase());
			}
		}
	}
}
