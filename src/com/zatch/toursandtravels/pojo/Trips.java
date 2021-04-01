package com.zatch.toursandtravels.pojo;

import java.time.LocalDateTime;

/*
  	create table trip_408(
	tripId int primary key auto_increment,
	packageId int,
	fromCity varchar(50),
	fromDate datetime,
	toDate datetime
	);

 */

public class Trips 
{
	private int tripId;
	private int packageId;
	
	private Package pkg;
	
	private String fromCity;
	private LocalDateTime fromDate;
	private LocalDateTime toDate;
	
	
	
	
	public Trips() {
		// TODO Auto-generated constructor stub
	}

	public Trips(int packageId, Package pkg, String fromCity, LocalDateTime fromDate, LocalDateTime toDate) {
		super();
		this.packageId = packageId;
		this.pkg = pkg;
		this.fromCity = fromCity;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	public Trips(int tripId, int packageId, Package pkg, String fromCity, LocalDateTime fromDate,
			LocalDateTime toDate) {
		super();
		this.tripId = tripId;
		this.packageId = packageId;
		this.pkg = pkg;
		this.fromCity = fromCity;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	public Trips(int packageId, String fromCity, LocalDateTime fromDate, LocalDateTime toDate) {
		super();
		this.packageId = packageId;
		this.fromCity = fromCity;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
	
	

	public Trips(int tripId, int packageId, String fromCity, LocalDateTime fromDate, LocalDateTime toDate) {
		super();
		this.tripId = tripId;
		this.packageId = packageId;
		this.fromCity = fromCity;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	public int getTripId() {
		return tripId;
	}
	public void setTripId(int tripId) {
		this.tripId = tripId;
	}
	public int getPackageId() {
		return packageId;
	}
	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}
	public Package getPkg() {
		return pkg;
	}
	public void setPkg(Package pkg) {
		this.pkg = pkg;
	}
	public String getFromCity() {
		return fromCity;
	}
	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}
	public LocalDateTime getFromDate() {
		return fromDate;
	}
	public void setFromDate(LocalDateTime fromDate) {
		this.fromDate = fromDate;
	}
	public LocalDateTime getToDate() {
		return toDate;
	}
	public void setToDate(LocalDateTime toDate) {
		this.toDate = toDate;
	}
	
	
	@Override
	public String toString() {
		return "Trips [tripId=" + tripId + ", packageId=" + packageId + ", pkg=" + pkg + ", fromCity=" + fromCity
				+ ", fromDate=" + fromDate + ", toDate=" + toDate + "]";
	}
	
	
		
}
