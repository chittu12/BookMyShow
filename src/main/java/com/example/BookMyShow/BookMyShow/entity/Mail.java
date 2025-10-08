package com.example.BookMyShow.BookMyShow.entity;


public class Mail {

	private String subject;
	
	private String message;

	public Mail(String subject, String message) {
		super();
		this.subject = subject;
		this.message = message;
	}

	public Mail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
