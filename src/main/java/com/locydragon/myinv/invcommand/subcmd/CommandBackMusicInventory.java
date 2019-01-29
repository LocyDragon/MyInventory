package com.locydragon.myinv.invcommand.subcmd;

import com.locydragon.myinv.MyInventory;
import com.locydragon.myinv.api.Menu;
import com.locydragon.myinv.api.MyInventoryAPI;
import com.locydragon.myinv.core.MenuStacks;
import com.locydragon.myinv.invcommand.SubCmdRunner;
import com.locydragon.myinv.invcommand.SubCommandInfo;
import com.locydragon.myinv.util.ItemStackUtil;
import org.bukkit.ChatColor;

public class CommandBackMusicInventory implements SubCmdRunner {
	/**
	 * 指令前缀
	 */
	public static final String COMMAND_Prefix = "music";
	/**
	 * 期望指令长度
	 */
	public static final Integer LENGTH_EXPECT = 3;

	@Override
	public void onSubCommand(SubCommandInfo info) {
		if (info.args[0].equalsIgnoreCase(COMMAND_Prefix) && info.sender.isOp()) {
			if (info.args.length != LENGTH_EXPECT) {
				info.sender.sendMessage("§3[MyInventory] §e请使用/miv music [Gui界面名称] [音乐名称] ——给一个Gui界面添加一个音乐.Tip: 需要AudioBuffer插件支持.");
				return;
			}
			String musicName = info.args[2];
			Menu targetMenu = MyInventoryAPI.getMenu(info.args[1]);
			if (targetMenu == null) {
				info.sender.sendMessage("§3[MyInventory] §c目标UI界面不存在.");
				return;
			}
			if (!MyInventory.useAudioBuffer) {
				info.sender.sendMessage("§3[MyInventory] §cAudioBuffer插件不存在.无法使用该功能.");
				return;
			}
			targetMenu.setMusicName(musicName);
			targetMenu.save();
			MenuStacks.insert(targetMenu);
			info.sender.sendMessage("§3[MyInventory] §c添加背景音乐成功.");
		}
	}
}
