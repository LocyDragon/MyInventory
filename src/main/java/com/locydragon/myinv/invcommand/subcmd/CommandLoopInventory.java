package com.locydragon.myinv.invcommand.subcmd;

import com.locydragon.myinv.api.Menu;
import com.locydragon.myinv.api.MyInventoryAPI;
import com.locydragon.myinv.core.MenuStacks;
import com.locydragon.myinv.invcommand.SubCmdRunner;
import com.locydragon.myinv.invcommand.SubCommandInfo;

public class CommandLoopInventory implements SubCmdRunner {
	/**
	 * 指令前缀
	 */
	public static final String COMMAND_Prefix = "loop";
	/**
	 * 期望指令长度
	 */
	public static final Integer LENGTH_EXPECT = 3;

	@Override
	public void onSubCommand(SubCommandInfo info) {
		if (info.args[0].equalsIgnoreCase(COMMAND_Prefix) && info.sender.isOp()) {
			if (info.args.length != LENGTH_EXPECT) {
				info.sender.sendMessage("§3[MyInventory] §e请使用/miv loop [Gui界面名称] [Y/N] ——设置是否循环播放动画(Y-是/N-否,默认Y)");
				return;
			}
			Menu targetMenu = MyInventoryAPI.getMenu(info.args[1]);
			if (targetMenu == null) {
				info.sender.sendMessage("§3[MyInventory] §c目标UI界面不存在.");
				return;
			}
			String param = info.args[2];
			boolean loop = true;
			if (param.equalsIgnoreCase("N")) {
				loop = false;
			}
			targetMenu.setLooping(loop);
			targetMenu.save();
			MenuStacks.insert(targetMenu);
			info.sender.sendMessage("§3[MyInventory] §c成功设置成: "+loop+"(true-是/false-否)");
		}
	}
}
