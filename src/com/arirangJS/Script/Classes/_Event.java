package com.arirangJS.Script.Classes;

import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.annotations.JSConstructor;
import org.mozilla.javascript.annotations.JSStaticFunction;

import com.arirangJS.Main.Main;

@SuppressWarnings("unused")
public class _Event extends ScriptableObject {
	
	private static final long serialVersionUID = -3043165829405454351L;

	@Override
	public String getClassName() {
		return "Event";
	}
	
	@JSConstructor
	public _Event() {}
	
	@JSStaticFunction
	public static void setJoinMessage(String message) {
		Main.joinMessage = message;
	}
	
	@JSStaticFunction
	public static void setQuitMessage(String message) {
		Main.quitMessage = message;
	}
	
	@JSStaticFunction
	public static String getJoinMessage() {
		return Main.joinMessage;
	}
	
	@JSStaticFunction
	public static String getQuitMessage() {
		return Main.quitMessage;
	}
	
	@JSStaticFunction
	public static void setChatFormat(String format) {
		Main.chatFormat = format;
	}
	
	@JSStaticFunction
	public static String getChatFormat(String format) {
		return Main.chatFormat;
	}
	
	@JSStaticFunction
	public static void setCancelled(String event, boolean cancel) {
		Main.isCancelled.put(event, cancel);
	}
	
	@JSStaticFunction
	public static boolean isCancelled(String event) {
		return Main.isCancelled.get(event);
	}
	
	@JSStaticFunction
	public static boolean getCancelled(String event) {
		return isCancelled(event);
	}
	
	@JSStaticFunction
	public static void setInstaBreak(boolean instaBreak) {
		Main.instaBreak = instaBreak;
	}
	
	@JSStaticFunction
	public static boolean getInstaBreak() {
		return Main.instaBreak;
	}
}
