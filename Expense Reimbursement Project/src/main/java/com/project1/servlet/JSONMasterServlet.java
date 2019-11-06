package com.project1.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;

import com.project1.controller.JSONRequestHelper;

public class JSONMasterServlet extends HttpServlet{





	    private static final long serialVersionUID = 1L;

	    @Override
	    protected void doGet( HttpServletRequest request, HttpServletResponse response )
	            throws ServletException, IOException {
	    	MasterServlet1.logger.setLevel(Level.ALL);
	        JSONRequestHelper.getProcess( request, response );
	        
	        
	    }

	    @Override
	    protected void doPost( HttpServletRequest request, HttpServletResponse response )
	            throws ServletException, IOException {
	        // TODO Auto-generated method stub
	        //JSONRequestHelper.getProcess( request, response );
	        doGet( request, response );
	    }

	}

