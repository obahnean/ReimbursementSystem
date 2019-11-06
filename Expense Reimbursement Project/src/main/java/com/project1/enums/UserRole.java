package com.project1.enums;

public class UserRole {
	private int role;
	
	public String getRole(int role) {
		if(role==1)
			return "Employer";
		else
			return "Manager";
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "UserRole [role_id=" + this.role + ", role_desc=" + getRole(this.role) + "]";
	}
}
