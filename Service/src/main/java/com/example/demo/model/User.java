package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User {
	@Id
	private String userName;
	private String password;
	private String fullName;
	private String email;
	private String address;
	public User() {
		super();
	}
	public User(String userName, String password, String fullName, String email, String gender, String address) {
		super();
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.email = email;
		this.address = address;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", fullName=" + fullName + ", email=" + email
				+ ", address=" + address + "]";
	}
	
	
	

}
