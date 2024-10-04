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
		Connection conn = DBConn.getConnection();
		PreparedStatement stmt=cnn.PreparedStatement("Replace into user(title, description, image, url, categories)VALUES(?,?,?)");
		stmt.setString(1,this.title);
		stmt.setString(2,this.description);
		stmt.setString(3,this.image);
		stmt.setString(4,this.url);
		stmt.setString(5,this.categories);
		stmt.executeUpdate();
	}catch(SQLException a){
		System.out.println(a);
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
