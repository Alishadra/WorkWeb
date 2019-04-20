package org.prom.info;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.Buffer;

public class FileManager {
	
	private static final String TEXT_FILE_PATH = System.getProperty("user.dir") + System.getProperty("file.separator")
	+ "OmenByHP" + System.getProperty("OmenByHP.separator") + "OmenByHP.xml";
	
	public synchronized static boolean writePromParsingToFile(PromParsing promParsing, boolean append) {
		
		try (FileWriter fileWriter = new FileWriter(TEXT_FILE_PATH, append)){
			
			fileWriter.write(promParsing.toString());
			fileWriter.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return append;
		
		
	}

}
