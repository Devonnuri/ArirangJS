package com.arirangJS.Script;

import java.lang.reflect.InvocationTargetException;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.RhinoException;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.annotations.JSConstructor;
import org.mozilla.javascript.annotations.JSStaticFunction;

import com.arirangJS.Debug.Debug;

public class ScriptManager {
	String code;
	int line=1;
	
	public ScriptManager(String code) {
		this.code = code;
	}
	
	public ScriptManager(String[] code) {
		String str = "";
		for(String temp : code) {
			str += temp;
		}
		
		this.code = str;
		this.line = code.length;
	}
	
	public static String toString(Object object) {
		return Context.toString(object);
	}
	
	public Object run() {
		Context context = Context.enter();
		
		Object result = null;
		
		try {
			Scriptable scope = context.initStandardObjects();
			
			ScriptableObject.defineClass(scope, _Bukkit.class);
			
			result = context.evaluateString(scope, code, "<cmd>", line, null);
		} catch(RhinoException e) {
			Debug.danger(e.getMessage());
		} catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
			Debug.danger("An error occured while compiling code.");
			e.printStackTrace();
		} finally {
			Context.exit();
		}
		
		return result;
	}
	
	public static class _Bukkit extends ScriptableObject {

		private static final long serialVersionUID = -3993427606107770469L;
		
		@JSConstructor
	    public _Bukkit() {}
		
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
	}
}
