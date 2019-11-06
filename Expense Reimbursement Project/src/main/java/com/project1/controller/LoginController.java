package com.project1.controller;

import javax.servlet.http.HttpServletRequest;

import com.project1.dao.UserDAO;
import com.project1.dao.UserInterface;
import com.project1.model.User;
import com.project1.servlet.MasterServlet1;

public class LoginController {
	
	public static String login(HttpServletRequest request) {
		
			
	
		//UsersService users = (UsersService) new UsersServiceImpl();
		String un = request.getParameter("username");
		
		String pass = request.getParameter("password");
		
		System.out.println("user: "+ un +"    pass: "+pass);
		System.out.println("Got the parameters....");	
			
		UserInterface db = new UserDAO();
		User loggedAttempt = db.login(un, pass);
		
		System.out.println("Was able to check log in");	
		System.out.println(loggedAttempt);
		if(loggedAttempt.getId() > 0) {
			MasterServlet1.logger.info("Somebody has logged in as an employer");
			System.out.println("Logged successfully");
			int role = loggedAttempt.getRole();
			request.getSession().setAttribute("user", loggedAttempt );
			request.getSession().setAttribute("username", loggedAttempt.getUsername() );
			request.getSession().setAttribute("password", loggedAttempt.getPassword());
			request.getSession().setAttribute("role", role);
			request.getSession().setAttribute("userID", loggedAttempt.getId());
			System.out.println("The user I am looking for"+loggedAttempt);
			System.out.println("LOOK HERE" + loggedAttempt.getId());
			if(role == 2) {
				System.out.println("You are an employer");
				
				return "/html/home.html";
			}else if(role==1) {
				System.out.println("You are a manager");
				MasterServlet1.logger.info("A manager has logged in");
				
				return "/html/admin.html";
			}
			
			return "home.do";
				
		} 
		else {
			MasterServlet1.logger.error("Invalid Credentials entered");
			return "/html/login.html";	
		}		
			
		
	}	
}
