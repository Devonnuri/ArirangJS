package com.arirangJS.Script.Classes.org.bukkit.command;

/**
 * Created by devonnuri on 17. 2. 10.
 */
public interface _ICommandSender {
    String getName();
    void sendMessage(String message);
    void sendMessage(String[] messages);
}
