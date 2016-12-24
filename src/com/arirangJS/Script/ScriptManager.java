package com.arirangJS.Script;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.NativeObject;
import org.mozilla.javascript.RhinoException;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

import com.arirangJS.Debug.Debug;
import com.arirangJS.File.FileSystem;
import com.arirangJS.Main.Main;
import com.arirangJS.Script.Classes._Biome;
import com.arirangJS.Script.Classes._Bukkit;
import com.arirangJS.Script.Classes._ChatColor;
import com.arirangJS.Script.Classes._Event;
import com.arirangJS.Script.Classes._Player;


public class ScriptManager implements Listener {
	public static void callMethod(String functionName, Object... args) {
		for(String filename : Main.scripts) {
			Context context = Context.enter();
			Scriptable scope = context.initStandardObjects();
			
			try {
				ScriptableObject.defineClass(scope, _Bukkit.class);
				ScriptableObject.defineClass(scope, _Player.class);
				ScriptableObject.defineClass(scope, _Event.class);
				ScriptableObject.putProperty(scope, "ChatColor", constantsToObj(_ChatColor.class));
				ScriptableObject.putProperty(scope, "Biome", constantsToObj(_Biome.class));
				context.evaluateReader(scope, new FileReader(FileSystem.LOC_SCRIPT+filename), filename, 0, null);
				Object object = scope.get(functionName, scope);
				
				if(object != null && object instanceof Function) {
					Function function = (Function) object;
					function.call(context, scope, scope, args);
				}
			} catch(RhinoException e) {
				Debug.danger(e.getMessage()+" ("+e.lineNumber()+", "+e.columnNumber()+")");
			} catch(IOException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
				Debug.danger("An error occured while compiling code.");
			} finally {
				Context.exit();
			}
		}
	}
	
	public static ScriptableObject constantsToObj(Class<?> clazz) {
		ScriptableObject obj = new NativeObject();
		for(Field field : clazz.getFields()) {
			try {
				obj.putConst(field.getName(), obj, field.get(null));
			} catch (IllegalArgumentException | IllegalAccessException e) {
				Debug.danger("An error occured translate class to jsObject");
				e.printStackTrace();
			}
		}
		
		return obj;
	}
	
	public static String locToJSON(Location location) {
		double x = location.getX();
		double y = location.getY();
		double z = location.getZ();
		float yaw = location.getYaw();
		float pitch = location.getPitch();
		int blockX = location.getBlockX();
		int blockY = location.getBlockY();
		int blockZ = location.getBlockZ();
		
		String result = String.format("({x: %f, y: %f, z: %f, yaw: %f, pitch: %f, blockX: %d, blockY: %d, blockZ: %d})",
				x, y, z, yaw, pitch, blockX, blockY, blockZ);
		return result;
	}
	
	@SuppressWarnings("deprecation")
	public static String blockToJSON(Block block) {
		int x = block.getX();
		int y = block.getY();
		int z = block.getZ();
		int id = block.getTypeId();
		int damage = block.getData();
		int biome = block.getBiome().ordinal();
		
		String result = String.format("({x: %d, y: %d, z: %d, id: %d, damage: %d, biome: %d})",
				x, y, z, id, damage, biome);
		return result;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Main.joinMessage = e.getJoinMessage();
		callMethod("onPlayerJoin", e.getPlayer().getName());
		e.setJoinMessage(Main.joinMessage);
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		Main.quitMessage = e.getQuitMessage();
		callMethod("onPlayerQuit", e.getPlayer().getName());
		e.setQuitMessage(Main.quitMessage);
	}
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		callMethod("onPlayerMove", e.getPlayer().getName(), locToJSON(e.getFrom()), locToJSON(e.getTo()));
	}
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		Main.chatFormat = e.getFormat();
		callMethod("onPlayerChat", e.getPlayer().getName(), e.getMessage());
		e.setFormat(Main.chatFormat);
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		Main.isCanceled.put(e.getEventName(), false);
		callMethod("onBlockPlace", e.getPlayer().getName(), blockToJSON(e.getBlock()));
		e.setCancelled(Main.isCanceled.get(e.getEventName()));
	}
}
