package com.arirangJS.Script.Classes;

import com.arirangJS.Script.Classes.org.bukkit.entity._Player;
import org.bukkit.craftbukkit.v1_10_R1.entity.CraftPlayer;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.annotations.JSConstructor;
import org.mozilla.javascript.annotations.JSStaticFunction;

import net.minecraft.server.v1_10_R1.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_10_R1.PacketPlayOutChat;
import net.minecraft.server.v1_10_R1.PacketPlayOutTitle;
import net.minecraft.server.v1_10_R1.PacketPlayOutTitle.EnumTitleAction;

public class _Effect extends ScriptableObject{

	private static final long serialVersionUID = -1992104712460419487L;
	
	@JSConstructor
	public _Effect() {}
	
	@Override
	public String getClassName() {
		return "Effect";
	}
	
	@JSStaticFunction
	public static void displayActionBar(_Player player, String message){
		PacketPlayOutChat packet = new PacketPlayOutChat(ChatSerializer.a(message), (byte) 2);
		((CraftPlayer) player.e).getHandle().playerConnection.sendPacket(packet);
	}
	
	@JSStaticFunction
	public static void displayTitle(_Player player, String message, int fadeIn, int duration, int fadeOut){
		PacketPlayOutTitle packet = new PacketPlayOutTitle(EnumTitleAction.TITLE, ChatSerializer.a("{\"text\":\""+message+"\"}"), fadeIn, duration, fadeOut);
		((CraftPlayer) player.e).getHandle().playerConnection.sendPacket(packet);
	}

	@JSStaticFunction
	public static void displaySubtitle(_Player player, String message, int fadeIn, int duration, int fadeOut){
		PacketPlayOutTitle packet = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, ChatSerializer.a("{\"text\":\""+message+"\"}"), fadeIn, duration, fadeOut);
		((CraftPlayer) player.e).getHandle().playerConnection.sendPacket(packet);
	}
}
