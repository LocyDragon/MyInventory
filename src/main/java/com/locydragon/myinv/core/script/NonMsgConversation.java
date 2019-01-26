package com.locydragon.myinv.core.script;

import org.bukkit.Bukkit;
import org.bukkit.conversations.*;
import org.bukkit.plugin.Plugin;

import java.util.logging.Level;

public class NonMsgConversation extends Conversation {
	protected NonMsgConversation(Plugin plugin, Conversable forWhom, Prompt firstPrompt) {
		super(plugin, forWhom, firstPrompt);
	}

	@Override
	public void outputNextPrompt() {
		if (this.currentPrompt == null) {
			abandon(new ConversationAbandonedEvent(this));
		} else {
			this.context.getForWhom().sendRawMessage(this.prefix.getPrefix(this.context)
					+ this.currentPrompt.getPromptText(this.context));
			if (!this.currentPrompt.blocksForInput(this.context)) {
				this.currentPrompt = this.currentPrompt.acceptInput(this.context, null);
				outputNextPrompt();
			}
		}
	}

	@Override
	public void acceptInput(String input) {
		try {
			if (this.currentPrompt != null) {
				for (ConversationCanceller canceller : this.cancellers) {
					if (canceller.cancelBasedOnInput(this.context, input)) {
						abandon(new ConversationAbandonedEvent(this, canceller));
						return;
					}

				}
				this.currentPrompt = this.currentPrompt.acceptInput(this.context, input);
				outputNextPrompt();
			}
		} catch (Throwable t) {
			Bukkit.getLogger().log(Level.SEVERE, "Error handling conversation prompt", t);
		}
	}
}
