package com.oop.models;

import com.oop.exceptions.GamehubException;

public interface Persistable {
	public void load() throws GamehubException;
	public void save();
}
