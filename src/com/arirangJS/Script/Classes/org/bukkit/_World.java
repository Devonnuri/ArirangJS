package com.arirangJS.Script.Classes.org.bukkit;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.annotations.JSConstructor;
import org.mozilla.javascript.annotations.JSFunction;

import com.arirangJS.Script.Classes.org.bukkit.block._Block;

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
	
	@JSFunction
	public Entity[] getEntities() {
		return world.getEntities().toArray(new Entity[0]);
	}
	
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
	public LivingEntity[] getLivingEntities() {
		return world.getLivingEntities().toArray(new LivingEntity[0]);
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
	
	@JSFunction
	public Entity[] getNearbyEntities(double x, double y, double z, double offsetX, double offsetY, double offsetZ) {
		return world.getNearbyEntities(new Location(world, x, y, z), offsetX, offsetY, offsetZ).toArray(new Entity[0]);
	}
	
	@JSFunction
	public Player[] getPlayers() {
		return world.getPlayers().toArray(new Player[0]);
	}
	
	@JSFunction
	public boolean getPVP() {
		return world.getPVP();
	}
	
	@JSFunction
	public int getSeaLevel() {
		return world.getSeaLevel();
	}
	
	@JSFunction
	public int getSeed() {
		return (int) world.getSeed();
	}
	
	@JSFunction
	public double[] getSpawnLocation() {
		Location loc = world.getSpawnLocation();
		return new double[] {
			loc.getX(),
			loc.getY(),
			loc.getZ()
		};
	}
	
	@JSFunction
	public double getTemperature(int x, int z) {
		return world.getTemperature(x, z);
	}
	
	@JSFunction
	public int getThunderDuration() {
		return world.getThunderDuration();
	}
	
	@JSFunction
	public int getTicksPerAnimalSpawns() {
		return (int) world.getTicksPerAnimalSpawns();
	}
	
	@JSFunction
	public int getTicksPerMonsterSpawns() {
		return (int) world.getTicksPerMonsterSpawns();
	}
	
	@JSFunction
	public int getTime() {
		return (int) world.getTime();
	}
	
	@JSFunction
	public String getUID() {
		return world.getUID().toString();
	}
	
	@JSFunction
	public int getWaterAnimalSpawnLimit() {
		return world.getWaterAnimalSpawnLimit();
	}
	
	@JSFunction
	public int getWeatherDuration() {
		return world.getWeatherDuration();
	}
	
	@JSFunction
	public int getWorldType() {
		return world.getWorldType().ordinal();
	}
	
	@JSFunction
	public boolean hasStorm() {
		return world.hasStorm();
	}
	
	@JSFunction
	public boolean isAutoSave() {
		return world.isAutoSave();
	}
	
	@JSFunction
	public boolean isChunkInUse(int x, int z) {
		return world.isChunkInUse(x, z);
	}
	
	@JSFunction
	public boolean isChunkLoaded(int x, int z) {
		return world.isChunkLoaded(x, z);
	}
	
	@JSFunction
	public boolean isGameRule(String rule) {
		return world.isGameRule(rule);
	}
	
	@JSFunction
	public boolean isThundering() {
		return world.isThundering();
	}
	
	@JSFunction
	public void loadChunk(int x, int z) {
		world.loadChunk(x, z);
	}
	
	@JSFunction
	public boolean loadChunk2(int x, int z, boolean generate) {
		return world.loadChunk(x, z, generate);
	}
	
	@JSFunction
	public void playSound(double x, double y, double z, int sound, double volume, double pitch) {
		 world.playSound(new Location(world, x, y, z), Sound.values()[sound], (float) volume, (float) pitch);
	}
	
	@JSFunction
	public void playSoundStr(double x, double y, double z, String sound, double volume, double pitch) {
		 world.playSound(new Location(world, x, y, z), sound, (float) volume, (float) pitch);
	}
	
	@JSFunction
	public boolean regenerateChunk(int x, int z) {
		return world.regenerateChunk(x, z);
	}
	
	@JSFunction
	public void save() {
		world.save();
	}
	
	@JSFunction
	public void setAmbientSpawnLimit(int limit) {
		world.setAmbientSpawnLimit(limit);
	}
	
	@JSFunction
	public void setAnimalSpawnLimit(int limit) {
		world.setAnimalSpawnLimit(limit);
	}
	
	@JSFunction
	public void setAutoSave(boolean value) {
		world.setAutoSave(value);
	}
	
	@JSFunction
	public void setBiome(int x, int z, int bio) {
		world.setBiome(x, z, Biome.values()[bio]);
	}
	
	@JSFunction
	public void setDifficulty(int difficulty) {
		world.setDifficulty(Difficulty.values()[difficulty]);
	}
	
	@JSFunction
	public void setFullTime(int time) {
		world.setFullTime((long) time);
	}
	
	@JSFunction
	public boolean setGameRuleValue(String rule, String value) {
		return world.setGameRuleValue(rule, value);
	}
	
	@JSFunction
	public void setKeepSpawnInMemory(boolean keepLoaded) {
		world.setKeepSpawnInMemory(keepLoaded);
	}
	
	@JSFunction
	public void setMonsterSpawnLimit(int limit) {
		world.setMonsterSpawnLimit(limit);
	}
	
	@JSFunction
	public void setStorm(boolean hasStorm) {
		world.setStorm(hasStorm);
	}
	
	@JSFunction
	public void setThunderDuration(int duration) {
		world.setThunderDuration(duration);
	}
}
