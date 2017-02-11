package com.arirangJS.Script.Classes.org.bukkit.entity;

import com.arirangJS.Script.Classes.org.bukkit._World;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.annotations.JSConstructor;
import org.mozilla.javascript.annotations.JSFunction;

/**
 * Created by devonnuri on 17. 2. 7.
 */
@SuppressWarnings("unused")
public class _Entity extends ScriptableObject implements _IEntity {
    Entity entity;

    @Override
    public String getClassName() {
        return "Entity";
    }

    @JSConstructor
    public _Entity() {}

    public _Entity(Entity entity) {
        this.entity = entity;
    }

    @JSFunction
    public boolean addScoreboardTag(String tag) {
        return entity.addScoreboardTag(tag);
    }

    @JSFunction
    public boolean eject() {
        return entity.eject();
    }

    @JSFunction
    public int getEntityId() {
        return entity.getEntityId();
    }

    @JSFunction
    public double getFallDistance() {
        return entity.getFallDistance();
    }

    @JSFunction
    public int getFireTicks() {
        return entity.getFireTicks();
    }

    @JSFunction
    public double[] getLocation() {
        return new double[] {
                entity.getLocation().getX(),
                entity.getLocation().getY(),
                entity.getLocation().getZ(),
                entity.getLocation().getYaw(),
                entity.getLocation().getPitch()
        };
    }

    @JSFunction
    public int getMaxFireTicks() {
        return entity.getMaxFireTicks();
    }

    @JSFunction
    public _Entity[] getNearbyEntities(double x, double y, double z) {
        Entity[] entities = (Entity[]) entity.getNearbyEntities(x, y, z).toArray();
        _Entity[] result = new _Entity[entities.length];

        int index = 0;
        for(Entity temp : entities) {
            result[index] = new _Entity(temp);
            index++;
        }

        return result;
    }

    @JSFunction
    public _Entity getPassenger() {
        return new _Entity(entity.getPassenger());
    }

    @JSFunction
    public int getPortalCooldown() {
        return entity.getPortalCooldown();
    }

    @JSFunction
    public String[] getScoreboardTags() {
        return entity.getScoreboardTags().toArray(new String[0]);
    }

    @JSFunction
    public int getTicksLived() {
        return entity.getTicksLived();
    }

    @JSFunction
    public int getType() {
        return entity.getType().ordinal();
    }

    @JSFunction
    public String getUniqueId() {
        return entity.getUniqueId().toString();
    }

    @JSFunction
    public _Entity getVehicle() {
        return new _Entity(entity.getVehicle());
    }

    /*
     * TODO: Vector getVector()
     * No Vector Class
     */

    @JSFunction
    public _World getWorld() {
        return new _World(entity.getWorld());
    }

    @JSFunction
    public boolean hasGravity() {
        return entity.hasGravity();
    }

    @JSFunction
    public boolean isCustomNameVisible() {
        return entity.isCustomNameVisible();
    }

    @JSFunction
    public boolean isDead() {
        return entity.isDead();
    }

    @JSFunction
    public boolean isEmpty() {
        return entity.isEmpty();
    }

    @JSFunction
    public boolean isGlowing() {
        return entity.isGlowing();
    }

    @JSFunction
    public boolean isInsideVehicle() {
        return entity.isInsideVehicle();
    }

    @JSFunction
    public boolean isInvulnerable() {
        return entity.isInvulnerable();
    }

    @JSFunction
    public boolean isOnGround() {
        return entity.isOnGround();
    }

    @JSFunction
    public boolean isSilent() {
        return entity.isSilent();
    }

    @JSFunction
    public boolean isValid() {
        return entity.isValid();
    }

    @JSFunction
    public boolean leaveVehicle() {
        return entity.leaveVehicle();
    }

    @JSFunction
    public boolean removeScoreboardTag(String tag) {
        return entity.removeScoreboardTag(tag);
    }

    @JSFunction
    public void setCustomNameVisible(boolean flag) {
        entity.setCustomNameVisible(flag);
    }

    @JSFunction
    public void setFallDistance(double distance) {
        entity.setFallDistance((float) distance);
    }

    @JSFunction
    public void setFireTicks(int ticks) {
        entity.setFireTicks(ticks);
    }

    @JSFunction
    public void setGlowing(boolean flag) {
        entity.setGlowing(flag);
    }

    @JSFunction
    public void setGravity(boolean gravity) {
        entity.setGravity(gravity);
    }

    @JSFunction
    public void setInvulnerable(boolean flag) {
        entity.setInvulnerable(flag);
    }

    @JSFunction
    public boolean setPassenger(_Entity passenger) {
        return entity.setPassenger(passenger.entity);
    }

    @JSFunction
    public void setPortalCooldown(int cooldown) {
        entity.setPortalCooldown(cooldown);
    }

    @JSFunction
    public void setSilent(boolean flag) {
        entity.setSilent(flag);
    }

    @JSFunction
    public void setTicksLived(int value) {
        entity.setTicksLived(value);
    }

    /*
     * TODO: void setVelocity(Vector velocity)
     * No Vector Class
     */

    @JSFunction
    public boolean teleport(_Entity destination) {
        return entity.teleport(destination.entity);
    }

    @JSFunction
    public boolean teleportCoord(double x, double y, double z) {
        return entity.teleport(new Location(entity.getWorld(), x, y, z));
    }
}