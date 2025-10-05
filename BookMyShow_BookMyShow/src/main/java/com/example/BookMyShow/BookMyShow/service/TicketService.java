package com.example.BookMyShow.BookMyShow.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;

import com.example.BookMyShow.BookMyShow.dto.TicketProjection;
import com.example.BookMyShow.BookMyShow.entity.Booking;
import com.example.BookMyShow.BookMyShow.entity.Show;
import com.example.BookMyShow.BookMyShow.entity.Ticket;
import com.google.zxing.WriterException;


public interface TicketService {
	public Ticket createMovie(Ticket ticket) throws WriterException, IOException, MessagingException;

	public List<Ticket> finadAll();

	public List<Ticket> findById(Booking booking);

	public Ticket UpdateById(Ticket ticket);

	public String deleteById(long id);

	public String deleteAll(Ticket ticket);
	
	/* public Ticket calculateTotalCost(long id); */
}
