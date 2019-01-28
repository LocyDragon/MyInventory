package com.locydragon.myinv.core.script;

import com.locydragon.myinv.api.AnimatedFramePlayer;
import com.locydragon.myinv.api.Menu;
import com.locydragon.myinv.api.MyInventoryAPI;
import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.Prompt;
import org.bukkit.entity.Player;

public class ConversationPrompt implements Prompt {
	private JobPerScript script;
	private Player who;
	private String msg;
	private Menu fatherMenu;
	private int frameIndex;
	public ConversationPrompt(JobPerScript script, Player who, String message, Menu openedMenu, int frame) {
		this.script = script;
		this.who = who;
		this.msg = message;
		this.fatherMenu = openedMenu;
		this.frameIndex = frame;
	}

	@Override
	public String getPromptText(ConversationContext conversationContext) {
		return msg;
	}

	@Override
	public boolean blocksForInput(ConversationContext conversationContext) {
		return true;
	}

	@Override
	public Prompt acceptInput(ConversationContext conversationContext, String in) {
		script.father.placeHolderStacks.put((String)script.knownHash.get(JobPerScript.PLACEHOLDER_PARAM), in);
		script.done.set(true);
		return Prompt.END_OF_CONVERSATION;
	}
}
