package com.zatch.toursandtravels.dao.impl;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.zatch.toursandtravels.dao.BookingDao;
import com.zatch.toursandtravels.pojo.Booking;
import com.zatch.toursandtravels.pojo.Trips;
import com.zatch.toursandtravels.utility.DBConnection;

public class BookingDaoImpl implements BookingDao
{
	Connection con = DBConnection.getCon();
	PreparedStatement ps=null,ps2 = null;
	ResultSet rs=null;
	
	String sqlQuery,sqlQuery2;
	

	@Override
	public Booking bookTheTrip(String custEmailId, int tripId, int noOfPerson) 
	{
		sqlQuery="insert into booking_zatch (custEmailId,tripId,bookingDate,noOfPersons,totalAmount) values(?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sqlQuery);
			
			ps.setString(1,custEmailId);
			ps.setInt(2,tripId);
			final String bookingDate = LocalDateTime.now().toString();
			ps.setString(3, bookingDate);
			ps.setInt(4,noOfPerson);
			
			Trips trip = new TripDaoImpl().getTripById(tripId);
			double basePrice = trip.getPkg().getPackagePrice();
			double totalAmount = basePrice * noOfPerson ;
			
			ps.setDouble(5,totalAmount);
			
			int i = ps.executeUpdate();
			if(i>0)
			{
				sqlQuery2 = "select * from Booking_zatch where custEmailId=? and bookingDate=?";
				ps2 = con.prepareStatement(sqlQuery2);
				
				ps2.setString(1, custEmailId);
				ps2.setString(2, bookingDate);
				rs = ps2.executeQuery();
				if(rs.next())
				{
					Booking booking = new Booking();
					booking.setBookingId(rs.getInt(1));
					booking.setCustEmailId(rs.getString(2));
					booking.setTripId(rs.getInt(3));
					booking.setBookingDate(LocalDateTime.parse(rs.getString(4)));
					booking.setBookingStatus(rs.getString(5));
					booking.setNoOfPersons(rs.getInt(6));
					booking.setTotalAmount(rs.getDouble(7));
					
					return booking;
				}
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Booking updateBooking(int bookingId, int tripId, int noOfPerson) {

		sqlQuery="update booking_zatch set tripId=? , noOfPersons=? , totalAmount=?  where bookingId=?";
		try {
			ps = con.prepareStatement(sqlQuery);
			ps.setInt(1,tripId);
			ps.setInt(2,noOfPerson);
			
			double baseAmount = new TripDaoImpl().getTripById(tripId).getPkg().getPackagePrice();
			double totalAmount = baseAmount * noOfPerson;
			
			ps.setDouble(3,totalAmount);
			ps.setInt(4,bookingId);
			
			
		
			int i = ps.executeUpdate();
		
			if(i>0)
			{
				sqlQuery2="select * from booking_zatch where bookingId=?";
				ps2 = con.prepareStatement(sqlQuery2);
				
				ps2.setInt(1, bookingId);
				
				rs = ps2.executeQuery();
				
				if(rs.next())
				{
					Booking booking = new Booking();
					booking.setBookingId(rs.getInt(1));
					booking.setCustEmailId(rs.getString(2));
					booking.setTripId(rs.getInt(3));
					booking.setBookingDate(LocalDateTime.parse(rs.getString(4)));
					booking.setBookingStatus(rs.getString(5));
					booking.setNoOfPersons(rs.getInt(6));
					booking.setTotalAmount(rs.getDouble(7));
					
					return booking;
				}
				
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean cancelBooking(int bookingId) {

		sqlQuery="";
		try {
			ps = con.prepareStatement(sqlQuery);
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<Booking> getAllBookings() {
		List<Booking> bookinglist = new ArrayList<>();
		sqlQuery="select * from booking_zatch";
		try {
			ps = con.prepareStatement(sqlQuery);
			
			rs = ps.executeQuery();
			while(rs.next())
			{
				Booking booking = new Booking();
				booking.setBookingId(rs.getInt(1));
				booking.setCustEmailId(rs.getString(2));
				booking.setTripId(rs.getInt(3));
				booking.setBookingDate(LocalDateTime.parse(rs.getString(4)));
				booking.setBookingStatus(rs.getString(5));
				booking.setNoOfPersons(rs.getInt(6));
				booking.setTotalAmount(rs.getDouble(7));
				bookinglist.add(booking);
			}
			return bookinglist;
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Booking> getMyBookings(String custEmailId) {
		
		List<Booking>  bookinglist = new ArrayList<>();
		sqlQuery="select * from booking_zatch where custEmailId=?";
		try {
			ps = con.prepareStatement(sqlQuery);
			ps.setString(1,custEmailId);
			
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				Booking booking = new Booking();
				booking.setBookingId(rs.getInt(1));
				booking.setCustEmailId(rs.getString(2));
				booking.setTripId(rs.getInt(3));
				booking.setBookingDate(LocalDateTime.parse(rs.getString(4)));
				booking.setBookingStatus(rs.getString(5));
				booking.setNoOfPersons(rs.getInt(6));
				booking.setTotalAmount(rs.getDouble(7));
				bookinglist.add(booking);
			}
			return bookinglist;
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return null;
	}

}
