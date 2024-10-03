package com.oop.models;

import java.util.ArrayList;
public class Game extends GameBase {

	public Game(int title, int description, String image, String url, ArrayList<Category> categories) {
		super(title, description, image, url, categories);
	}

	@Override
	public void load(String identifier) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'load'");
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'save'");
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'print'");
	}
	
}
