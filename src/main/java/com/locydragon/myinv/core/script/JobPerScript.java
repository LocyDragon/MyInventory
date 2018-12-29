package com.locydragon.myinv.core.script;

import com.locydragon.myinv.MyInventory;
import com.locydragon.myinv.api.AnimatedFramePlayer;
import com.locydragon.myinv.api.Menu;
import com.locydragon.myinv.api.MyInventoryAPI;
import com.locydragon.myinv.conversation.Conversation;
import com.locydragon.myinv.conversation.request.RequestString;
import com.locydragon.myinv.reflectasm.PlaceHolderReflector;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class JobPerScript {
	protected JobCodeEnum job;
	protected SlotScript father;
	private boolean done = true;
	protected HashMap<String,Object> knownHash = new HashMap<>();
	public static final String COMMAND_PREFIX = "COMMAND_NAME";
	public static final String PLACEHOLDER_PARAM = "PLACEHOLDER";
	public static final String TIME_OUT = "TIME_OUT";
	public String param;
	public JobPerScript(SlotScript script, String param) {
		this.father = script;
		father.init(this, param);
		this.param = param;
	}

	public boolean isDone() {
		return done;
	}

	public void run(Player user) {
		if (this.job == null) {
			return;
		}
		Bukkit.getScheduler().runTask(MyInventory.getInstance(), () -> {
			switch (this.job) {
				case PLAYER_CMD:
					done = false;
					String cmdTarget = (String) knownHash.get(COMMAND_PREFIX);
					cmdTarget = father.parse(PlaceHolderReflector.invoke(user, cmdTarget));
					if (!cmdTarget.startsWith("/")) {
						cmdTarget = "/" + cmdTarget;
					}
					user.chat(cmdTarget);
					done = true;
					break;
				case CONSOLE_CMD:
					done = false;
					String consoleCmdTarget = (String) knownHash.get(COMMAND_PREFIX);
					consoleCmdTarget = father.parse(PlaceHolderReflector.invoke(user, consoleCmdTarget));
					if (consoleCmdTarget.startsWith("/")) {
						consoleCmdTarget = consoleCmdTarget.substring(1);
					}
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), consoleCmdTarget);
					done = true;
					break;
				case OP_CMD:
					done = false;
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
					done = true;
					break;
				case ASK:
					Menu fatherMenu = father.fatherMenu;
					int frameIndex = fatherMenu.getFrameIndex();
					user.closeInventory();
					done = false;
					Conversation conversation = new Conversation(MyInventory.getInstance());
					conversation.addRequest(new RequestString().newRequestString().setTimeout((long) knownHash.get(TIME_OUT)));
					conversation.setOnCancel(con -> {
						done = true;
						if (con.getRequest(0) != null) {
							father.placeHolderStacks.put((String) knownHash.get(PLACEHOLDER_PARAM), con.getRequest(0).toString());
						}
						Menu newMenu = MyInventoryAPI.getMenu(fatherMenu.getMenuName());
						newMenu.setIndex(frameIndex);
						AnimatedFramePlayer.playFor(user, fatherMenu);
					});
					conversation.setOnComplete(con -> {
						done = true;
						if (con.getRequest(0) != null) {
							father.placeHolderStacks.put((String) knownHash.get(PLACEHOLDER_PARAM), con.getRequest(0).toString());
						}
						Menu newMenu = MyInventoryAPI.getMenu(fatherMenu.getMenuName());
						newMenu.setIndex(frameIndex);
						AnimatedFramePlayer.playFor(user, fatherMenu);
					});
					break;
			}
		});
	}
}
