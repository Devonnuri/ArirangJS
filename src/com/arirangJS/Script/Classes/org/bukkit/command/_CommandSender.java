package com.arirangJS.Script.Classes.org.bukkit.command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.annotations.JSConstructor;
import org.mozilla.javascript.annotations.JSFunction;

/**
 * Created by devonnuri on 17. 2. 10.
 */
public class _CommandSender extends ScriptableObject {
	
	private static final long serialVersionUID = -8068902219758323716L;
	
	public Player e;

    @Override
    public String getClassName() {
        return "CommandSender";
    }

    @JSConstructor
    public _CommandSender() {}

    public _CommandSender(CommandSender sender) {
        this.e = (Player) sender;
    }

    @JSFunction
    public String entity() {
        return e.getName();
    }

    @JSFunction
    public void sendMessage(String message) {
    	e.sendMessage(message);
    }
}
