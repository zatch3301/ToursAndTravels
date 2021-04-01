package com.zatch.toursandtravels.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.zatch.toursandtravels.dao.PackageDao;
import com.zatch.toursandtravels.dao.impl.PackageDaoImpl;
import com.zatch.toursandtravels.pojo.Package;


@WebServlet("/package")
@MultipartConfig		// When upcoming request multi-media data like image video etc.
public class PackageServlet extends HttpServlet {
	
	int packageId;
	String action;
	String packageName, packageLocation, packageType, packageDetails;
	int packageDays;
	double packagePrice;
	
	Package packageobj = null; 
	PackageDao packageDaoObj = new PackageDaoImpl();
	boolean flag;
	InputStream packageImage;
	
	List<Package> packagelist = null;
	HttpSession session;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String action = req.getParameter("action");
		
		if(action!=null && action.equalsIgnoreCase("add")) {
			
			packageName = req.getParameter("packageName");
			packageLocation = req.getParameter("packageLocation");
			packageType = req.getParameter("packageType");
			packageDays = Integer.parseInt(req.getParameter("packageDays"));
			packagePrice = Double.parseDouble(req.getParameter("packagePrice"));
			packageDetails = req.getParameter("packageDetails");
			
			/* image retrival from request */
			Part part = req.getPart("packageImage");
			packageImage = part.getInputStream();
			
			packageobj = new Package(packageName, packageLocation, packageType, 
						packageDays, packagePrice, packageDetails, packageImage);
			
			flag = packageDaoObj.addPackage(packageobj);
			
			if(flag == true) {
				req.setAttribute("msg","<h3>Package is Added</h3>");
				session = req.getSession();
				packagelist = packageDaoObj.showAllPackage();
				session.setAttribute("packagelist", packagelist);
			}
			else {
				req.setAttribute("msg","<h3>Package is not Added</h3>");
			}
			req.getRequestDispatcher("packagelist.jsp").forward(req, resp);
			
		}else if(action!=null && action.equalsIgnoreCase("update")) {
			
			packageId = Integer.parseInt(req.getParameter("packageId"));
			packageName = req.getParameter("packageName");
			packageLocation = req.getParameter("packageLocation");
			packageType = req.getParameter("packageType");
			packageDays = Integer.parseInt(req.getParameter("packageDays"));
			packagePrice = Double.parseDouble(req.getParameter("packagePrice"));
			packageDetails = req.getParameter("packageDetails");
			
			Part part = req.getPart("packageImage");
			packageImage = part.getInputStream();
			
			if(packageImage.available()<=0) // user dont want to update img
			{
				// old image will be taken 
				packageImage = packageDaoObj.getPackageById(packageId).getPackageImage();
				
			}
			
			packageobj =  new Package(packageId, packageName, packageLocation, 
						packageType, packageDays, packagePrice, packageDetails);
			packageobj.setPackageImage(packageImage);
			
			flag = packageDaoObj.updatePackage(packageobj);
			
			if(flag) {
				req.setAttribute("msg","<h3 class='success'>Package Update Success.</h3>");
				session = req.getSession();
				packagelist = packageDaoObj.showAllPackage();
				session.setAttribute("packagelist", packagelist);
			}else
				req.setAttribute("msg","<h3 class='error'>Package Update Unsuccess.</h3>");
			req.getRequestDispatcher("packagelist.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		action = req.getParameter("action");
		session = req.getSession();
		if(action != null && action.equalsIgnoreCase("delete")) {
			
			out.println("delete action");
			packageId = Integer.parseInt(req.getParameter("packageId"));
			flag = packageDaoObj.deletePackage(packageId);
			if(flag) {
				packagelist = packageDaoObj.showAllPackage();
				session.setAttribute("packagelist", packagelist);
				req.setAttribute("msg","<h2 class='success'>Package Deleted Success. Package Id"+packageId+"</h2>");

			}else
				req.setAttribute("msg","<h2 class='error'>Package Delete Unsuccess.</h2>");
			RequestDispatcher rd = req.getRequestDispatcher("packagelist.jsp");
			rd.forward(req, resp);
			
		}else if (action != null && action.equalsIgnoreCase("update")) {
			packageId = Integer.parseInt(req.getParameter("packageId"));
			out.print("update action" + packageId);
			packageobj = packageDaoObj.getPackageById(packageId);
			if(packageobj != null) {
				req.setAttribute("packageobj", packageobj);
				req.getRequestDispatcher("updatepackage.jsp").forward(req, resp);
				
			}else {
				
			}
		}else {
			packagelist = packageDaoObj.showAllPackage();
			session.setAttribute("packagelist", packagelist);
			
			// Package list should be viewed by new request.
			resp.sendRedirect("packagelist.jsp");			
		}
		
	}
	
}
