package com.arirangJS.Script.Classes;

import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.annotations.JSStaticFunction;

public class _Bukkit extends ScriptableObject {
	private static final long serialVersionUID = -3993427606107770469L;
	
	@Override
	public String getClassName() {
		return "Bukkit";
	}
	
	@JSStaticFunction
	public static void broadcastMessage(String message) {
		org.bukkit.Bukkit.broadcastMessage(message);
	}
	
	@JSStaticFunction
	public static void banIP(String address) {
		org.bukkit.Bukkit.banIP(address);
	}
	
	@JSStaticFunction
	public static void clearRecipes() {
		org.bukkit.Bukkit.clearRecipes();
	}
	
	@JSStaticFunction
	public static boolean getAllowEnd() {
		return org.bukkit.Bukkit.getAllowEnd();
	}
	
	@JSStaticFunction
	public static boolean getAllowFlight() {
		return org.bukkit.Bukkit.getAllowFlight();
	}
	
	@JSStaticFunction
	public static boolean getAllowNether() {
		return org.bukkit.Bukkit.getAllowNether();
	}
	
	@JSStaticFunction
	public static int getAmbientSpawnLimit() {
		return org.bukkit.Bukkit.getAmbientSpawnLimit();
	}
	
	@JSStaticFunction
	public static int getAnimalSpawnLimit() {
		return org.bukkit.Bukkit.getAnimalSpawnLimit();
	}
	
	@JSStaticFunction
	public static String getBukkitVersion() {
		return org.bukkit.Bukkit.getBukkitVersion();
	}
	
	@JSStaticFunction
	public static long getConnectionThrottle() {
		return org.bukkit.Bukkit.getConnectionThrottle();
	}
	
	@JSStaticFunction
	public static boolean getGenerateStructures() {
		return org.bukkit.Bukkit.getGenerateStructures();
	}
	
	@JSStaticFunction
	public static int getIdleTimeout() {
		return org.bukkit.Bukkit.getIdleTimeout();
	}
	
	@JSStaticFunction
	public static String getIp() {
		return org.bukkit.Bukkit.getIp();
	}
	
	@JSStaticFunction
	public static int getMaxPlayers() {
		return org.bukkit.Bukkit.getMaxPlayers();
	}
	
	@JSStaticFunction
	public static int getMonsterSpawnLimit() {
		return org.bukkit.Bukkit.getMonsterSpawnLimit();
	}
}