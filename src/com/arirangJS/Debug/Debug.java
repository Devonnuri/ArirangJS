package com.arirangJS.Debug;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class Debug {
	private static final String prefix = "[ArirangJS] ";
	private static CommandSender sender = Bukkit.getConsoleSender();
	
	public static void log(String text) {
		sender.sendMessage(prefix+text);
	}
	
	public static void logRaw(String text) {
		sender.sendMessage(text);
	}
	
	public static void warn(String text) {
		sender.sendMessage(ChatColor.YELLOW+prefix+text);
	}
	
	public static void warnRaw(String text) {
		sender.sendMessage(ChatColor.YELLOW+text);
	}
	
	public static void danger(String text) {
		sender.sendMessage(ChatColor.RED+prefix+text);
	}
	
	public static void dangerRaw(String text) {
		sender.sendMessage(ChatColor.RED+text);
	}
	
	public static void success(String text) {
		sender.sendMessage(ChatColor.GREEN+prefix+text);
	}
	
	public static void successRaw(String text) {
		sender.sendMessage(ChatColor.GREEN+text);
	}
}
