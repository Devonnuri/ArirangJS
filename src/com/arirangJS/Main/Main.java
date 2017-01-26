package com.arirangJS.Main;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
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
	public static boolean instaBreak;
	
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
		if(label.equalsIgnoreCase("arirang") || label.equalsIgnoreCase("arirangjs") || label.equalsIgnoreCase("嬴葬嫌")) {
			if(args.length == 1) {
				if(args[0].equalsIgnoreCase("test")) {
					
				}
			} else if(args.length >= 2) {
				if(args[0].equalsIgnoreCase("reload")) {
					String filename = String.join(" ", Arrays.copyOfRange(args, 1, args.length));
					if(FileSystem.isExist(FileSystem.LOC_SCRIPT + filename)) {
						scripts.add(filename);
						FileSystem.copy(FileSystem.LOC_SCRIPT+filename, FileSystem.LOC_TEMP+filename);
						sender.sendMessage(ChatColor.GREEN+""+ChatColor.BOLD+"[ArirangJS] File \""+filename+"\" was reloaded successfully!");
					} else {
						sender.sendMessage(ChatColor.RED+""+ChatColor.BOLD+"[ArirangJS] Script \""+filename+"\" is not exist.");
					}
					return true;
				} else if(args[0].equalsIgnoreCase("view")) {
					String filename = String.join(" ", Arrays.copyOfRange(args, 1, args.length));
					if(FileSystem.isExist(FileSystem.LOC_TEMP + filename)) {
						String code = FileSystem.readRawInline(FileSystem.LOC_TEMP + filename);
						sender.sendMessage(ChatColor.AQUA+""+ChatColor.BOLD+"忙式式式式式式式["+ChatColor.RESET+""+ChatColor.BOLD+"ArirangJS - "+filename+ChatColor.AQUA+""+ChatColor.BOLD+"]式式式式式式式忖");
						code = SyntaxHighlighter.highlight(code);
						sender.sendMessage(code);
						JOptionPane.showMessageDialog(null, code);
					} else {
						sender.sendMessage(ChatColor.RED+""+ChatColor.BOLD+"[ArirangJS] Script \""+filename+"\" is not exist.");
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
	
	@EventHandler
	public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
		if(label.equalsIgnoreCase("arirang") || label.equalsIgnoreCase("arirangjs") || label.equalsIgnoreCase("嬴葬嫌")) {
			if(args.length == 1) {
				String[] argsList = {"list", "reload", "view"};
				ArrayList<String> list = new ArrayList<String>();
				
				if(args[0].equals("")) {
					list.addAll(Arrays.asList(argsList));
				} else {
					for(String str : argsList) {
						if(str.startsWith(args[0].toLowerCase())) {
							list.add(str);
						}
					}
				}
				
				Collections.sort(list);
				
				return list;
			} else if(args.length == 2) {
				if(args[0].equalsIgnoreCase("reload") || args[0].equalsIgnoreCase("view")) {
					File[] fileList = new File(FileSystem.LOC_SCRIPT).listFiles();
					ArrayList<String> list = new ArrayList<String>();
					
					if(args[1].equals("")) {
						for(File file : fileList) {
							if(file.getName().endsWith(".js")) {
								list.add(file.getName());
							}
						}
					} else {
						for(File file : fileList) {
							if(file.getName().startsWith(args[1].toLowerCase()) && file.getName().endsWith(".js")) {
								list.add(file.getName());
							}
						}
					}
					
					return list;
				}
			}
		}
		return null;
	}
}
