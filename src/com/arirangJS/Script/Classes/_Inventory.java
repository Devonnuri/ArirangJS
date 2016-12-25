package com.arirangJS.Script.Classes;

import org.bukkit.inventory.Inventory;
import org.mozilla.javascript.ScriptableObject;

public class _Inventory extends ScriptableObject {

	private static final long serialVersionUID = -8479061051661200182L;

	public Inventory inv;
	
	public _Inventory() {}
	
	@Override
	public String getClassName() {
		return "Inventory";
	}

}
