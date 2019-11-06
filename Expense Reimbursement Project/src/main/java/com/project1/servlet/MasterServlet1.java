package com.project1.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project1.controller.RequestHelper;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;


public class MasterServlet1 extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	
	public final static Logger logger = Logger.getLogger(RequestHelper.class);
       
  
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("in doGet...");
		logger.setLevel(Level.ALL);
		request.getRequestDispatcher(RequestHelper.process(request)).forward(request, response);
	}

	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		logger.setLevel(Level.ALL);
		request.getRequestDispatcher(RequestHelper.process(request)).forward(request, response);

	}

}
