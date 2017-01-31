package com.arirangJS.Script.Classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.annotations.JSConstructor;
import org.mozilla.javascript.annotations.JSFunction;

import com.arirangJS.Debug.Debug;
import com.arirangJS.File.FileSystem;

public class _Var extends ScriptableObject {
	/* 
	 * Example
	 * {
	 *    "variables": [
	 *       {
	 *          "key": "test1",
	 *          "value": "Hello, World!",
	 *          "created": "2017-01-30 21:44"
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
		
		FileSystem.writeRaw(file,
						"{",
						"	\"variables\": []",
						"}");
	}
	
	@JSFunction
	public static void set(String key, String value) {
		checkNull();
		
		JSONParser parser = new JSONParser();
		JSONObject object;
		try {
			object = (JSONObject) parser.parse(new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8")));
		} catch (ParseException e) {
			Debug.danger("JSON Parsing failed");
			e.printStackTrace();
			return;
		} catch (IOException e) {
			Debug.danger("IOException occured while parsing JSON");
			e.printStackTrace();
			return;
		}
		
		if(object.get("variables") == null) {
			FileSystem.writeRaw(file,
					"{",
					"	\"variables\": []",
					"}");
		}
		
		JSONArray variables = (JSONArray) object.get("variables");
		
		for(Object obj : variables) {
			JSONObject set = (JSONObject) obj;
			if(key.equals(set.get("key"))) {
				variables.remove(obj);
				// TODO: 아직 안끝났으여!
			}
		}
	}
	
	private static void checkNull() {
		if(file == null) throw new IllegalArgumentException("Constructor \"Var\" cannot be empty");
	}
}
