package com.arirangJS.Script;

import com.arirangJS.Debug.Debug;
import com.arirangJS.Main.Main;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.*;
import org.bukkit.event.server.ServerCommandEvent;
import org.bukkit.inventory.ItemStack;
import org.mozilla.javascript.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class ScriptManager implements Listener {
	
	public static void callMethod(String functionName, Object... args) {
		for(Script script : Main.scripts.values()) {
			Context context = Context.enter();
			Scriptable scope = script.scope;
			
			if(script.errors.size() >= Main.MAX_ERRORS_NUM)
				continue;
			if(script.scope == null)
				continue;
			
			try {
				Object object = scope.get(functionName, scope);
				if(object != null && object instanceof Function) {
					Function function = (Function) object;
					function.call(context, scope, scope, args);
				}
			} catch(RhinoException e) {
				script.errors.add(e.getMessage());
				Debug.danger(e.getMessage()+" ("+e.lineNumber()+", "+e.columnNumber()+")");
			} finally {
				Context.exit();
			}
		}
	}
	
	public static String locToJSON(Location location) {
		double x = location.getX();
		double y = location.getY();
		double z = location.getZ();
		float yaw = location.getYaw();
		float pitch = location.getPitch();
		int blockX = location.getBlockX();
		int blockY = location.getBlockY();
		int blockZ = location.getBlockZ();
		
		String result = String.format("({x: %f, y: %f, z: %f, yaw: %f, pitch: %f, blockX: %d, blockY: %d, blockZ: %d})",
				x, y, z, yaw, pitch, blockX, blockY, blockZ);
		return result;
	}
	
	@SuppressWarnings("deprecation")
	public static String blockToJSON(Block block) {
		if(block == null) return "({})";
		int x = block.getX();
		int y = block.getY();
		int z = block.getZ();
		int id = block.getTypeId();
		int damage = block.getData();
		int biome = block.getBiome().ordinal();
		String world = block.getWorld().getName();
		
		String result = String.format("({x: %d, y: %d, z: %d, id: %d, damage: %d, biome: %d, world: %s})",
				x, y, z, id, damage, biome, world);
		return result;
	}
	
	@SuppressWarnings("deprecation")
	public static String itemToJSON(ItemStack item) {
		if(item == null) return "({})";
		int id = item.getTypeId();
		int amount = item.getAmount();
		int durability = item.getDurability();
		String displayName = "";
		List<String> loreList;
		if(item.getItemMeta() == null) {
			displayName = "";
			loreList = new ArrayList<String>();
		} else if(item.getItemMeta().getDisplayName() == null) {
			displayName = "";
			loreList = new ArrayList<String>();
		} else {
			displayName = item.getItemMeta().getDisplayName();
			loreList = item.getItemMeta().getLore();
		}
		
		String enchantment = "{}";
		
		if(item.getEnchantments().size() > 0) {
			StringBuilder builder = new StringBuilder();
			builder.append("{");
			for(Entry<Enchantment, Integer> entry : item.getEnchantments().entrySet()) {
				builder.append(entry.getKey().getName()+": "+entry.getValue()+", ");
			}
			builder.setLength(builder.length()-2);
			builder.append("}");
			enchantment = builder.toString();
		}
		
		String lore = "[]";
		if(loreList != null) {
			if(loreList.size() != 0) {
				lore = "[";
				for(String str : loreList) {
					lore += "\""+str+"\",";
				}
				lore = lore.substring(0, lore.length()-1);
				lore += "]";
			}
		}
		
		String result = String.format("({id: %d, amount: %d, durability: %d, displayName: \"%s\", lore: %s, enchantment: %s})", id, amount, durability, displayName, lore, enchantment);
		return result;
	}
	
	public static String blockStateToJSON(BlockState state) {
		String blockJSON = blockToJSON(state.getBlock());
		int lightLevel = state.getLightLevel();
		
		String result = String.format("({block: %s, lightLevel: %d})", blockJSON, lightLevel);
		return result;
	}
	
	public static String strArrayToJSON(String[] strArray) {
		String[] result = strArray;
		for(int i=0; i<strArray.length; i++) {
			result[i] = "\""+strArray[i]+"\"";
		}
		
		return Arrays.toString(result);
	}
	
	public static String enchantListToJSON(Map<Enchantment, Integer> map) {
		if(map.size() == 0) return "({})";
		
		StringBuilder builder = new StringBuilder();
		builder.append("({");
		for(Entry<Enchantment, Integer> entry : map.entrySet()) {
			builder.append(entry.getKey().getName()+": "+entry.getValue()+", ");
		}
		builder.setLength(builder.length()-2);
		builder.append("})");
		
		return builder.toString();
	}
	
	@EventHandler(ignoreCancelled = true)
	public void onPlayerJoin(PlayerJoinEvent e) {
		Main.joinMessage = e.getJoinMessage();
		callMethod("onPlayerJoin", e.getPlayer().getName());
		
		e.setJoinMessage(Main.joinMessage);
	}

	@EventHandler(ignoreCancelled = true)
	public void onPlayerQuit(PlayerQuitEvent e) {
		Main.quitMessage = e.getQuitMessage();
		
		callMethod("onPlayerQuit", e.getPlayer().getName());
		
		e.setQuitMessage(Main.quitMessage);
	}

	@EventHandler(ignoreCancelled = true)
	public void onPlayerMove(PlayerMoveEvent e) {
		Main.isCancelled.put(e.getEventName(), e.isCancelled());
		
		callMethod("onPlayerMove", e.getPlayer().getName(), locToJSON(e.getFrom()), locToJSON(e.getTo()));
		
		e.setCancelled(Main.isCancelled.get(e.getEventName()));
	}

	@EventHandler(ignoreCancelled = true)
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		Main.isCancelled.put("PlayerChatEvent", e.isCancelled());
		Main.chatFormat = e.getFormat();
		
		callMethod("onPlayerChat", e.getPlayer(), e.getMessage());
		
		e.setFormat(Main.chatFormat);
		e.setCancelled(Main.isCancelled.get("PlayerChatEvent"));
	}

	@EventHandler(ignoreCancelled = true)
	public void onBlockPlace(BlockPlaceEvent e) {
		Main.isCancelled.put(e.getEventName(), e.isCancelled());
		
		callMethod("onBlockPlace", e.getPlayer().getName(), blockToJSON(e.getBlock()));
		
		e.setCancelled(Main.isCancelled.get(e.getEventName()));
	}

	@EventHandler(ignoreCancelled = true)
	public void onBlockBreak(BlockBreakEvent e) {
		Main.isCancelled.put(e.getEventName(), e.isCancelled());
		
		callMethod("onBlockBreak", e.getPlayer().getName(), blockToJSON(e.getBlock()));
		
		e.setCancelled(Main.isCancelled.get(e.getEventName()));
	}
	
	@EventHandler(ignoreCancelled = true)
	public void onBlockBurn(BlockBurnEvent e) {
		Main.isCancelled.put(e.getEventName(), e.isCancelled());
		
		callMethod("onBlockBurn", blockToJSON(e.getBlock()));
		
		e.setCancelled(Main.isCancelled.get(e.getEventName()));
	}
	
	@EventHandler(ignoreCancelled = true)
	public void onBlockDamage(BlockDamageEvent e) {
		Main.isCancelled.put(e.getEventName(), e.isCancelled());
		Main.instaBreak = e.getInstaBreak();
		
		callMethod("onBlockDamage", e.getPlayer().getName(), blockToJSON(e.getBlock()));
		
		e.setCancelled(Main.isCancelled.get(e.getEventName()));
		e.setInstaBreak(Main.instaBreak);
	}
	
	@EventHandler(ignoreCancelled = true)
	public void onBlockExplode(BlockExplodeEvent e) {
		Main.isCancelled.put(e.getEventName(), e.isCancelled());
		
		callMethod("onBlockExplode", blockToJSON(e.getBlock()), (double) e.getYield());
		
		e.setCancelled(Main.isCancelled.get(e.getEventName()));
	}
	
	@EventHandler(ignoreCancelled = true)
	public void onBlockFade(BlockFadeEvent e) {
		Main.isCancelled.put(e.getEventName(), e.isCancelled());
		
		callMethod("onBlockExplode", blockToJSON(e.getBlock()), blockStateToJSON(e.getNewState()));
		
		e.setCancelled(Main.isCancelled.get(e.getEventName()));
	}
	
	@EventHandler(ignoreCancelled = true)
	public void onBlockGrow(BlockGrowEvent e) {
		Main.isCancelled.put(e.getEventName(), e.isCancelled());
		
		callMethod("onBlockGrow", blockToJSON(e.getBlock()), blockStateToJSON(e.getNewState()));
		
		e.setCancelled(Main.isCancelled.get(e.getEventName()));
	}
	
	@EventHandler(ignoreCancelled = true)
	public void onBlockIgnite(BlockIgniteEvent e) {
		Main.isCancelled.put(e.getEventName(), e.isCancelled());
		
		callMethod("onBlockIgnite", (e.getPlayer()==null?null:e.getPlayer().getName()), blockToJSON(e.getBlock()), e.getCause().ordinal());
		
		e.setCancelled(Main.isCancelled.get(e.getEventName()));
	}
	
	@EventHandler(ignoreCancelled = true)
	public void onBlockRedstone(BlockRedstoneEvent e) {
		callMethod("onBlockRedstone", blockToJSON(e.getBlock()), e.getOldCurrent(), e.getNewCurrent());
	}
	
	@EventHandler(ignoreCancelled = true)
	public void onEnchantItem(EnchantItemEvent e) {
		Main.isCancelled.put(e.getEventName(), e.isCancelled());
		
		callMethod("onEnchantItem", e.getEnchanter().getName(), itemToJSON(e.getItem()), e.getExpLevelCost(), enchantListToJSON(e.getEnchantsToAdd()), blockToJSON(e.getEnchantBlock()));
		
		e.setCancelled(Main.isCancelled.get(e.getEventName()));
	}

	@EventHandler(ignoreCancelled = true)
	public void onPlayerInteract(PlayerInteractEvent e) {
		Main.isCancelled.put(e.getEventName(), e.isCancelled());
		
		callMethod("onPlayerInteract", e.getPlayer().getName(), e.getAction().ordinal(), blockToJSON(e.getClickedBlock()),
				itemToJSON(e.getPlayer().getInventory().getItemInMainHand()));
		
		e.setCancelled(Main.isCancelled.get(e.getEventName()));
	}

	@EventHandler(ignoreCancelled = true)
	public void onInventoryClick(InventoryClickEvent e) {
		Main.isCancelled.put(e.getEventName(), e.isCancelled());
		
		callMethod("onInventoryClick", e.getWhoClicked().getName(), e.getInventory().getName(), itemToJSON(e.getCurrentItem()), e.getSlot());
		
		e.setCancelled(Main.isCancelled.get(e.getEventName()));
	}

	@EventHandler(ignoreCancelled = true)
	public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent e) {
		Main.isCancelled.put("CommandEvent", e.isCancelled());
		
		String label = e.getMessage().replaceFirst("\\/", "").split(" ")[0];
		String[] args = {};
		
		if(e.getMessage().contains(" "))
			args = e.getMessage().substring(label.length()+2).split(" ");
		
		callMethod("onCommand", e.getPlayer(), label, new NativeArray(args));
		e.setCancelled(Main.isCancelled.get("CommandEvent"));
	}
	
	@EventHandler(ignoreCancelled = true)
	public void onServerCommand(ServerCommandEvent e) {
		Main.isCancelled.put("CommandEvent", e.isCancelled());
		
		String label = e.getCommand().replaceFirst("\\/", "").split(" ")[0];
		String[] args = {};
		
		if(e.getCommand().contains(" "))
			args = e.getCommand().substring(label.length()+1).split(" ");
		
		callMethod("onCommand", e.getSender(), label, new NativeArray(args));
		e.setCancelled(Main.isCancelled.get("CommandEvent"));
	}
}
