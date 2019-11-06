package com.project1.controller;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project1.dao.ReimbursementDAO;
import com.project1.dao.ReimbursementInt;
import com.project1.model.Reimbursement;
import com.project1.service.UsersServiceImpl;
import com.project1.servlet.MasterServlet1;


public class ReimbursementController {
	
	public static void getTickets(int empID, int empType, HttpServletResponse response) {
		
		ArrayList <Reimbursement> tickets = UsersServiceImpl.getTickets(empID, empType);
		try {
			MasterServlet1.logger.info("Processing Tickets");
			response.getWriter().write(new ObjectMapper().writeValueAsString(tickets));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//add
	public static void addReimbursements(HttpServletRequest req ) {
		
		
		String ammount = req.getParameter("price");
		String description = req.getParameter("desc");
		String author =  req.getSession().getAttribute("userID").toString();
		String type = req.getParameter("reimbtype");
		
		System.out.println("LOOK HERE "+author);
		
		
		double toDouble = Double.parseDouble(ammount);
		System.out.println("ToDouble\t"+toDouble);
		int toAuthor = Integer.parseInt(author);
		System.out.println("ToAuthor\t"+toAuthor);
		
		int toType = Integer.parseInt(type);
		System.out.println("ToType\t"+toType);
		ReimbursementDAO reimbDB = new ReimbursementDAO();
		
		reimbDB.addReimbursement(toDouble, description, toAuthor, toType);
		MasterServlet1.logger.info("New Reimbursement added by " + toAuthor);
		
	}

	public static void respond(HttpServletRequest req) {
		
		
	
		
		int userid = Integer.parseInt(req.getParameter("userid"));
		int reimbursid = Integer.parseInt(req.getParameter("reimbursid"));
		int responseValue = Integer.parseInt(req.getParameter("responseValue"));
		
		ReimbursementDAO reimbDB = new ReimbursementDAO();
		reimbDB.reViewReimbursement(userid, reimbursid, responseValue);
		System.out.println("Finished");
		MasterServlet1.logger.info("Finished Processing ticket");
		
		
		
	}
	
	
}




