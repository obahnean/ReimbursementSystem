package com.project1.service;

import java.sql.SQLException;


public interface UsersService {

	public boolean checkUserAndPassword(String u, String p) throws SQLException;
	
	public void addReimbursement(double ammount, String description, int empID, int rType);

	public void resolveTicket(int stats, int rid);
	
	
	
}
