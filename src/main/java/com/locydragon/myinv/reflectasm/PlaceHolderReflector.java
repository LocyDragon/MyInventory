package com.locydragon.myinv.reflectasm;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.OfflinePlayer;

public class PlaceHolderReflector {
	public static String invoke(OfflinePlayer target, String text) {
		text = text.replace("{player}", target.getName());
		return PlaceholderAPI.setPlaceholders(target, text);
	}
}
