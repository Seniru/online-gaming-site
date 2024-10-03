package com.oop.models;

import java.util.ArrayList;

public abstract class GameBase implements Persistable, Printable {
	    
	private int title;
	private int description;
	private String image;
	private String url;
	private ArrayList<Category> categories;

	public GameBase(int title, int description, String image, String url, ArrayList<Category> categories) {
		this.title = title;
		this.description = description;
		this.image = image;
		this.url = url;
		this.categories = categories;
	}

	int getTitle() {
		return title;
	}

	public void setTitle(int title) {
		this.title = title;
	}

	public int getDescription() {
		return description;
	}
	
	public void setDescription(int description) {
		this.description = description;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getUrl() {
		return url;
	}

	public void setURl(String url) {
		this.url = url;
	}

	public ArrayList<Category> getCategories() {
		return categories;
	}

	public void setCategories(ArrayList<Category> categories) {
		this.categories = categories;
	}
	    
}

