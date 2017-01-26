package com.arirangJS.Main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bukkit.ChatColor;

import com.arirangJS.Debug.Debug;

public class SyntaxHighlighter {
	
	
	public static String highlight(String code) {
		String result = code;
		
		// 주석 1: /* 이런 스타일 */
		result = find(result, "(^|[^\\\\])\\/\\*[\\w\\W]*?\\*\\/+", ChatColor.GRAY);
		// 주석 2: // 이런 스타일
		result = find(result, "(^|[^\\\\:])\\/\\/.*", ChatColor.GRAY);
		
		// 문자열: "이런 스타일"
		result = find(result, "([\"\'])(\\\\(?:\\r\\n|[\\s\\S])|(?!\\1)[^\\\\\\r\\n])*\\1+", ChatColor.GREEN);
		
		return result;
	}
	
	private static String find(String origin, String regex, ChatColor color) {
		String result = origin;
		Matcher matcher = Pattern.compile(regex).matcher(origin);
		
		while(matcher.find()) {
			int start = matcher.start();
			int end = matcher.end();
			Debug.warn(result.charAt(end-1)+"");
			result = insert(result, start, color+"");
			result = insert(result, end+(color+"").length(), ChatColor.RESET+"");
		}
		
		return result;
	}
	
	public static String insert(String origin, int loc, String str) {
		if(origin == null) throw new NullPointerException("String cannot be null");
		
		if(loc < 0 || loc > origin.length())
			throw new IndexOutOfBoundsException("Incorrect Index");
		
		return origin.substring(0, loc) + str + origin.substring(loc, origin.length());
	}
}