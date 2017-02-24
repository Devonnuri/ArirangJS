package com.arirangJS.Main;

import com.arirangJS.Debug.Debug;
import com.arirangJS.Lang.ErrReporter;
import com.arirangJS.Script.Classes._Var;
import com.arirangJS.Script.Script;
import com.arirangJS.Script.ScriptManager;
import com.arirangJS.Util.FileSystem;
import com.arirangJS.Util.Misc;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.*;

public class Main extends JavaPlugin {
    public static HashMap<String, Boolean> isCancelled = new HashMap<>();

    public static String joinMessage = "";
    public static String quitMessage = "";
    public static String chatFormat = "";
    public static boolean instaBreak;

    public static final int MAX_ERRORS_NUM = 5;

    private static final String PREFIX = ChatColor.AQUA + "" + ChatColor.BOLD + " = [ArirangJS] - ";

    public static HashMap<String, Script> scripts = new HashMap<>();

    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new ScriptManager(), this);

        FileSystem.checkExist(FileSystem.LOC_PLUGIN);
        FileSystem.checkExist(FileSystem.LOC_SCRIPT);
        FileSystem.checkExist(FileSystem.LOC_VAR);


        for (File file : Misc.getOnlyFileList(FileSystem.LOC_SCRIPT)) {
            Script script = new Script(file.getName());
            if (script.errors.size() > 0) {
                Debug.warn(ErrReporter.get("script.not.load", file.getName()));
                continue;
            }

            scripts.put(file.getName(), script);
            Debug.success(ErrReporter.get("script.load", file.getName()));
        }

        _Var.resetAll();

        Debug.success(ErrReporter.get("plugin.enable"));
        Debug.success(ErrReporter.get("arirang"));
    }

    public void onDisable() {
        Debug.warn(ErrReporter.get("plugin.disable"));
        Debug.success(ErrReporter.get("arirang"));
    }

    @EventHandler
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("arirang") || label.equalsIgnoreCase("arirangjs") || label.equalsIgnoreCase("아리랑")) {
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("list")) {
                    sender.sendMessage(PREFIX + "File List");

                    int i = 0;
                    for (File file : Misc.getOnlyFileList(FileSystem.LOC_SCRIPT)) {
                        i++;
                        sender.sendMessage(" " + ChatColor.BOLD + "" + i + ". " + ChatColor.GOLD + "" + ChatColor.BOLD + file.getName() + " : " + ChatColor.AQUA + String.format("%.2f KB", file.length() / 1024.0));
                    }

                    return true;
                }
            } else if (args.length >= 2 && args[0].equalsIgnoreCase("reload")) {
                String filename = String.join(" ", Arrays.copyOfRange(args, 1, args.length));
                if (FileSystem.isExist(FileSystem.LOC_SCRIPT + filename)) {
                    scripts.put(filename, new Script(filename));
                    sender.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "[ArirangJS] " + ErrReporter.get("script.reload", filename));
                } else {
                    if (scripts.containsKey(filename))
                        scripts.remove(filename);
                    sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "[ArirangJS] " + ErrReporter.get("script.not.exist", filename));
                }

                return true;
            } else if (args.length <= 1 && args[0].equalsIgnoreCase("reload")) {
                scripts.clear();
                for (File file : Misc.getOnlyFileList(FileSystem.LOC_SCRIPT)) {
                    scripts.put(file.getName(), new Script(file.getName()));

                    Debug.success("File \"" + file.getName() + "\" was reloaded successfully!");
                }
                return true;
            } else if (args.length >= 2 && args[0].equalsIgnoreCase("test")) {
                String code = String.join(" ", Arrays.copyOfRange(args, 1, args.length));
                String result = Script.test(code);

                sender.sendMessage(PREFIX + "Test Code - Result");
                if (result == null) {
                    sender.sendMessage("null");
                } else {
                    sender.sendMessage(Script.test(code));
                }

                return true;
            } else if (args.length >= 2 && args[0].equalsIgnoreCase("view")) {
                String filename = String.join(" ", Arrays.copyOfRange(args, 1, args.length));
                if (FileSystem.isExist(FileSystem.LOC_SCRIPT + filename)) {
                    String code = FileSystem.readRawInline(FileSystem.LOC_SCRIPT + filename);
                    sender.sendMessage(PREFIX + "View \"" + filename + "\"");
                    code = code.replaceAll("\t", "   ");
                    code = SyntaxHighlighter.highlight(code);
                    sender.sendMessage(code);
                } else {
                    sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "[ArirangJS] Script \"" + filename + "\" is not exist.");
                }

                return true;
            } else {
                helpMessage(sender);
            }
            return true;
        }
        return false;
    }

    @EventHandler
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("arirang") || label.equalsIgnoreCase("arirangjs") || label.equalsIgnoreCase("아리랑")) {
            if (args.length == 1) {
                String[] argsList = {"list", "reload", "view", "test"};
                ArrayList<String> list = new ArrayList<>();

                if (args[0].equals("")) {
                    list.addAll(Arrays.asList(argsList));
                } else {
                    for (String str : argsList) {
                        if (str.startsWith(args[0].toLowerCase())) {
                            list.add(str);
                        }
                    }
                }

                Collections.sort(list);
                return list;
            } else if (args.length == 2) {
                if (args[0].equalsIgnoreCase("reload") || args[0].equalsIgnoreCase("view")) {
                    ArrayList<String> list = new ArrayList<>();

                    if (args[1].equals("")) {
                        for (File file : Misc.getOnlyFileList(FileSystem.LOC_SCRIPT)) {
                            list.add(file.getName());
                        }
                    } else {
                        for (File file : Misc.getOnlyFileList(FileSystem.LOC_SCRIPT)) {
                            String name = file.getName();
                            if (name.startsWith(args[1].toLowerCase()) && (name.endsWith(".js") || name.endsWith(".ajs"))) {
                                list.add(name);
                            }
                        }
                    }

                    return list;
                }
            }
        }
        return null;
    }

    private void helpMessage(CommandSender sender) {
        sender.sendMessage("");
        sender.sendMessage(PREFIX + "Command List");
        sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + " /arirang list" + ChatColor.RESET + "" + ChatColor.BOLD + " : " + ErrReporter.get("cmd.desc.list"));
        sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + " /arirang reload [script]" + ChatColor.RESET + "" + ChatColor.BOLD + " : " + ErrReporter.get("cmd.desc.reload"));
        sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + " /arirang view [script]" + ChatColor.RESET + "" + ChatColor.BOLD + " : " + ErrReporter.get("cmd.desc.view"));
        sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + " /arirang test [code]" + ChatColor.RESET + "" + ChatColor.BOLD + " : " + ErrReporter.get("cmd.desc.test"));
        sender.sendMessage("");
    }
}