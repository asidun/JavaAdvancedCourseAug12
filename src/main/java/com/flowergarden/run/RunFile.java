package com.flowergarden.run;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class RunFile {

	public static void main(String[] arg) {
		String content = "content!";
		BufferedWriter bw = null;
		File file = new File("file2.txt");
		try {

			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			bw.write(content);
		} catch (Exception e) {
			System.out.println("Ошибка записи в файл \n" + file.getAbsolutePath());
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
