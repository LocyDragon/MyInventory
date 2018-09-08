package com.locydragon.myinv.invcommand;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * @author Administrator
 */
public class InventoryCommandMain implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
		SubCommandInfo info = new SubCommandInfo();
		info.args = args;
		info.command = command;
		info.sender = sender;
		info.s = s;
		SubCommandBasic.invoke(info);
		return false;
	}
}
