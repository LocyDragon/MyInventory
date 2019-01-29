package com.locydragon.myinv.core.script;

import com.locydragon.myinv.MyInventory;
import com.locydragon.myinv.api.AnimatedFramePlayer;
import com.locydragon.myinv.api.Menu;
import com.locydragon.myinv.api.MyInventoryAPI;
import com.locydragon.myinv.util.StringParamEntry;
import org.bukkit.Bukkit;
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
	public String out;
	public String action;
	private List<JobPerScript> scripts = new ArrayList<>();
	private int slot;
	protected Menu fatherMenu;
	private List<String> scriptsString = new ArrayList<>();

	protected static final String PLAYER_CMD = "player";
	protected static final String OP_CMD = "op";
	protected static final String CONSOLE_CMD = "console";
	protected static final String ASK = "ask";
	protected static final String CLOSE = "close";
	protected static final String MONEY = "money";
	protected static final String TELL = "tell";
	protected static final String POINTS = "point";
	protected static final String XP = "xp"; //弃用的

	protected static final String IS_NUMBER = "number";
	protected static final String HAS_PERMISSION = "permission";
	protected static final String COMPARE = "compare";

	protected static final String COST = "cost";
	protected static final String POINT_COST = "spend";
	protected static final String COST_ITEM_BY_NAME = "name_item";
	protected static final String COST_ITEM_BY_ID = "id_item";


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
			String[] params = value.split("\\|", 3);
			try {
				long timeOut = Long.valueOf(params[1]);
				script.knownHash.put(JobPerScript.TIME_OUT, timeOut);
				script.knownHash.put(JobPerScript.PLACEHOLDER_PARAM, params[0]);
				script.knownHash.put(JobPerScript.MESSAGE, ChatColor.translateAlternateColorCodes('&',
						params[2]));
			} catch (Exception e) {
				return;
			}
		} else if (StringParamEntry.startsWithIgnoreCase(type, CLOSE)) {
			script.job = JobCodeEnum.CLOSE;
		} else if (StringParamEntry.startsWithIgnoreCase(type, MONEY) && MyInventory.useVault) {
			script.job = JobCodeEnum.MONEY;
			script.knownHash.put(JobPerScript.MONEY_NUM, value);
		} else if (StringParamEntry.startsWithIgnoreCase(type, TELL)) {
			script.job = JobCodeEnum.MESSAGE;
			script.knownHash.put(JobPerScript.MESSAGE, ChatColor.translateAlternateColorCodes('&',
					value));
		} else if (StringParamEntry.startsWithIgnoreCase(type, POINTS)) {
			script.job = JobCodeEnum.POINTS;
			script.knownHash.put(JobPerScript.MONEY_NUM, value);
		} else if (StringParamEntry.startsWithIgnoreCase(type, IS_NUMBER)) {
			script.job = JobCodeEnum.IS_NUMBER;
			script.knownHash.put(JobPerScript.OBJECT, value);
		} else if (StringParamEntry.startsWithIgnoreCase(type, HAS_PERMISSION)) {
			script.job = JobCodeEnum.HAS_PERMISSION;
			script.knownHash.put(JobPerScript.OBJECT, value);
		} else if (StringParamEntry.startsWithIgnoreCase(type, COMPARE)) {
			script.job = JobCodeEnum.COMPARE;
			script.knownHash.put(JobPerScript.COMPARE_OBJECT, value);
		} else if (StringParamEntry.startsWithIgnoreCase(type, COST)) {
			script.job = JobCodeEnum.COST;
			script.knownHash.put(JobPerScript.MONEY_NUM, value);
		} else if (StringParamEntry.startsWithIgnoreCase(type, POINT_COST)) {
			script.job = JobCodeEnum.COST_POINT;
			script.knownHash.put(JobPerScript.MONEY_NUM, value);
		} else if (StringParamEntry.startsWithIgnoreCase(type, COST_ITEM_BY_NAME)) {
			script.job = JobCodeEnum.ITEM_COST_BY_NAME;
			String[] params = value.split("\\|", 2);
			script.knownHash.put(JobPerScript.ITEM_NAME, params[1]);
			script.knownHash.put(JobPerScript.AMOUNT, params[0]);
		} else if (StringParamEntry.startsWithIgnoreCase(type, COST_ITEM_BY_ID)) {
			script.job = JobCodeEnum.ITEM_COST_BY_ENGLISH_NAME;
			String[] params = value.split("\\|", 2);
			script.knownHash.put(JobPerScript.ITEM_ID, params[1]);
			script.knownHash.put(JobPerScript.AMOUNT, params[0]);
		}
	}

	protected String parse(String input) {
		for (HashMap.Entry<String,String> entry : this.placeHolderStacks.entrySet()) {
			input = input.replace(entry.getKey(), entry.getValue());
		}
		return input;
	}

	public boolean containsType(JobCodeEnum type) {
		for (JobPerScript script : this.scripts) {
			if (script.job == type || script.job.equals(type)) {
				return true;
			}
		}
		return false;
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
		newObject.out = this.out;
		newObject.action = this.action;
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
			waitingQueue.add(who.getName().toUpperCase());
			boolean closeInventory = false;
			boolean isFirst = true;
			boolean closedInventory[] = {false};
			for (JobPerScript script : this.scripts) {
				closeInventory = script.job == JobCodeEnum.ASK;
				closedInventory[0] = closeInventory && isFirst;
				if (closedInventory[0]) {
					isFirst = false;
					Bukkit.getScheduler().runTask(MyInventory.getInstance(), () -> {
						who.closeInventory();
						if (AnimatedFramePlayer.playerList.containsKey(who)) {
							AnimatedFramePlayer.playerList.get(who).cancel();
							AnimatedFramePlayer.playerList.remove(who);
						}
						if (AnimatedFramePlayer.openMenuTarget.containsKey(who)) {
							AnimatedFramePlayer.openMenuTarget.remove(who);
						}
					});
				}
				script.done.set(false);
				try {
					script.run(who);
				} catch (Throwable throwable) {
					throwable.printStackTrace();
					waitingQueue.remove(who.getName().toUpperCase());
					break;
				}
				while (!script.isDone()) {
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				Result result = script.getResult();
				if (result != null && result == Result.END) {
					if (out != null) {
						who.sendMessage(ChatColor.translateAlternateColorCodes('&'
						, out));
					}
					waitingQueue.remove(who.getName().toUpperCase());
					break;
				}
			}
			waitingQueue.remove(who.getName().toUpperCase());
			Bukkit.getScheduler().runTask(MyInventory.getInstance(), () -> {
				if (closedInventory[0] && who.isOnline()) {
					Menu newMenu = MyInventoryAPI.getMenu(fatherMenu.getMenuName());
					AnimatedFramePlayer.playFor(who, newMenu);
				}
			});
		});
	}

	public int getSlot() {
		return this.slot;
	}

	public String getMenuName() {
		return this.fatherMenu.getMenuName();
	}
}
