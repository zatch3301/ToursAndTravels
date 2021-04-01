package com.zatch.toursandtravels.dao;

import java.util.List;

import com.zatch.toursandtravels.pojo.Customer;
// Data access Object.
public interface CustomerDao 
{
	boolean registerCustomer(Customer cust);
	boolean updateCustomer(Customer cust);
	boolean deleteCustomer(int custId);
	List<Customer> showAllCustomer();
	Customer getCustomerById(int custId);
	Customer getCustomerByEmailId(String custEmailId);

	List<Customer> sortCustomerById();
	List<Customer> sortCustomerByName();
	
	
	
}
