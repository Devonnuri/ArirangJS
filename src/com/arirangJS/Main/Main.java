package com.arirangJS.Main;

import java.io.File;
import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.arirangJS.Debug.Debug;
import com.arirangJS.File.FileSystem;
import com.arirangJS.Script.ScriptManager;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin implements Listener {
	HashMap<String, String> scripts = new HashMap<String, String>();
	
	public void onEnable() {
		FileSystem.checkExist(FileSystem.LOC_PLUGIN);
		FileSystem.checkExist(FileSystem.LOC_SCRIPT);
		
		//File folder_plugin = new File(FileSystem.LOC_PLUGIN);
		File folder_script = new File(FileSystem.LOC_SCRIPT);
		
		for(File file : folder_script.listFiles()) {
			String[] code = FileSystem.readRaw(file);
			String str = "";
			for(String temp : code) str += temp;
			
			scripts.put(file.getName(), str);
			
			Debug.success("File \""+file.getName()+"\" was loaded successfully!");
		}
		
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
			if(args.length == 1) {
				if(args[0].equalsIgnoreCase("list")) {
					
				}
			} else if(args.length == 2) {
				if(args[0].equalsIgnoreCase("reload")) {
					if(scripts.containsKey(args[1]) && FileSystem.isExist(FileSystem.LOC_SCRIPT + args[1])) {
						String[] code = FileSystem.readRaw(FileSystem.LOC_SCRIPT + args[1]);
						ScriptManager script = new ScriptManager(code);
						sender.sendMessage(ScriptManager.toString(script.run()));
					} else {
						sender.sendMessage(ChatColor.RED+""+ChatColor.BOLD+"[ArirangJS] Script \""+args[1]+"\" is not exist.");
					}
					return true;
				}else if(args[0].equalsIgnoreCase("view")) {
					if(FileSystem.isExist(FileSystem.LOC_SCRIPT + args[1])) {
						String[] script = FileSystem.readRaw(FileSystem.LOC_SCRIPT + args[1]);
						sender.sendMessage(ChatColor.AQUA+""+ChatColor.BOLD+"忙式式式式式式式["+ChatColor.RESET+""+ChatColor.BOLD+"ArirangJS - "+args[1]+ChatColor.AQUA+""+ChatColor.BOLD+"]式式式式式式式忖");
						for(String str : script) {
							sender.sendMessage(ChatColor.BOLD+str);
						}
					} else {
						sender.sendMessage(ChatColor.RED+""+ChatColor.BOLD+"[ArirangJS] Script \""+args[1]+"\" is not exist.");
					}
					return true;
				}
				
				sender.sendMessage("");
				sender.sendMessage(ChatColor.AQUA+""+ChatColor.BOLD+"忙式式式式式式式[ArirangJS]式式式式式式式忖");
				sender.sendMessage(ChatColor.GOLD+""+ChatColor.BOLD+" /arirang list"+ChatColor.RESET+""+ChatColor.BOLD+" : List of the Scripts");
				sender.sendMessage(ChatColor.GOLD+""+ChatColor.BOLD+" /arirang reload [script]"+ChatColor.RESET+""+ChatColor.BOLD+" : Reload the Script");
				sender.sendMessage(ChatColor.GOLD+""+ChatColor.BOLD+" /arirang view [script]"+ChatColor.RESET+""+ChatColor.BOLD+" : View the Script");
				sender.sendMessage(ChatColor.AQUA+""+ChatColor.BOLD+"戌式式式式式式式[ArirangJS]式式式式式式式戎");
				sender.sendMessage("");
			} else {
				sender.sendMessage("");
				sender.sendMessage(ChatColor.AQUA+""+ChatColor.BOLD+"忙式式式式式式式[ArirangJS]式式式式式式式忖");
				sender.sendMessage(ChatColor.GOLD+""+ChatColor.BOLD+" /arirang list"+ChatColor.RESET+""+ChatColor.BOLD+" : List of the Scripts");
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
