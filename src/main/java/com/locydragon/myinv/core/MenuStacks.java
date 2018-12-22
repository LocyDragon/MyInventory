package com.locydragon.myinv.core;

import com.locydragon.myinv.api.Menu;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author LocyDragon
 */
public class MenuStacks {
	private static HashMap<String,Menu> menuMap = new HashMap<>();
	public static void load() {
		File settingsFile = new File(".//plugins//MyInventory//Gui//");
		if (settingsFile.exists()) {
			for (File listFile : settingsFile.listFiles()) {
				if (listFile.getName().endsWith(".yml")) {
					String menuName = listFile.getName().split("\\.")[0];
					menuMap.put(menuName, Menu.forName(menuName));
				}
			}
		}
	}

	public static Menu getMenuCloned(String menuName) {
		Menu clonedBefore = menuMap.get(menuName);
		if (clonedBefore == null) {
			return null;
		}
		return menuMap.get(menuName).deepClone();
	}

	public static void insert(Menu menu) {
		menuMap.put(menu.getMenuName(), menu);
	}

	public static List<String> menuList() {
		return new ArrayList<>(menuMap.keySet());
	}
}
