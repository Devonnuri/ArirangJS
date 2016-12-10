package com.arirangJS.Script.Classes;

import org.mozilla.javascript.ScriptableObject;

public abstract class _Player extends ScriptableObject {
	
	private static final long serialVersionUID = 583488239536525223L;
	
	@Override
	public String getClassName() {
		return "Player";
	}
}
