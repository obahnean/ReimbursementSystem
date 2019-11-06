package com.project1.enums;

public class ReimbursementStatus {
	private int state;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	public String getStatus(int st) {
		if (state == 1)
			return "Approved";
		else if (state == 2)
			return "Declined";
		else
			return "Pending";
	}
	@Override
	public String toString() {
		return "ReimbursementStatus [status_id=" + this.state + ", reimb_status=" + getStatus(this.state) + "]";
	}
	
}
