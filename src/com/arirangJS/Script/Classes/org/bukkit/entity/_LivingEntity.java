package com.arirangJS.Script.Classes.org.bukkit.entity;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.mozilla.javascript.annotations.JSConstructor;
import org.mozilla.javascript.annotations.JSFunction;

import com.arirangJS.Script.Classes.org.bukkit.potion._PotionEffect;

public class _LivingEntity extends _Entity {

	private static final long serialVersionUID = 2485571018791985097L;
	
	@Override
	public String getClassName() {
		return "LivingEntity";
	}

	@JSConstructor
	public _LivingEntity() {}
	
	public _LivingEntity(LivingEntity entity) {
		this.e = (Player) entity;
	}
	
	@JSFunction
	public boolean addPotionEffect(_PotionEffect effect) {
		return e.addPotionEffect(effect.potionEffect);
	}
	
	@JSFunction
	public boolean addPotionEffectForce(_PotionEffect effect) {
		return e.addPotionEffect(effect.potionEffect, true);
	}
	
	@JSFunction
	public boolean getCanPickupItems() {
		return e.getCanPickupItems();
	}
	
	@JSFunction
	public double getEyeHeight() {
		return e.getEyeHeight();
	}
	
	@JSFunction
	public double getEyeHeightIgnoreSneak() {
		return e.getEyeHeight(true);
	}
	
	@JSFunction
	public _Player getKiller() {
		return new _Player(e.getKiller());
	}
	
	@JSFunction
	public double getLastDamage() {
		return e.getLastDamage();
	}
	
	@JSFunction
	public int getMaximumAir() {
		return e.getMaximumAir();
	}
	
	@JSFunction
	public int getMaximumNoDamageTicks() {
		return e.getMaximumNoDamageTicks();
	}
	
	@JSFunction
	public int getNoDamageTicks() {
		return e.getNoDamageTicks();
	}
	
	@JSFunction
	public boolean hasAI() {
		return e.hasAI();
	}
	
	@JSFunction
	public boolean isCollidable() {
		return e.isCollidable();
	}
	
	@JSFunction
	public boolean isGliding() {
		return e.isGliding();
	}
	
	@JSFunction
	public boolean isLeashed() {
		return e.isLeashed();
	}
	
	@JSFunction
	public void setAI(boolean ai) {
		e.setAI(ai);
	}
	
	@JSFunction
	public void setCanPickupItems(boolean pickup) {
		e.setCanPickupItems(pickup);
	}
	
	@JSFunction
	public void setCollidable(boolean collidable) {
		e.setCollidable(collidable);
	}
	
	@JSFunction
	public void setGliding(boolean gliding) {
		e.setGliding(gliding);
	}
	
	@JSFunction
	public void setLastDamage(double damage) {
		e.setLastDamage(damage);
	}
	
	@JSFunction
	public void setMaximumAir(int ticks) {
		e.setMaximumAir(ticks);
	}
	
	@JSFunction
	public void setMaximumNoDamageTicks(int ticks) {
		e.setMaximumNoDamageTicks(ticks);
	}
	
	@JSFunction
	public void setNoDamageTicks(int ticks) {
		e.setNoDamageTicks(ticks);
	}
	
	@JSFunction
	public void setRemainingAir(int ticks) {
		e.setRemainingAir(ticks);
	}
	
	@JSFunction
	public void setRemoveWhenFarAway(boolean remove) {
		e.setRemoveWhenFarAway(remove);
	}
}
