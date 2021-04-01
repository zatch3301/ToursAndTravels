package com.zatch.toursandtravels.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zatch.toursandtravels.dao.LoginDao;
import com.zatch.toursandtravels.dao.impl.CustomerDaoImpl;
import com.zatch.toursandtravels.dao.impl.LoginDaoImpl;
import com.zatch.toursandtravels.pojo.Customer;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
		
		String action,emailId,password,userType;
		LoginDao loginDao = new LoginDaoImpl();
		boolean flag = false;
		HttpSession session =null;
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			session = req.getSession();
			action = req.getParameter("action");
			
			if(action != null && action.equalsIgnoreCase("login")) {
				
				emailId = req.getParameter("emailId");
				password = req.getParameter("password");
				userType = req.getParameter("userType");
				
				if(userType!=null && userType.equalsIgnoreCase("admin")) {
					flag = loginDao.isAdmin(emailId, password);
					if(flag) {
						req.setAttribute("msg", "Admin Login Success...");
						session.setAttribute("adminEamil", emailId);
						req.getRequestDispatcher("index.jsp").forward(req, resp);
					}else {
						req.setAttribute("msg", "Admin Login Unsuccess...");
						req.getRequestDispatcher("login.jsp").forward(req, resp);
					}
					
				}else if(userType!=null && userType.equalsIgnoreCase("customer")) {
					flag = loginDao.isCustomer(emailId, password);
					if(flag) {
						req.setAttribute("msg", "Customer Login Success...");
						session.setAttribute("customerEmail", emailId);
						Customer customerObj = new CustomerDaoImpl().getCustomerByEmailId(emailId);
						session.setAttribute("user", customerObj);
						req.getRequestDispatcher("index.jsp").forward(req, resp);
					}else {
						req.setAttribute("msg", "Customer Login Unsuccess...");
						req.getRequestDispatcher("login.jsp").forward(req, resp);
					}
				}
			}
			
		}
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			session = req.getSession();
			action = req.getParameter("action");
			
			if(action != null && action.equalsIgnoreCase("logout")) {
				session.invalidate();
				req.setAttribute("msg", "<span class='success'> Logout success....</span>");
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			}
		}
}
