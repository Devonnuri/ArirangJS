package com.arirangJS.Script.Classes.org.bukkit.entity;

import com.arirangJS.Script.Classes.org.bukkit.potion._PotionEffect;
import org.mozilla.javascript.annotations.JSFunction;

/**
 * Created by devonnuri on 17. 2. 10.
 */
public interface _ILivingEntity extends _IEntity {
    @JSFunction
    boolean addPotionEffect(_PotionEffect effect);

    @JSFunction
    boolean addPotionEffectForce(_PotionEffect effect);

    @JSFunction
    boolean getCanPickupItems();

    @JSFunction
    double getEyeHeight();

    @JSFunction
    double getEyeHeightIgnoreSneak();

    @JSFunction
    _Player getKiller();

    @JSFunction
    double getLastDamage();

    @JSFunction
    int getMaximumAir();

    @JSFunction
    int getMaximumNoDamageTicks();

    @JSFunction
    int getNoDamageTicks();

    @JSFunction
    boolean hasAI();

    @JSFunction
    boolean isCollidable();

    @JSFunction
    boolean isGliding();

    @JSFunction
    boolean isLeashed();

    @JSFunction
    void setAI(boolean ai);

    @JSFunction
    void setCanPickupItems(boolean pickup);

    @JSFunction
    void setCollidable(boolean collidable);

    @JSFunction
    void setGliding(boolean gliding);

    @JSFunction
    void setLastDamage(double damage);

    @JSFunction
    void setMaximumAir(int ticks);

    @JSFunction
    void setMaximumNoDamageTicks(int ticks);

    @JSFunction
    void setNoDamageTicks(int ticks);

    @JSFunction
    void setRemainingAir(int ticks);

    @JSFunction
    void setRemoveWhenFarAway(boolean remove);
}
