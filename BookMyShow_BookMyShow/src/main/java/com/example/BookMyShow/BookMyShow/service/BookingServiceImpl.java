package com.example.BookMyShow.BookMyShow.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.BookMyShow.BookMyShow.entity.Booking;
import com.example.BookMyShow.BookMyShow.entity.ShowSeat;
import com.example.BookMyShow.BookMyShow.entity.Ticket;
import com.example.BookMyShow.BookMyShow.entity.User;
import com.example.BookMyShow.BookMyShow.repository.BookingRepository;
import com.example.BookMyShow.BookMyShow.repository.TicketRepository;
import com.example.BookMyShow.BookMyShow.repository.UserRepository;
@Service
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Booking createMovie(Booking booking) {
		// TODO Auto-generated method stub
		
		
		
		  Authentication
		  authentication=SecurityContextHolder.getContext().getAuthentication();
		  
		  UserDetailsImpl userDetails=(UserDetailsImpl) authentication.getPrincipal();
		  
		  
		
		  
		  Optional<User> booking1=userRepository.findById(userDetails.getId());
		  
		  booking.setUser(booking1.get());
		 
return bookingRepository.save(booking);
	}

	@Override
	public List<Booking> finadAll() {
		// TODO Auto-generated method stub
		return bookingRepository.findAll();
	}

	@Override
	public List<Booking> findById(User user) {
		// TODO Auto-generated method stub
		
return bookingRepository.findByUser(user);
	}

	@Override
	public Booking UpdateById(Booking booking) {
		// TODO Auto-generated method stub
		return bookingRepository.save(booking);
	}

	@Override
	public String deleteById(long id) {
		bookingRepository.deleteById(id);
		return "Data Deleted Successfully";
	}

	@Override
	public String deleteAll(Booking booking) {
		bookingRepository.deleteAll();
		return "All Data Deleted Successfully";
	}

	
	/*
	 * @Override public Booking calculateTotalCost(long id) { // TODO Auto-generated
	 * method stub List<Booking> ticket=bookingRepository.findAll(); Set<ShowSeat>
	 * showSeat=new HashSet<ShowSeat>();
	 * 
	 * for(Booking tickets:ticket) { if(id==tickets.getTicket().getId()) {
	 * showSeat.addAll(tickets.getShowSeat()); } }
	 * 
	 * double amount = 0; for (ShowSeat seat : showSeat) { amount = amount +
	 * seat.getPrice(); } Booking booking=bookingRepository.getOne(id);
	 * booking.setTotal_cost(amount);
	 * 
	 * return booking ; }
	 */
	 
	
	@Override
	public Booking calculateTotalCost(long id) {
		// TODO Auto-generated method stub
		List<Booking> ticket=bookingRepository.findAll();
		Set<ShowSeat> showSeat=new HashSet<ShowSeat>();
		
		for(Booking tickets:ticket)
		{
			if(id==tickets.getId())
			{
				showSeat.addAll(tickets.getShowSeat());
			}
		}
	double amount = 0;
		for (ShowSeat seat : showSeat) {
			amount = amount + seat.getPrice();
		}
	Booking booking=bookingRepository.findById(id).orElseThrow();
		booking.setTotal_cost(amount);
		
		bookingRepository.save(booking);
		
		return booking;
	}

}
