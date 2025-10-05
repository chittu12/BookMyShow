package com.example.BookMyShow.BookMyShow.service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.BookMyShow.BookMyShow.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;



public class UserDetailsImpl implements UserDetails {
	
	 private static final long serialVersionUID = 1L;
	 private Long id;

	  private String first_name;
	  
	  private String last_name;
	  
	
	  private String username;


	  private String email;

	@JsonIgnore
	  private String password;
	  
	  private String phone;
	  
	  private String gender;
	  
	  private Collection<? extends GrantedAuthority> authorities;
	  
	  
	  


	public UserDetailsImpl(Long id, String first_name, String last_name, String username, String email, String password,
			String phone, String gender, Collection<? extends GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.gender = gender;
		this.authorities = authorities;
	}

	  public static UserDetailsImpl build(User user) {
		    List<GrantedAuthority> authorities = user.getRoles().stream()
		        .map(role -> new SimpleGrantedAuthority(role.getName().name()))
		        .collect(Collectors.toList());
		    
		    return new UserDetailsImpl(user.getId(),
		    		user.getFirst_name(),
		    		user.getLast_name(),
		    		user.getUsername(),
		    		user.getEmail(),
		    		user.getPassword(),
		    		user.getPhone(),
		    		user.getGender(),
		    		authorities);
		    
	  }
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}
	
	
	
	



	public Long getId() {
		return id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getPhone() {
		return phone;
	}

	public String getGender() {
		return gender;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	  @Override
	  public boolean equals(Object o) {
	    if (this == o)
	      return true;
	    if (o == null || getClass() != o.getClass())
	      return false;
	    UserDetailsImpl user = (UserDetailsImpl) o;
	    return Objects.equals(id, user.id);
	  }

}
