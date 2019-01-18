package com.locydragon.myinv.core.script;

import com.locydragon.myinv.api.Menu;
import com.locydragon.myinv.util.StringParamEntry;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SlotScript {
	public static ConcurrentLinkedQueue<String> waitingQueue = new ConcurrentLinkedQueue<>();
	public static Executor threadPool = Executors.newCachedThreadPool();
	protected ConcurrentHashMap<String,String> placeHolderStacks = new ConcurrentHashMap<>();
	private List<JobPerScript> scripts = new ArrayList<>();
	private int slot;
	protected Menu fatherMenu;
	private List<String> scriptsString = new ArrayList<>();

	protected static final String PLAYER_CMD = "player";
	protected static final String OP_CMD = "op";
	protected static final String CONSOLE_CMD = "console";
	protected static final String ASK = "ask";

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
		this.scriptsString = input;
	}

	public List<String> getScripts() {
		return this.scriptsString;
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
		String[] paramSplit = param.split(":", 2);
		String type = paramSplit[0].trim();
		String value = paramSplit[1].trim();
		if (StringParamEntry.startsWithIgnoreCase(type, PLAYER_CMD)) {
			script.job = JobCodeEnum.PLAYER_CMD;
			script.knownHash.put(JobPerScript.COMMAND_PREFIX, value);
		} else if (StringParamEntry.startsWithIgnoreCase(type, OP_CMD)) {
			script.job = JobCodeEnum.OP_CMD;
			script.knownHash.put(JobPerScript.COMMAND_PREFIX, value);
		} else if (StringParamEntry.startsWithIgnoreCase(type, CONSOLE_CMD)) {
			script.job = JobCodeEnum.CONSOLE_CMD;
			script.knownHash.put(JobPerScript.COMMAND_PREFIX, value);
		} else if (StringParamEntry.startsWithIgnoreCase(type, ASK)) {
			script.job = JobCodeEnum.ASK;
			String[] params = value.split("\\|");
			try {
				long timeOut = Long.valueOf(params[1]);
				script.knownHash.put(JobPerScript.TIME_OUT, timeOut);
				script.knownHash.put(JobPerScript.PLACEHOLDER_PARAM, params[0]);
				script.knownHash.put(JobPerScript.MESSAGE, ChatColor.translateAlternateColorCodes('&',
						params[2]));
			} catch (Exception e) {
				return;
			}
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
		newObject.placeHolderStacks = new ConcurrentHashMap<>();
		List<JobPerScript> newScript = new ArrayList<>();
		for (JobPerScript script : this.scripts) {
			newScript.add(script.clone());
		}
		newObject.scripts = newScript;
		newObject.slot = this.slot;
		newObject.fatherMenu = this.fatherMenu;
		newObject.scriptsString = this.scriptsString;
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
				script.done.set(false);
				script.run(who);
				while (!script.isDone()) {
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(script.job);
			}
			waitingQueue.remove(who.getName());
		});
	}

	public int getSlot() {
		return this.slot;
	}

	public String getMenuName() {
		return this.fatherMenu.getMenuName();
	}
}
