package com.sab.microservices.pojo;


public class Users {
	public String name;
	public String userName;
	public String email;
	public String moblieNumber;
	public String address;
	public Users(String name, String userName, String email, String moblieNumber, String address) {
		super();
		this.name = name;
		this.userName = userName;
		this.email = email;
		this.moblieNumber = moblieNumber;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMoblieNumber() {
		return moblieNumber;
	}
	public void setMoblieNumber(String moblieNumber) {
		this.moblieNumber = moblieNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
