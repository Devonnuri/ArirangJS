package com.arirangJS.Script.Classes;

import com.arirangJS.Debug.Debug;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.annotations.JSConstructor;
import org.mozilla.javascript.annotations.JSStaticFunction;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class _Request extends ScriptableObject {
	
	private static final long serialVersionUID = -1355237397792687743L;
	
	static final String USER_AGENT = "Mozilla/5.0";
	
	@Override
	public String getClassName() {
		return "Request";
	}
	
	@JSConstructor
	public _Request() {}
	
	@JSStaticFunction
	public static String sendGET(String url) {
		try {
			URL urlObj = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
			
			conn.setRequestMethod("GET");
			conn.setRequestProperty("User-Agent", USER_AGENT);
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			String str;
			StringBuffer response = new StringBuffer();
			
			while((str = reader.readLine()) != null) {
				response.append(str);
			}
			reader.close();
			
			return response.toString();
		} catch(IOException e) {
			Debug.danger(e.getLocalizedMessage());
		}
		
		return null;
	}
	
	@JSStaticFunction
	public static String sendPOST(String url, String paramStr) {
		try {
			URL urlObj = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
			
			conn.setRequestMethod("POST");
			conn.setRequestProperty("User-Agent", USER_AGENT);
			conn.setDoOutput(true);
			
			DataOutputStream outStream = new DataOutputStream(conn.getOutputStream());
			outStream.writeBytes(paramStr);
			outStream.flush();
			outStream.close();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			String str;
			StringBuffer response = new StringBuffer();
			
			while((str = reader.readLine()) != null) {
				response.append(str);
			}
			reader.close();
			
			return response.toString();
		} catch (IOException e) {
			Debug.danger(e.getLocalizedMessage());
		}
		
		return null;
	}
}
