package com.project1.dao;

import com.project1.model.User;

public class TestShell {

	public static void main(String[] args) {
		User testUser = new User();
		
		UserInterface usr = new UserDAO();
		testUser = usr.login("bahny", "test");
		
		if(testUser.getPassword().equals(usr.getPassHash("bahny", "test"))) {
			System.out.println("Login Complete");
		}
		
		System.out.println(testUser.getFname()+" "+testUser.getLname()+" " + testUser.getPassword());
		System.out.println("The role of the user is : " + testUser.getRole() );

	}

}
