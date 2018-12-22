package com.locydragon.myinv.invcommand.subcmd;

import com.locydragon.myinv.api.Menu;
import com.locydragon.myinv.api.MyInventoryAPI;
import com.locydragon.myinv.invcommand.SubCmdRunner;
import com.locydragon.myinv.invcommand.SubCommandInfo;
import org.bukkit.ChatColor;

public class CommandInventoryInfoInventory implements SubCmdRunner {
	/**
	 * 指令前缀
	 */
	public static final String COMMAND_Prefix = "see";
	/**
	 * 期望指令长度
	 */
	public static final Integer LENGTH_EXPECT = 2;

	@Override
	public void onSubCommand(SubCommandInfo info) {
		if (info.args[0].equalsIgnoreCase(COMMAND_Prefix) && info.sender.isOp()) {
			if (info.args.length != LENGTH_EXPECT) {
				info.sender.sendMessage("§3[MyInventory] §e请使用/miv see [Gui界面名称] ——查看一个界面的名称");
				return;
			}
			Menu instance = MyInventoryAPI.getMenu(info.args[1]);
			if (instance == null) {
				info.sender.sendMessage("§3[MyInventory] §c对象界面不存在.");
				return;
			}
			info.sender.sendMessage(ChatColor.GREEN + "界面名称 "+ ChatColor.AQUA +"—— "+ChatColor.YELLOW+instance.getMenuName());
			info.sender.sendMessage(ChatColor.GREEN + "界面帧数 "+ ChatColor.AQUA +"—— "+ChatColor.YELLOW+instance.getFramesSize());
			info.sender.sendMessage(ChatColor.GREEN + "每帧间隔时长 "+ ChatColor.AQUA +"—— "+ChatColor.YELLOW+instance.getPeriod());
			info.sender.sendMessage(ChatColor.GREEN + "是否循环播放(true-是/false-否) "+ ChatColor.AQUA +"—— "+ChatColor.YELLOW+instance.isLoop());
			info.sender.sendMessage(ChatColor.GREEN + "背景音乐(需要AudioBuffer插件支持)" +
					" "+ ChatColor.AQUA +"—— "+ChatColor.YELLOW+instance.getMusicName());
			info.sender.sendMessage(ChatColor.GREEN + "界面格子数 "+ ChatColor.AQUA +"—— "+ChatColor.YELLOW+instance.getSize());
			info.sender.sendMessage(ChatColor.GREEN + "界面标题 "+ ChatColor.AQUA +"—— "+ChatColor.YELLOW+instance.getTitle());
		}
	}
}
