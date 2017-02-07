package com.arirangJS.Lang;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import com.arirangJS.Debug.Debug;

public class ErrReporter {
	public static void send(String key, String... properties) {
		ResourceBundle res = ResourceBundle.getBundle("com.arirangJS.Lang.lang");
		Debug.danger(new MessageFormat(res.getString(key)).format(properties));
	}
	
	public static String get(String key, String... properties) {
		ResourceBundle res = ResourceBundle.getBundle("com.arirangJS.Lang.lang");
		return new MessageFormat(res.getString(key)).format(properties);
	}
}
