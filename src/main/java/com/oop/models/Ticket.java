package com.oop.models;

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
		public void print() {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException("Unimplemented method 'print'");
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
	
}
