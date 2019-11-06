package com.project1.dao;

import com.project1.model.User;

public interface UserInterface {
	
	public User login(String username, String password);
	
	public String getPassHash(String uname, String pass);
	
	public User getUserByUsername(String username);
	
	
}
