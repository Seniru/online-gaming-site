package com.oop.models;

import java.sql.*;
import java.io.PrintWriter;

import com.oop.utils.DBConn;

public class Ticket implements Persistable, Printable {
		    
		private int ticketID;
	    private String title;
	    private String body;
	    private RegisteredUser user;
        
		public Ticket(int ticketID, String title, String body, RegisteredUser user) {
			this.ticketID = ticketID;
			this.title = title;
			this.body = body;
			this.user = user;
		}
	    
		public int getTicketID() {
			return ticketID;
		}
		
		public void setTicketID(int ticketID) {
			this.ticketID = ticketID;
		}

		public String getTitle() {
			return this.title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getBody() {
			return body;
		}


		public void setBody(String body) {
			this.body = body;
		}

		public RegisteredUser getUser() {
			return user;
		}

		public void setUsername(RegisteredUser user) {
			this.user = user;
		}

		@Override
		public void print(PrintWriter out) {
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
			try{
				Connection conn = DBConn.getConnection();
				PreparedStatement stmt = conn.prepareStatement("REPLACE INTO Ticket(Title, Body, Username) VALUES (?,?,?)");
				stmt.setString(1, this.title);
				stmt.setString(2, this.body);
				stmt.setString(3, this.user.getUsername());
				stmt.executeUpdate();
			} catch (SQLException e){
				System.out.println(e);
			}		
		}
	
}
