package com.arirangJS.Script.Classes.org.bukkit.entity;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.mozilla.javascript.annotations.JSConstructor;
import org.mozilla.javascript.annotations.JSFunction;

import com.arirangJS.Script.Classes.org.bukkit._World;
import com.arirangJS.Script.Classes.org.bukkit.command._CommandSender;

public class _Entity extends _CommandSender {
	private static final long serialVersionUID = 6636356115866447346L;
	
    @Override
    public String getClassName() {
        return "Entity";
    }

    @JSConstructor
    public _Entity() {}

    public _Entity(Entity entity) {
        this.e = (Player) entity;
    }

    @JSFunction
    public boolean eject() {
        return e.eject();
    }

    @JSFunction
    public int getEntityId() {
        return e.getEntityId();
    }

    @JSFunction
    public double getFallDistance() {
        return e.getFallDistance();
    }

    @JSFunction
    public int getFireTicks() {
        return e.getFireTicks();
    }

    @JSFunction
    public double[] getLocation() {
        return new double[] {
                e.getLocation().getX(),
                e.getLocation().getY(),
                e.getLocation().getZ(),
                e.getLocation().getYaw(),
                e.getLocation().getPitch()
        };
    }

    @JSFunction
    public int getMaxFireTicks() {
        return e.getMaxFireTicks();
    }

    @JSFunction
    public _Entity[] getNearbyEntities(double x, double y, double z) {
        Entity[] entities = (Entity[]) e.getNearbyEntities(x, y, z).toArray();
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
        return new _Entity(e.getPassenger());
    }

    @JSFunction
    public int getTicksLived() {
        return e.getTicksLived();
    }

    @JSFunction
    public String getType() {
        return e.getType().toString();
    }
    
    @JSFunction
    public int getTypeId() {
        return e.getType().ordinal();
    }

    @JSFunction
    public String getUniqueId() {
        return e.getUniqueId().toString();
    }

    @JSFunction
    public _Entity getVehicle() {
        return new _Entity(e.getVehicle());
    }

    /*
     * TODO: Vector getVector()
     * No Vector Class
     */

    @JSFunction
    public _World getWorld() {
        return new _World(e.getWorld());
    }

    @JSFunction
    public boolean hasGravity() {
        return e.hasGravity();
    }

    @JSFunction
    public boolean isCustomNameVisible() {
        return e.isCustomNameVisible();
    }

    @JSFunction
    public boolean isDead() {
        return e.isDead();
    }

    @JSFunction
    public boolean isEmpty() {
        return e.isEmpty();
    }

    @JSFunction
    public boolean isGlowing() {
        return e.isGlowing();
    }

    @JSFunction
    public boolean isInsideVehicle() {
        return e.isInsideVehicle();
    }

    @JSFunction
    public boolean isInvulnerable() {
        return e.isInvulnerable();
    }

    @JSFunction
    public boolean isSilent() {
        return e.isSilent();
    }

    @JSFunction
    public boolean isValid() {
        return e.isValid();
    }

    @JSFunction
    public boolean leaveVehicle() {
        return e.leaveVehicle();
    }

    @JSFunction
    public void setCustomNameVisible(boolean flag) {
        e.setCustomNameVisible(flag);
    }

    @JSFunction
    public void setFallDistance(double distance) {
        e.setFallDistance((float) distance);
    }

    @JSFunction
    public void setFireTicks(int ticks) {
        e.setFireTicks(ticks);
    }

    @JSFunction
    public void setGlowing(boolean flag) {
        e.setGlowing(flag);
    }

    @JSFunction
    public void setGravity(boolean gravity) {
        e.setGravity(gravity);
    }

    @JSFunction
    public void setInvulnerable(boolean flag) {
        e.setInvulnerable(flag);
    }

    @JSFunction
    public boolean setPassenger(_Entity passenger) {
        return e.setPassenger(passenger.e);
    }

    @JSFunction
    public void setSilent(boolean flag) {
        e.setSilent(flag);
    }

    @JSFunction
    public void setTicksLived(int value) {
        e.setTicksLived(value);
    }

    /*
     * TODO: void setVelocity(Vector velocity)
     * No Vector Class
     */

    @JSFunction
    public boolean teleport(_Entity destination) {
        return e.teleport(destination.e);
    }

    @JSFunction
    public boolean teleportCoord(double x, double y, double z) {
        return e.teleport(new Location(e.getWorld(), x, y, z));
    }
}