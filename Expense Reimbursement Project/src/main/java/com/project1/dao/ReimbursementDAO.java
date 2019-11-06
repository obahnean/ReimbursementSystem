package com.project1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.project1.model.Reimbursement;

public class ReimbursementDAO {
	
	private static String connection = "jdbc:oracle:thin:@revaturedb.cg5nmibgkbsw.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "reimbdb";
	private static String password = "p4ssw0rd";
	
	static {
	       try {
	           Class.forName("oracle.jdbc.driver.OracleDriver");
	       } catch (ClassNotFoundException e) {
	           e.printStackTrace();
	       }
	   }
	
	public static ArrayList <Reimbursement> viewReimbs(int eid, int etype) {
		ArrayList <Reimbursement> tix = new ArrayList<Reimbursement>();
		String sql = "";
		
		
		try(Connection conn = DriverManager.getConnection(connection, username, password)){
			ResultSet rs;
			if(etype == 1) {
				sql = "SELECT * FROM ers_reimbursment";
				PreparedStatement ps = conn.prepareStatement(sql);
				
				rs = ps.executeQuery();
			}else {
				sql = "SELECT * FROM ers_reimbursment WHERE reimb_author = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setString(1, ""+eid);
				
				System.out.println("After PS........");
				rs = ps.executeQuery();
				
				System.out.println("After Execute Query");
			}
			

			
			
			while(rs.next()) {
				tix.add(new Reimbursement(rs.getInt(1),rs.getDouble(2),rs.getString(3),rs.getString(4),rs.getString(5),null,rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(10)));
				System.out.println("tix added");
			}
			
			return tix;
		} catch (SQLException e) {
			
			System.out.println("You made it to the view tix catch statement");
			e.printStackTrace();
		}
		return null;
		
	}
	public void addReimbursement(double ammount, String d, int aut ,int rt) {
		
		try(Connection conn = DriverManager.getConnection(connection,username,password)) {
			String insertSQL = "INSERT INTO ers_reimbursment VALUES(REIMBURSMENT_SEQ.NEXTVAL,?,sysdate,null,?,null,?,null,3,?)";
			PreparedStatement ps = conn.prepareStatement(insertSQL);
			//System.out.println("In ADD Reimbursements....\t Watchout");
			ps.setDouble(1, ammount);
			//System.out.println("after amount");
			ps.setString(2, d);
			//System.out.println("afer decs");
			ps.setInt(3, aut);
			//System.out.println("after auth");
			ps.setInt(4, rt);
			//System.out.println("after rt");
			ps.executeQuery();
			//System.out.println("after execute query...");
			
		}catch(SQLException e){
			System.out.println("You made it to the add reimbursement catch block");
		}
		
	}
	
	public void reViewReimbursement(int userid, int reimbursid, int responseValue) {
		try(Connection conn = DriverManager.getConnection(connection,username,password)){
			
			
			String updateSQL = "UPDATE ers_reimbursment SET reimb_status_id = ?, reimb_resolver = ? WHERE reimb_id = ?";
			PreparedStatement ps = conn.prepareStatement(updateSQL);
			System.out.println();
			ps.setInt(1, responseValue);
			System.out.println(responseValue);
			ps.setInt(2, userid);
			System.out.println(userid);
		
			ps.setInt(3, reimbursid) ;
			System.out.println(reimbursid);

			
			ps.executeQuery();
			
		}
		catch(SQLException e){
			System.out.println("You made it to the review reimbursement block...");
		}
	}
			
}
