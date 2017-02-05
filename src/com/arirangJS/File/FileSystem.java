package com.arirangJS.File;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;

import com.arirangJS.Debug.Debug;

public class FileSystem {
	public static final String LOC_PLUGIN = "plugins/ArirangJS/";
	public static final String LOC_SCRIPT = LOC_PLUGIN+"scripts/";
	public static final String LOC_VAR = LOC_SCRIPT+"var/";
	
	public static String[] readRaw(String filename){
		return readRaw(new File(filename));
	}
	
	public static String[] readRaw(File file){
		try{
			return Files.readAllLines(file.toPath(), StandardCharsets.UTF_8).toArray(new String[0]);
		}catch(IOException e){
			Debug.danger("File("+file.getName()+") Exception(IOException) Occured.");
			e.printStackTrace();
		}
		return null;
	}
	
	public static String readRawInline(String filename){
		return readRawInline(new File(filename));
	}
	
	public static String readRawInline(File file){
		try{
			return new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
		}catch(IOException e){
			Debug.danger("File("+file.getName()+") Exception(IOException) Occured.");
			Debug.danger(e.getMessage());
		}
		
		return null;
	}
	
	public static String readLine(File file, int line){
		String[] str = readRaw(file);
		
		if(str.length < line) return null;
		
		return str[line];
	}
	
	public static String readLine(String filename, int line){
		String[] str = readRaw(filename);
		
		if(str.length < line) return null;
		if(str.length == 0) return null;
		
		return str[line];
	}
	
	public static void writeRaw(File file, ArrayList<String> string){
		try{
			Files.write(file.toPath(), string);
		}catch(IOException e){
			Debug.danger("File("+file.getName()+") Exception(IOException) Occured.");
			e.printStackTrace();
		}
	}
	
	public static void writeRaw(File file, String... string){
		try{
			Files.write(file.toPath(), Arrays.asList(string));
		}catch(IOException e){
			Debug.danger("File("+file.getName()+") Exception(IOException) Occured.");
			e.printStackTrace();
		}
	}
	
	public static void writeLine(File file, int line, String str){
		String[] result = readRaw(file);
		if(result.length < line){
			throw new IndexOutOfBoundsException("Given line number is out of string range: " + result.length + " >= " + line);
		}
		
		result[line] = str;
		
		writeRaw(file, new ArrayList<String>(Arrays.asList(result)));
	}
	
	public static boolean checkExist(String filename){
		if(isExist(filename)){
			return true;
		}else{
			File file = new File(filename);
			if(filename.endsWith("/")) {
				file.mkdirs();
			} else {
				file.getParentFile().mkdirs();
			}
			
			return false;
		}
	}
	
	public static void copy(String src, String dest) {
		try {
			FileInputStream input = new FileInputStream(src);
			FileOutputStream output = new FileOutputStream(dest);
			
			int data = 0;
			while((data = input.read())!=-1) {
				output.write(data);
			}
			
			input.close();
			output.close();
		} catch(IOException e) {
			Debug.danger("An error(IOException) occured while copying files.");
			e.printStackTrace();
		}
	}
	
	public static boolean isExist (String filename){
		return new File(filename).exists();
	}
}