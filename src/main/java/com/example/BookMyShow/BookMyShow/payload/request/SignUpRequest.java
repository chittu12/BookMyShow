package com.example.BookMyShow.BookMyShow.payload.request;

import java.util.Set;



public class SignUpRequest {

	private String first_name;
	
	private String last_name;
	
private String username;

private String email;
	
	private Set<String> role;
	
	private String password;
	
	private String phone;
	
	private String gender;

	public SignUpRequest(String first_name, String last_name, String username, String email, Set<String> role,
			String password, String phone, String gender) {
		
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.email = email;
		this.role = role;
		this.password = password;
		this.phone = phone;
		this.gender = gender;
	}

	public SignUpRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<String> getRole() {
		return role;
	}

	public void setRole(Set<String> role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	
}
