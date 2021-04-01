package com.zatch.toursandtravels.dao;

public interface LoginDao {
	
	boolean isAdmin(String emailId, String password);
	boolean isCustomer(String emailId, String password);

	boolean forgetPassword(String emailId, String MobileNo, String newPassword);
	boolean changePassword(String emailId, String oldPassword, String newPassword);
	
} 
