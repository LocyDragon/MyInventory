package com.locydragon.myinv.core.script;

import com.avaje.ebean.validation.NotNull;
import com.locydragon.myinv.MyInventory;
import com.locydragon.myinv.api.AnimatedFramePlayer;
import com.locydragon.myinv.api.Menu;
import com.locydragon.myinv.api.MyInventoryAPI;
import com.locydragon.myinv.reflectasm.PlaceHolderReflector;
import org.bukkit.Bukkit;
import org.bukkit.conversations.*;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

public class JobPerScript {
	@NotNull protected JobCodeEnum job;
	protected SlotScript father;
	protected volatile AtomicReference<Boolean> done = new AtomicReference<>();
	@NotNull protected HashMap<String,Object> knownHash = new HashMap<>();
	protected double chance = 100.0;
	protected static final String COMMAND_PREFIX = "COMMAND_NAME";
	protected static final String PLACEHOLDER_PARAM = "PLACEHOLDER";
	protected static final String TIME_OUT = "TIME_OUT";
	protected static final String MESSAGE = "MESSAGE";
	public String param;
	public JobPerScript(SlotScript script, String param) {
		done.set(true);
		this.father = script;
		this.param = param;
		SlotScript.init(this, this.param);
	}

	private JobPerScript() {}

	public JobPerScript clone() {
		JobPerScript newScript = new JobPerScript();
		newScript.job = this.job;
		done.set(true);
		newScript.father = this.father;
		HashMap<String,Object> newMap = new HashMap<>();
		newMap.putAll(this.knownHash);
		newScript.knownHash = newMap;
		newScript.chance = this.chance;
		newScript.param = this.param;
		return newScript;
	}

	public String toString() {
		StringBuilder out = new StringBuilder();
		switch (this.job) {
			case OP_CMD:
				out.append(SlotScript.OP_CMD).append(":").
						append(knownHash.get(COMMAND_PREFIX)).append("<chance:" + chance + ">");
				break;
			case PLAYER_CMD:
				out.append(SlotScript.PLAYER_CMD).append(":").
						append(knownHash.get(COMMAND_PREFIX)).append("<chance:" + chance + ">");
				break;
			case ASK:
				out.append(SlotScript.ASK).append(":").append(knownHash.get(PLACEHOLDER_PARAM))
						.append("|").append(knownHash.get(TIME_OUT)).append("|")
						.append(knownHash.get(MESSAGE)).append("<chance:" + chance + ">");
				break;
			case CONSOLE_CMD:
				out.append(SlotScript.CONSOLE_CMD).append(":").append(":").
						append(knownHash.get(COMMAND_PREFIX)).append("<chance:" + chance + ">");
				break;
			default:
				return null;
		}
		return out.toString();
	}

	public boolean isDone() {
		return done.get();
	}

	public void run(Player user) {
		if (this.job == null) {
			return;
		}
		if (Math.random() * 100 + 1 >= chance) {
			return;
		}
		Bukkit.getScheduler().runTask(MyInventory.getInstance(), () -> {
			switch (this.job) {
				case PLAYER_CMD:
					done.set(false);
					String cmdTarget = (String) knownHash.get(COMMAND_PREFIX);
					cmdTarget = father.parse(PlaceHolderReflector.invoke(user, cmdTarget));
					if (!cmdTarget.startsWith("/")) {
						cmdTarget = "/" + cmdTarget;
					}
					user.chat(cmdTarget);
					done.set(true);
					break;
				case CONSOLE_CMD:
					done.set(false);
					String consoleCmdTarget = (String) knownHash.get(COMMAND_PREFIX);
					consoleCmdTarget = father.parse(PlaceHolderReflector.invoke(user, consoleCmdTarget));
					if (consoleCmdTarget.startsWith("/")) {
						consoleCmdTarget = consoleCmdTarget.substring(1);
					}
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), consoleCmdTarget);
					done.set(true);
					break;
				case OP_CMD:
					done.set(false);
					String opCmdTarget = (String) knownHash.get(COMMAND_PREFIX);
					opCmdTarget = father.parse(PlaceHolderReflector.invoke(user, opCmdTarget));
					if (!opCmdTarget.startsWith("/")) {
						opCmdTarget = "/" + opCmdTarget;
					}
					boolean isOp = user.isOp();
					user.setOp(true);
					user.chat(opCmdTarget);
					user.setOp(isOp);
					if (user.isOp() != isOp) {
						Bukkit.getLogger().info("Hack player: " + user.getName());
						user.setOp(false);
					}
					done.set(true);
					break;
				case ASK:
					Menu fatherMenu = father.fatherMenu;
					int frameIndex = fatherMenu.getFrameIndex();
					user.closeInventory();
					done.set(false);
					Conversation conversation = new ConversationFactory(MyInventory.getInstance())
							.withTimeout((int)(long) knownHash.get(TIME_OUT))
							.withFirstPrompt(new ConversationPrompt(this, user, (String)this.knownHash.get(MESSAGE)
							, fatherMenu, frameIndex))
							.buildConversation(user);
					conversation.begin();
					break;
			}
		});
	}
}
