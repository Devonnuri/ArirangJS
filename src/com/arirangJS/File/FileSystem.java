package com.arirangJS.File;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import com.arirangJS.Debug.Debug;

public class FileSystem {
	public static final String LOC_PLUGIN = "plugins/ArirangJS/";
	public static final String LOC_SCRIPT = LOC_PLUGIN+"scripts/";
	public static final String LOC_TEMP = LOC_SCRIPT+"temp/";
	
	public static String[] readRaw(String filename){
		checkExist(filename);
		return readRaw(new File(filename));
	}
	
	public static String[] readRaw(File file){
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
			String str;
			ArrayList<String> result = new ArrayList<String>();
			
			while((str = reader.readLine()) != null){
				result.add(str);
			}
			
			reader.close();
			return result.toArray(new String[result.toArray().length]);
			
		}catch(IOException e){
			Debug.danger("파일("+file.getName()+") 입력 오류(IOException)가 발생하였습니다. 자세한 내용은 아래에 있습니다.");
			Debug.danger(e.getMessage());
		}
		return null;
	}
	
	public static String readRawInline(String filename){
		checkExist(filename);
		return readRawInline(new File(filename));
	}
	
	public static String readRawInline(File file){
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
			String str;
			String result = "";
			
			while((str = reader.readLine()) != null){
				result += str+"\n";
			}
			
			reader.close();
			return result;
		}catch(IOException e){
			Debug.danger("파일("+file.getName()+") 입력 오류(IOException)가 발생하였습니다. 자세한 내용은 아래에 있습니다.");
			Debug.danger(e.getMessage());
		}
		
		return null;
	}
	
	
	public static String readLine(String filename, int line){
		String[] file = readRaw(filename);
		if(file.length < line){
			Debug.danger("주어진 줄 번호가 너무 큽니다.");
			return null;
		}
		
		return file[line];
	}
	
	public static void writeRaw(String filename, ArrayList<String> string){
		try{
			checkExist(filename); 
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(filename)));
			
			for(String str : string){
				writer.append(str+"\r\n");
			}
			
			writer.close();
		}catch(IOException e){
			Debug.danger("파일("+filename+") 출력 오류(IOException)가 발생하였습니다. 자세한 내용은 아래에 있습니다.");
			e.printStackTrace();
		}
	}
	
	public static void writeRaw(String filename, String... string){
		try{
			checkExist(filename); 
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(filename)));
			
			for(String str : string){
				writer.append(str+"\r\n");
			}
			
			writer.close();
		}catch(IOException e){
			Debug.danger("파일("+filename+") 출력 오류(IOException)가 발생하였습니다. 자세한 내용은 아래에 있습니다.");
			e.printStackTrace();
		}
	}
	
	public static void writeLine(String filename, int line, String str){
		checkExist(filename);
		
		String[] result = readRaw(filename);
		if(result.length < line){
			Debug.danger("주어진 줄 번호가 너무 큽니다.");
			return;
		}
		
		result[line] = str;
		
		writeRaw(filename, new ArrayList<String>(Arrays.asList(result)));
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
			Debug.danger("파일을 복사하는 데 문제가 발생하였습니다.");
			e.printStackTrace();
		}
	}
	
	public static boolean isExist(String filename){
		return new File(filename).exists();
	}
}