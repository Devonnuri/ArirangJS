package com.arirangJS.Script;

import java.util.Arrays;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.RhinoException;
import org.mozilla.javascript.Scriptable;

import com.arirangJS.Debug.Debug;

public class Script {
	String code;
	
	public Script(String code) {
		this.code = code;
	}
	
	public Script(String[] code) {
		this.code = Arrays.toString(code);
	}
	
	public static String toString(Object object) {
		return Context.toString(object);
	}
	
	public Object run() {
		Context context = Context.enter();
		
		Object result = null;
		
		try {
			Scriptable scope = context.initStandardObjects();
			
			result = context.evaluateString(scope, code, "<cmd>", 1, null);
		} catch(RhinoException e) {
			Debug.danger(e.getMessage());
		} finally {
			Context.exit();
		}
		
		return result;
	}
}
