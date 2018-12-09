package com.locydragon.myinv.listeners.editor;

import com.locydragon.myinv.api.FrameMenu;
import com.locydragon.myinv.api.Menu;
import com.locydragon.myinv.core.EditorStacks;
import com.locydragon.myinv.core.MenuStacks;
import com.locydragon.myinv.core.data.Editor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;

public class EditorListener implements Listener {
	@EventHandler
	public void onBeingKicked(PlayerKickEvent e) {
		if (EditorStacks.editorHashMap.containsKey(e.getPlayer())) {
			EditorStacks.editorHashMap.remove(e.getPlayer());
		}
	}

	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		if (EditorStacks.editorHashMap.containsKey(e.getPlayer())) {
			EditorStacks.editorHashMap.remove(e.getPlayer());
		}
	}

	@EventHandler
	public void onClose(InventoryCloseEvent e) {
		if (EditorStacks.editorHashMap.containsKey(e.getPlayer())) {
			Inventory inventory = e.getInventory();
			Editor editor = EditorStacks.editorHashMap.get(e.getPlayer());
			EditorStacks.editorHashMap.remove(e.getPlayer());
			Menu targetMenu = editor.menu;
			int index = editor.index;
			FrameMenu frameMenu = new FrameMenu(targetMenu);
			frameMenu.setInventory(inventory);
			targetMenu.insertFrame(index, frameMenu);
			targetMenu.save();
			MenuStacks.insert(targetMenu);
			e.getPlayer().sendMessage("§3[MyInventory] §e保存完成了...");
		}
	}
}
