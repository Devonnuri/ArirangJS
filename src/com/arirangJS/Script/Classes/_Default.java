package com.arirangJS.Script.Classes;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mozilla.javascript.ImporterTopLevel;
import org.mozilla.javascript.annotations.JSFunction;

public class _Default extends ImporterTopLevel {

	private static final long serialVersionUID = -4290301262375673084L;
	
	@JSFunction
	public boolean isSenderPlayer(CommandSender sender) {
		return sender instanceof Player;
	}
}
