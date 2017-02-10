package com.arirangJS.Script.Classes;

import org.bukkit.Bukkit;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.annotations.JSStaticFunction;

@SuppressWarnings("unused")
public class _Bukkit extends ScriptableObject {
	private static final long serialVersionUID = -3993427606107770469L;
	
	@Override
	public String getClassName() {
		return "Bukkit";
	}
	
	@JSStaticFunction
	public static void broadcastMessage(String message) {
		Bukkit.broadcastMessage(message);
	}
	
	@JSStaticFunction
	public static void banIP(String address) {
		Bukkit.banIP(address);
	}
	
	@JSStaticFunction
	public static void clearRecipes() {
		Bukkit.clearRecipes();
	}
	
	@JSStaticFunction
	public static boolean getAllowEnd() {
		return Bukkit.getAllowEnd();
	}
	
	@JSStaticFunction
	public static boolean getAllowFlight() {
		return Bukkit.getAllowFlight();
	}
	
	@JSStaticFunction
	public static boolean getAllowNether() {
		return Bukkit.getAllowNether();
	}
	
	@JSStaticFunction
	public static int getAmbientSpawnLimit() {
		return Bukkit.getAmbientSpawnLimit();
	}
	
	@JSStaticFunction
	public static int getAnimalSpawnLimit() {
		return Bukkit.getAnimalSpawnLimit();
	}
	
	@JSStaticFunction
	public static String getBukkitVersion() {
		return Bukkit.getBukkitVersion();
	}
	
	@JSStaticFunction
	public static long getConnectionThrottle() {
		return Bukkit.getConnectionThrottle();
	}
	
	@JSStaticFunction
	public static boolean getGenerateStructures() {
		return Bukkit.getGenerateStructures();
	}
	
	@JSStaticFunction
	public static int getIdleTimeout() {
		return Bukkit.getIdleTimeout();
	}
	
	@JSStaticFunction
	public static String getIp() {
		return Bukkit.getIp();
	}
	
	@JSStaticFunction
	public static int getMaxPlayers() {
		return Bukkit.getMaxPlayers();
	}
	
	@JSStaticFunction
	public static int getMonsterSpawnLimit() {
		return Bukkit.getMonsterSpawnLimit();
	}
	
	@JSStaticFunction
	public static void sendConsole(String msg) {
		Bukkit.getConsoleSender().sendMessage(msg);
	}
}