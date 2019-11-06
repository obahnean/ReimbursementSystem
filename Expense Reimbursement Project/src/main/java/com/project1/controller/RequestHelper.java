package com.project1.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {
	
	public static String process(HttpServletRequest req) {
		
	
		
		
		
		switch(req.getRequestURI()) {
		case "/Project1/html/login.do":
			System.out.println("in login.do requestHelper");
			return LoginController.login(req);
			
		case "/Project1/html/home.do":
			System.out.println("in home.do requestHelper");
			return LoginController.login(req);
		
		case "/Project1/html/logout.do":
			
			req.getSession().invalidate();
			return "/html/login.html";

		case "/Project1/addReimb.do":
			System.out.println("Got to call add reimb");
			ReimbursementController.addReimbursements(req);
			return "/html/home.html";
		case "/Project1/html/respond.do":
			System.out.println("You try to Approve/Deny");
			ReimbursementController.respond(req);
			return "admin.html";
			
		default:
			System.out.println(req.getRequestURI());
			return "/Project1/html/404.html";
		}
		
	}

}
