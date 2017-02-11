package com.arirangJS.Script.Classes.org.bukkit.entity;

import com.arirangJS.Script.Classes.org.bukkit._World;
import org.mozilla.javascript.annotations.JSFunction;

/**
 * Created by devonnuri on 17. 2. 10.
 */
public interface _IEntity {
    @JSFunction
    boolean addScoreboardTag(String tag);

    @JSFunction
    boolean eject();

    @JSFunction
    int getEntityId();

    @JSFunction
    double getFallDistance();

    @JSFunction
    int getFireTicks();

    @JSFunction
    double[] getLocation();

    @JSFunction
    int getMaxFireTicks();

    @JSFunction
    _Entity[] getNearbyEntities(double x, double y, double z);

    @JSFunction
    _Entity getPassenger();

    @JSFunction
    int getPortalCooldown();

    @JSFunction
    String[] getScoreboardTags();

    @JSFunction
    int getTicksLived();

    @JSFunction
    int getType();

    @JSFunction
    String getUniqueId();

    @JSFunction
    _Entity getVehicle();

    @JSFunction
    _World getWorld();

    @JSFunction
    boolean hasGravity();

    @JSFunction
    boolean isCustomNameVisible();

    @JSFunction
    boolean isDead();

    @JSFunction
    boolean isEmpty();

    @JSFunction
    boolean isGlowing();

    @JSFunction
    boolean isInsideVehicle();

    @JSFunction
    boolean isInvulnerable();

    @JSFunction
    boolean isOnGround();

    @JSFunction
    boolean isSilent();

    @JSFunction
    boolean isValid();

    @JSFunction
    boolean leaveVehicle();

    @JSFunction
    boolean removeScoreboardTag(String tag);

    @JSFunction
    void setCustomNameVisible(boolean flag);

    @JSFunction
    void setFallDistance(double distance);

    @JSFunction
    void setFireTicks(int ticks);

    @JSFunction
    void setGlowing(boolean flag);

    @JSFunction
    void setGravity(boolean gravity);

    @JSFunction
    void setInvulnerable(boolean flag);

    @JSFunction
    boolean setPassenger(_Entity passenger);

    @JSFunction
    void setPortalCooldown(int cooldown);

    @JSFunction
    void setSilent(boolean flag);

    @JSFunction
    void setTicksLived(int value);

    @JSFunction
    boolean teleport(_Entity destination);

    @JSFunction
    boolean teleportCoord(double x, double y, double z);
}
