package com.example.BookMyShow.BookMyShow.controller;


import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.mail.MessagingException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookMyShow.BookMyShow.config.QRCodeGenerator;
import com.example.BookMyShow.BookMyShow.dto.TicketProjection;
import com.example.BookMyShow.BookMyShow.entity.Booking;
import com.example.BookMyShow.BookMyShow.entity.Show;
import com.example.BookMyShow.BookMyShow.entity.Theater;
import com.example.BookMyShow.BookMyShow.entity.Ticket;

import com.example.BookMyShow.BookMyShow.service.TicketServiceImpl;
import com.google.zxing.WriterException;
@RestController
@RequestMapping("/api/ticket")
public class TicketController {
	
	@Autowired
	private TicketServiceImpl bookingServiceImpl;
	
	
	
@PostMapping("/post")
@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Ticket> createMovie(@RequestBody Ticket ticket) throws WriterException, IOException, MessagingException
	{
	ticket.setCreatedon(new Date());
	Ticket movie1=bookingServiceImpl.createMovie(ticket);
	
	QRCodeGenerator.QRCodeGenerator(ticket);
		return new ResponseEntity<Ticket>(movie1,HttpStatus.CREATED);
	}
	
	@GetMapping("/get")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<Ticket>> findAll() throws WriterException, IOException
	{
		List<Ticket> movie2=bookingServiceImpl.finadAll();
		
	
		
		return new ResponseEntity<List<Ticket>>(movie2,HttpStatus.OK);
	}
	
	@GetMapping("/get/{booking}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<List<Ticket>> findById(@PathVariable Booking booking)
	{
		List<Ticket> movie3=bookingServiceImpl.findById(booking);
		if(movie3.isEmpty())
		{
			return new ResponseEntity<List<Ticket>>(HttpStatus.NOT_FOUND);
		}
		else
		{
			return new ResponseEntity<List<Ticket>>(movie3,HttpStatus.FOUND);
		}
	}
	
	
	
	@PutMapping("/put/{id}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Ticket> UpdateById(@PathVariable long id,@RequestBody Ticket ticket)
	{
		Ticket movie4=bookingServiceImpl.UpdateById(ticket);
		
		movie4.setId(id);
		return new ResponseEntity<Ticket>(movie4,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasRole('USER')")
	public String deleteById(@PathVariable long id)
	{
		bookingServiceImpl.deleteById(id);
		
		return "Data Deleted Successfully";
	}
	
	@DeleteMapping("/delete")
	@PreAuthorize("hasRole('USER')")
	public String deleteAll(@RequestBody Ticket ticket)
	{
		bookingServiceImpl.deleteAll(ticket);
		return "All Data Deleted Successfully";
	}
	
	/*
	 * @GetMapping("/cost/{id}") public String TotalBookingCost(@PathVariable long
	 * id) { Ticket booking=bookingServiceImpl.calculateTotalCost(id); return
	 * "The Total Amount is:"+booking;
	 * 
	 * }
	 */
}
