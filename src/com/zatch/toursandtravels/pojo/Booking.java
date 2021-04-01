package com.zatch.toursandtravels.pojo;

import java.time.LocalDateTime;

/*
	 	create table booking_408(
		bookingId int primary Key auto_increment,
		custEmailId varchar(50) not null,
		tripId int not null,
		bookingDate varchar(50) ,
		bookingStatus varchar(100) default 'Processing',
		noOfPersons int default 1,
		totalAmount double
	);
 */

public class Booking
{
	private int bookingId;
	private String custEmailId;
	private int tripId;
	private LocalDateTime bookingDate;
	private String bookingStatus;
	private int noOfPersons;
	private double totalAmount;
	
	public Booking() {
		// TODO Auto-generated constructor stub
	}

	public Booking(String custEmailId, int tripId, LocalDateTime bookingDate, String bookingStatus, int noOfPersons,
			double totalAmount) {//CURRENT_TIMESTAMP
		super();
		this.custEmailId = custEmailId;
		this.tripId = tripId;
		this.bookingDate = bookingDate;
		this.bookingStatus = bookingStatus;
		this.noOfPersons = noOfPersons;
		this.totalAmount = totalAmount;
	}

	public Booking(int bookingId, String custEmailId, int tripId, LocalDateTime bookingDate, String bookingStatus,
			int noOfPersons, double totalAmount) {
		super();
		this.bookingId = bookingId;
		this.custEmailId = custEmailId;
		this.tripId = tripId;
		this.bookingDate = bookingDate;
		this.bookingStatus = bookingStatus;
		this.noOfPersons = noOfPersons;
		this.totalAmount = totalAmount;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getCustEmailId() {
		return custEmailId;
	}

	public void setCustEmailId(String custEmailId) {
		this.custEmailId = custEmailId;
	}

	public int getTripId() {
		return tripId;
	}

	public void setTripId(int tripId) {
		this.tripId = tripId;
	}

	public LocalDateTime getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDateTime bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public int getNoOfPersons() {
		return noOfPersons;
	}

	public void setNoOfPersons(int noOfPersons) {
		this.noOfPersons = noOfPersons;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", custEmailId=" + custEmailId + ", tripId=" + tripId
				+ ", bookingDate=" + bookingDate + ", bookingStatus=" + bookingStatus + ", noOfPersons=" + noOfPersons
				+ ", totalAmount=" + totalAmount + "]";
	}
}
