package com.arirangJS.Script.Classes;

import com.arirangJS.Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.mozilla.javascript.ImporterTopLevel;
import org.mozilla.javascript.annotations.JSFunction;

public class _TopClass extends ImporterTopLevel {

    private static final long serialVersionUID = -4290301262375673084L;

    @JSFunction
    public boolean isSenderPlayer(CommandSender sender) {
        return sender instanceof Player;
    }

    @JSFunction
    public Player getPlayer(String str) {
        return Bukkit.getPlayer(str);
    }

    @SuppressWarnings("deprecation")
    @JSFunction
    public PotionEffect getPotionEffect(int type, int duration, int amplifier) {
        return new PotionEffect(PotionEffectType.getById(type), duration, amplifier);
    }

    @SuppressWarnings("deprecation")
    @JSFunction
    public PotionEffect getPotionEffect2(int type, int duration, int amplifier, boolean ambient) {
        return new PotionEffect(PotionEffectType.getById(type), duration, amplifier, ambient);
    }

    @SuppressWarnings("deprecation")
    @JSFunction
    public PotionEffect getPotionEffect3(int type, int duration, int amplifier, boolean ambient, boolean particles) {
        return new PotionEffect(PotionEffectType.getById(type), duration, amplifier, ambient, particles);
    }

    @JSFunction
    public Block getBlock(World world, int x, int y, int z) {
        return world.getBlockAt(x, y, z);
    }

    @JSFunction
    public void setCancelled(String event, boolean cancel) {
        Main.isCancelled.put(event, cancel);
    }

    @JSFunction
    public static boolean getCancelled(String event) {
        return isCancelled(event);
    }

    @JSFunction
    public static boolean isCancelled(String event) {
        return Main.isCancelled.get(event);
    }
}
