package com.zatch.toursandtravels.test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.zatch.toursandtravels.dao.PackageDao;
import com.zatch.toursandtravels.dao.TripDao;
import com.zatch.toursandtravels.dao.impl.PackageDaoImpl;
import com.zatch.toursandtravels.dao.impl.TripDaoImpl;
import com.zatch.toursandtravels.pojo.Package;
import com.zatch.toursandtravels.pojo.Trips;

public class TripTest {

	public static void main(String[] args) 
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		int choice=0;
		Scanner sc = new Scanner(System.in);
		int tripId,packageId;
		String fromCity;
		LocalDateTime fromDate,toDate;
		
		Trips trip = null;
		TripDao tripDao = new TripDaoImpl();
		List<Trips> triplist = null;
		boolean flag;
		
		
		do {
			sc = new Scanner(System.in);
			System.out.println("----------------- Tours Package Testing ------------------");
			System.out.println("___1.Create Trip ");
			System.out.println("___2.Show Trips ");
			System.out.println("___3.Show Trips By Pacakge  ");
			System.out.println("___4.Update Trip by TripId  ");
			System.out.println("___5.Delete Trip ");
			System.out.println("___6.Show Trip by Id  ");
			System.out.println("___7.Exit");
			try 
			{
				System.out.println("Enter your Choice");
				choice = sc.nextInt(); // to handle this 
				switch(choice)
				{
					case 1:
						System.out.println("Enter The Trip Details");
						System.out.println("Enter The Package Id");
						packageId = sc.nextInt();
						Package pkg = new PackageDaoImpl().getPackageById(packageId);
						// here we use un-reference Object of PackageDaoImpl because we need to call 
						// only one single method from this class.
						System.out.println("********Pakage Details************");
						System.out.println(pkg);
						System.out.println("_____________________________________________");
						System.out.println("From City ");
						fromCity = sc.next();
						System.out.println("From Date (e.g dd-MM-yyyy HH:mm):- ");
						sc.nextLine();
						String fdate = sc.nextLine();
						
						fromDate = LocalDateTime.parse(fdate,formatter);
						System.out.println("FromDate :- "+fromDate);
						// To Calculate To date we will take help package module
						int days = pkg.getPackageDays();
						toDate = fromDate.plusDays(days);
						System.out.println("To Date :- "+toDate);	
						
						trip = new Trips(packageId, fromCity, fromDate, toDate);
						
						flag = tripDao.createTrip(trip);
						
						if(flag)
							System.out.println("Trip is Generated for Package id  "+packageId);
						else
							System.out.println("Something went worng Trip is not Generated");
						break;
					case 2:
						triplist = tripDao.showTrips();
						if(triplist!=null && !triplist.isEmpty())
						{
							System.out.println("**************************Available Trip List*********************************");
							triplist.forEach(System.out::println);
							System.out.println("____________________________________________________________");
						}
						else
							System.out.println("No Trips Found");
						break;
					case 3:
							System.out.println("Enter the Package id");
							packageId = sc.nextInt();
							triplist = tripDao.showTripByPackage(packageId);
							if(triplist!=null && !triplist.isEmpty())
							{
								System.out.println("**************************Available Trip List*********************************");
								
								triplist.forEach(System.out::println);
								// here we careate of Consumer object using Method Reference.
								
								System.out.println("____________________________________________________________");
							}
						break;
					case 4:
						System.out.println("Enter the Trip Id to Update Trip");
						tripId = sc.nextInt();
						trip = tripDao.getTripById(tripId);
						if(trip !=null)
						{
							System.out.println("Enter Updated Details for Trip Id :- "+tripId);
							System.out.println("Package Id");
							packageId = sc.nextInt();
							System.out.println("From City");
							fromCity = sc.next();
							System.out.println("From Date(dd-MM-YYYY HH:MM)");
							sc.nextLine();
							String fDate = sc.nextLine();
							fromDate = LocalDateTime.parse(fDate, formatter);
							days = new PackageDaoImpl().getPackageById(packageId).getPackageDays();
							toDate = fromDate.plusDays(days);
							
							trip = new Trips(tripId, packageId, fromCity, fromDate, toDate);
							
							flag = tripDao.updateTrip(trip);
							
							if(flag)
								System.out.println("Trip is Updated Successfully.");
							else
								System.out.println("Trip is Not Updated.");
						}else {
							System.out.println("Trip id Not Found.");
						}
						
						break;
					case 5:
							System.out.println("Enter the Trip id to Delete Trip");
							tripId = sc.nextInt();
							flag = tripDao.deleteTrip(tripId);
							if(flag)
								System.out.println("Trip is Deleted");
							else
								System.out.println("Trip is Not Deleted");
						break;
					case 6:
						System.out.println("Enter the Trip id to show the Trip Details");
						tripId = sc.nextInt();
						
						trip = tripDao.getTripById(tripId);
						if(trip!=null) {
							System.out.println("Trip is Found ");
							System.out.println(trip);
						}
						else
							System.out.println("Trip not Found");
						
						break;
					case 7:
						System.out.println("Thank You :)");
						break;
						
						
						
				}
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}while(choice!=7);

	}

}
