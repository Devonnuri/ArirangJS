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
		this.player = Bukkit.getPlayer(name);
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
		this.player.chat(msg);
	}
	
	@JSFunction
	public boolean getAllowFlight() {
		return this.player.getAllowFlight();
	}
	
	@JSFunction
	public String getDisplayName() {
		return this.player.getDisplayName();
	}
	
	@JSFunction
	public double getExhaustion() {
		return this.player.getExhaustion();
	}
	
	@JSFunction
	public double getExp() {
		return this.player.getExp();
	}
	
	@JSFunction
	public double getFlySpeed() {
		return this.player.getFlySpeed();
	}
	
	@JSFunction
	public double getFoodLevel() {
		return this.player.getFoodLevel();
	}
	
	@JSFunction
	public double getHealthScale() {
		return (double) this.player.getHealthScale();
	}
	
	@JSFunction
	public int getLevel() {
		return this.player.getLevel();
	}
	
	@JSFunction
	public String getPlayerListName() {
		return this.player.getPlayerListName();
	}
	
	@JSFunction
	public int getPlayerTime() {
		return (int) this.player.getPlayerTime();
	}
	
	@JSFunction
	public int getPlayerTimeOffset() {
		return (int) this.player.getPlayerTimeOffset();
	}
	
	@JSFunction
	public double getSaturation() {
		return this.player.getSaturation();
	}
	
	@JSFunction
	public int getTotalExperience() {
		return this.player.getTotalExperience();
	}
	
	@JSFunction
	public double getWalkSpeed() {
		return this.player.getWalkSpeed();
	}
	
	@JSFunction
	public void giveExp(int amount) {
		this.player.giveExp(amount);
	}
	
	@JSFunction
	public void giveExpLevels(int amount) {
		this.player.giveExpLevels(amount);
	}
	
	@JSFunction
	public void hidePlayer(_Player player) {
		this.player.hidePlayer(player.player);
	}
	
	@JSFunction
	public boolean isFlying() {
		return this.player.isFlying();
	}
	
	@JSFunction
	public boolean isHealthScaled() {
		return this.player.isHealthScaled();
	}
	
	@JSFunction
	public boolean isPlayerTimeRelative() {
		return this.player.isPlayerTimeRelative();
	}
	
	@JSFunction
	public boolean isSleepingIgnored() {
		return this.player.isSleepingIgnored();
	}
	
	@JSFunction
	public boolean isSneaking() {
		return this.player.isSneaking();
	}
	
	@JSFunction
	public boolean isSprinting() {
		return this.player.isSprinting();
	}
	
	@JSFunction
	public void kickPlayer(String message) {
		this.player.kickPlayer(message);
	}
	
	@JSFunction
	public void loadData() {
		this.player.loadData();
	}
	
	@JSFunction
	public boolean performCommand(String command) {
		return this.player.performCommand(command);
	}
	
	@JSFunction
	public void resetPlayerTime() {
		this.player.resetPlayerTime();
	}
	
	@JSFunction
	public void resetPlayerWeather() {
		this.player.resetPlayerWeather();
	}
	
	@JSFunction
	public void saveData() {
		this.player.saveData();
	}

	@JSFunction
	public void sendRawMessage(String message) {
		this.player.sendRawMessage(message);
	}
	
	@JSFunction
	public void setAllowFlight(boolean flight) {
		this.player.setAllowFlight(flight);
	}
	
	@JSFunction
	public void setDisplayName(String name) {
		this.player.setDisplayName(name);
	}
	
	@JSFunction
	public void setExhaustion(double value) {
		this.player.setExhaustion((float) value);
	}
	
	@JSFunction
	public void setExp(double exp) {
		this.player.setExp((float) exp);
	}
	
	@JSFunction
	public void setFlying(boolean value) {
		this.player.setFlying(value);
	}
	
	@JSFunction
	public void setFlySpeed(double value) {
		this.player.setFlySpeed((float) value);
	}
	
	@JSFunction
	public void setFoodLevel(int value) {
		this.player.setFoodLevel(value);
	}
	
	@JSFunction
	public void setHealthScale(double scale) {
		this.player.setHealthScale(scale);
	}
	
	@JSFunction
	public void setHealthScaled(boolean scale) {
		this.player.setHealthScaled(scale);
	}
	
	@JSFunction
	public void setLevel(int level) {
		this.player.setLevel(level);
	}
	
	@JSFunction
	public void setPlayerListName(String name) {
		this.player.setPlayerListName(name);
	}
	
	@JSFunction
	public void setPlayerTime(int time, boolean relative) {
		this.player.setPlayerTime(time, relative);
	}
	
	@JSFunction
	public void setResourcePack(String url) {
		this.player.setResourcePack(url);
	}
	
	@JSFunction
	public void setSaturation(double value) {
		this.player.setSaturation((float) value);
	}
	
	@JSFunction
	public void setSleepingIgnored(boolean isSleeping) {
		this.player.setSleepingIgnored(isSleeping);
	}
	
	@JSFunction
	public void setSneaking(boolean sneak) {
		this.player.setSneaking(sneak);
	}
	
	@JSFunction
	public void setSprinting(boolean sprint) {
		this.player.setSprinting(sprint);
	}
	
	@JSFunction
	public void setTotalExperience(int exp) {
		this.player.setTotalExperience(exp);
	}
	
	@JSFunction
	public void setWalkSpeed(double value) {
		this.player.setWalkSpeed((float) value);
	}
	
	@JSFunction
	public void showPlayer(_Player player) {
		this.player.showPlayer(player.player);
	}
	
	// Methods inherited from interface org.bukkit.entity.HumanEntity
	@JSFunction
	public void closeInventory() {
		this.player.closeInventory();
	}
	
	@JSFunction
	public void openInventory(_Inventory inv) {
		this.player.openInventory(inv.inv);
	}
	
	@JSFunction
	public _Inventory getInventory() {
		return new _Inventory(this.player);
	}
	
	@JSFunction
	public int getExpToLevel() {
		return this.player.getExpToLevel();
	}
	
	@JSFunction
	public String getName() {
		return this.player.getName();
	}
	
	@JSFunction
	public int getSleepTicks() {
		return this.player.getSleepTicks();
	}
	
	@JSFunction
	public boolean isBlocking() {
		return this.player.isBlocking();
	}
	
	@JSFunction
	public boolean isSleeping() {
		return this.player.isSleeping();
	}
	
	//Methods inherited from interface org.bukkit.entity.LivingEntity
	
	@JSFunction
	public boolean getCanPickupItems() {
		return this.player.getCanPickupItems();
	}
	
	@JSFunction
	public double getEyeHeight() {
		return this.player.getEyeHeight();
	}
	
	@JSFunction
	public double getEyeHeightIgnoreSneak() {
		return this.player.getEyeHeight(true);
	}
	
	@JSFunction
	public _Player getKiller() {
		return new _Player(this.player.getKiller());
	}
	
	@JSFunction
	public double getLastDamage() {
		return this.player.getLastDamage();
	}
	
	@JSFunction
	public int getMaximumAir() {
		return this.player.getMaximumAir();
	}
	
	@JSFunction
	public int getMaximumNoDamageTicks() {
		return this.player.getMaximumNoDamageTicks();
	}
	
	@JSFunction
	public boolean hasAI() {
		return this.player.hasAI();
	}
	
	@JSFunction
	public boolean isCollidable() {
		return this.player.isCollidable();
	}
	
	@JSFunction
	public boolean isGliding() {
		return this.player.isGliding();
	}
	
	@JSFunction
	public boolean isLeashed() {
		return this.player.isLeashed();
	}
	
	@JSFunction
	public void setAI(boolean ai) {
		this.player.setAI(ai);
	}
	
	@JSFunction
	public void setCanPickupItems(boolean pickup) {
		this.player.setCanPickupItems(pickup);
	}
	
	@JSFunction
	public void setCollidable(boolean collidable) {
		this.player.setCollidable(collidable);
	}
	
	@JSFunction
	public void setGliding(boolean gliding) {
		this.player.setGliding(gliding);
	}
	
	@JSFunction
	public void setLastDamage(double damage) {
		this.player.setLastDamage(damage);
	}
	
	@JSFunction
	public void setMaximumAir(int ticks) {
		this.player.setMaximumAir(ticks);
	}
	
	@JSFunction
	public void setMaximumNoDamageTicks(int ticks) {
		this.player.setMaximumNoDamageTicks(ticks);
	}
	
	@JSFunction
	public void setNoDamageTicks(int ticks) {
		this.player.setNoDamageTicks(ticks);
	}
	
	@JSFunction
	public void setRemainingAir(int ticks) {
		this.player.setRemainingAir(ticks);
	}
	
	@JSFunction
	public void setRemoveWhenFarAway(boolean remove) {
		this.player.setRemoveWhenFarAway(remove);
	}
	
	//Methods inherited from interface org.bukkit.entity.Damageable
	
	@JSFunction
	public void damage(double amount) {
		this.player.damage(amount);
	}
	
	@JSFunction
	public double getHealth() {
		return this.player.getHealth();
	}
	
	@JSFunction
	public double getMaxHealth() {
		return this.player.getMaxHealth();
	}
	
	@JSFunction
	public void setHealth(double health) {
		this.player.setHealth(health);
	}
	
	@JSFunction
	public void setMaxHealth(double health) {
		this.player.setMaxHealth(health);
	}
	
	//Methods inherited from interface org.bukkit.command.CommandSender
	
	@JSFunction
	public void sendMessage(String message) {
		this.player.sendMessage(message);
	}
	
	//Methods inherited from interface org.bukkit.entity.Entity
	
	@JSFunction
	public void teleport(double x, double y, double z) {
		this.player.teleport(new Location(player.getWorld(), x, y, z));
	}
	
	@JSFunction
	public void teleportEye(double x, double y, double z, double yaw, double pitch) {
		this.player.teleport(new Location(player.getWorld(), x, y, z, (float) yaw, (float) pitch));
	}
}
