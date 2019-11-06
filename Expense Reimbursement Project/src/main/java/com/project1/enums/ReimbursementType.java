package com.project1.enums;

public class ReimbursementType {
	private int type;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	public String getReimbursement(int ty) {
		if(ty==1)
			return "Lodging";
		else if(ty==2)
			return "Travel";
		else if(ty==3)
			return "Food";
		else
			return "Other";
	}
	
	@Override
	public String toString() {
		return "ReimbursementType [type_id=" + this.type + ", reimb_status=" + getReimbursement(this.type) + "]";
	}
}
