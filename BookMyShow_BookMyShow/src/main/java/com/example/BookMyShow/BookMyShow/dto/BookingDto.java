package com.example.BookMyShow.BookMyShow.dto;

public class BookingDto {

	private double total_cost;

	public BookingDto(double total_cost) {
		super();
		this.total_cost = total_cost;
	}

	public BookingDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public double getTotal_cost() {
		return total_cost;
	}

	public void setTotal_cost(double total_cost) {
		this.total_cost = total_cost;
	}
	
	
}
