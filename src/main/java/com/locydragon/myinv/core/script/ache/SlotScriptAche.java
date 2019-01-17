package com.locydragon.myinv.core.script.ache;

import com.locydragon.myinv.core.script.SlotScript;

import java.util.HashMap;

public class SlotScriptAche {
	private static HashMap<SlotLabel,SlotScript> scriptCache = new HashMap<>();

	public static void insert(String menuName, int slot, SlotScript script) {
		SlotLabel label = new SlotLabel(slot, menuName);
		scriptCache.put(label, script);
	}

	public static SlotScript searchScript(String menuName, int slot) {
		return scriptCache.get(new SlotLabel(slot, menuName));
	}
}
