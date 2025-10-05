package com.example.BookMyShow.BookMyShow.entity;



public enum SeatStatus {
	
	AVAIALABLE("Available"),BLOCKED("Blocked"),BOOKED("Booked"),CANCELLED("Cancelled");



private String SeatStatus;

private SeatStatus(String seatStatus) {
	SeatStatus = seatStatus;
}

public String getSeatStatus() {
	return SeatStatus;
}

public void setSeatStatus(String seatStatus) {
	SeatStatus = seatStatus;
}
	
	

}
