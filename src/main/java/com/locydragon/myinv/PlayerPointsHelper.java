package com.locydragon.myinv;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.UUID;

public class PlayerPointsHelper {
	private static Object instance;
	public static void init() throws Exception {
		Class<?> pointsClass = Class.forName("org.black_ixx.playerpoints.PlayerPoints");
		Method GET_API = pointsClass.getMethod("getAPI");
		instance = GET_API.invoke(Bukkit.getPluginManager().getPlugin("PlayerPoints"));
	}

	public static void addPoints(Player user, int amount) {
		try {
			instance.getClass()
					.getMethod("give", new Class[] {UUID.class, int.class })
					.invoke(instance, user.getUniqueId(), amount);
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
}
