package com.arirangJS.Script.Classes.org.bukkit.potion;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.annotations.JSStaticFunction;

public class _PotionEffect extends ScriptableObject {

	private static final long serialVersionUID = -350575615822544497L;
	
	@Override
	public String getClassName() {
		return "PotionEffect";
	}
	
	public _PotionEffect() {}
	
	@SuppressWarnings("deprecation")
	@JSStaticFunction
	public PotionEffect get(int type, int duration, int amplifier) {
		return new PotionEffect(PotionEffectType.getById(type), duration, amplifier);
	}
	
	@SuppressWarnings("deprecation")
	@JSStaticFunction
	public PotionEffect get(int type, int duration, int amplifier, boolean ambient) {
		return new PotionEffect(PotionEffectType.getById(type), duration, amplifier);
	}
	
	@SuppressWarnings("deprecation")
	@JSStaticFunction
	public PotionEffect get(int type, int duration, int amplifier, boolean ambient, boolean particles) {
		return new PotionEffect(PotionEffectType.getById(type), duration, amplifier, particles);
	}
}
