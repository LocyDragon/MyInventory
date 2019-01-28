package com.locydragon.myinv.core.script;

import com.avaje.ebean.validation.NotNull;
import com.locydragon.myinv.EconomyAche;
import com.locydragon.myinv.MyInventory;
import com.locydragon.myinv.PlayerPointsHelper;
import com.locydragon.myinv.api.AnimatedFramePlayer;
import com.locydragon.myinv.api.Menu;
import com.locydragon.myinv.api.MyInventoryAPI;
import com.locydragon.myinv.reflectasm.PlaceHolderReflector;
import com.locydragon.myinv.util.Calculator;
import com.locydragon.myinv.util.Compare;
import com.locydragon.myinv.util.ItemStackUtil;
import org.bukkit.Bukkit;
import org.bukkit.conversations.*;
import org.bukkit.entity.Player;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

public class JobPerScript {
	@NotNull protected JobCodeEnum job;
	protected SlotScript father;
	protected volatile AtomicReference<Boolean> done = new AtomicReference<>();
	protected volatile AtomicReference<Result> result = new AtomicReference<>();
	@NotNull protected HashMap<String,Object> knownHash = new HashMap<>();
	protected double chance = 100.0;
	protected static final String COMMAND_PREFIX = "COMMAND_NAME";
	protected static final String PLACEHOLDER_PARAM = "PLACEHOLDER";
	protected static final String TIME_OUT = "TIME_OUT";
	protected static final String MESSAGE = "MESSAGE";
	protected static final String MONEY_NUM = "MONEY_NUM";
	protected static final String OBJECT = "OBJECT";
	protected static final String COMPARE_OBJECT = "COMPARE_OBJECT";
	protected static final String AMOUNT = "AMOUNT";
	protected static final String ITEM_NAME = "ITEM_NAME";
	protected static final String ITEM_ID = "ITEM_ID";

	public String param;
	private static final Calculator calculator = new Calculator();

	private static Method CONVERSATION_CANCELLER_METHOD = null;
	static {
		try {
			CONVERSATION_CANCELLER_METHOD = Conversation.class.getDeclaredMethod("addConversationCanceller"
			, ConversationCanceller.class);
			CONVERSATION_CANCELLER_METHOD.setAccessible(true);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}

	public Result getResult() {
		return result.get();
	}

	public JobPerScript(SlotScript script, String param) {
		done.set(true);
		result.set(Result.CONTINUE);
		this.father = script;
		this.param = param;
		SlotScript.init(this, this.param);
		this.knownHash.put("%RANDOM%", Math.random());
	}

	private JobPerScript() {}

	public JobPerScript clone() {
		JobPerScript newScript = new JobPerScript();
		newScript.job = this.job;
		newScript.done.set(true);
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
				out.append(SlotScript.CONSOLE_CMD).append(":").
						append(knownHash.get(COMMAND_PREFIX)).append("<chance:" + chance + ">");
				break;
			case CLOSE:
				out.append(SlotScript.CLOSE);
				break;
			case MONEY:
				out.append(SlotScript.MONEY).append(":").append((String)this.knownHash.get(MONEY_NUM));
				break;
			case MESSAGE:
				out.append(SlotScript.TELL).append(":")
						.append((String)this.knownHash.get(MESSAGE));
				break;
			case POINTS:
				out.append(SlotScript.POINTS).append(":")
						.append((String)this.knownHash.get(MONEY_NUM));
				break;
			case IS_NUMBER:
				out.append(SlotScript.IS_NUMBER).append(":").append((String)this.knownHash.get(OBJECT));
				break;
			case HAS_PERMISSION:
				out.append(SlotScript.HAS_PERMISSION).append(":").append((String)this.knownHash.get(OBJECT));
				break;
			case COMPARE:
				out.append(SlotScript.COMPARE).append(":").append((String)this.knownHash.get(COMPARE_OBJECT));
				break;
			case COST:
				out.append(SlotScript.COST).append(":").append((String)this.knownHash.get(MONEY_NUM));
				break;
			case COST_POINT:
				out.append(SlotScript.POINT_COST).append(":").append((String)this.knownHash.get(MONEY_NUM));
				break;
			default:
				return "";
		}
		return out.toString();
	}

	public boolean isDone() {
		return done.get();
	}

