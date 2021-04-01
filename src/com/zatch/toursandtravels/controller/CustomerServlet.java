package com.zatch.toursandtravels.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zatch.toursandtravels.dao.CustomerDao;
import com.zatch.toursandtravels.dao.impl.CustomerDaoImpl;
import com.zatch.toursandtravels.pojo.Customer;

@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {
	
	Customer customer = null;
	String action = null;
	CustomerDao customerDao = new CustomerDaoImpl();
	
	int custId;
	String custName, custEmailId, custMobileNo, custPassword, custAddress;
	boolean flag = false;
	List<Customer> customerlist = null;
	HttpSession session;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		action = req.getParameter("action");
		session = req.getSession();
		
		if(action!=null && action.equalsIgnoreCase("addcustomer")) {
			
			custName = req.getParameter("custName");
			custEmailId = req.getParameter("custEmailId");
			custMobileNo = req.getParameter("custMobileNo");
			custPassword = req.getParameter("custPassword");
			custAddress = req.getParameter("custAddress");
			
			customer = new Customer(custName, custEmailId, custMobileNo, custPassword, custAddress);
			
			flag = customerDao.registerCustomer(customer);
			if(flag) {
				req.setAttribute("msg", "<h4 class='success'>Customer Registration Success Login here</h4>");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
				
			}else {
				req.setAttribute("msg", "<h4 class='error'>Customer Registration Unsuccess Try again</h4>");
				req.getRequestDispatcher("custregistration.jsp").forward(req, resp);
			}
				
		}else if(action!=null && action.equalsIgnoreCase("updatecustomer")) {
			
			custName = req.getParameter("custName");
			custEmailId = req.getParameter("custEmailId");
			custMobileNo = req.getParameter("custMobileNo");
			custPassword = req.getParameter("custPassword");
			custAddress = req.getParameter("custAddress");
			custId = Integer.parseInt(req.getParameter("custId"));
			
			customer = new Customer(custId, custName, custEmailId, custMobileNo, custPassword, custAddress);
			flag = customerDao.updateCustomer(customer);
			
			if(flag) {
				req.setAttribute("msg", "<h2 class='success'>Cuntomer is updated</h2>");
				customerlist = customerDao.showAllCustomer();
				session.setAttribute("customerlist", customerlist);
				req.getRequestDispatcher("customerlist.jsp").forward(req, resp);
			}else{
				req.setAttribute("msg", "<h2 class='success'>Cuntomer is not updated</h2>");
				req.getRequestDispatcher("updatecustomer.jsp").forward(req, resp);
			}
			
		}else if(action!=null && action.equalsIgnoreCase("EmailVerification")) {
			custEmailId = req.getParameter("custEmailId");
			customer = customerDao.getCustomerByEmailId(custEmailId);
//			System.out.println(customer);
			if(customer != null) {
				resp.getWriter().print("<br><span class='error'>Email already Exist</span>");
			}else {
				resp.getWriter().print("<br><span class='success'>Valid Email</span>");
			}
				
			
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		action = req.getParameter("action");
		session = req.getSession();
		
		if(action!=null && action.equalsIgnoreCase("delete")) {
			
			custId = Integer.parseInt(req.getParameter("custId"));
			flag = customerDao.deleteCustomer(custId);
			if(flag) {
				req.setAttribute("msg", "<h2 class='success'>Cuntomer is deleted</h2>");
				customerlist = customerDao.showAllCustomer();
				session.setAttribute("customerlist", customerlist);
			}else {
				req.setAttribute("msg", "<h2 class='error'>Cuntomer is not deleted</h2>");
			}
			req.getRequestDispatcher("customerlist.jsp").forward(req, resp);
		}
		else if(action!=null && action.equalsIgnoreCase("edit")) {
			custId = Integer.parseInt(req.getParameter("custId"));
			customer = customerDao.getCustomerById(custId);
			if(customer!=null) {
				req.setAttribute("customerObj", customer);
				req.getRequestDispatcher("updatecustomer.jsp").forward(req, resp);
				
			}else {
				req.setAttribute("msg", "<h2 class='error'>Cuntomer not found</h2>");
				req.getRequestDispatcher("customerlist.jsp").forward(req, resp);
			}
			
		}else {
			
			customerlist =customerDao.showAllCustomer();
			session.setAttribute("customerlist", customerlist); // Multiple Request can access it.
			//to access next resource we can take a new request bcoz we dont want to carry any data from previous request
			resp.sendRedirect("customerlist.jsp");
		}
		
	}
	
}
