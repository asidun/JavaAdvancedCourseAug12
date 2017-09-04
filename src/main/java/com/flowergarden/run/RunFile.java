package com.flowergarden.run;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class RunFile {

	public static void main(String[] arg) throws IOException{
		BufferedReader bufferedIn = null;
		try{
		FileReader filReadStream=new FileReader("file.txt");
		bufferedIn=new BufferedReader(filReadStream);
		String s="",tmpS="";
		while((tmpS=bufferedIn.readLine())!=null)
		    s+=tmpS+"\n";
		System.out.println(s);
		} catch(Exception e){
		      System.out.println("Ошибка чтения из файла file.txt" + e.getMessage());
		}finally{
		    bufferedIn.close();
			}

	}

}
