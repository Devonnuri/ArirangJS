package com.arirangJS.Script.Classes.org.bukkit.command;

import org.bukkit.command.CommandSender;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.annotations.JSConstructor;
import org.mozilla.javascript.annotations.JSFunction;

/**
 * Created by devonnuri on 17. 2. 10.
 */
public class _CommandSender extends ScriptableObject implements  _ICommandSender{
    CommandSender sender;

    @Override
    public String getClassName() {
        return "CommandSender";
    }

    @JSConstructor
    public _CommandSender() {}

    public _CommandSender(CommandSender sender) {
        this.sender = sender;
    }

    @JSFunction
    public String getName() {
        return sender.getName();
    }

    @JSFunction
    public void sendMessage(String message) {
        sender.sendMessage(message);
    }

    @JSFunction
    public void sendMessage(String[] messages) {
        sender.sendMessage(messages);
    }
}
