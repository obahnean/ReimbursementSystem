package com.project1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.project1.model.Reimbursement;
import com.project1.model.User;

public class UserDAO implements UserInterface{
	private static String url = "jdbc:oracle:thin:@revaturedb.cg5nmibgkbsw.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "reimbdb";
	private static String password = "p4ssw0rd";
	
	static {
	       try {
	           Class.forName("oracle.jdbc.driver.OracleDriver");
	       } catch (ClassNotFoundException e) {
	           e.printStackTrace();
	       }
	   }
	
	@Override 
	public User login(String user, String pass) {
		
		String hashPass = getPassHash(user,pass);
		User login = new User(0,"","","","","",0);
		System.out.println(hashPass);
		
		try (Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "SELECT * FROM ers_users WHERE ers_username=? AND ers_password=?";   
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, hashPass);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				login.setId(rs.getInt("ers_user_id"));
				login.setUsername(rs.getString("ers_username"));
				login.setPassword(rs.getString("ers_password"));
				login.setFname(rs.getString("user_first_name"));
				login.setLname(rs.getString("user_last_name"));
				login.setEmail(rs.getString("user_email"));
				login.setRole(rs.getInt("user_role_id"));
				
			}
		
		} catch (SQLException e) {
			System.out.println("You made it to the login exception");
		}
		
		return login;
	}


	@Override
	public String getPassHash(String uname , String pass) {
		
		String hash = "";
		
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "SELECT get_user_hash(?,?) from dual";
			 
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, pass);
			
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				hash = rs.getString(1);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("You made it to the catch statement in getPassHash");
		}
		
		
		return hash;
	}


	@Override
	public User getUserByUsername(String username) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM ers_users where ers_usernamee=?");
			statement.setString(1, username);
			
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				User u = new User( rs.getInt(1), //userid
						rs.getString(2),	//username
						rs.getString(3),	//password
						rs.getString(4),	//firstname
						rs.getString(5),	//lastname
						rs.getString(6),	//email
						rs.getInt(7));		//role
				return u;
			}
			
		}catch(SQLException e) {
			System.out.println("No such user found...");
		}
		return null;
	}
	
	
	
	
}
