package com.locydragon.myinv.invcommand;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
public class SubCommandBasic {
	private static List<SubCmdRunner> runners = new ArrayList<>();
	protected static List<String> subCommandPrefixs = new ArrayList<>();

	public static void addListener(SubCmdRunner runner) {
		try {
			Field targetField = runner.getClass().getField("COMMAND_Prefix");
			try {
				subCommandPrefixs.add(((String) targetField.get(null)).toLowerCase());
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				return;
			}
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
			return;
		}
		runners.add(runner);
	}

	public static boolean invoke(SubCommandInfo info) {
		runners.forEach(x -> x.onSubCommand(info));
		return subCommandPrefixs.contains(info.args[0].toLowerCase());
	}
}
