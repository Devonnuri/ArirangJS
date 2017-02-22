package com.arirangJS.Script.Classes.org.bukkit.entity;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.annotations.JSStaticFunction;

public class _Player extends ScriptableObject {
	
	private static final long serialVersionUID = 583488239536525223L;
	
	public _Player() {}
	
	@Override
	public String getClassName() {
		return "Player";
	}
	
	@JSStaticFunction
	public static Player get(String name) {
		return Bukkit.getPlayer(name);
	}
}
