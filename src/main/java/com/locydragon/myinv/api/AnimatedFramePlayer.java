package com.locydragon.myinv.api;

import com.locydragon.myinv.MyInventory;
import com.locydragon.myinv.api.events.MenuOpenEvent;
import com.locydragon.myinv.core.audio.AudioPlayerOut;
import com.locydragon.myinv.util.InventorySerialization;
import com.locydragon.myinv.util.VolatileMap;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

public class AnimatedFramePlayer {
	public static volatile VolatileMap<Player,BukkitTask> playerList = new VolatileMap<>();
	public static volatile VolatileMap<Player,Menu> openMenuTarget = new VolatileMap<>();
	public static void playFor(Player who, Menu menu) {
		Bukkit.getPluginManager().callEvent(new MenuOpenEvent(who, menu));
		if (menu.hasMusic()) {
			AudioPlayerOut.playFor(who, menu.getMusicName());
		}
		openMenuTarget.put(who, menu);
		if (menu.getFramesSize() <= 0) {
			who.openInventory(Bukkit.createInventory(null, menu.getSize(), menu.getTitle()));
		} else if (menu.getFramesSize() == 1) {
			who.openInventory(menu.getFrame(0).getInventory());
		} else {
			BukkitTask task = Bukkit.getScheduler().runTaskTimer(MyInventory.getInstance(), () -> {
				FrameMenu extended = menu.getExtended();
				FrameMenu next = menu.nextFrame();
				if (extended == null) {
					who.openInventory(InventorySerialization.cloneInventory(next.getInventory()));
				} else {
					next.findDifferenceAndSet(who.getOpenInventory(), who);
					who.updateInventory();
				}
				openMenuTarget.replace(who, menu);
			},0L, (long)(menu.getPeriod() * 20));
			AnimatedFramePlayer.playerList.put(who, task);
		}
	}
}
