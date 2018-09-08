package com.locydragon.myinv;

import com.locydragon.myinv.invcommand.InventoryCommandMain;
import org.bukkit.Bukkit;

/**
 * @author Administrator
 */
public class Main {
	public static void infoMessage() { //发送后台信息
		MyInventory.getInstance().getLogger().info("欢迎使用MyInventory——新一代低耗能智能菜单插件!");
		MyInventory.getInstance().getLogger().info("作者QQ: 2424441676");
		MyInventory.getInstance().getLogger().info("欢迎来吐槽本插件~有bug加QQ反馈!");
		MyInventory.getInstance().getLogger().info("插件指令: /myinv 和 /miv");
	}

	public static void registerCommands() { //注册指令
		Bukkit.getPluginCommand("myinv").setExecutor(new InventoryCommandMain());
		Bukkit.getPluginCommand("miv").setExecutor(new InventoryCommandMain());
	}
}
