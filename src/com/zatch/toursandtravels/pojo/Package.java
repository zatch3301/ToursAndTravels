package com.zatch.toursandtravels.pojo;

import java.io.InputStream;

/*
 	SQL Table :- 
 	create table Package_408(
	packageId int primary key auto_increment,
	packageName varchar(30) Not Null,
	packageLocation varchar(30) Not Null,
	packageType varchar(30),
	packageDays int,
	packagePrice double(15,2),
	packageDetails varchar(200)
	)

 */
public class Package implements Comparable<Package>
{
	private int packageId;
	private String packageName;
	private String packageLocation;
	private String packageType;
	private int packageDays;
	private double packagePrice;
	private String packageDetails;
	private InputStream packageImage;
	
	//Empyt Object
	public Package() {
	}

	//Object of Package without Id
	public Package(String packageName, String packageLocation, String packageType, int packageDays, double packagePrice,
			String packageDetails, InputStream packageImage) {
		super();
		this.packageName = packageName;
		this.packageLocation = packageLocation;
		this.packageType = packageType;
		this.packageDays = packageDays;
		this.packagePrice = packagePrice;
		this.packageDetails = packageDetails;
		this.packageImage = packageImage;
	}

	//package object with id and all details
	public Package(int packageId, String packageName, String packageLocation, String packageType, int packageDays,
			double packagePrice, String packageDetails) {
		super();
		this.packageId = packageId;
		this.packageName = packageName;
		this.packageLocation = packageLocation;
		this.packageType = packageType;
		this.packageDays = packageDays;
		this.packagePrice = packagePrice;
		this.packageDetails = packageDetails;
		this.packageImage = packageImage;
	}

	// getters and setters
	public int getPackageId() {
		return packageId;
	}

	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getPackageLocation() {
		return packageLocation;
	}

	public void setPackageLocation(String packageLocation) {
		this.packageLocation = packageLocation;
	}

	public String getPackageType() {
		return packageType;
	}

	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}

	public int getPackageDays() {
		return packageDays;
	}

	public void setPackageDays(int packageDays) {
		this.packageDays = packageDays;
	}

	public double getPackagePrice() {
		return packagePrice;
	}

	public void setPackagePrice(double packagePrice) {
		this.packagePrice = packagePrice;
	}

	public String getPackageDetails() {
		return packageDetails;
	}

	public void setPackageDetails(String packageDetails) {
		this.packageDetails = packageDetails;
	}
	
	public InputStream getPackageImage() {
		return packageImage;
	}

	public void setPackageImage(InputStream packageImage) {
		this.packageImage = packageImage;
	}

	// To convert Package object into string.
	@Override
	public String toString() {
		return "Package [packageId=" + packageId + ", packageName=" + packageName + ", packageLocation="
				+ packageLocation + ", packageType=" + packageType + ", packageDays=" + packageDays + ", packagePrice="
				+ packagePrice + ", packageDetails=" + packageDetails + "]";
	}

	@Override
	public int compareTo(Package pkg) {
		// TODO Auto-generated method stub
		return  pkg.packageId - this.packageId;
	}
	
	
	
	

}
