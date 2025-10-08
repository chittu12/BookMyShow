package com.example.BookMyShow.BookMyShow.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Role {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
@Enumerated(EnumType.STRING)
	private ERole name;

public Role(long id, ERole name) {
	super();
	this.id = id;
	this.name = name;
}

public Role() {

}

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public ERole getName() {
	return name;
}

public void setName(ERole name) {
	this.name = name;
}



	
}
