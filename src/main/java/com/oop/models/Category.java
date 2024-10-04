package com.oop.models;

public class Category implements Persistable, Printable {
	
	private String cname;
	private String icon;
	private String color;

	public Category(String cname, String icon, String color) {
		this.cname = cname;
		this.icon = icon;
		this.color = color;
	}

	public String getCname() {
		return this.cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'print'");
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'load'");
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'save'");
	}
    
}
