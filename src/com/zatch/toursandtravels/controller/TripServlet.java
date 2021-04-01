package com.zatch.toursandtravels.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zatch.toursandtravels.dao.PackageDao;
import com.zatch.toursandtravels.dao.TripDao;
import com.zatch.toursandtravels.dao.impl.PackageDaoImpl;
import com.zatch.toursandtravels.dao.impl.TripDaoImpl;
import com.zatch.toursandtravels.pojo.Package;
import com.zatch.toursandtravels.pojo.Trips;;

@WebServlet("/trip")
public class TripServlet extends HttpServlet{
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
	String action,fdate,cur,fromCity;
	int packageId;
	PackageDao packageDao = new PackageDaoImpl();
	TripDao tripDao = new TripDaoImpl();
	Package tripPackage;
	LocalDateTime fromDate,toDate;
	Trips trip;
	List<Trips> triplist = null;
	boolean flag = false;
	HttpSession session = null;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		action= req.getParameter("action");
		if(action != null && action.equalsIgnoreCase("createtrip")) {
			packageId = Integer.parseInt(req.getParameter("packageId"));
			fromCity = req.getParameter("fromCity");
			fromDate = LocalDateTime.parse(req.getParameter("fromDate"),formatter);
			toDate = LocalDateTime.parse(req.getParameter("toDate"),formatter);
			trip = new Trips(packageId, fromCity, fromDate, toDate);
			
			flag = tripDao.createTrip(trip);
			if(flag) {
				req.setAttribute("msg", "<span class='success'> Trip is Added.</span>");
			}else {
				req.setAttribute("msg", "<span class='success'> Trip is not Added.</span>");
			}
			req.getRequestDispatcher("packagelist.jsp").forward(req, resp);
		}

	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		action= req.getParameter("action");
		session = req.getSession();
		if(action != null && action.equalsIgnoreCase("addtrip")) {
			packageId = Integer.parseInt(req.getParameter("packageId"));
			tripPackage = packageDao.getPackageById(packageId);
			req.setAttribute("tripPackage", tripPackage);
			cur = LocalDateTime.now().format(formatter);
//			System.out.println(cur);
			req.setAttribute("curtime", cur);
			req.getRequestDispatcher("addtrip.jsp").forward(req, resp);
			
		}else if(action != null && action.equalsIgnoreCase("calcToDate")) {
			packageId = Integer.parseInt(req.getParameter("packageId"));
			tripPackage = packageDao.getPackageById(packageId);
			fdate = req.getParameter("fromDate");
			fromDate = LocalDateTime.parse(fdate,formatter);
			int days = tripPackage.getPackageDays();
			toDate = fromDate.plusDays(days);
			String tDate = toDate.format(formatter);
			resp.setContentType("text/plain");
			resp.getWriter().print(tDate);
			
		}else if(action != null && action.equalsIgnoreCase("showtripbypackage")) {
			packageId = Integer.parseInt(req.getParameter("packageId"));
			triplist = tripDao.showTripByPackage(packageId);
			session.setAttribute("triplist", triplist);
			resp.sendRedirect("triplist.jsp");
			
		}else {
			triplist = tripDao.showTrips();
			session.setAttribute("triplist", triplist);
			resp.sendRedirect("triplist.jsp");
		}
	}
}
