package com.project1.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project1.model.User;

import org.apache.log4j.Logger;

public class JSONRequestHelper {
	private static final Logger logger = Logger.getLogger(JSONRequestHelper.class);
	
	
	
	public static void getProcess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		System.out.println("In JSONRequestHelper, getProcess...");
		String uri = req.getRequestURI();
		System.out.println(uri);
		
		switch(uri) {
		case "/Project1/getUser.json":
			User temp = (User)req.getSession().getAttribute("user");
			
			System.out.println(temp.toString());

			
			res.getWriter().write(new ObjectMapper().writeValueAsString(temp));
			break;
		case "/Project1/getTix.json":
			
		//req.getSession().setAttribute("role", new User("Ovidiu"));
			User temp2 = (User)req.getSession().getAttribute("user");
			
			ReimbursementController.getTickets(temp2.getId(),temp2.getRole(),res);
			
			System.out.println("In getTix.json: " +req.getSession().getAttribute("user"));
			
			
			
			//res.getWriter().write(new ObjectMapper().writeValueAsString(temp2));
			break;
			
			//next is for debug
		case "/Project1/demo.json":
			DemoController.demoUser(req, res);
			break;
		default:
			res.sendError(404);
		}
		
	}
		
		
		
}



