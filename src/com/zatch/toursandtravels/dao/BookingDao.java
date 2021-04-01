package com.zatch.toursandtravels.dao;

import java.util.List;

import com.zatch.toursandtravels.pojo.Booking;

public interface BookingDao
{
	Booking bookTheTrip(String custEmailId,int tripId,int noOfPerson);
	
	Booking updateBooking(int bookingId,int tripId,int noOfPerson);
	
	boolean cancelBooking(int bookingId);
	
	
	List<Booking> getAllBookings();
	List<Booking> getMyBookings(String custEmailId);
	
	
	
}
