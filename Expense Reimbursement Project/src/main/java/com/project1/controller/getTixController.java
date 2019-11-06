package com.project1.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project1.model.Reimbursement;
import com.project1.service.UsersServiceImpl;
import com.project1.servlet.MasterServlet1;

public class getTixController {

	public static void getTickets(int empID, int eType, HttpServletResponse res) {
		ArrayList <Reimbursement> tixs = UsersServiceImpl.getTickets(empID,eType);
		try {
			res.getWriter().write(new ObjectMapper().writeValueAsString(tixs));
		}catch(JsonProcessingException e) {
			
			System.out.println("You made it to the JSON exception of getTixController");
		}catch(IOException e) {
			System.out.println("You made it to the IO exception block of getTixController");
		} 
		
	}
	
}
