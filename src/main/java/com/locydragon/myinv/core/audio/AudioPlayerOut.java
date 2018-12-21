package com.locydragon.myinv.core.audio;

import com.locydragon.myinv.MyInventory;
import org.bukkit.entity.Player;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AudioPlayerOut {
	public static Method loopMethod = null;
	public static Method playMethod = null;
	public static Method stopMethod = null;
	static {
		try {
			Class<?> apiClass = Class.forName("com.locydragon.abf.api.AudioBufferAPI");
			loopMethod = apiClass.getMethod("loopPlayer", Player.class, String.class);
			playMethod = apiClass.getMethod("playFor", Player.class, String.class);
			stopMethod = apiClass.getMethod("stopPlaying", Player.class);
		} catch (ClassNotFoundException | NoSuchMethodException e) {
			e.printStackTrace();
		}
	}

	public static boolean loopFor(Player who, String musicName) {
		if (MyInventory.useAudioBuffer) {
			try {
				return (boolean) loopMethod.invoke(null, who, musicName);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
		} else {
			return false;
		}
		return false;
	}

	public static boolean playFor(Player who, String musicName) {
		if (MyInventory.useAudioBuffer) {
			try {
				return (boolean) playMethod.invoke(null, who, musicName);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
		} else {
			return false;
		}
		return false;
	}

	public static void stop(Player who) {
		if (!MyInventory.useAudioBuffer) {
			return;
		}
		try {
			stopMethod.invoke(null, who);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
