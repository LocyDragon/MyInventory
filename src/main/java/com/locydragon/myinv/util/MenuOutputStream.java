package com.locydragon.myinv.util;

import com.locydragon.myinv.api.FrameMenu;
import com.locydragon.myinv.api.Menu;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.Inventory;

import java.io.File;
import java.io.IOException;

/**
 * @author LocyDragon
 */
public class MenuOutputStream {
	public static final String TITLE_PATH = "Output.Title";
	public static final String SIZE_PATH = "Output.Size";
	public static final String FRAME = "FRAME_";
	public static void saveTo(FileConfiguration configuration, Menu menu, File targetFile) {
		configuration.set(TITLE_PATH, menu.getTitle());
		configuration.set(SIZE_PATH, menu.getSize());
		for (int i = 0;i < menu.getFramesSize();i++) {
			FrameMenu frameMenu = menu.getFrame(i);
			configuration.set(FRAME + i + ".Exist", true);
			InventorySerialization.serialization(configuration, frameMenu.getInventory(), FRAME + i);
		}
		try {
			configuration.save(targetFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Menu load(FileConfiguration config, String name) {
		Menu menu = new Menu(config.getString(TITLE_PATH), config.getInt(SIZE_PATH), name);
		for (int i = 0;i < Integer.MAX_VALUE;i++) {
			if (!config.getBoolean(FRAME + i + ".Exist", false)) {
				break;
			}
			FrameMenu frameMenu = new FrameMenu(menu);
			Inventory targetInventory = InventorySerialization.deSerialization(config, FRAME + i, menu.getSize(), menu.getTitle());
			frameMenu.setInventory(targetInventory);
			menu.addFrame(frameMenu);
		}
		return menu;
	}
}


