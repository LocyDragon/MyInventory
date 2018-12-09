package com.locydragon.myinv.api;

import com.locydragon.myinv.MyInventory;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.InventoryView;
import org.bukkit.scheduler.BukkitTask;
import java.util.HashMap;

public class AnimatedFramePlayer {
	public static HashMap<Player,BukkitTask> playerList = new HashMap<>();
	public static void playFor(Player who, Menu menu) {
		if (menu.getFramesSize() <= 0) {
			who.openInventory(Bukkit.createInventory(null, menu.getSize(), menu.getTitle()));
		} else if (menu.getFramesSize() == 1) {
			who.openInventory(menu.getFrame(0).getInventory());
		} else {
			BukkitTask task = Bukkit.getScheduler().runTaskTimer(MyInventory.getInstance(), () -> {
				InventoryView view = null;
				FrameMenu extended = menu.getExtended();
				FrameMenu next = menu.nextFrame();
				if (extended == null) {
					view = who.openInventory(next.getInventory());
				} else {
					next.findDifferenceAndSet(view);
					who.updateInventory();
				}
			},0L, (long)(MyInventory.period * 20));
			playerList.put(who, task);
		}
	}
}
