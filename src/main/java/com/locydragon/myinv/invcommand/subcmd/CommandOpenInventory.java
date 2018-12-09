package com.locydragon.myinv.invcommand.subcmd;

import com.locydragon.myinv.api.AnimatedFramePlayer;
import com.locydragon.myinv.api.Menu;
import com.locydragon.myinv.api.MyInventoryAPI;
import com.locydragon.myinv.invcommand.SubCmdRunner;
import com.locydragon.myinv.invcommand.SubCommandInfo;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class CommandOpenInventory implements SubCmdRunner {
	/**
	 * 指令前缀
	 */
	public static final String COMMAND_Prefix = "open";
	/**
	 * 期望指令长度
	 */
	public static final Integer LENGTH_EXPECT = 3;

	@Override
	public void onSubCommand(SubCommandInfo info) {
		if (info.args[0].equalsIgnoreCase(COMMAND_Prefix) && info.sender.isOp()) {
			if (info.args.length != LENGTH_EXPECT) {
				info.sender.sendMessage("§3[MyInventory] §e请使用/miv open [Gui界面名称] [玩家名称] ——为某个玩家打开一个界面");
				return;
			}
			String uiName = info.args[1];
			String playerName = info.args[2];
			Menu selectedMenu = MyInventoryAPI.getMenu(uiName);
			if (selectedMenu == null) {
				info.sender.sendMessage("§3[MyInventory] §c对象界面不存在.");
				return;
			}
			Player player = Bukkit.getPlayer(playerName);
			if (player == null) {
				info.sender.sendMessage("§3[MyInventory] §c对象玩家不存在.");
				return;
			}
			AnimatedFramePlayer.playFor(player, selectedMenu);
		}
	}
}
