package com.locydragon.myinv.reflectasm;

import com.locydragon.myinv.api.Menu;
import com.locydragon.myinv.api.MyInventoryAPI;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;

public class PlaceHolderReflector {
	public static String invoke(Player target, String text) {
		text = defaultPlaceHolder(target, text);
		return PlaceholderAPI.setPlaceholders(target, text);
	}

	private static String defaultPlaceHolder(Player who, String text) {
		Menu menu = MyInventoryAPI.getMenuOpening(who);
		int frameIndex = menu == null ? 0 :	menu.getFrameIndex();
		text = text.replace("%exp%", String.valueOf(who.getTotalExperience()))
				.replace("%level%", String.valueOf(who.getLevel()))
				.replace("%health%", String.valueOf(who.getHealth()))
				.replace("%name%", String.valueOf(who.getName()))
				.replace("%display_name%", String.valueOf(who.getDisplayName()))
				.replace("%last_damage%", String.valueOf(who.getLastDamage()))
				.replace("%ip%", String.valueOf(who.getAddress().toString()))
				.replace("%speed%", String.valueOf(who.getWalkSpeed()))
				.replace("%frame%", String.valueOf(frameIndex));
		return text;
	}
}
