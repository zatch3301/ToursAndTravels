package com.zatch.toursandtravels.test;

import java.util.List;
import java.util.Scanner;

import com.zatch.toursandtravels.dao.BookingDao;
import com.zatch.toursandtravels.dao.impl.BookingDaoImpl;
import com.zatch.toursandtravels.pojo.Booking;

public class BookingTest {

	public static void main(String[] args) 
	{
		int choice=0;
		Scanner sc = null;
		String custEmailId;
		int bookingId,tripId,noOfPerson;
		
		Booking booking = null;
		BookingDao bookingDao = new BookingDaoImpl();
		List<Booking> bookinglist = null;
		do
		{
			sc = new Scanner(System.in);
			System.out.println("...Booking Testing...");
			System.out.println("1. Book The Trip ");
			System.out.println("2. Update Booking ");
			System.out.println("3. Delete Booking ");
			System.out.println("4. Show All Booking ");
			System.out.println("5. show My Booking ");
			System.out.println("Select your choice ");
			choice =sc.nextInt();
			
			switch(choice)
			{
				case 1:
					System.out.println("Enter the Booking Details ");
					System.out.println("Enter EmailId");
					custEmailId = sc.next();
					System.out.println("Enter tripId ");
					tripId = sc.nextInt();
					System.out.println("Enter No of Person ");
					noOfPerson = sc.nextInt();
					
					booking = bookingDao.bookTheTrip(custEmailId, tripId, noOfPerson);
					
					if(booking!=null)
					{
						System.out.println("Your Trip Successfully Booking ");
						System.out.println("Details as follows ");
						System.out.println(booking);
						System.out.println("*********************Enjoy Your Trip*********************\n");
						
						
						
					}else {
						System.out.println("Your trip is not Booked. \n\t  try again");
					}
					
					break;
				case 2:
						System.out.println("Enter the Booking Id which u want to update ");
						bookingId = sc.nextInt();
						System.out.println("Enter updated tripId ");
						tripId = sc.nextInt();
						System.out.println("Enter updated No of Person ");
						noOfPerson = sc.nextInt();
						
						booking = bookingDao.updateBooking(bookingId, tripId, noOfPerson);
						
						if(booking!=null)
						{
							System.out.println("Your Booking is Updated ");
							System.out.println("Details as follows ");
							System.out.println(booking);
						}else
							System.out.println("Not Updated....");
						
						
					break;
				case 4:
					bookinglist=bookingDao.getAllBookings();
					if(bookinglist!=null && !bookinglist.isEmpty())
					{
						System.out.println("**********************Booking List**************************");
						bookinglist.forEach(System.out::println); // method Reference.
						System.out.println("________________________________________________________________");
						
					}else
						System.out.println("No Bookings Found.. :(");

					break;
				case 5:
					System.out.println("Enter the Email Id ");
					custEmailId = sc.next();
					bookinglist = bookingDao.getMyBookings(custEmailId);
					if(bookinglist!=null && !bookinglist.isEmpty())
					{
						System.out.println("**********************Booking List**************************");
						bookinglist.forEach(System.out::println); // method Reference.
						System.out.println("________________________________________________________________");
					}else
					{
						System.out.println("No Booking Founds");
					}
					break;
				case 6:
					System.out.println("Thank You :)");
					break;
				default:
					System.out.println("Invalid Choice\n\n\t Try Again\n");
					break;
			}
			
		}while(choice!=6);

	}

}
