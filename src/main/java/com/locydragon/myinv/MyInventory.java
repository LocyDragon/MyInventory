package com.locydragon.myinv;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author LocyDragon
 */
public class MyInventory extends JavaPlugin {
	private static MyInventory instance;
	@Override
	public void onEnable() { //当插件被加载时
		Main.infoMessage();
		//一些信息..
		instance = this;
		//我 赋 值 我 自 己
	}

	public static MyInventory getInstance() { //获取实例对象
		return instance;
	}
}
