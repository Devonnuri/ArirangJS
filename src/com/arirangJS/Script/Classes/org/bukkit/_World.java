package com.arirangJS.Script.Classes.org.bukkit;

import java.util.Arrays;

import com.arirangJS.Script.Classes.org.bukkit.block._Block;
import com.arirangJS.Script.Classes.org.bukkit.entity._LivingEntity;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.annotations.JSConstructor;
import org.mozilla.javascript.annotations.JSFunction;

@SuppressWarnings("unused")
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
	
	@JSFunction
	public _Block getBlockAt(int x, int y, int z) {
		return new _Block(world.getBlockAt(x, y, z));
	}
	
	@SuppressWarnings("deprecation")
	@JSFunction
	public int getBlockTypeIdAt(int x, int y, int z) {
		return world.getBlockTypeIdAt(x, y, z);
	}
	
	/* TODO: Chunk getChunkAt(Block block)
	 * TODO: Chunk getChunkAt(int x, int z)
	 * No Chunk Class
	 */
	
	@JSFunction
	public int getDifficulty() {
		return world.getDifficulty().ordinal();
	}
	
	/* TODO: ChunkSnapshot getEmptyChunkSnapshot(int x, int z, boolean includeBiome, boolean includeBiomeTempRain)
	 * No ChunkSnapshot Class
	 */
	
	/* TODO: List<Entity> getEntities()
	 * No Entity Class
	 */
	
	@JSFunction
	public int getEnvironment() {
		return world.getEnvironment().ordinal();
	}
	
	@JSFunction
	public long getFullTime() {
		return world.getFullTime();
	}
	
	@JSFunction
	public String[] getGameRules() {
		return world.getGameRules();
	}
	
	/* TODO: ChunkGenerator getGenerator()
	 * No ChunkGenerator Class
	 */
	
	@JSFunction
	public _Block getHighestBlockAt(int x, int z) {
		return new _Block(world.getHighestBlockAt(x, z));
	}
	
	@JSFunction
	public int getHighestBlockYAt(int x, int z) {
		return world.getHighestBlockYAt(x, z);
	}
	
	@JSFunction
	public double getHumidity(int x, int z) {
		return world.getHumidity(x, z);
	}
	
	@JSFunction
	public boolean getKeepSpawnInMemory() {
		return world.getKeepSpawnInMemory();
	}
	
	@JSFunction
	public _LivingEntity[] getLivingEntities() {
		_LivingEntity[] result = new _LivingEntity[world.getLivingEntities().size()];
		
		int index = 0;
		for(LivingEntity entity : world.getLivingEntities()) {
			result[index] = new _LivingEntity(entity);
		}
		
		return result;
	}
	
	@JSFunction
	public int getMaxHeight() {
		return world.getMaxHeight();
	}
	
	@JSFunction
	public int getMonsterSpawnLimit() {
		return world.getMonsterSpawnLimit();
	}
	
	@JSFunction
	public String getName() {
		return world.getName();
	}
	
	public enum Environment {
	    NORMAL, NETHER, THE_END
	}
}
