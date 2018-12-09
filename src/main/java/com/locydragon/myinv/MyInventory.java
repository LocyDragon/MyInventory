package com.locydragon.myinv;

import com.locydragon.myinv.core.MenuStacks;
import com.locydragon.myinv.invcommand.SubCommandBasic;
import com.locydragon.myinv.invcommand.subcmd.CommandCreateInventory;
import com.locydragon.myinv.invcommand.subcmd.CommandFramesInventory;
import com.locydragon.myinv.listeners.ClickParamSender;
import com.locydragon.myinv.listeners.InventoryProtectListener;
import com.locydragon.myinv.listeners.editor.EditorListener;
import org.bukkit.Bukkit;
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
	public static Double period = 0.5;

	@Override
	public void onEnable() { //当插件被加载时
		Main.registerCommands();
		Main.infoMessage();
		MyInventory.getInstance().saveDefaultConfig();
		config = MyInventory.getInstance().getConfig();
		instance = this;
		period = MyInventory.getSettings().getDouble("period");
		Bukkit.getPluginManager().registerEvents(new InventoryProtectListener(), this);
		Bukkit.getPluginManager().registerEvents(new ClickParamSender(), this);
		Bukkit.getPluginManager().registerEvents(new EditorListener(), this);
		getLogger().info("加载界面中...");
		MenuStacks.load();
		getLogger().info("加载完成了!");
		SubCommandBasic.addListener(new CommandCreateInventory());
		SubCommandBasic.addListener(new CommandFramesInventory());
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
