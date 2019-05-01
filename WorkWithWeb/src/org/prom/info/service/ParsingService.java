package org.prom.info.service;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.prom.info.model.Item;

public class ParsingService {

	public static Item getItem(String URL) {
		Item item = new Item();
		Document document = null;
		try {
			document = Jsoup.connect(URL).get();
			item.setImgURL(getImgUrl(document));
			item.setName(getName(document));
			item.setURL(getURL(document));
			item.setPrice(getPrice(document));
			item.setArticle(getArticle(document));

		} catch (IOException e) {
			e.printStackTrace();
		}

		return item;

	}

	private static String getArticle(Document document) {
		Elements artElements = document.getElementsByTag("a");
		for (Element element : artElements) {
			if(element.attr("data-product-id").equals("895411456")) {
				return element.attr("data-product-id");
			}
		}
		
		return "";
	}

	private static Integer getPrice(Document document) {
		Elements spanElements = document.getElementsByTag("span");
		for (Element element : spanElements) {
			if (element.attr("itemprop").equals("price")) {
				String span = element.text();
				int price = Integer.parseInt(span);
				return price;
			}
			
		}

		
		return null;
	}

	private static String getURL(Document document) {
		Elements linkElements = document.getElementsByTag("link");
		for (Element element : linkElements) {
			if (element.hasAttr("hreflang") && element.hasAttr("href") && element.hasAttr("rel")
					&& element.attr("hreflang").equals("uk")) {

				return element.attr("href");
			}
		}

		return "";
	}

	private static String getName(Document document) {
		Elements nameElements = document.getElementsByTag("h1");
		for (Element element : nameElements) {
			if (element.hasAttr("class") && element.hasAttr("data-qaid") && element.hasAttr("itemprop")
					&& element.attr("class").equals("x-title") && element.attr("data-qaid").equals("product_name") && element.attr("itemprop").equals("name")) {
				return element.text();
			}
		}

		return "";
	}

	private static String getImgUrl(Document document) {
		Elements metaElements = document.getElementsByTag("meta");
		for (Element element : metaElements) {
			if (element.hasAttr("content") && element.hasAttr("itemprop") && element.attr("itemprop").equals("image")) {

				return element.attr("content");

			}
		}
		return "";
	}

}
