package com.flowergarden.run;

import java.io.File;
import java.io.IOException;

public class RunPathFile {

	public static void main(String[] args) throws IOException {
		System.out.println ("com" + File.separator + "myfile.txt" );
		File myFile = new File("com" + File.separator + "myfile.txt");
		System.out.println(myFile.getCanonicalPath());
		System.out.println(myFile.canWrite());


	}

}
