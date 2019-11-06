package com.project1.service;


import java.util.ArrayList;

import com.project1.dao.ReimbursementDAO;
import com.project1.dao.UserDAO;
import com.project1.dao.UserInterface;
import com.project1.model.Reimbursement;
import com.project1.model.User;

public class UsersServiceImpl implements UsersService {

	@Override
	public boolean checkUserAndPassword(String u, String p) {
		UserInterface users = new UserDAO();
		User temp = users.login(u,p);
		if(temp == null){
			System.out.println("Incorect username or password");
			return false;
		}
		return true;
	}

	@Override
	public void addReimbursement(double ammount, String description, int empID, int rType) {
		
		
	}

	@Override
	public void resolveTicket(int stats, int rid) {
		// TODO Auto-generated method stub
		
	}

	
	public static ArrayList<Reimbursement> getTickets (int eid, int etype){
		
		ArrayList<Reimbursement> tixs = ReimbursementDAO.viewReimbs(eid, etype);
		return tixs;
		
	}

	


}
