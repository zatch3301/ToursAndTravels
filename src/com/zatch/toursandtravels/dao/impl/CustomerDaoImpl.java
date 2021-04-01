package com.zatch.toursandtravels.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.zatch.toursandtravels.dao.CustomerDao;
import com.zatch.toursandtravels.pojo.Customer;
import com.zatch.toursandtravels.utility.DBConnection;
import com.zatch.toursandtravels.utility.SortCustomerByName;

public class CustomerDaoImpl implements CustomerDao {
	Connection con = DBConnection.getCon();
	PreparedStatement ps = null;
	ResultSet rs = null;

	String sqlQuery;

	@Override
	public boolean registerCustomer(Customer cust) {
		sqlQuery = "insert into Customer_zatch (custName,custEmailId,custMobileNo,custPassword,custAddress) values (?,?,?,?,?)";

		try {
			ps = con.prepareStatement(sqlQuery);

			ps.setString(1, cust.getCustName());
			ps.setString(2, cust.getCustEmailId());
			ps.setString(3, cust.getCustMobileNo());
			ps.setString(4, cust.getCustPassword());
			ps.setString(5, cust.getCustAddress());

			int i = ps.executeUpdate();

			if (i > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateCustomer(Customer cust) {
		sqlQuery = "update customer_zatch set custName=?, custEmailId=?,custMobileNo=?,custPassword=?,custAddress=? where custId=?";

		try {
			ps = con.prepareStatement(sqlQuery);

			ps.setString(1, cust.getCustName());
			ps.setString(2, cust.getCustEmailId());
			ps.setString(3, cust.getCustMobileNo());
			ps.setString(4, cust.getCustPassword());
			ps.setString(5, cust.getCustAddress());
			ps.setInt(6, cust.getCustId());

			int i = ps.executeUpdate();

			if (i > 0)
				return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteCustomer(int custId) {
		sqlQuery = "delete from customer_zatch where custId=?";

		try {
			ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, custId);

			int i = ps.executeUpdate();

			if (i > 0)
				return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Customer> showAllCustomer() {
		List<Customer> custlist = new ArrayList<>();
		sqlQuery = "select * from customer_zatch";

		try {
			ps = con.prepareStatement(sqlQuery);

			rs = ps.executeQuery();

			while (rs.next()) {
				Customer cust = new Customer();
				cust.setCustId(rs.getInt(1));
				cust.setCustName(rs.getString(2));
				cust.setCustEmailId(rs.getString(3));
				cust.setCustMobileNo(rs.getString(4));
				cust.setCustPassword(rs.getString(5));
				cust.setCustAddress(rs.getString(6));
				custlist.add(cust);
			}

			return custlist;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Customer getCustomerById(int custId) {

		sqlQuery = "select * from customer_zatch where custId=?";

		try {
			ps = con.prepareStatement(sqlQuery);

			ps.setInt(1, custId);

			rs = ps.executeQuery();

			if (rs.next()) {
				Customer cust = new Customer();
				cust.setCustId(rs.getInt(1));
				cust.setCustName(rs.getString(2));
				cust.setCustEmailId(rs.getString(3));
				cust.setCustMobileNo(rs.getString(4));
				cust.setCustPassword(rs.getString(5));
				cust.setCustAddress(rs.getString(6));
				return cust;
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		finally
		{
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Customer getCustomerByEmailId(String custEmailId) {

		sqlQuery = "select * from customer_zatch where custEmailId=?";

		try {
			ps = con.prepareStatement(sqlQuery);

			ps.setString(1, custEmailId);

			rs = ps.executeQuery();

			while(rs.next()) {
				Customer cust = new Customer();
				cust.setCustId(rs.getInt(1));
				cust.setCustName(rs.getString(2));
				cust.setCustEmailId(rs.getString(3));
				cust.setCustMobileNo(rs.getString(4));
				cust.setCustPassword(rs.getString(5));
				cust.setCustAddress(rs.getString(6));
				return cust;
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		finally
		{
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	@Override
	public List<Customer> sortCustomerById() {
		List<Customer> list = showAllCustomer();
		Collections.sort(list);
		return list;
	}
	
	@Override
	public List<Customer> sortCustomerByName() {
		List<Customer> list = showAllCustomer();
		SortCustomerByName byName = new SortCustomerByName();
		Collections.sort(list,byName);
		return list;
	}

}
