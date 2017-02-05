package com.arirangJS.Script.Classes;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.LivingEntity;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.annotations.JSConstructor;
import org.mozilla.javascript.annotations.JSFunction;

public class _LivingEntity extends ScriptableObject {

	private static final long serialVersionUID = 2485571018791985097L;

	public LivingEntity entity;
	
	@Override
	public String getClassName() {
		return "LivingEntity";
	}
	
	public _LivingEntity() {}
	
	public _LivingEntity(LivingEntity entity) {
		this.entity = entity;
	}
	
	@JSConstructor
	public _LivingEntity(String uuid) {
		this.entity = null;
		for(World world : Bukkit.getWorlds()) {
			for(LivingEntity entity : world.getLivingEntities()) {
				if(entity.getUniqueId().toString().equals(uuid)) {
					this.entity = entity;
					break;
				}
			}
		}
	}
	
	@JSFunction
	public boolean addPotionEffect(_PotionEffect effect) {
		return entity.addPotionEffect(effect.potionEffect);
	}
	
	@JSFunction
	public boolean addPotionEffectForce(_PotionEffect effect) {
		return entity.addPotionEffect(effect.potionEffect, true);
	}
	
	@JSFunction
	public boolean getCanPickupItems() {
		return entity.getCanPickupItems();
	}
	
	@JSFunction
	public double getEyeHeight() {
		return entity.getEyeHeight();
	}
	
	@JSFunction
	public double getEyeHeightIgnoreSneak() {
		return entity.getEyeHeight(true);
	}
	
	@JSFunction
	public _Player getKiller() {
		return new _Player(entity.getKiller());
	}
	
	@JSFunction
	public double getLastDamage() {
		return entity.getLastDamage();
	}
	
	@JSFunction
	public int getMaximumAir() {
		return entity.getMaximumAir();
	}
	
	@JSFunction
	public int getMaximumNoDamageTicks() {
		return entity.getMaximumNoDamageTicks();
	}
	
	@JSFunction
	public int getNoDamageTicks() {
		return entity.getNoDamageTicks();
	}
	
	@JSFunction
	public boolean hasAI() {
		return entity.hasAI();
	}
	
	@JSFunction
	public boolean isCollidable() {
		return entity.isCollidable();
	}
	
	@JSFunction
	public boolean isGliding() {
		return entity.isGliding();
	}
	
	@JSFunction
	public boolean isLeashed() {
		return entity.isLeashed();
	}
	
	@JSFunction
	public void setAI(boolean ai) {
		entity.setAI(ai);
	}
	
	@JSFunction
	public void setCanPickupItems(boolean pickup) {
		entity.setCanPickupItems(pickup);
	}
	
	@JSFunction
	public void setCollidable(boolean collidable) {
		entity.setCollidable(collidable);
	}
	
	@JSFunction
	public void setGliding(boolean gliding) {
		entity.setGliding(gliding);
	}
	
	@JSFunction
	public void setLastDamage(double damage) {
		entity.setLastDamage(damage);
	}
	
	@JSFunction
	public void setMaximumAir(int ticks) {
		entity.setMaximumAir(ticks);
	}
	
	@JSFunction
	public void setMaximumNoDamageTicks(int ticks) {
		entity.setMaximumNoDamageTicks(ticks);
	}
	
	@JSFunction
	public void setNoDamageTicks(int ticks) {
		entity.setNoDamageTicks(ticks);
	}
	
	@JSFunction
	public void setRemainingAir(int ticks) {
		entity.setRemainingAir(ticks);
	}
	
	@JSFunction
	public void setRemoveWhenFarAway(boolean remove) {
		entity.setRemoveWhenFarAway(remove);
	}
}
