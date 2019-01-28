package com.locydragon.myinv.core.script.loader;

import com.locydragon.myinv.core.script.SlotScript;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class SlotScriptSaver {
	public static void saveTo(File yaml, SlotScript script) {
		FileConfiguration config = YamlConfiguration.loadConfiguration(yaml);
		String key = "Slot" + script.getSlot();
		config.set(key + SlotScriptLoader.SLOT_PATH, script.getScripts());
		config.set(key + SlotScriptLoader.MENU_PATH, script.getMenuName());
		config.set(key + SlotScriptLoader.SCRIPT_PATH, script.getScripts());
		config.set(key + SlotScriptLoader.OUT_PATH, script.out);
		config.set(key + SlotScriptLoader.ACTION, script.action);
		try {
			config.save(yaml);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
