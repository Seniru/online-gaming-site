package com.oop.models;
import java.sql.*;
import com.oop.utils.DBConn;

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
        String html =
                  "<div class=\"chip\">" +
                  "<i class=\"icon\">" + this.icon ; style=\"color:" + this.color + ";\"></i>" +
                  "</div>" +
                  "<div class=\"name container\">" + this.cname + "</div>";
        System.out.println(html);

	}

	@Override
	public void load() {
		try{
			Connection conn = DBConn.getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Category WHERE cname = ? ");
			stmt.setString(1,cname);
			ResultSet res = stmt.executeQuery();

			if(res.next()){

			this.cname = res.getString("cname");
			this.icon = res.getString("icon");
			this.color = res.getString("color ");

			}else{
				System.out.println("Category not found");
			}

		}catch(SQLException e ){
			System.out.println(e);
		}
	}

	@Override
	public void save() {
		try {
			Connection conn = DBConn.getConnection();
			PreparedStatement stmt = conn.prepareStatement("REPLACE INTO cname (cname, icon, color ) VALUES (?, ?, ?)");
			stmt.setString(1, this.cname);
			stmt.setString(2, this.icon);
			stmt.setString(3, this.color );
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
    
}
