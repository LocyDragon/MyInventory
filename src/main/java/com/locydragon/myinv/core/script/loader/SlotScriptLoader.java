package com.locydragon.myinv.core.script.loader;

import com.locydragon.myinv.api.MyInventoryAPI;
import com.locydragon.myinv.core.script.SlotScript;
import com.locydragon.myinv.core.script.ache.SlotLabel;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import java.util.HashMap;
import java.util.List;

public class SlotScriptLoader {
	protected static final String MENU_PATH = ".linkToMenu";
	protected static final String SLOT_PATH = ".location";
	protected static final String SCRIPT_PATH = ".script";
	public static HashMap<SlotLabel,SlotScript> loadByFile(File input) {
		HashMap<SlotLabel,SlotScript> mapLoaded = new HashMap<>();
		FileConfiguration config = YamlConfiguration.loadConfiguration(input);
		for (String key : config.getKeys(false)) {
			String menuName = config.getString(key + MENU_PATH, null);
			int slot = config.getInt(key + SLOT_PATH, -1);
			List<String> scripts = config.getStringList(key + SCRIPT_PATH);
			if (menuName == null || !MyInventoryAPI.hasMenu(menuName)) {
				continue;
			}
			if (slot == -1) {
				continue;
			}
			SlotLabel label = new SlotLabel(slot, menuName);
			SlotScript script = new SlotScript(slot, MyInventoryAPI.getMenu(menuName), scripts);
			mapLoaded.put(label, script);
		}
		return mapLoaded;
	}
}
