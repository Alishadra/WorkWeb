package org.prom.info;


public class AppRunner {

	public static void main(String[] args) {

		
		PromParsing promParsing = new PromParsing();
		FileManager fileManager = new FileManager();
		
		System.out.println(fileManager.writePromParsingToFile(promParsing, true));
		
	}

}
