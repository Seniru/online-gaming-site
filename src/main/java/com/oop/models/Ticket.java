package com.oop.models;

public class Ticket {
		    
		int TicketID;
	    String Title;
	    String Body;
	    String Username;



        public class Ticketw {
	    
		int TicketID;
	    String Title;
	    String Body;
	    String Username;
	    
	    
	  
		public int getTicketID() {
			return TicketID;
		}
		
		public void setTicketID(int ticketID) {
			TicketID = ticketID;
		}


		public String getTitle() {
			return Title;
		}

		public void setTitle(String title) {
			Title = title;
		}


		public String getBody() {
			return Body;
		}


		public void setBody(String body) {
			Body = body;
		}


		public String getUsername() {
			return Username;
		}

		public void setUsername(String username) {
			Username = username;
		}


		public Ticketw(int ticketID, String title, String body, String username) {
			super();
			TicketID = ticketID;
			Title = title;
			Body = body;
			Username = username;
		}
	    
	    
}


}
