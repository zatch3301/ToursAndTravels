package com.zatch.toursandtravels.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

import com.zatch.toursandtravels.dao.TripDao;
import com.zatch.toursandtravels.pojo.Package;
import com.zatch.toursandtravels.pojo.Trips;
import com.zatch.toursandtravels.utility.DBConnection;

public class TripDaoImpl implements TripDao
{
	Connection con = DBConnection.getCon();
	PreparedStatement ps = null;
	ResultSet rs;
	
	String sqlQuery;

	@Override
	public boolean createTrip(Trips trip) 
	{
		sqlQuery= "insert into trip_zatch (packageId,fromCity,fromDate,toDate )values(?,?,?,?)";
		try
		{
			ps = con.prepareStatement(sqlQuery);
			ps.setInt(1,trip.getPackageId());
			ps.setString(2, trip.getFromCity());
			// how we will convert LocalDate into java.sql.Date
			// how we will convert LocalDateTime into java.sql.Timestamp
			Timestamp fDate = Timestamp.valueOf(trip.getFromDate());
			
			ps.setTimestamp(3,fDate);
			Timestamp tDate = Timestamp.valueOf(trip.getToDate());
			ps.setTimestamp(4,tDate);
			
			int i = ps.executeUpdate();
			
			if(i>0)
			{
				return true;
			}

		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Trips> showTrips() 
	{
		List<Trips> triplist = new ArrayList<>();
		sqlQuery="select * from trip_zatch natural join package_zatch";
		
		try {
			ps = con.prepareStatement(sqlQuery);
			
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				Trips trip = new Trips();
				Package pkg = new Package();
				
				trip.setTripId(rs.getInt("tripId"));  // index is 2
				trip.setPackageId(rs.getInt("packageId")); // index 1
				trip.setFromCity(rs.getString(3));
				
				// converting timestamp in LocalDateTime
				Timestamp fts = rs.getTimestamp(4);
				trip.setFromDate(fts.toLocalDateTime());
				trip.setToDate(rs.getTimestamp(5).toLocalDateTime());
				
				//now we set package details 
				pkg.setPackageId(rs.getInt(1));
				pkg.setPackageName(rs.getString(6));
				pkg.setPackageLocation(rs.getString(7));
				pkg.setPackageType(rs.getString(8));
				pkg.setPackageDays(rs.getInt(9));
				pkg.setPackagePrice(rs.getDouble(10));
				pkg.setPackageDetails(rs.getString(11));
				
				
				trip.setPkg(pkg);
				triplist.add(trip);
			}
			return triplist;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Trips> showTripByPackage(int packageId) {
		
		List<Trips> triplist = new ArrayList<>();
		sqlQuery = "select * from trip_zatch natural join package_zatch  where packageId=?";
		
		try {
			
			ps = con.prepareStatement(sqlQuery);
			
			ps.setInt(1,packageId);
			
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				Trips trip = new Trips();
				Package pkg = new Package();
				
				trip.setTripId(rs.getInt("tripId"));  // index is 2
				trip.setPackageId(rs.getInt("packageId")); // index 1
				trip.setFromCity(rs.getString(3));
				
				// converting timestamp in LocalDateTime
				Timestamp fts = rs.getTimestamp(4);
				trip.setFromDate(fts.toLocalDateTime());
				trip.setToDate(rs.getTimestamp(5).toLocalDateTime());
				
				//now we set package details 
				pkg.setPackageId(rs.getInt(1));
				pkg.setPackageName(rs.getString(6));
				pkg.setPackageLocation(rs.getString(7));
				pkg.setPackageType(rs.getString(8));
				pkg.setPackageDays(rs.getInt(9));
				pkg.setPackagePrice(rs.getDouble(10));
				pkg.setPackageDetails(rs.getString(11));
				
				
				trip.setPkg(pkg);
				triplist.add(trip);
			}
			return triplist;	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateTrip(Trips trip) {
		sqlQuery="update trip_zatch set packageId=? ,fromCity =? ,fromDate=?, toDate=? where tripId=?";
				
		try {
			ps = con.prepareStatement(sqlQuery);
			
			ps.setInt(1, trip.getPackageId());
			ps.setString(2,trip.getFromCity());
			ps.setTimestamp(3,Timestamp.valueOf(trip.getFromDate()));
			ps.setTimestamp(4,Timestamp.valueOf(trip.getToDate()));
			ps.setInt(5,trip.getTripId());
			
			int i = ps.executeUpdate();
			
			if(i>0)
				return true;
			
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteTrip(int tripId) 
	{
		sqlQuery="delete from trip_zatch where tripId=?";
		try
		{
			ps = con.prepareStatement(sqlQuery);
			ps.setInt(1,tripId);
			
			int i = ps.executeUpdate();
			
			if(i>0)
				return true;
			
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public Trips getTripById(int tripId) 
	{
		sqlQuery = "select * from trip_zatch natural join package_zatch where tripId=?";
		
		try
		{
			ps = con.prepareStatement(sqlQuery);
			ps.setInt(1,tripId);
			
			rs = ps.executeQuery();
			
			if(rs.next())
			{
				Trips trip = new Trips();
				Package pkg = new Package();
				
				trip.setTripId(rs.getInt(2));  // index is 2
				trip.setPackageId(rs.getInt(1)); // index 1
				trip.setFromCity(rs.getString(3));
				
				// converting timestamp in LocalDateTime
				Timestamp fts = rs.getTimestamp(4);
				trip.setFromDate(fts.toLocalDateTime());
				trip.setToDate(rs.getTimestamp(5).toLocalDateTime());
				
				//now we set package details 
				pkg.setPackageId(rs.getInt(1));
				pkg.setPackageName(rs.getString(6));
				pkg.setPackageLocation(rs.getString(7));
				pkg.setPackageType(rs.getString(8));
				pkg.setPackageDays(rs.getInt(9));
				pkg.setPackagePrice(rs.getDouble(10));
				pkg.setPackageDetails(rs.getString(11));
				
				
				
				
				trip.setPkg(pkg);
				return trip;
			}		
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

}
