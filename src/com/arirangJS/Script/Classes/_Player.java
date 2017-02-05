package com.arirangJS.Script.Classes;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.annotations.JSConstructor;
import org.mozilla.javascript.annotations.JSFunction;

public class _Player extends ScriptableObject {
	
	private static final long serialVersionUID = 583488239536525223L;
	
	public Player player;
	
	public _Player() {}
	
	@JSConstructor
	public _Player(String name) {
		player = Bukkit.getPlayer(name);
	}
	
	public _Player(Player player) {
		this.player = player;
	}
	
	@Override
	public String getClassName() {
		return "Player";
	}
	
	@JSFunction
	public boolean canSee(_Player player) {
		return this.player.canSee(player.player);
	}
	
	@JSFunction
	public void chat(String msg) {
		player.chat(msg);
	}
	
	@JSFunction
	public boolean getAllowFlight() {
		return player.getAllowFlight();
	}
	
	@JSFunction
	public String getDisplayName() {
		return player.getDisplayName();
	}
	
	@JSFunction
	public double getExhaustion() {
		return player.getExhaustion();
	}
	
	@JSFunction
	public double getExp() {
		return player.getExp();
	}
	
	@JSFunction
	public double getFlySpeed() {
		return player.getFlySpeed();
	}
	
	@JSFunction
	public double getFoodLevel() {
		return player.getFoodLevel();
	}
	
	@JSFunction
	public double getHealthScale() {
		return (double) player.getHealthScale();
	}
	
	@JSFunction
	public int getLevel() {
		return player.getLevel();
	}
	
	@JSFunction
	public String getPlayerListName() {
		return player.getPlayerListName();
	}
	
	@JSFunction
	public int getPlayerTime() {
		return (int) player.getPlayerTime();
	}
	
	@JSFunction
	public int getPlayerTimeOffset() {
		return (int) player.getPlayerTimeOffset();
	}
	
	@JSFunction
	public double getSaturation() {
		return player.getSaturation();
	}
	
	@JSFunction
	public int getTotalExperience() {
		return player.getTotalExperience();
	}
	
	@JSFunction
	public double getWalkSpeed() {
		return player.getWalkSpeed();
	}
	
	@JSFunction
	public void giveExp(int amount) {
		player.giveExp(amount);
	}
	
	@JSFunction
	public void giveExpLevels(int amount) {
		player.giveExpLevels(amount);
	}
	
	@JSFunction
	public void hidePlayer(_Player player) {
		this.player.hidePlayer(player.player);
	}
	
	@JSFunction
	public boolean isFlying() {
		return player.isFlying();
	}
	
	@JSFunction
	public boolean isHealthScaled() {
		return player.isHealthScaled();
	}
	
	@JSFunction
	public boolean isPlayerTimeRelative() {
		return player.isPlayerTimeRelative();
	}
	
	@JSFunction
	public boolean isSleepingIgnored() {
		return player.isSleepingIgnored();
	}
	
	@JSFunction
	public boolean isSneaking() {
		return player.isSneaking();
	}
	
	@JSFunction
	public boolean isSprinting() {
		return player.isSprinting();
	}
	
	@JSFunction
	public void kickPlayer(String message) {
		player.kickPlayer(message);
	}
	
	@JSFunction
	public void loadData() {
		player.loadData();
	}
	
	@JSFunction
	public boolean performCommand(String command) {
		return player.performCommand(command);
	}
	
	@JSFunction
	public void resetPlayerTime() {
		player.resetPlayerTime();
	}
	
	@JSFunction
	public void resetPlayerWeather() {
		player.resetPlayerWeather();
	}
	
	@JSFunction
	public void saveData() {
		player.saveData();
	}

	@JSFunction
	public void sendRawMessage(String message) {
		player.sendRawMessage(message);
	}
	
	@JSFunction
	public void setAllowFlight(boolean flight) {
		player.setAllowFlight(flight);
	}
	
	@JSFunction
	public void setDisplayName(String name) {
		player.setDisplayName(name);
	}
	
	@JSFunction
	public void setExhaustion(double value) {
		player.setExhaustion((float) value);
	}
	
	@JSFunction
	public void setExp(double exp) {
		player.setExp((float) exp);
	}
	
	@JSFunction
	public void setFlying(boolean value) {
		player.setFlying(value);
	}
	
	@JSFunction
	public void setFlySpeed(double value) {
		player.setFlySpeed((float) value);
	}
	
	@JSFunction
	public void setFoodLevel(int value) {
		player.setFoodLevel(value);
	}
	
	@JSFunction
	public void setHealthScale(double scale) {
		player.setHealthScale(scale);
	}
	
	@JSFunction
	public void setHealthScaled(boolean scale) {
		player.setHealthScaled(scale);
	}
	
	@JSFunction
	public void setLevel(int level) {
		player.setLevel(level);
	}
	
	@JSFunction
	public void setPlayerListName(String name) {
		player.setPlayerListName(name);
	}
	
	@JSFunction
	public void setPlayerTime(int time, boolean relative) {
		player.setPlayerTime(time, relative);
	}
	
	@JSFunction
	public void setResourcePack(String url) {
		player.setResourcePack(url);
	}
	
	@JSFunction
	public void setSaturation(double value) {
		player.setSaturation((float) value);
	}
	
