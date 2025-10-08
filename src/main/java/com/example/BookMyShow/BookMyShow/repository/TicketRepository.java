package com.example.BookMyShow.BookMyShow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



import com.example.BookMyShow.BookMyShow.entity.Booking;
import com.example.BookMyShow.BookMyShow.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

List<Ticket> getByBooking(Booking booking);



	
}
