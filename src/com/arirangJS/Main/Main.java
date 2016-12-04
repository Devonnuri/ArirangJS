package com.arirangJS.Main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.arirangJS.Debug.Debug;
import com.arirangJS.File.FileSystem;
import com.arirangJS.Script.Script;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin implements Listener{
	public void onEnable() {
		Debug.success("ArirangJS was enabled successfully!");
		Debug.success("Arirang Arirang Arariyo~");
	}
	
	public void onDisable() {
		Debug.warn("ArirangJS was disabled successfully!");
		Debug.warn("Arirang Arirang Arariyo~");
	}
	
	@EventHandler
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(label.equalsIgnoreCase("arirang") || label.equalsIgnoreCase("arirangjs") || label.equalsIgnoreCase("嬴葬嫌")) {
			if(args.length == 2) {
				if(args[0].equalsIgnoreCase("reload")) {
					if(FileSystem.isExist(FileSystem.LOC_SCRIPT + args[1])) {
						
					} else {
						sender.sendMessage(ChatColor.RED+""+ChatColor.BOLD+"[ArirangJS] Script \""+args[1]+"\" is not exist.");
					}
					return true;
				}else if(args[0].equalsIgnoreCase("view")) {
					if(FileSystem.isExist(FileSystem.LOC_SCRIPT + args[1])) {
						String[] script = FileSystem.readRaw(FileSystem.LOC_PLUGIN + args[1]);
						for(String str : script) {
							sender.sendMessage(ChatColor.BOLD+str);
						}
					} else {
						sender.sendMessage(ChatColor.RED+""+ChatColor.BOLD+"[ArirangJS] Script \""+args[1]+"\" is not exist.");
					}
					return true;
				}else if(args[0].equalsIgnoreCase("test")) {
		            Script script = new Script(args[1]);
					sender.sendMessage(Script.toString(script.run()));
					return true;
				}
				
				sender.sendMessage("");
				sender.sendMessage(ChatColor.AQUA+""+ChatColor.BOLD+"忙式式式式式式式[ArirangJS]式式式式式式式忖");
				sender.sendMessage(ChatColor.GOLD+""+ChatColor.BOLD+" /arirang reload [script]"+ChatColor.RESET+""+ChatColor.BOLD+" : Reload the Script");
				sender.sendMessage(ChatColor.GOLD+""+ChatColor.BOLD+" /arirang view [script]"+ChatColor.RESET+""+ChatColor.BOLD+" : View the Script");
				sender.sendMessage(ChatColor.AQUA+""+ChatColor.BOLD+"戌式式式式式式式[ArirangJS]式式式式式式式戎");
				sender.sendMessage("");
			} else {
				sender.sendMessage("");
				sender.sendMessage(ChatColor.AQUA+""+ChatColor.BOLD+"忙式式式式式式式[ArirangJS]式式式式式式式忖");
				sender.sendMessage(ChatColor.GOLD+""+ChatColor.BOLD+" /arirang reload [script]"+ChatColor.RESET+""+ChatColor.BOLD+" : Reload the Script");
				sender.sendMessage(ChatColor.GOLD+""+ChatColor.BOLD+" /arirang view [script]"+ChatColor.RESET+""+ChatColor.BOLD+" : View the Script");
				sender.sendMessage(ChatColor.AQUA+""+ChatColor.BOLD+"戌式式式式式式式[ArirangJS]式式式式式式式戎");
				sender.sendMessage("");
			}
			return true;
		}
		return false;
	}
}
