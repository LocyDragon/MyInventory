package com.locydragon.myinv.api;

import com.locydragon.myinv.core.MenuStacks;
import org.bukkit.entity.Player;

public class MyInventoryAPI {
	public static Menu getMenu(String menuName) {
		return MenuStacks.getMenuCloned(menuName);
	}

	public static boolean isOpening(Player who) { return AnimatedFramePlayer.playerList.containsKey(who); }

	public static Menu getMenuOpening(Player who) {
		if (!isOpening(who)) {
			return null;
		}
		return AnimatedFramePlayer.openMenuTarget.get(who);
	}
}
