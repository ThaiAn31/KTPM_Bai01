package com.example.bai01.entity;

public class User {
	int id;
	String fullName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public User(int id, String fullName) {
		super();
		this.id = id;
		this.fullName = fullName;
	}

	public User() {
		super();
	}

}
