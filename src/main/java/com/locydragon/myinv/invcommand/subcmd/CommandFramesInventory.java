package com.locydragon.myinv.invcommand.subcmd;

import com.locydragon.myinv.api.Menu;
import com.locydragon.myinv.core.EditorStacks;
import com.locydragon.myinv.core.MenuStacks;
import com.locydragon.myinv.core.data.Editor;
import com.locydragon.myinv.invcommand.SubCmdRunner;
import com.locydragon.myinv.invcommand.SubCommandInfo;
import com.locydragon.myinv.util.InventorySerialization;
import com.locydragon.myinv.util.ItemStackUtil;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public class CommandFramesInventory implements SubCmdRunner {
	/**
	 * 指令前缀
	 */
	public static final String COMMAND_Prefix = "frame";
	/**
	 * 期望指令长度
	 */
	public static final Integer LENGTH_EXPECT = 3;
	@Override
	public void onSubCommand(SubCommandInfo info) {
		if (info.args[0].equalsIgnoreCase(COMMAND_Prefix) && info.sender.isOp()) {
			if (info.args.length != LENGTH_EXPECT) {
				info.sender.sendMessage("§3[MyInventory] §e请使用/miv frame [Gui界面名称] [帧数(从0开始)] ——来编辑帧");
				return;
			}
			String uiName = info.args[1];
			String frame = info.args[2];
			Menu targetMenu = MenuStacks.getMenuCloned(uiName);
			if (targetMenu == null) {
				info.sender.sendMessage("§3[MyInventory] §c目标UI界面不存在.");
				return;
			}
			if (!ItemStackUtil.isInteger(frame)) {
				info.sender.sendMessage("§3[MyInventory] §c你所输入的帧数不是一个数字!");
				return;
			}
			int frameIndex = Integer.valueOf(frame);
			Inventory targetFrame = null;
			if (targetMenu.hasFrame(frameIndex)) {
				targetFrame = InventorySerialization.cloneInventory(targetMenu.getFrame(frameIndex).getInventory());
			} else if (targetMenu.isEmpty()) {
				targetFrame = Bukkit.createInventory(null, targetMenu.getSize(), targetMenu.getTitle());
			} else {
				targetFrame = InventorySerialization.cloneInventory(targetMenu.getFrame(targetMenu.getFramesSize() - 1).getInventory());
			}
			Editor editor = new Editor();
			editor.editor = info.sender;
			editor.index = frameIndex;
			editor.menu = targetMenu;
			EditorStacks.editorHashMap.put(info.sender, editor);
			info.sender.sendMessage("§3[MyInventory] §c您正在编辑 "+uiName+" 的第 "+frameIndex+" 帧动画.");
			info.sender.openInventory(targetFrame);
		}
	}
}
