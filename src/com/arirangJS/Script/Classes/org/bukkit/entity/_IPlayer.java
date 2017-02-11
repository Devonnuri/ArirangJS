package com.arirangJS.Script.Classes.org.bukkit.entity;

import com.arirangJS.Script.Classes.org.bukkit.inventory._Inventory;
import org.mozilla.javascript.annotations.JSFunction;

/**
 * Created by devonnuri on 17. 2. 10.
 */
public interface _IPlayer extends _ILivingEntity {
    @JSFunction
    boolean canSee(_Player player);

    @JSFunction
    void chat(String msg);

    @JSFunction
    boolean getAllowFlight();

    @JSFunction
    String getDisplayName();

    @JSFunction
    double getExhaustion();

    @JSFunction
    double getExp();

    @JSFunction
    double getFlySpeed();

    @JSFunction
    double getFoodLevel();

    @JSFunction
    double getHealthScale();

    @JSFunction
    int getLevel();

    @JSFunction
    String getPlayerListName();

    @JSFunction
    int getPlayerTime();

    @JSFunction
    int getPlayerTimeOffset();

    @JSFunction
    double getSaturation();

    @JSFunction
    int getTotalExperience();

    @JSFunction
    double getWalkSpeed();

    @JSFunction
    void giveExp(int amount);

    @JSFunction
    void giveExpLevels(int amount);

    @JSFunction
    void hidePlayer(_Player player);

    @JSFunction
    boolean isFlying();

    @JSFunction
    boolean isHealthScaled();

    @JSFunction
    boolean isPlayerTimeRelative();

    @JSFunction
    boolean isSleepingIgnored();

    @JSFunction
    boolean isSneaking();

    @JSFunction
    boolean isSprinting();

    @JSFunction
    void kickPlayer(String message);

    @JSFunction
    void loadData();

    @JSFunction
    boolean performCommand(String command);

    @JSFunction
    void resetPlayerTime();

    @JSFunction
    void resetPlayerWeather();

    @JSFunction
    void saveData();

    @JSFunction
    void sendRawMessage(String message);

    @JSFunction
    void setAllowFlight(boolean flight);

    @JSFunction
    void setDisplayName(String name);

    @JSFunction
    void setExhaustion(double value);

    @JSFunction
    void setExp(double exp);

    @JSFunction
    void setFlying(boolean value);

    @JSFunction
    void setFlySpeed(double value);

    @JSFunction
    void setFoodLevel(int value);

    @JSFunction
    void setHealthScale(double scale);

    @JSFunction
    void setHealthScaled(boolean scale);

    @JSFunction
    void setLevel(int level);

    @JSFunction
    void setPlayerListName(String name);

    @JSFunction
    void setPlayerTime(int time, boolean relative);

    @JSFunction
    void setResourcePack(String url);

    @JSFunction
    void setSaturation(double value);

    @JSFunction
    void setSleepingIgnored(boolean isSleeping);

    @JSFunction
    void setSneaking(boolean sneak);

    @JSFunction
    void setSprinting(boolean sprint);

    @JSFunction
    void setTotalExperience(int exp);

    @JSFunction
    void setWalkSpeed(double value);

    @JSFunction
    void showPlayer(_Player player);

    // Methods inherited from interface org.bukkit.entity.HumanEntity
    @JSFunction
    void closeInventory();

    @JSFunction
    void openInventory(_Inventory inv);

    @JSFunction
    _Inventory getInventory();

    @JSFunction
    int getExpToLevel();

    @JSFunction
    String getName();

    @JSFunction
    int getSleepTicks();

    @JSFunction
    boolean isBlocking();

    @JSFunction
    boolean isSleeping();
}
