package com.example.BookMyShow.BookMyShow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.BookMyShow.BookMyShow.dto.TicketProjection;
import com.example.BookMyShow.BookMyShow.entity.Booking;
import com.example.BookMyShow.BookMyShow.entity.User;

public interface BookingRepository extends JpaRepository<Booking, Long> {
	

List<Booking> findByUser(User user);
	
	
@Query(value="call getTotalCost(?)",nativeQuery=true)

List<TicketProjection> getReport(@Param ("booking_id") Long booking_id);
	
@Query(value="select * from booking where transaction_status='Unpaid'",nativeQuery = true)
List<Booking> findByUserId(Long userId);



}
