package com.zatch.toursandtravels.dao;

import java.util.List;

import com.zatch.toursandtravels.pojo.Trips;

public interface TripDao
{
	boolean createTrip(Trips trip);
	List<Trips> showTrips();
	List<Trips> showTripByPackage(int PackageId);
	boolean updateTrip(Trips trip);
	boolean deleteTrip(int tripId);
	//delete from trip_408 where tripId =?
	Trips getTripById(int tripId);
	//select  * from trip_408 natural join package_408 where trip_id =?

}