	public Result run(Player user) {
		Result[] mainResult = new Result[] {Result.CONTINUE};
		if (this.job == null) {
			return mainResult[0];
		}
		if (Math.random() * 100 + 1 >= chance) {
			return mainResult[0];
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
					done.set(false);
					NonMsgConversation nonMsgConversation = new NonMsgConversation(MyInventory.getInstance()
					, user, new ConversationPrompt(this, user,
							parseString(user, (String)this.knownHash.get(MESSAGE))
							, fatherMenu, frameIndex));
					try {
						CONVERSATION_CANCELLER_METHOD.invoke(nonMsgConversation,
								new InactivityConversationCanceller(MyInventory.getInstance(), (int)(long) knownHash.get(TIME_OUT)));
					} catch (IllegalAccessException | InvocationTargetException e) {
						e.printStackTrace();
					}
					nonMsgConversation.addConversationAbandonedListener(new ConversationAbandonedListener() {
						@Override
						public void conversationAbandoned(ConversationAbandonedEvent e) {
							if (e.getCanceller() != null &&
									e.getCanceller().getClass().equals(InactivityConversationCanceller.class)) {
								result.set(Result.END);
								done.set(true);
							}
						}
					});
					nonMsgConversation.begin();
					break;
				case CLOSE:
					done.set(false);
					user.closeInventory();
					if (AnimatedFramePlayer.playerList.containsKey(user)) {
						AnimatedFramePlayer.playerList.get(user).cancel();
						AnimatedFramePlayer.playerList.remove(user);
						AnimatedFramePlayer.openMenuTarget.remove(user);
					}
					if (AnimatedFramePlayer.openMenuTarget.containsKey(user)) {
						AnimatedFramePlayer.openMenuTarget.remove(user);
					}
					done.set(true);
					break;
				case MONEY:
					done.set(false);
					int moneyNum = (int)toInteger(parseString(user, (String)this.knownHash.get(MONEY_NUM)));
					EconomyAche.economy.depositPlayer(user, moneyNum);
					done.set(true);
					break;
				case MESSAGE:
					done.set(false);
					user.sendMessage(parseString(user, (String)this.knownHash.get(MESSAGE)));
					done.set(true);
					break;
				case POINTS:
					done.set(false);
					int pointsNum = (int)toInteger(parseString(user, (String)this.knownHash.get(MONEY_NUM)));
					PlayerPointsHelper.addPoints(user, pointsNum);
					done.set(true);
					break;
				case IS_NUMBER:
					done.set(false);
					String outPut = parseString(user, (String)this.knownHash.get(OBJECT));
					if (!isInteger(outPut)) {
						mainResult[0] = Result.END;
						result.set(Result.END);
					} else {
						mainResult[0] = Result.CONTINUE;
						result.set(Result.CONTINUE);
					}
					done.set(true);
					break;
				case HAS_PERMISSION:
					done.set(false);
					String permission = (String)this.knownHash.get(OBJECT);
					if (!user.hasPermission(permission)) {
						mainResult[0] = Result.END;
						result.set(Result.END);
					} else {
						mainResult[0] = Result.CONTINUE;
						result.set(Result.CONTINUE);
					}
					done.set(true);
					break;
				case COMPARE:
					done.set(false);
					String compareString = (String)this.knownHash.get(COMPARE_OBJECT);
					if (!Compare.compare(parseString(user, compareString))) {
						mainResult[0] = Result.END;
						result.set(Result.END);
					} else {
						mainResult[0] = Result.CONTINUE;
						result.set(Result.CONTINUE);
					}
					done.set(true);
					break;
				case COST:
					done.set(false);
					int costNum = (int)toInteger(parseString(user, (String)this.knownHash.get(MONEY_NUM)));
					if (EconomyAche.economy.has(user, costNum)) {
						EconomyAche.economy.withdrawPlayer(user, costNum);
						mainResult[0] = Result.CONTINUE;
						result.set(Result.CONTINUE);
					} else {
						mainResult[0] = Result.END;
						result.set(Result.END);
					}
					done.set(true);
					break;
				case COST_POINT:
					done.set(false);
					int pointNum = (int)toInteger(parseString(user, (String)this.knownHash.get(MONEY_NUM)));
					if (pointNum > PlayerPointsHelper.look(user)) {
						mainResult[0] = Result.END;
						result.set(Result.END);
					} else {
						PlayerPointsHelper.take(user, pointNum);
						mainResult[0] = Result.CONTINUE;
						result.set(Result.CONTINUE);
					}
					done.set(true);
					break;
				case ITEM_COST_BY_NAME:
					done.set(false);
					int amountName = (int)toInteger(parseString(user, (String)this.knownHash.get(AMOUNT)));
					String itemName = parseString(user, (String)this.knownHash.get(ITEM_NAME));
					if (ItemStackUtil.take(itemName, user.getInventory(), amountName)) {
						user.updateInventory();
						mainResult[0] = Result.END;
						result.set(Result.END);
					} else {
						mainResult[0] = Result.CONTINUE;
						result.set(Result.CONTINUE);
					}
 					done.set(true);
					break;
				case ITEM_COST_BY_ENGLISH_NAME:
					done.set(false);
					int amountID = (int)toInteger(parseString(user, (String)this.knownHash.get(AMOUNT)));
					String itemID = parseString(user, (String)this.knownHash.get(ITEM_ID));
					if (ItemStackUtil.takeByName(itemID, user.getInventory(), amountID)) {
						user.updateInventory();
						mainResult[0] = Result.END;
						result.set(Result.END);
					} else {
						mainResult[0] = Result.CONTINUE;
						result.set(Result.CONTINUE);
					}
					done.set(true);
					break;
				default:
					break;
			}
		});
		return mainResult[0];
	}

	private String parseString(Player user, String input) {
		return father.parse(PlaceHolderReflector.invoke(user, input.trim()));
	}

	private double toInteger(String input) {
		double out = calculator.calculate(input);
		calculator.clear();
		return out;
	}

	private boolean isInteger(String input) {
		try {
			input = input.trim();
			Integer.valueOf(input);
			return true;
		} catch (Exception exc) {
			return false;
		}
	}
}
