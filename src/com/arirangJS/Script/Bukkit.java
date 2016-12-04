package com.arirangJS.Script;

import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.annotations.JSFunction;

public class Bukkit extends ScriptableObject {
	
	private static final long serialVersionUID = -310855388331344787L;

	public Bukkit() {
		
	}
	
	@Override
	public String getClassName() {
		return "Bukkit";
	}
	
	@JSFunction
	public static void broadcastMessage(String str) {
		org.bukkit.Bukkit.broadcastMessage(str);
	}

}