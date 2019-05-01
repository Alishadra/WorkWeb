package org.prom.info.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Item {

	private String name;
	private String article;
	private String URL;
	private String imgURL;
	private Integer price;

	public String getImgURL() {
		return imgURL;
	}

	@XmlElement
	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}

	public String getName() {
		return name;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public String getArticle() {
		return article;
	}

	@XmlElement
	public void setArticle(String article) {
		this.article = article;
	}

	public String getURL() {
		return URL;
	}

	@XmlElement
	public void setURL(String uRL) {
		URL = uRL;
	}

	public Integer getPrice() {
		return price;
	}

	@XmlElement
	public void setPrice(Integer price) {
		this.price = price;
	}

}
