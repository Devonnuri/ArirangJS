package com.arirangJS.Script.Classes;

import com.arirangJS.Debug.Debug;
import com.arirangJS.Util.FileSystem;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.annotations.JSConstructor;
import org.mozilla.javascript.annotations.JSFunction;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class _Var extends ScriptableObject {
	/* 
	 * Example
	 * {
	 *    "variables": [
	 *       {
	 *          "key": "test1",
	 *          "value": "Hello, World!",
	 *          "created": "2017-01-30 21:44:32.285"
	 *       }
	 *    ]
	 * }
	 */
	
	
	private static final long serialVersionUID = 1646844363497398152L;

	@Override
	public String getClassName() {
		return "Var";
	}
	
	static File file;
	
	@JSConstructor
	public _Var() {
		file = null;
	}
	
	@JSConstructor
	public _Var(String address) {
		file = new File(FileSystem.LOC_VAR+address+".json");
		
		if(!file.exists()) {
			FileSystem.writeRaw(file, "{\"variables\": []}");
		}
	}
	
	@SuppressWarnings("unchecked")
	@JSFunction
	public static void set(String key, String value) {
		checkNull();

		JSONParser parser = new JSONParser();
		JSONObject json_root;
		try {
			json_root = (JSONObject) parser.parse(new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8")));
		} catch (ParseException e) {
			Debug.danger("JSON Parsing failed");
			e.printStackTrace();
			return;
		} catch (IOException e) {
			Debug.danger("IOException occured while parsing JSON");
			e.printStackTrace();
			return;
		}
		
		JSONArray json_variables = (JSONArray) json_root.get("variables");
		JSONObject keyset = new JSONObject();
		keyset.put("key", key);
		keyset.put("value", value);
		keyset.put("created", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
		
		int index = -1;
		for(Object obj : json_variables) {
			index++;
			if(((JSONObject) obj).get("key").toString().equals(key)) {
				break;
			}
		}
		
		if(get(key) != null) {
			json_variables.remove(index);
		}
		
		json_variables.add(keyset);
		json_root.put("variables", json_variables);
		
		FileSystem.writeRaw(file, json_root.toJSONString());
	}
	
	@JSFunction
	public static String get(String key) {
		checkNull();
		
		JSONParser parser = new JSONParser();
		JSONObject json_root;
		try {
			json_root = (JSONObject) parser.parse(new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8")));
		} catch (ParseException e) {
			Debug.danger("JSON Parsing failed");
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			Debug.danger("IOException occured while parsing JSON");
			e.printStackTrace();
			return null;
		}
		
		JSONArray json_variables = (JSONArray) json_root.get("variables");
		for(Object obj : json_variables) {
			JSONObject tmp = (JSONObject) obj;
			
			if(tmp.get("key").toString().equals(key))
				return tmp.get("value").toString();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@JSFunction
	public static void remove(String key) {
		checkNull();

		JSONParser parser = new JSONParser();
		JSONObject json_root;
		try {
			json_root = (JSONObject) parser.parse(new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8")));
		} catch (ParseException e) {
			Debug.danger("JSON Parsing failed");
			e.printStackTrace();
			return;
		} catch (IOException e) {
			Debug.danger("IOException occured while parsing JSON");
			e.printStackTrace();
			return;
		}
		
		JSONArray json_variables = (JSONArray) json_root.get("variables");
		JSONObject keyset = new JSONObject();
		
		int index = -1;
		for(Object obj : json_variables) {
			index++;
			if(((JSONObject) obj).get("key").toString().equals(key)) {
				break;
			}
		}
		
		if(get(key) == null) {
			return;
		}
		
		json_variables.remove(index);
		
		json_variables.add(keyset);
		json_root.put("variables", json_variables);
		
		FileSystem.writeRaw(file, json_root.toJSONString());
	}

	public static void resetAll() {
		for(File file : new File(FileSystem.LOC_VAR).listFiles()) {
			if(file.isDirectory()) break;
			if(!file.getName().endsWith(".json")) break;

			FileSystem.writeRaw(file, "{\"variables\": []}");
		}
	}
	
	private static void checkNull() {
		if(file == null) throw new IllegalArgumentException("Constructor \"Var\" cannot be empty");
	}
}
