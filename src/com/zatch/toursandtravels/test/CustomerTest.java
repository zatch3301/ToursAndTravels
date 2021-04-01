package com.zatch.toursandtravels.test;

import java.util.List;
import java.util.Scanner;

import com.zatch.toursandtravels.dao.CustomerDao;
import com.zatch.toursandtravels.dao.impl.CustomerDaoImpl;
import com.zatch.toursandtravels.pojo.Customer;
import com.zatch.toursandtravels.utility.DBConnection;

public class CustomerTest {


	public static void main(String[] args) 
	{
		Scanner sc;
		int custId,choice=0;
		String custName,custEmailId,custMobileNo,custPassword,custAddress;
		
		boolean flag=false;
		
		Customer cust = null;
		CustomerDao custDao = new CustomerDaoImpl();
		List<Customer> custlist = null;
		
		do {
		sc = new Scanner(System.in);
		System.out.println("----------------- Customer Testing ------------------");
		System.out.println("___1.Registration ");
		System.out.println("___2.Show All Customer ");
		System.out.println("___3.Update Customer ");
		System.out.println("___4.Delete Customer ");
		System.out.println("___5.Show Customer by Id ");
		System.out.println("___6.show Customer by Name");
		System.out.println("___7.Sort Customer By CustId");
		System.out.println("___8.Sort Customer By CustName");
		System.out.println("___9.Exit");
		try {
		System.out.println("Select You choice ");
		choice = sc.nextInt();
		switch(choice)
		{
			case 1: 
				System.out.println("Enter Customer Registration Details");
				System.out.println("Name:- ");
				custName = sc.next();
				System.out.println("Email Id:- ");
				custEmailId = sc.next();
				System.out.println("Mobile No:- ");
				custMobileNo = sc.next();
				System.out.println("Passwrod :- ");
				custPassword = sc.next();
				System.out.println("Address :- ");
				custAddress = sc.next();
				
				
				cust = new Customer(custName, custEmailId, custMobileNo, custPassword, custAddress);
				
				flag = custDao.registerCustomer(cust);
				
				if(flag)
					System.out.println("Registration Successfull");
				else
					System.out.println("Registration Unsuccessfull.");
				break;
			case 2:
					custlist = custDao.showAllCustomer();
					
					if(custlist!=null && !custlist.isEmpty())
					{
						System.out.println("---***----   Customer List ---***---");
						custlist.forEach(System.out::println);
						System.out.println("-------------------------------------");
						System.out.println();
					}
				
				break;
			case 3:
				System.out.println("Enter Customer Id which you want update");
				custId=sc.nextInt();
				
				cust = custDao.getCustomerById(custId);
				// this to check that customer is available or not
				
				if(cust!=null)
				{
					System.out.println("------------**Old Details ***------------");
					System.out.println(cust);
					System.out.println("------------------------------------------");
	
					System.out.println("Updated details of Customer custId is "+custId);
					System.out.println("Name:- ");
					custName = sc.next();
					System.out.println("Email Id:- ");
					custEmailId = sc.next();
					System.out.println("Mobile No:- ");
					custMobileNo = sc.next();
					System.out.println("Passwrod :- ");
					custPassword = sc.next();
					System.out.println("Address :- ");
					custAddress = sc.next();
					
					cust = new Customer(custId, custName, custEmailId, custMobileNo, custPassword, custAddress);
					
					flag = custDao.updateCustomer(cust);
					
					if(flag)
						System.out.println("Customer is Updated ");
					else
						System.out.println("Customer is Not Updated. ");
				}else
				{
					System.out.println("Customer Not Found.....");
				}
				
				
				break;
			case 4:
				System.out.println("Enter Customer Id ");
				custId= sc.nextInt();
				
				flag = custDao.deleteCustomer(custId);
				if (flag)
					System.out.println("Customer is Deleted ");
				else
					System.out.println("Customer is Not Deleted");
			break;
			case 5:
				System.out.println("Enter Customer Id to show the deatails");
				custId=sc.nextInt();
				
				cust = custDao.getCustomerById(custId);
				
				if(cust!=null && cust.getCustId()!=0)
				{
					System.out.println("Customer is Found ");
					System.out.println(cust);
				}else
				{
					System.out.println("Customer is Not Found");
				}
				break;
			case 6:
				System.out.println("Enter the Cust EmaiId");
				custEmailId = sc.next();
				cust = custDao.getCustomerByEmailId(custEmailId);
				if(cust!=null && cust.getCustId()!=0)
				{
					System.out.println("Customer is Found ");
					System.out.println(cust);
					System.out.println("___________________________");
				}else
				{
					System.out.println("Customer is Not Found");
				}
				break;
			case 7:
				System.out.println("Sorted Customer list by custId ");
				custlist = custDao.sortCustomerById();
				if(custlist!=null && !custlist.isEmpty())
				{
					for (Customer customer : custlist) {
						System.out.println(customer);
					}
				}
				break;
			case 8:
				System.out.println("Sorted Customer list by custName ");
				custlist = custDao.sortCustomerByName();
				if(custlist!=null && !custlist.isEmpty())
				{
					for (Customer customer : custlist) {
						System.out.println(customer);
					}
				}
				
		}// switch ends
		}// try
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		}while(choice!=9);
		sc.close();
		DBConnection.CloseConnection();	// last line in main /method of test class
		System.out.println("Program is End Successfully.");
	}

}