	@JSFunction
	public void setSleepingIgnored(boolean isSleeping) {
		player.setSleepingIgnored(isSleeping);
	}
	
	@JSFunction
	public void setSneaking(boolean sneak) {
		player.setSneaking(sneak);
	}
	
	@JSFunction
	public void setSprinting(boolean sprint) {
		player.setSprinting(sprint);
	}
	
	@JSFunction
	public void setTotalExperience(int exp) {
		player.setTotalExperience(exp);
	}
	
	@JSFunction
	public void setWalkSpeed(double value) {
		player.setWalkSpeed((float) value);
	}
	
	@JSFunction
	public void showPlayer(_Player player) {
		this.player.showPlayer(player.player);
	}
	
	// Methods inherited from interface org.bukkit.entity.HumanEntity
	@JSFunction
	public void closeInventory() {
		player.closeInventory();
	}
	
	@JSFunction
	public void openInventory(_Inventory inv) {
		player.openInventory(inv.inv);
	}
	
	@JSFunction
	public _Inventory getInventory() {
		return new _Inventory(player);
	}
	
	@JSFunction
	public int getExpToLevel() {
		return player.getExpToLevel();
	}
	
	@JSFunction
	public String getName() {
		return player.getName();
	}
	
	@JSFunction
	public int getSleepTicks() {
		return player.getSleepTicks();
	}
	
	@JSFunction
	public boolean isBlocking() {
		return player.isBlocking();
	}
	
	@JSFunction
	public boolean isSleeping() {
		return player.isSleeping();
	}
	
	//Methods inherited from interface org.bukkit.entity.LivingEntity
	
	@JSFunction
	public boolean getCanPickupItems() {
		return player.getCanPickupItems();
	}
	
	@JSFunction
	public double getEyeHeight() {
		return player.getEyeHeight();
	}
	
	@JSFunction
	public double getEyeHeightIgnoreSneak() {
		return player.getEyeHeight(true);
	}
	
	@JSFunction
	public _Player getKiller() {
		return new _Player(player.getKiller());
	}
	
	@JSFunction
	public double getLastDamage() {
		return player.getLastDamage();
	}
	
	@JSFunction
	public int getMaximumAir() {
		return player.getMaximumAir();
	}
	
	@JSFunction
	public int getMaximumNoDamageTicks() {
		return player.getMaximumNoDamageTicks();
	}
	
	@JSFunction
	public boolean hasAI() {
		return player.hasAI();
	}
	
	@JSFunction
	public boolean isCollidable() {
		return player.isCollidable();
	}
	
	@JSFunction
	public boolean isGliding() {
		return player.isGliding();
	}
	
	@JSFunction
	public boolean isLeashed() {
		return player.isLeashed();
	}
	
	@JSFunction
	public void setAI(boolean ai) {
		player.setAI(ai);
	}
	
	@JSFunction
	public void setCanPickupItems(boolean pickup) {
		player.setCanPickupItems(pickup);
	}
	
	@JSFunction
	public void setCollidable(boolean collidable) {
		player.setCollidable(collidable);
	}
	
	@JSFunction
	public void setGliding(boolean gliding) {
		player.setGliding(gliding);
	}
	
	@JSFunction
	public void setLastDamage(double damage) {
		player.setLastDamage(damage);
	}
	
	@JSFunction
	public void setMaximumAir(int ticks) {
		player.setMaximumAir(ticks);
	}
	
	@JSFunction
	public void setMaximumNoDamageTicks(int ticks) {
		player.setMaximumNoDamageTicks(ticks);
	}
	
	@JSFunction
	public void setNoDamageTicks(int ticks) {
		player.setNoDamageTicks(ticks);
	}
	
	@JSFunction
	public void setRemainingAir(int ticks) {
		player.setRemainingAir(ticks);
	}
	
	@JSFunction
	public void setRemoveWhenFarAway(boolean remove) {
		player.setRemoveWhenFarAway(remove);
	}
	
	//Methods inherited from interface org.bukkit.entity.Damageable
	
	@JSFunction
	public void damage(double amount) {
		player.damage(amount);
	}
	
	@JSFunction
	public double getHealth() {
		return player.getHealth();
	}
	
	@JSFunction
	public double getMaxHealth() {
		return player.getMaxHealth();
	}
	
	@JSFunction
	public void setHealth(double health) {
		player.setHealth(health);
	}
	
	@JSFunction
	public void setMaxHealth(double health) {
		player.setMaxHealth(health);
	}
	
	//Methods inherited from interface org.bukkit.command.CommandSender
	
	@JSFunction
	public void sendMessage(String message) {
		player.sendMessage(message);
	}
	
	//Methods inherited from interface org.bukkit.entity.Entity
	
	@JSFunction
	public void teleport(double x, double y, double z) {
		player.teleport(new Location(player.getWorld(), x, y, z));
	}
	
	@JSFunction
	public void teleportEye(double x, double y, double z, double yaw, double pitch) {
		player.teleport(new Location(player.getWorld(), x, y, z, (float) yaw, (float) pitch));
	}
	
	@JSFunction
	public _World getWorld() {
		return new _World(player.getWorld());
	}
	
	@JSFunction
	public double[] getLocation() {
		return new double[] {player.getLocation().getX(),
							player.getLocation().getY(),
							player.getLocation().getZ()};
	}
}
