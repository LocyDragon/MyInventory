package com.locydragon.myinv.invcommand.subcmd;

import com.locydragon.myinv.api.Menu;
import com.locydragon.myinv.api.MyInventoryAPI;
import com.locydragon.myinv.core.MenuStacks;
import com.locydragon.myinv.invcommand.SubCmdRunner;
import com.locydragon.myinv.invcommand.SubCommandBasic;
import com.locydragon.myinv.invcommand.SubCommandInfo;
import com.locydragon.myinv.util.ItemStackUtil;
import org.bukkit.ChatColor;

/**
 * @author Administrator
 */
public class CommandCreateInventory implements SubCmdRunner {
	/**
	 * 指令前缀
	 */
	public static final String COMMAND_Prefix = "create";
	/**
	 * 期望指令长度
	 */
	public static final Integer LENGTH_EXPECT = 4;

	@Override
	public void onSubCommand(SubCommandInfo info) {
		if (info.args[0].equalsIgnoreCase(COMMAND_Prefix) && info.sender.isOp()) {
			if (info.args.length != LENGTH_EXPECT) {
				info.sender.sendMessage("§3[MyInventory] §e请使用/miv create [Gui界面名称] [界面行数] [Title名称] ——创建一个新的Gui界面模板!");
				return;
			}
			Menu expectMenu = MyInventoryAPI.getMenu(info.args[1]);
			if (expectMenu != null) {
				info.sender.sendMessage("§3[MyInventory] §c你所输入的GUI界面已经被创建过了.");
				return;
			}
			if (!ItemStackUtil.isInteger(info.args[2])) {
				info.sender.sendMessage("§3[MyInventory] §c你所输入的行数不是一个数字!");
				return;
			}
			Integer number = Integer.valueOf(info.args[2]);
			if (number < 9 || number > 54 || (number % 9) != 0) {
				info.sender.sendMessage("§3[MyInventory] §c你所输入的行数不规范!");
				return;
			}
			Menu newMenu = new Menu(ChatColor.translateAlternateColorCodes('&', info.args[3]), number, info.args[1]);
			newMenu.save();
			MenuStacks.insert(newMenu);
			info.sender.sendMessage("§3[MyInventory] §c创建完成了!现在使用/miv frame [Gui界面名称] [帧数(从0开始)] ——来编辑帧吧~");
		}
	}
}
