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
		SlotLabel label = new SlotLabel(slot, menuName);
		SlotScript[] script = new SlotScript[] { null };
		scriptCache.entrySet().parallelStream().forEach(x -> {
			if (x.getKey().equals(label)) {
				script[0] = x.getValue();
			}
		});
		return script[0];
	}

	public static void putAll(HashMap<SlotLabel,SlotScript> map) {
		scriptCache.putAll(map);
	}
}
