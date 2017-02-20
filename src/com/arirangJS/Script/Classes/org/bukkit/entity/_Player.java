package com.arirangJS.Script.Classes.org.bukkit.entity;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mozilla.javascript.annotations.JSConstructor;
import org.mozilla.javascript.annotations.JSFunction;

import com.arirangJS.Script.Classes.org.bukkit.inventory._Inventory;

public class _Player extends _LivingEntity {
	
	private static final long serialVersionUID = 583488239536525223L;
	
	public _Player() {}
	
	@JSConstructor
	public _Player(String name) {
		e = Bukkit.getPlayer(name);
	}
	
	public _Player(Player player) {
		this.e = player;
		super.e = player;
	}
	
	@Override
	public String getClassName() {
		return "Player";
	}
	
	@JSFunction
	public boolean canSee(_Player player) {
		return this.e.canSee(player.e);
	}
	
	@JSFunction
	public void chat(String msg) {
		e.chat(msg);
	}
	
	@JSFunction
	public boolean getAllowFlight() {
		return e.getAllowFlight();
	}
	
	@JSFunction
	public String getDisplayName() {
		return e.getDisplayName();
	}
	
	@JSFunction
	public double getExhaustion() {
		return e.getExhaustion();
	}
	
	@JSFunction
	public double getExp() {
		return e.getExp();
	}
	
	@JSFunction
	public double getFlySpeed() {
		return e.getFlySpeed();
	}
	
	@JSFunction
	public double getFoodLevel() {
		return e.getFoodLevel();
	}
	
	@JSFunction
	public double getHealthScale() {
		return (double) e.getHealthScale();
	}
	
	@JSFunction
	public int getLevel() {
		return e.getLevel();
	}
	
	@JSFunction
	public String getPlayerListName() {
		return e.getPlayerListName();
	}
	
	@JSFunction
	public int getPlayerTime() {
		return (int) e.getPlayerTime();
	}
	
	@JSFunction
	public int getPlayerTimeOffset() {
		return (int) e.getPlayerTimeOffset();
	}
	
	@JSFunction
	public double getSaturation() {
		return e.getSaturation();
	}
	
	@JSFunction
	public int getTotalExperience() {
		return e.getTotalExperience();
	}
	
	@JSFunction
	public double getWalkSpeed() {
		return e.getWalkSpeed();
	}
	
	@JSFunction
	public void giveExp(int amount) {
		e.giveExp(amount);
	}
	
	@JSFunction
	public void giveExpLevels(int amount) {
		e.giveExpLevels(amount);
	}
	
	@JSFunction
	public void hidePlayer(_Player player) {
		this.e.hidePlayer(player.e);
	}
	
	@JSFunction
	public boolean isFlying() {
		return e.isFlying();
	}
	
	@JSFunction
	public boolean isHealthScaled() {
		return e.isHealthScaled();
	}
	
	@JSFunction
	public boolean isPlayerTimeRelative() {
		return e.isPlayerTimeRelative();
	}
	
	@JSFunction
	public boolean isSleepingIgnored() {
		return e.isSleepingIgnored();
	}
	
	@JSFunction
	public boolean isSneaking() {
		return e.isSneaking();
	}
	
	@JSFunction
	public boolean isSprinting() {
		return e.isSprinting();
	}
	
	@JSFunction
	public void kickPlayer(String message) {
		e.kickPlayer(message);
	}
	
	@JSFunction
	public void loadData() {
		e.loadData();
	}
	
	@JSFunction
	public boolean performCommand(String command) {
		return e.performCommand(command);
	}
	
	@JSFunction
	public void resetPlayerTime() {
		e.resetPlayerTime();
	}
	
	@JSFunction
	public void resetPlayerWeather() {
		e.resetPlayerWeather();
	}
	
	@JSFunction
	public void saveData() {
		e.saveData();
	}

	@JSFunction
	public void sendRawMessage(String message) {
		e.sendRawMessage(message);
	}
	
	@JSFunction
	public void setAllowFlight(boolean flight) {
		e.setAllowFlight(flight);
	}
	
	@JSFunction
	public void setDisplayName(String name) {
		e.setDisplayName(name);
	}
	
	@JSFunction
	public void setExhaustion(double value) {
		e.setExhaustion((float) value);
	}
	
	@JSFunction
	public void setExp(double exp) {
		e.setExp((float) exp);
	}
	
	@JSFunction
	public void setFlying(boolean value) {
		e.setFlying(value);
	}
	
	@JSFunction
	public void setFlySpeed(double value) {
		e.setFlySpeed((float) value);
	}
	
	@JSFunction
	public void setFoodLevel(int value) {
		e.setFoodLevel(value);
	}
	
	@JSFunction
	public void setHealthScale(double scale) {
		e.setHealthScale(scale);
	}
	
	@JSFunction
	public void setHealthScaled(boolean scale) {
		e.setHealthScaled(scale);
	}
	
	@JSFunction
	public void setLevel(int level) {
		e.setLevel(level);
	}
	
	@JSFunction
	public void setPlayerListName(String name) {
		e.setPlayerListName(name);
	}
	
	@JSFunction
	public void setPlayerTime(int time, boolean relative) {
		e.setPlayerTime(time, relative);
	}
	
	@JSFunction
	public void setResourcePack(String url) {
		e.setResourcePack(url);
	}
	
	@JSFunction
	public void setSaturation(double value) {
		e.setSaturation((float) value);
	}
	
	@JSFunction
	public void setSleepingIgnored(boolean isSleeping) {
		e.setSleepingIgnored(isSleeping);
	}
	
	@JSFunction
	public void setSneaking(boolean sneak) {
		e.setSneaking(sneak);
	}
	
	@JSFunction
	public void setSprinting(boolean sprint) {
		e.setSprinting(sprint);
	}
	
	@JSFunction
	public void setTotalExperience(int exp) {
		e.setTotalExperience(exp);
	}
	
	@JSFunction
	public void setWalkSpeed(double value) {
		e.setWalkSpeed((float) value);
	}
	
	@JSFunction
	public void showPlayer(_Player player) {
		this.e.showPlayer(player.e);
	}
	
	// Methods inherited from interface org.bukkit.entity.HumanEntity
	@JSFunction
	public void closeInventory() {
		e.closeInventory();
	}
	
	@JSFunction
	public void openInventory(_Inventory inv) {
		e.openInventory(inv.inv);
	}
	
	@JSFunction
	public _Inventory getInventory() {
		return new _Inventory(e);
	}
	
	@JSFunction
	public int getExpToLevel() {
		return e.getExpToLevel();
	}
	
	@JSFunction
	public String getName() {
		return e.getName();
	}
	
	@JSFunction
	public int getSleepTicks() {
		return e.getSleepTicks();
	}
	
	@JSFunction
	public boolean isBlocking() {
		return e.isBlocking();
	}
	
	@JSFunction
	public boolean isSleeping() {
		return e.isSleeping();
	}
}
