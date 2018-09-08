package com.locydragon.myinv.invcommand;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

/**
 * @author Administrator
 */
public class SubCommandInfo {
	public String[] args;
	public CommandSender sender;
	public Command command;
	public String s;

	public String[] getArgs() {
		return args;
	}

	public Command getCommand() {
		return command;
	}

	public CommandSender getSender() {
		return sender;
	}

	public String getS() {
		return s;
	}
}
