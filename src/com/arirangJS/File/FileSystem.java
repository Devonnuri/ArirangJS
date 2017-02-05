package com.arirangJS.File;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;

import com.arirangJS.Debug.Debug;
import com.arirangJS.Lang.ErrReporter;

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
			ErrReporter.send("err.io.read", file.getName());
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
			ErrReporter.send("err.io.read", file.getName());
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
			ErrReporter.send("err.io.read", file.getName());
			e.printStackTrace();
		}
	}
	
	public static void writeRaw(File file, String... string){
		try{
			Files.write(file.toPath(), Arrays.asList(string));
		}catch(IOException e){
			ErrReporter.send("err.io.write", file.getName());
			e.printStackTrace();
		}
	}
	
	public static void writeLine(File file, int line, String str){
		String[] result = readRaw(file);
		if(result.length < line){
			ErrReporter.send("err.io.incorrect.line", result.length+" >= "+line);
			return;
		} else if(0 > line) {
			ErrReporter.send("err.io.incorrect.line", "0 <= "+line);
			return;
		}
		
		result[line] = str;
		writeRaw(file, result);
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
	
	public static void copy(File src, File dest) {
		try {
			Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
		} catch(IOException e) {
			ErrReporter.send("err.io.copy", src.getName());
			e.printStackTrace();
		}
	}
	
	public static boolean isExist(String filename) {
		return new File(filename).exists();
	}
}