package com.oop.models;

public class CustomerSupportAgent extends BaseUser {

	public CustomerSupportAgent(String username, String password, String email, String profilePicture) {
		super(username, password, email, profilePicture);   
	}

	public void resolveTicket(Ticket t) {
	
	}

	@Override
	public void delete() {
		throw new UnsupportedOperationException("Cannot delete customer support agents!");
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
