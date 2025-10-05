package com.example.BookMyShow.BookMyShow.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.BookMyShow.BookMyShow.dto.TicketProjection;
import com.example.BookMyShow.BookMyShow.entity.Booking;
import com.example.BookMyShow.BookMyShow.entity.User;
import com.example.BookMyShow.BookMyShow.repository.BookingRepository;
import com.example.BookMyShow.BookMyShow.service.BookingServiceImpl;

@RestController
@RequestMapping("/api/booking")
public class BookingController {

	@Autowired
	private BookingServiceImpl bookingServiceImpl;
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@PreAuthorize("hasRole('USER')")
	@PostMapping("/post")
	public ResponseEntity<Booking> createMovie(@RequestBody Booking booking)
	{
		
		 booking.setBooking_date(new Date());
			Booking movie1=bookingServiceImpl.createMovie(booking);
			

		 
		 return new ResponseEntity<Booking>(movie1,HttpStatus.OK) ;

	}
	
	@GetMapping("/get")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<Booking>> findAll()
	{
		List<Booking> movie2=bookingServiceImpl.finadAll();
		
		return new ResponseEntity<List<Booking>>(movie2,HttpStatus.OK);
	}
	
	@GetMapping("/get/{user}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')" )
	public ResponseEntity<List<Booking>> findById(@PathVariable User user)
	{
		List<Booking> movie3=bookingServiceImpl.findById(user);
		if(movie3.isEmpty())
		{
			return new ResponseEntity<List<Booking>>(HttpStatus.NOT_FOUND);
		}
		else
		{
			return new ResponseEntity<List<Booking>>(movie3,HttpStatus.FOUND);
		}
	}
	
	@PutMapping("/put/{id}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Booking> UpdateById(@PathVariable long id,@RequestBody Booking booking)
	{
		Booking movie4=bookingServiceImpl.UpdateById(booking);
		
		movie4.setId(id);
		return new ResponseEntity<Booking>(movie4,HttpStatus.OK);
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
	public String deleteAll(@RequestBody Booking booking)
	{
		bookingServiceImpl.deleteAll(booking);
		return "All Data Deleted Successfully";
	}
	
	@GetMapping("/totalcost/{booking_id}")
	@PreAuthorize("hasRole('USER')")
public ResponseEntity<List<TicketProjection>> totalCost(@PathVariable Long booking_id)
{
		ModelMapper modelMapper=new ModelMapper();
		
		List<TicketProjection> collect=bookingRepository.getReport(booking_id).stream().map(ticketProjection -> modelMapper.map(ticketProjection, TicketProjection.class))
				.collect(Collectors.toList());
		
		collect.stream().forEach((stock)-> {
			System.out.println(stock.getTotal_cost());
	    });
		
		return new ResponseEntity<List<TicketProjection>>(collect,HttpStatus.OK);
}
	
	

  @GetMapping("/cost/{id}") public String TotalBookingCost(@PathVariable long
  id) { 
	  
	Booking booking=bookingServiceImpl.calculateTotalCost(id);
	return "Total Booking Cost is:"+booking;

  
  }
 
	
}
