package com.locydragon.myinv;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

/**
 * @author LocyDragon
 */
public class MyInventory extends JavaPlugin {
	private static MyInventory instance;
	public static FileConfiguration config;

	@Override
	public void onEnable() { //当插件被加载时
		Main.registerCommands();
		Main.infoMessage();
		MyInventory.getInstance().saveDefaultConfig();
		config = MyInventory.getInstance().getConfig();
		instance = this;
		//我 赋 值 我 自 己
	}

	public static MyInventory getInstance() { //获取实例对象
		return instance;
	}

	public static FileConfiguration getSettings() {
		return config;
	}

	public static void saveConfiguration() {
		try {
			config.save(new File(".//plugins//MyInventory//config.yml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
