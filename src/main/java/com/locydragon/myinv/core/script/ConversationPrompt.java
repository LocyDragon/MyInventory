package com.locydragon.myinv.core.script;

import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.Prompt;
import org.bukkit.conversations.ValidatingPrompt;
import org.bukkit.entity.Player;

public class ConversationPrompt extends ValidatingPrompt {
	private JobPerScript script;
	private Player who;
	private String msg;
	public ConversationPrompt(JobPerScript script, Player who, String message) {
		this.script = script;
		this.who = who;
		this.msg = message;
	}

	@Override
	protected boolean isInputValid(ConversationContext conversationContext, String s) {
		return true;
	}

	@Override
	protected Prompt acceptValidatedInput(ConversationContext context, String in) {
		context.getForWhom().sendRawMessage("Conversation end, your input is:" + in);
		script.father.placeHolderStacks.put((String)script.knownHash.get(JobPerScript.PLACEHOLDER_PARAM), in);
		who.sendRawMessage("You say: "+in);
		script.done.set(true);
		return Prompt.END_OF_CONVERSATION;
	}

	@Override
	public String getPromptText(ConversationContext conversationContext) {
		return msg;
	}
}
