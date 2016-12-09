package com.arirangJS.Script;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.NativeObject;
import org.mozilla.javascript.RhinoException;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

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
			ScriptableObject.defineClass(scope, com.arirangJS.Script.Classes._Bukkit.class);
			
			ScriptableObject.putProperty(scope, "ChatColor", constantsToObj(com.arirangJS.Script.Classes._ChatColor.class));
			
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

}
