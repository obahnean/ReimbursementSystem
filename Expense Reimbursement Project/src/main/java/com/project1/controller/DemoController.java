package com.project1.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project1.model.User;



public class DemoController {

	public static void demoUser(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException{
		//User newUser = new User("gigi","George");
		
		//res.getWriter().write(new ObjectMapper().writeValueAsString(newUser));
	}
}
