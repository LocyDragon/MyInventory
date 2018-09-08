package com.locydragon.myinv.invcommand.subcmd;

import com.locydragon.myinv.invcommand.SubCmdRunner;
import com.locydragon.myinv.invcommand.SubCommandBasic;
import com.locydragon.myinv.invcommand.SubCommandInfo;

/**
 * @author Administrator
 */
public class CommandCreateInventory implements SubCmdRunner {
	/**
	 * 指令前缀
	 */
	public static final String cmdPrefix = "create";
	/**
	 * 期望指令长度
	 */
	public static final Integer LENGTH_EXPECT = 3;

	static {
		SubCommandBasic.addListener(new CommandCreateInventory());
	}

	@Override
	public void onSubCommand(SubCommandInfo info) {
		if (info.args[0].equalsIgnoreCase(cmdPrefix)) {
			if (info.args.length != LENGTH_EXPECT) {
				info.sender.sendMessage("§3[MyInventory] §e请使用/miv create [Gui界面名称] [界面行数] ——创建一个新的Gui界面模板!");
				return;
			}
			throw new RuntimeException("Non done yet!");
		}
	}
}
