package org.prom.info;

import org.prom.info.model.Item;
import org.prom.info.service.FileManager;
import org.prom.info.service.ParsingService;

public class AppRunner {
	private static final String URL = "https://prom.ua/ua/p895411456-igrovoj-noutbu-omen.html";
	public static void main(String[] args) {


		
		Item item = ParsingService.getItem(URL);
		System.out.println(item.getImgURL() + "\n" + item.getName() + "\n" + item.getURL() + "\n" + item.getPrice() + "\n" + item.getArticle());
		FileManager.writeItemInfoToFile(item, false);
		
	}

}
