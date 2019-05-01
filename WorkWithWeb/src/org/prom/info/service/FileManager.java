package org.prom.info.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.StringWriter;
import java.nio.Buffer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.prom.info.model.Item;

public class FileManager {
	
	private static final String TEXT_FILE_PATH = System.getProperty("user.dir") + System.getProperty("file.separator")
	+ "data" + System.getProperty("file.separator") + "OmenByHP.xml";
	
	public static boolean writeItemInfoToFile(Item item, boolean append) {
		
		StringWriter sw = new StringWriter();
		
		try {
			// create jaxb context
	        JAXBContext jaxbContext = JAXBContext.newInstance(Item.class);

	        // create jaxb marshaller
	        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.marshal(item, sw);
		} catch (JAXBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String xmlString = sw.toString();
		try (FileWriter fileWriter = new FileWriter(TEXT_FILE_PATH, append)){
			
			fileWriter.write(xmlString);
			fileWriter.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return append;
		
		
	}

}
