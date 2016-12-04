package com.arirangJS.Script;

import java.util.Arrays;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.RhinoException;
import org.mozilla.javascript.Scriptable;

import com.arirangJS.Debug.Debug;

public class ScriptManager {
	String code;
	int line=1;
	
	public ScriptManager(String code) {
		this.code = code;
	}
	
	public ScriptManager(String[] code) {
		this.code = Arrays.toString(code);
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
			
			result = context.evaluateString(scope, code, "<cmd>", line, null);
		} catch(RhinoException e) {
			Debug.danger(e.getMessage());
		} finally {
			Context.exit();
		}
		
		return result;
	}
}
