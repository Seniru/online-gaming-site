package com.oop.models;

public class Category {
	
	    String Cname;
	    String Icon;
	    String Color;

	public Ticketw(String cname, String icon, String color) {
		super();
		Cname = cname;
		Icon = icon;
		Color = color;
	}

	public String getCname() {
		return Cname;
	}
	public void setCname(String cname) {
		Cname = cname;
	}

	public String getIcon() {
		return Icon;
	}

	public void setIcon(String icon) {
		Icon = icon;
	}
	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
	}
    
}
}
