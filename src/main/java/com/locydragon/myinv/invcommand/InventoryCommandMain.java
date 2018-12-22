package com.locydragon.myinv.invcommand;

import com.locydragon.myinv.util.Levenshtein;
import com.locydragon.myinv.util.StringParamEntry;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

/**
 * @author Administrator
 */
public class InventoryCommandMain implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
		if (args.length <= 0 || !(sender instanceof Player)) {
			sender.sendMessage("§3[MyInventory] §e请输入正确的指令!");
			return false;
		}
		SubCommandInfo info = new SubCommandInfo();
		info.args = args;
		info.command = command;
		info.sender = (Player)sender;
		info.s = s;
		if (!SubCommandBasic.invoke(info)) {
			List<Map.Entry<Float,String>> entryList = new ArrayList<>();
			for (String object : SubCommandBasic.subCommandPrefixs) {
				StringParamEntry entryTwice = new StringParamEntry();
				entryTwice.setValue(object);
				entryTwice.setKey(Levenshtein.getSimilarityRatio(object, info.args[0]));
				entryList.add(entryTwice);
			}
			Map.Entry<Float,String> temp;
			for (int i = 0;i < entryList.size();i++){
				for (int j = 0;j < entryList.size() - i - 1;j++){
					if (entryList.get(j + 1).getKey() < entryList.get(j).getKey()) {
						temp = entryList.get(j);
						Map.Entry<Float,String> last = entryList.get(j + 1);
						entryList.set(j, last);
						entryList.set(j + 1, temp);
					}
				}
			}
			info.sender.sendMessage("§3[MyInventory] §c你是想输入命令: §e§l/miv "
					+entryList.get(entryList.size() - 1).getValue()+" §c吗?");
		}
		return false;
	}
}
