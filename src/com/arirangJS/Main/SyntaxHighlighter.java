package com.arirangJS.Main;

import org.bukkit.ChatColor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SyntaxHighlighter {
    public static String highlight(String code) {
        String result = code;

        result = find(result, "([\"\'])(\\\\(?:\\r\\n|[\\s\\S])|(?!\\1)[^\\\\\\r\\n])*\\1+", ChatColor.GREEN + "");

        result = find(result, "\\b-?(0x[\\dA-Fa-f]+|0b[01]+|0o[0-7]+|\\d*\\.?\\d+([Ee][+-]?\\d+)?|NaN|Infinity)\\b", ChatColor.GREEN + "");

        result = find(result, "\\b(if|else|while|do|for|return|in|instanceof|function|new|try|throw|catch|finally|null|break|continue)\\b", ChatColor.RED + "");
        result = find(result, "\\b(as|async|await|break|case|catch|class|const|continue|debugger|default|delete|do|else|enum|export|extends|finally|for|from|function|get|if|implements|import|in|instanceof|interface|let|new|null|of|package|private|protected|public|return|set|static|super|switch|this|throw|try|typeof|var|void|while|with|yield)\\b", ChatColor.RED + "");

        result = find(result, "\\b(true|false)\\b", ChatColor.GOLD + "");

        result = find(result, "--?|\\+\\+?|!=?=?|<=?|>=?|==?=?|&&?|\\|\\|?|\\?|\\*\\*?|\\/|~|\\^|%|\\.{3}", ChatColor.BOLD + "");

        result = find(result, "(^|[^\\\\])\\/\\*[\\w\\W]*?\\*\\/+", ChatColor.GRAY + "");
        result = find(result, "(^|[^\\\\:])\\/\\/.*", ChatColor.GRAY + "");

        return result;
    }

    private static String find(String origin, String regex, String color) {
        String result = origin;

        if (origin == null) return "";

        Matcher matcher = Pattern.compile(regex).matcher(origin);

        int temp = 0;
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            result = insert(result, start + temp, color + "");
            temp += (color + "").length();
            result = insert(result, end + temp, ChatColor.RESET + "");
            temp += 2;
        }

        return result;
    }

    public static String insert(String origin, int loc, String str) {
        if (origin == null) throw new NullPointerException("String cannot be null");

        if (loc < 0 || loc > origin.length())
            throw new IndexOutOfBoundsException("Incorrect Index");

        return origin.substring(0, loc) + str + origin.substring(loc, origin.length());
    }
}