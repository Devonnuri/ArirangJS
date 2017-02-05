package com.arirangJS.Script.Classes;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.annotations.JSConstructor;
import org.mozilla.javascript.annotations.JSFunction;

public class _World extends ScriptableObject {

	private static final long serialVersionUID = 7701770472409202118L;

	public World world;
	
	@Override
	public String getClassName() {
		return "World";
	}
	
	@JSConstructor
	public _World() {}
	
	@JSConstructor
	public _World(String name) {
		world = Bukkit.getWorld(name);
	}
	
	public _World(World world) {
		this.world = world;
	}
	
	@JSFunction
	public boolean canGenerateStructures() {
		return world.canGenerateStructures();
	}
	
	@JSFunction
	public boolean createExplosion(double x, double y, double z, double power) {
		return world.createExplosion(x, y, z, (float) power);
	}
	
	@JSFunction
	public boolean createExplosion2(double x, double y, double z, double power, boolean setFire, boolean breakBlocks) {
		return world.createExplosion(x, y, z, (float) power, setFire, breakBlocks);
	}
	
	@SuppressWarnings("deprecation")
	@JSFunction
	public void dropItem(double x, double y, double z, int id, int amount, int damage) {
		world.dropItem(new Location(world, x, y, z), new ItemStack(id, amount, (short) damage));
	}
	
	@SuppressWarnings("deprecation")
	@JSFunction
	public void dropItem2(double x, double y, double z, int id, int amount, int damage, String displayName, String lore) {
		ItemStack item = new ItemStack(id, amount, (short) damage);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(displayName);
		meta.setLore(Arrays.asList(lore.split("\\|\\|")));
		item.setItemMeta(meta);
		
		world.dropItem(new Location(world, x, y, z), item);
	}
	
	@SuppressWarnings("deprecation")
	@JSFunction
	public void dropItemNaturally(double x, double y, double z, int id, int amount, int damage) {
		world.dropItemNaturally(new Location(world, x, y, z), new ItemStack(id, amount, (short) damage));
	}
	
	@SuppressWarnings("deprecation")
	@JSFunction
	public void dropItemNaturally2(double x, double y, double z, int id, int amount, int damage, String displayName, String lore) {
		ItemStack item = new ItemStack(id, amount, (short) damage);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(displayName);
		meta.setLore(Arrays.asList(lore.split("\\|\\|")));
		item.setItemMeta(meta);
		
		world.dropItemNaturally(new Location(world, x, y, z), item);
	}
	
	@JSFunction
	public boolean generateTree(double x, double y, double z, int type) {
		return world.generateTree(new Location(world, x, y, z), TreeType.values()[type]);
	}
	
	@JSFunction
	public boolean getAllowAnimals() {
		return world.getAllowAnimals();
	}
	
	@JSFunction
	public boolean getAllowMonsters() {
		return world.getAllowMonsters();
	}
	
	@JSFunction
	public int getAmbientSpawnLimit() {
		return world.getAmbientSpawnLimit();
	}
	
	@JSFunction
	public int getAnimalsSpawnLimit() {
		return world.getAnimalSpawnLimit();
	}
	
	@JSFunction
	public int getBiome(int x, int z) {
		return world.getBiome(x, z).ordinal();
	}
}
