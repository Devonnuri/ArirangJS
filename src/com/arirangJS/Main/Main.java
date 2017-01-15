package com.arirangJS.Main;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import com.arirangJS.Debug.Debug;
import com.arirangJS.File.FileSystem;
import com.arirangJS.Script.ScriptManager;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin {
	public static HashMap<String, Boolean> isCancelled = new HashMap<String, Boolean>();
	
	public static String joinMessage = "";
	public static String quitMessage = "";
	public static String chatFormat = "";
	
	public static ArrayList<String> scripts = new ArrayList<String>();
	
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new ScriptManager(), this);
		
		FileSystem.checkExist(FileSystem.LOC_PLUGIN);
		FileSystem.checkExist(FileSystem.LOC_SCRIPT);
		FileSystem.checkExist(FileSystem.LOC_TEMP);
		
		File folder_script = new File(FileSystem.LOC_SCRIPT);
		
		for(File file : folder_script.listFiles()) {
			if(file.isDirectory()) continue;
			FileSystem.copy(FileSystem.LOC_SCRIPT+file.getName(), FileSystem.LOC_TEMP+file.getName());
			scripts.add(file.getName());
			
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
		if(label.equalsIgnoreCase("arirang") || label.equalsIgnoreCase("arirangjs") || label.equalsIgnoreCase("아리랑")) {
			if(args.length == 1) {
				if(args[0].equalsIgnoreCase("test")) {
					ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
					item.addEnchantment(Enchantment.FIRE_ASPECT, 1);
					item.addEnchantment(Enchantment.DURABILITY, 1);
					ItemMeta meta = item.getItemMeta();
					meta.setDisplayName(ChatColor.AQUA+"헤헤헷");
					meta.setLore(Arrays.asList("로어로어", "두번째 로어"));
					item.setItemMeta(meta);
					Debug.warn(ScriptManager.itemToJSON(item));
				}
			} else if(args.length == 2) {
				if(args[0].equalsIgnoreCase("reload")) {
					if(FileSystem.isExist(FileSystem.LOC_SCRIPT + args[1])) {
						scripts.add(args[1]);
						FileSystem.copy(FileSystem.LOC_SCRIPT+args[1], FileSystem.LOC_TEMP+args[1]);
						sender.sendMessage(ChatColor.GREEN+""+ChatColor.BOLD+"[ArirangJS] File \""+args[1]+"\" was reloaded successfully!");
					} else {
						sender.sendMessage(ChatColor.RED+""+ChatColor.BOLD+"[ArirangJS] Script \""+args[1]+"\" is not exist.");
					}
					return true;
				} else if(args[0].equalsIgnoreCase("view")) {
					if(FileSystem.isExist(FileSystem.LOC_TEMP + args[1])) {
						String[] code = FileSystem.readRaw(FileSystem.LOC_TEMP + args[1]);
						sender.sendMessage(ChatColor.AQUA+""+ChatColor.BOLD+"┌───────["+ChatColor.RESET+""+ChatColor.BOLD+"ArirangJS - "+args[1]+ChatColor.AQUA+""+ChatColor.BOLD+"]───────┐");
						for(String str : code) {
							sender.sendMessage(ChatColor.BOLD+str);
						}
					} else {
						sender.sendMessage(ChatColor.RED+""+ChatColor.BOLD+"[ArirangJS] Script \""+args[1]+"\" is not exist.");
					}
					return true;
				}
				
				sender.sendMessage("");
				sender.sendMessage(ChatColor.AQUA+""+ChatColor.BOLD+"┌───────[ArirangJS]───────┐");
				sender.sendMessage(ChatColor.GOLD+""+ChatColor.BOLD+" /arirang list"+ChatColor.RESET+""+ChatColor.BOLD+" : List of the Scripts");
				sender.sendMessage(ChatColor.GOLD+""+ChatColor.BOLD+" /arirang reload [script]"+ChatColor.RESET+""+ChatColor.BOLD+" : Reload the Script");
				sender.sendMessage(ChatColor.GOLD+""+ChatColor.BOLD+" /arirang view [script]"+ChatColor.RESET+""+ChatColor.BOLD+" : View the Script");
				sender.sendMessage(ChatColor.AQUA+""+ChatColor.BOLD+"└───────[ArirangJS]───────┘");
				sender.sendMessage("");
			} else {
				sender.sendMessage("");
				sender.sendMessage(ChatColor.AQUA+""+ChatColor.BOLD+"┌───────[ArirangJS]───────┐");
				sender.sendMessage(ChatColor.GOLD+""+ChatColor.BOLD+" /arirang list"+ChatColor.RESET+""+ChatColor.BOLD+" : List of the Scripts");
				sender.sendMessage(ChatColor.GOLD+""+ChatColor.BOLD+" /arirang reload [script]"+ChatColor.RESET+""+ChatColor.BOLD+" : Reload the Script");
				sender.sendMessage(ChatColor.GOLD+""+ChatColor.BOLD+" /arirang view [script]"+ChatColor.RESET+""+ChatColor.BOLD+" : View the Script");
				sender.sendMessage(ChatColor.AQUA+""+ChatColor.BOLD+"└───────[ArirangJS]───────┘");
				sender.sendMessage("");
			}
			return true;
		}
		return false;
	}
}
