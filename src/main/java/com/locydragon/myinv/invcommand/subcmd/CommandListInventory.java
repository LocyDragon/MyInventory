package com.locydragon.myinv.invcommand.subcmd;

import com.locydragon.myinv.core.MenuStacks;
import com.locydragon.myinv.invcommand.SubCmdRunner;
import com.locydragon.myinv.invcommand.SubCommandInfo;
import org.bukkit.ChatColor;

public class CommandListInventory implements SubCmdRunner {
	/**
	 * 指令前缀
	 */
	public static final String COMMAND_Prefix = "list";

	@Override
	public void onSubCommand(SubCommandInfo info) {
		if (info.args[0].equalsIgnoreCase(COMMAND_Prefix) && info.sender.isOp()) {
			info.sender.sendMessage(ChatColor.GREEN + MenuStacks.menuList().toString());
		}
	}
}
