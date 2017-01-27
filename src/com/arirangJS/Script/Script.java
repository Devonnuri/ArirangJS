package com.arirangJS.Script;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.NativeObject;
import org.mozilla.javascript.RhinoException;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

import com.arirangJS.Debug.Debug;
import com.arirangJS.File.FileSystem;
import com.arirangJS.Script.Classes._Action;
import com.arirangJS.Script.Classes._Biome;
import com.arirangJS.Script.Classes._Bukkit;
import com.arirangJS.Script.Classes._ChatColor;
import com.arirangJS.Script.Classes._Effect;
import com.arirangJS.Script.Classes._Event;
import com.arirangJS.Script.Classes._Inventory;
import com.arirangJS.Script.Classes._Player;
import com.arirangJS.Script.Classes._Request;

public class Script {
	public String filename;
	public ArrayList<String> errors = new ArrayList<String>();
	public Scriptable scope = null;
	
	public Script(String filename) {
		Context context = Context.enter();
		Scriptable scope = context.initStandardObjects();
		
		try {
			ScriptableObject.defineClass(scope, _Bukkit.class);
			ScriptableObject.defineClass(scope, _Player.class);
			ScriptableObject.defineClass(scope, _Event.class);
			ScriptableObject.defineClass(scope, _Inventory.class);
			ScriptableObject.defineClass(scope, _Effect.class);
			ScriptableObject.defineClass(scope, _Request.class);
			ScriptableObject.putProperty(scope, "ChatColor", constantsToObj(_ChatColor.class));
			ScriptableObject.putProperty(scope, "Biome", constantsToObj(_Biome.class));
			ScriptableObject.putProperty(scope, "Action", constantsToObj(_Action.class));
			
			FileInputStream inStream = new FileInputStream(FileSystem.LOC_SCRIPT+filename);
			BufferedReader reader = new BufferedReader(new InputStreamReader(inStream, "UTF-8"));
			context.evaluateReader(scope, reader, filename, 0, null);
			
			this.filename = filename;
			this.scope = scope;
		} catch(RhinoException e) {
			this.errors.add(e.getMessage());
			Debug.danger(e.getMessage()+" ("+e.lineNumber()+", "+e.columnNumber()+")");
		} catch(IOException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
			this.errors.add(e.getMessage());
			Debug.danger("An error occured while compiling code.");
		} finally {
			Context.exit();
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
}