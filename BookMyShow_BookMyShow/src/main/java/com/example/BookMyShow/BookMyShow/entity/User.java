package com.example.BookMyShow.BookMyShow.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.Table;










@Entity
@Table(name="user")
public class User {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
	  private Long id;

	  private String first_name;
	  
	  private String last_name;
	  
	  private String username;
	  
	  private String email;

	
	  private String password;
	  
	  private String phone;
	  
	  private String gender;
	  
	  
	  
	  @ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.DETACH)
	  @JoinTable(name="user_roles",
	  joinColumns = @JoinColumn(name="user_id"),
	  inverseJoinColumns =@JoinColumn(name="role_id"))
	  
	  private Set<Role> roles=new HashSet<Role>();
	  
	



	public User(String first_name, String last_name, String username, String email, String password,
			String phone, String gender) {
	
	
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.gender = gender;
		
	}
	
	









	public User() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
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



	public Set<Role> getRoles() {
		return roles;
	}



	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	  






	



	

	
	
	
}
