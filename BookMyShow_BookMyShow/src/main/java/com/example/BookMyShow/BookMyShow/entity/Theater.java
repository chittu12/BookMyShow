package com.example.BookMyShow.BookMyShow.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="theaters")
public class Theater {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	private int totalcinemahalls;
	
	private String location;

	public Theater(long id, String name, int totalcinemahalls, String location) {
		super();
		this.id = id;
		this.name = name;
		this.totalcinemahalls = totalcinemahalls;
		this.location = location;
	}

	public Theater() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotalcinemahalls() {
		return totalcinemahalls;
	}

	public void setTotalcinemahalls(int totalcinemahalls) {
		this.totalcinemahalls = totalcinemahalls;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
	

}
