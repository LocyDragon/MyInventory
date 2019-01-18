package com.locydragon.myinv;


import com.locydragon.myinv.core.MenuStacks;
import com.locydragon.myinv.core.script.SlotScript;
import com.locydragon.myinv.core.script.ache.SlotLabel;
import com.locydragon.myinv.core.script.ache.SlotScriptAche;
import com.locydragon.myinv.core.script.listener.SlotClickListener;
import com.locydragon.myinv.core.script.loader.SlotScriptLoader;
import com.locydragon.myinv.invcommand.SubCommandBasic;
import com.locydragon.myinv.invcommand.subcmd.*;
import com.locydragon.myinv.listeners.ClickParamSender;
import com.locydragon.myinv.listeners.InventoryProtectListener;
import com.locydragon.myinv.listeners.editor.EditorListener;
import com.locydragon.myinv.metrics.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author LocyDragon
 */
public class MyInventory extends JavaPlugin {
	private static MyInventory instance;
	public static FileConfiguration config;
	public static Double period = 0.5;
	public static boolean useAudioBuffer = false;
	public static boolean usePAPI = false;

	@Override
	public void onLoad() {
		getLogger().info(">> 欢迎使用,MyInventory!");
		getLogger().info(">> 祝您使用愉快!");
	}

	@Override
	public void onEnable() {
		instance = this;
		Main.registerCommands();
		Main.infoMessage();
		MyInventory.getInstance().saveDefaultConfig();
		config = MyInventory.getInstance().getConfig();
		period = MyInventory.getSettings().getDouble("period");
		Bukkit.getPluginManager().registerEvents(new InventoryProtectListener(), this);
		Bukkit.getPluginManager().registerEvents(new ClickParamSender(), this);
		Bukkit.getPluginManager().registerEvents(new EditorListener(), this);
		Bukkit.getPluginManager().registerEvents(new SlotClickListener(), this);
		getLogger().info(">> 加载界面中...");
		MenuStacks.load();
		loadScripts();
		getLogger().info(">> 加载完成了!");
		SubCommandBasic.addListener(new CommandCreateInventory());
		SubCommandBasic.addListener(new CommandFramesInventory());
		SubCommandBasic.addListener(new CommandOpenInventory());
		SubCommandBasic.addListener(new CommandBackMusicInventory());
		SubCommandBasic.addListener(new CommandListInventory());
		SubCommandBasic.addListener(new CommandInventoryInfoInventory());
		SubCommandBasic.addListener(new CommandSetPeriodInventory());
		SubCommandBasic.addListener(new CommandLoopInventory());
		new Metrics(this);
		useAudioBuffer = Bukkit.getPluginManager().getPlugin("AudioBuffer") != null;
		if (useAudioBuffer) {
			getLogger().info(">> 已经和 AudioBuffer 插件挂钩了.");
		} else {
			getLogger().info(">> 音乐插件: AudioBuffer 不存在 挂钩失败.");
		}
		usePAPI = Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null;
		if (usePAPI) {
			getLogger().info(">> 已经和 PlaceholderAPI 插件挂钩了.");
		} else {
			getLogger().info(">> 变量插件: PlaceholderAPI 不存在 挂钩失败.");
		}
	}

	@Override
	public void onDisable() {
		getLogger().info(">> MyInventory插件关闭了...");
		getLogger().info(">> 我们很感谢您的使用...");
		getLogger().info(">> 作者QQ: 2424441676 ——绿毛");
		getLogger().info(">> 欢迎来吐槽本插件~有bug加QQ反馈!");
		getLogger().info(">> 插件指令: /myinv 和 /miv");
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

	public static void loadScripts() {
		int amount = 0;
		File folder = new File(".//plugins//MyInventory//Scripts//");
		for (File scriptFile : folder.listFiles()) {
			HashMap<SlotLabel,SlotScript> result = SlotScriptLoader.loadByFile(scriptFile);
			amount += result.size();
			SlotScriptAche.putAll(result);
		}
		MyInventory.getInstance().getLogger().info(">> 加载了 "+amount+" 个脚本!");
	}
}
