package com.oop.models;

public abstract class BaseUser implements Persistable {
	protected String username;
	protected String password;
	protected String email;
	protected String profilePicture;

	public BaseUser(String username, String password, String email, String profilePicture) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.profilePicture = profilePicture;
	}

	public String getUsername() {
		return this.username;
	}

	public String getPassword() {
		return this.password;
	}

	public String getEmail() {
		return this.email;
	}

	public String getProfilePicture() {
		return this.profilePicture;
	}

	public abstract void delete();

	@Override
	public String toString() {
		return "User " + this.getUsername();
	}

}
