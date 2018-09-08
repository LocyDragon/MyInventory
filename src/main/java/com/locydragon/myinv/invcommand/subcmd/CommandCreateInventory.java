package com.locydragon.myinv.invcommand.subcmd;

import com.locydragon.myinv.invcommand.SubCmdRunner;
import com.locydragon.myinv.invcommand.SubCommandBasic;
import com.locydragon.myinv.invcommand.SubCommandInfo;

/**
 * @author Administrator
 */
public class CommandCreateInventory implements SubCmdRunner {
	public static final String cmdPrefix = "create";
	static {
		SubCommandBasic.addListener(new CommandCreateInventory());
	}

	@Override
	public void onSubCommand(SubCommandInfo info) {
		if (info.args[0].equalsIgnoreCase(cmdPrefix)) {
			throw new RuntimeException("Non done yet!");
		}
	}
}
