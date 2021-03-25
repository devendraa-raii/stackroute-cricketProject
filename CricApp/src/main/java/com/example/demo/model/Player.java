package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Player")
public class Player {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	int pid;
	String name;
	String fullName;
	String userName;
	
	
	public Player() {
		super();
	}


	public Player(int id, int pid, String name, String fullName, String userName) {
		super();
		this.id = id;
		this.pid = pid;
		this.name = name;
		this.fullName = fullName;
		this.userName = userName;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getPid() {
		return pid;
	}


	public void setPid(int pid) {
		this.pid = pid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	@Override
	public String toString() {
		return "Player [id=" + id + ", pid=" + pid + ", name=" + name + ", fullName=" + fullName + ", userName="
				+ userName + "]";
	}
	

}
