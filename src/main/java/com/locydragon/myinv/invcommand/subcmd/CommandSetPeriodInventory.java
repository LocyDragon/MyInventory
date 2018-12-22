package com.locydragon.myinv.invcommand.subcmd;

import com.locydragon.myinv.MyInventory;
import com.locydragon.myinv.api.Menu;
import com.locydragon.myinv.api.MyInventoryAPI;
import com.locydragon.myinv.core.MenuStacks;
import com.locydragon.myinv.invcommand.SubCmdRunner;
import com.locydragon.myinv.invcommand.SubCommandInfo;
import com.locydragon.myinv.util.ItemStackUtil;

public class CommandSetPeriodInventory implements SubCmdRunner {
	/**
	 * 指令前缀
	 */
	public static final String COMMAND_Prefix = "period";
	/**
	 * 期望指令长度
	 */
	public static final Integer LENGTH_EXPECT = 3;

	@Override
	public void onSubCommand(SubCommandInfo info) {
		if (info.args[0].equalsIgnoreCase(COMMAND_Prefix) && info.sender.isOp()) {
			if (info.args.length != LENGTH_EXPECT) {
				info.sender.sendMessage("§3[MyInventory] §e请使用/miv period [Gui界面名称] [间隔(秒)] ——设置每帧间隔(默认"+ MyInventory.period +")");
				return;
			}
			String periodString = info.args[2];
			Menu targetMenu = MyInventoryAPI.getMenu(info.args[1]);
			if (targetMenu == null) {
				info.sender.sendMessage("§3[MyInventory] §c目标UI界面不存在.");
				return;
			}
			if (!ItemStackUtil.isDouble(periodString)) {
				info.sender.sendMessage("§3[MyInventory] §c你输入的间隔不是一个数字.");
				return;
			}
			double period = Double.valueOf(periodString);
			if (period <= 0) {
				info.sender.sendMessage("§3[MyInventory] §c你输入的间隔不是一个有效数字.");
				return;
			}
			targetMenu.setPeriod(period);
			targetMenu.save();
			MenuStacks.insert(targetMenu);
			info.sender.sendMessage("§3[MyInventory] §c修改帧间隔完成了.");
		}
	}

}
