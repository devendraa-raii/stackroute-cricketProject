package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Matches")
@Table(name="Matches")
public class Match {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	int unique_id;
	String team1;
	String team2;
	String date;
	String userName;
	String type;
	public Match() {
		super();
	}
	public Match(int id, int unique_id, String team1, String team2, String date, String userName, String type) {
		super();
		this.id = id;
		this.unique_id = unique_id;
		this.team1 = team1;
		this.team2 = team2;
		this.date = date;
		this.userName = userName;
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUnique_id() {
		return unique_id;
	}
	public void setUnique_id(int unique_id) {
		this.unique_id = unique_id;
	}
	public String getTeam1() {
		return team1;
	}
	public void setTeam1(String team1) {
		this.team1 = team1;
	}
	public String getTeam2() {
		return team2;
	}
	public void setTeam2(String team2) {
		this.team2 = team2;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Match [id=" + id + ", unique_id=" + unique_id + ", team1=" + team1 + ", team2=" + team2 + ", date="
				+ date + ", userName=" + userName + ", type=" + type + "]";
	}
	

}
