package com.project1.model;

public class Reimbursement {
	private int id;
	private double ammount;
	private String submit;
	private String resolved;
	private String description;
	private String blob;
	private int owner;
	private int resolver;
	private int status;
	private int reimb_type;
	
	
	public Reimbursement(int int1, double double1, String string, String string2, String string3, String string4,
			int int2, int int3, int int4, int int5) {
		this.id = int1;
		this.ammount = double1;
		this.submit= string;
		this.resolved = string2;
		this.description = string3;
		this.blob = string4;
		this.owner = int2;
		this.resolver = int3;
		this.status = int4;
		this.reimb_type = int5;
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public double getAmmount() {
		return ammount;
	}


	public void setAmmount(double ammount) {
		this.ammount = ammount;
	}


	public String getSubmit() {
		return submit;
	}


	public void setSubmit(String submit) {
		this.submit = submit;
	}


	public String getResolved() {
		return resolved;
	}


	public void setResolved(String resolved) {
		this.resolved = resolved;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getBlob() {
		return blob;
	}


	public void setBlob(String blob) {
		this.blob = blob;
	}


	public int getOwner() {
		return owner;
	}


	public void setOwner(int owner) {
		this.owner = owner;
	}


	public int getResolver() {
		return resolver;
	}


	public void setResolver(int resolver) {
		this.resolver = resolver;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public int getReimb_type() {
		return reimb_type;
	}


	public void setReimb_type(int reimb_type) {
		this.reimb_type = reimb_type;
	}


	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", ammount=" + ammount + ", submit=" + submit + ", resolved=" + resolved
				+ ", description=" + description + ", blob=" + blob + ", owner=" + owner + ", resolver=" + resolver
				+ ", status=" + status + ", reimb_type=" + reimb_type + "]";
	}
	
}
