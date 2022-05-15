package com.doug.agenda.model;

public class User {

	private Long id;
	
	private String description;
	
	private String password;
	
	public User() {}

	public User(Long id, String description, String password) {
		super();
		this.id = id;
		this.description = description;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
