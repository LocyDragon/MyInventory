package com.locydragon.myinv.invcommand.subcmd;

import com.locydragon.myinv.MyInventory;
import com.locydragon.myinv.core.script.ache.SlotScriptAche;
import com.locydragon.myinv.invcommand.SubCmdRunner;
import com.locydragon.myinv.invcommand.SubCommandInfo;

public class CommandScriptReloadInventory implements SubCmdRunner {
	/**
	 * 指令前缀
	 */
	public static final String COMMAND_Prefix = "reload";

	@Override
	public void onSubCommand(SubCommandInfo info) {
		if (info.args[0].equalsIgnoreCase(COMMAND_Prefix) && info.sender.isOp()) {
			SlotScriptAche.scriptCache.clear();
			MyInventory.loadScripts();
			info.sender.sendMessage("§3[MyInventory] §a重载了所有脚本了.");
		}
	}
}
