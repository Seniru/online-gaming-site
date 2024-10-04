package com.oop.models;

public interface Persistable {
	public void load(String identifier);
	public void save();
}
