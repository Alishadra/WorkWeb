package org.prom.info;

import java.io.File;
import java.io.IOException;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

public class PromParsing {
	
	PromParsing promParsing = new PromParsing();
	
	public static void PromParsing() {
		
		Document doc = null;
		try {
			doc =Jsoup.connect("https://prom.ua/ua/p895411456-igrovoj-noutbu-omen.html").get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Elements links = doc.select("rel[href]");
		Elements pngs = doc.select("img[src$=.png]");
		Element masthead = doc.select("div.masthead").first();
		Elements text = doc.getElementsContainingText("content");
		
		String linkhref = links.attr("href");
		
	}

}
