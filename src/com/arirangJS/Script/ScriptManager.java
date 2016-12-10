package com.arirangJS.Script;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
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


public class ScriptManager implements Listener {
	public static void callMethod(String functionName, Object... args) {
		for(String filename : Main.scripts) {
			Context context = Context.enter();
			Scriptable scope = context.initStandardObjects();
			
			try {
				ScriptableObject.defineClass(scope, com.arirangJS.Script.Classes._Bukkit.class);
				ScriptableObject.putProperty(scope, "ChatColor",
				constantsToObj(com.arirangJS.Script.Classes._ChatColor.class));
				context.evaluateReader(scope, new FileReader(FileSystem.LOC_SCRIPT+filename), filename, 0, null);
				Object object = scope.get(functionName, scope);
				
				if(object != null && object instanceof Function) {
					Function function = (Function) object;
					function.call(context, scope, scope, args);
				}
			} catch(RhinoException e) {
				Debug.danger(e.getMessage());
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
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		callMethod("onPlayerJoin");
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		callMethod("onPlayerQuit");
	}
}
