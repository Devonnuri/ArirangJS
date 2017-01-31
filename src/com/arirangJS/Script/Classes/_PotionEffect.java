package com.arirangJS.Script.Classes;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.annotations.JSConstructor;
import org.mozilla.javascript.annotations.JSFunction;

public class _PotionEffect extends ScriptableObject {

	private static final long serialVersionUID = -350575615822544497L;

	public PotionEffect potionEffect;
	
	@Override
	public String getClassName() {
		return "PotionEffect";
	}
	
	@SuppressWarnings("deprecation")
	@JSConstructor
	public _PotionEffect(int type, int duration, int amplifier) {
		this.potionEffect = new PotionEffect(PotionEffectType.getById(type), duration, amplifier);
	}
	
	@SuppressWarnings("deprecation")
	@JSConstructor
	public _PotionEffect(int type, int duration, int amplifier, boolean ambient) {
		this.potionEffect = new PotionEffect(PotionEffectType.getById(type), duration, amplifier);
	}
	
	@SuppressWarnings("deprecation")
	@JSConstructor
	public _PotionEffect(int type, int duration, int amplifier, boolean ambient, boolean particles) {
		this.potionEffect = new PotionEffect(PotionEffectType.getById(type), duration, amplifier, particles);
	}
	
	public _PotionEffect() {}
	
	public _PotionEffect(PotionEffect effect) {
		this.potionEffect = effect;
	}
	
	@JSFunction
	public boolean applyLivingEntity(_LivingEntity entity) {
		return potionEffect.apply(entity.entity);
	}
	
	@JSFunction
	public boolean apply(_Player player) {
		return potionEffect.apply(player.player);
	}
	
	@JSFunction
	public boolean equals(Object obj) {
		return potionEffect.equals(obj);
	}
	
	@JSFunction
	public int getAmplifier() {
		return potionEffect.getAmplifier();
	}
	
	@JSFunction
	public int getDuration() {
		return potionEffect.getDuration();
	}
	
	@SuppressWarnings("deprecation")
	@JSFunction
	public int getType() {
		return potionEffect.getType().getId();
	}
	
	@JSFunction
	public int hashCode() {
		return potionEffect.hashCode();
	}
	
	@JSFunction
	public boolean hasParticles() {
		return potionEffect.hasParticles();
	}
	
	@JSFunction
	public boolean isAmbient() {
		return potionEffect.isAmbient();
	}
	
	@JSFunction
	public String toString() {
		return potionEffect.toString();
	}
}
