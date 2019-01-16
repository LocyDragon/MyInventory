package com.locydragon.myinv.core.script;

import com.locydragon.myinv.api.Menu;
import org.bukkit.entity.Player;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SlotScript {
	public static ConcurrentLinkedQueue<String> waitingQueue = new ConcurrentLinkedQueue<>();
	public static Executor threadPool = Executors.newCachedThreadPool();
	protected HashMap<String,String> placeHolderStacks = new HashMap<>();
	private List<JobPerScript> scripts = new ArrayList<>();
	private int slot;
	protected Menu fatherMenu;

	private static Pattern CHANCE_SELECT_PATTERN = null;
	static {
		CHANCE_SELECT_PATTERN = Pattern.compile("<chance:+\\S+>");
	}

	public SlotScript(int slot, Menu fatherMenu, List<String> input) {
		this.slot = slot;
		this.fatherMenu = fatherMenu;
		for (String object : input) {
			JobPerScript scriptTarget = new JobPerScript(this, object);
			scripts.add(scriptTarget);
		}
	}

	private SlotScript() {}

	protected static void init(JobPerScript script, String param) {
		Matcher matcherChance = CHANCE_SELECT_PATTERN.matcher(param);
		if (matcherChance.find()) {
			String chanceFindParam = matcherChance.group();
			script.chance = Double.valueOf(chanceFindParam
					.replace("<chance:", "").replace(">", ""));
			if (script.chance > 100.0 || script.chance <= 0.0) {
				script.chance = 100.0;
			}
			param = param.replace(chanceFindParam, "");
		}

	}

	protected String parse(String input) {
		for (HashMap.Entry<String,String> entry : this.placeHolderStacks.entrySet()) {
			input.replace(entry.getKey(), entry.getValue());
		}
		return input;
	}

	public SlotScript deepClone() {
		SlotScript newObject = new SlotScript();
		HashMap<String,String> newStacks = new HashMap<>();
		newStacks.putAll(this.placeHolderStacks);
		newObject.placeHolderStacks = newStacks;
		List<JobPerScript> newScript = new ArrayList<>();
		for (JobPerScript script : this.scripts) {
			newScript.add(new JobPerScript(newObject, script.param));
		}
		newObject.scripts = newScript;
		newObject.slot = this.slot;
		newObject.fatherMenu = this.fatherMenu;
		return newObject;
	}

	public void run(Player who, int slot) {
		if (slot != this.slot) {
			return;
		}
		if (waitingQueue.contains(who.getName().toUpperCase())) {
			return;
		}
		threadPool.execute(() -> {
			waitingQueue.add(who.getName());
			for (JobPerScript script : this.scripts) {
				script.run(who);
				while (!script.isDone());
			}
		});
	}
}
