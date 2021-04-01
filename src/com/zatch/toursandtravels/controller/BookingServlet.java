package com.zatch.toursandtravels.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zatch.toursandtravels.dao.BookingDao;
import com.zatch.toursandtravels.dao.TripDao;
import com.zatch.toursandtravels.dao.impl.BookingDaoImpl;
import com.zatch.toursandtravels.dao.impl.TripDaoImpl;
import com.zatch.toursandtravels.pojo.Booking;
import com.zatch.toursandtravels.pojo.Trips;

@WebServlet("/booking")
public class BookingServlet extends HttpServlet{
	
	String action,custEmailId;
	int tripId,noOfPerson;
	Trips trip;
	TripDao tripDao = new TripDaoImpl();
	BookingDao bookingDao = new BookingDaoImpl();
	Booking booking = null;
	HttpSession session;
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		action= req.getParameter("action");
		session = req.getSession();
		if(action != null && action.equalsIgnoreCase("bookthetrip")) {
			custEmailId = req.getParameter("custEmailId");
			tripId = Integer.parseInt(req.getParameter("tripId"));
			noOfPerson = Integer.parseInt(req.getParameter("noOfPerson"));
			bookingDao.bookTheTrip(custEmailId, tripId, noOfPerson);
			booking = bookingDao.bookTheTrip(custEmailId, tripId, noOfPerson);
			req.setAttribute("msg", "Your booking is successful...");
			req.setAttribute("booking", booking);
			req.getRequestDispatcher("bookingdetail.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		action= req.getParameter("action");
		session = req.getSession();
		if(action != null && action.equalsIgnoreCase("booktrip")) {
			tripId = Integer.parseInt(req.getParameter("tripId"));
			trip = tripDao.getTripById(tripId);
			req.setAttribute("bookedTrip", trip);
			req.getRequestDispatcher("addbooking.jsp").forward(req, resp);
		}
	}

}
