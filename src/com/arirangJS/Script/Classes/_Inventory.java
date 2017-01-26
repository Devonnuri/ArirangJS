package com.arirangJS.Script.Classes;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.annotations.JSConstructor;
import org.mozilla.javascript.annotations.JSFunction;

import com.arirangJS.Script.ScriptManager;

public class _Inventory extends ScriptableObject {

	private static final long serialVersionUID = -8479061051661200182L;

	public Inventory inv;
	
	public _Inventory() {}
	
	public _Inventory(Inventory inv) {
		this.inv = inv;
	}
	
	public _Inventory(Player player) {
		this.inv = player.getInventory();
	}
	
	@JSConstructor
	public _Inventory(int size) {
		this(size, "");
	}
	
	@JSConstructor
	public _Inventory(int size, String title) {
		this.inv = Bukkit.createInventory(null, size, title);
	}
	
	@Override
	public String getClassName() {
		return "Inventory";
	}
	
	@SuppressWarnings("deprecation")
	@JSFunction
	public void addItem(int id, int amount, int damage) {
		inv.addItem(new ItemStack(id, amount, (short) damage));
	}
	
	@JSFunction
	public void clear() {
		inv.clear();
	}
	
	@SuppressWarnings("deprecation")
	@JSFunction
	public boolean containsID(int id) {
		return inv.contains(id);
	}
	
	@SuppressWarnings("deprecation")
	@JSFunction
	public boolean containsItem(int id, int amount) {
		return inv.contains(new ItemStack(id, amount));
	}
	
	@SuppressWarnings("deprecation")
	@JSFunction
	public boolean containsItemDamage(int id, int amount, int damage) {
		return inv.contains(new ItemStack(id, amount, (short) damage));
	}
	
	@SuppressWarnings("deprecation")
	@JSFunction
	public int first(int id) {
		return inv.first(id);
	}
	
	@JSFunction
	public int firstEmpty() {
		return inv.firstEmpty();
	}
	
	@JSFunction
	public String getContents() {
		String contents = "[]";
		ItemStack[] contentList = inv.getContents();
		if(inv.getContents() != null) {
			contents = "[";
			for(ItemStack item : contentList) {
				contents += ScriptManager.itemToJSON(item)+",";
			}
			contents = contents.substring(0, contents.length()-1);
			contents += "]";
		}
		return contents;
	}
	
	@JSFunction
	public String getItem(int index) {
		return ScriptManager.itemToJSON(inv.getItem(index));
	}
	
	@JSFunction
	public String getLocation() {
		return ScriptManager.locToJSON(inv.getLocation());
	}
	
	@JSFunction
	public int getMaxStackSize() {
		return inv.getMaxStackSize();
	}
	
	@JSFunction
	public String getName() {
		return inv.getName();
	}
	
	@JSFunction
	public int getSize() {
		return inv.getSize();
	}
	
	@JSFunction
	public String getStorageContents() {
		String contents = "[]";
		ItemStack[] contentList = inv.getStorageContents();
		if(inv.getContents() != null) {
			contents = "[";
			for(ItemStack item : contentList) {
				contents += ScriptManager.itemToJSON(item)+",";
			}
			contents = contents.substring(0, contents.length()-1);
			contents += "]";
		}
		return contents;
	}
	
	@JSFunction
	public String getTitle() {
		return inv.getTitle();
	}
	
	@JSFunction
	public String getViewers() {
		String viewers = "[]";
		if(inv.getViewers() != null) {
			viewers = "[";
			for(HumanEntity player : inv.getViewers()) {
				viewers += player.getName()+",";
			}
			viewers = viewers.substring(0, viewers.length()-1);
			viewers += "]";
		}
		return viewers;
	}
	
	@SuppressWarnings("deprecation")
	@JSFunction
	public void remove(int id) {
		inv.remove(id);
	}
	
	@SuppressWarnings("deprecation")
	@JSFunction
	public void setItem(int index, int id, int amount, int damage) {
		inv.setItem(index, new ItemStack(id, amount, (short) damage));
	}
	
	@SuppressWarnings("deprecation")
	@JSFunction
	public void setItem2(int index, int id, int amount, int damage, String displayName, String lore) {
		ItemStack item = new ItemStack(id, amount, (short) damage);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(displayName);
		meta.setLore(Arrays.asList(lore.split("\\|\\|")));
		item.setItemMeta(meta);
		inv.setItem(index, item);
	}
	
	@JSFunction
	public void setMaxStackSize(int size) {
		inv.setMaxStackSize(size);
	}
}
