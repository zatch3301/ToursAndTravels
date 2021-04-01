package com.zatch.toursandtravels.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zatch.toursandtravels.dao.LoginDao;
import com.zatch.toursandtravels.utility.DBConnection;

public class LoginDaoImpl implements LoginDao {
	Connection con = DBConnection.getCon();
	PreparedStatement ps = null;
	ResultSet rs = null;
	String sqlQuery;

	@Override
	public boolean isAdmin(String emailId, String password) {
		sqlQuery ="select * from admin_zatch where adminEmailId=? and adminPassword=?";
		
		try {
			ps = con.prepareStatement(sqlQuery);
			ps.setString(1, emailId);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			if(rs.next()){
				return true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean isCustomer(String emailId, String password) {
		sqlQuery ="select * from customer_zatch where custEmailId=? and custPassword=?";
		
		try {
			ps = con.prepareStatement(sqlQuery);
			ps.setString(1, emailId);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			if(rs.next()){
				return true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean forgetPassword(String emailId, String MobileNo, String newPassword) {
		sqlQuery ="UPDATE customer_zatch set custPassword=? where custEmailId=? and custMobileNo=?";
		try {
			ps = con.prepareStatement(sqlQuery);
			ps.setString(1, newPassword);
			ps.setString(2, emailId);
			ps.setString(3, MobileNo);
			
			int i = ps.executeUpdate();
			if(i>0) {
				return true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean changePassword(String emailId, String oldPassword, String newPassword) {
		sqlQuery ="UPDATE admin_zatch set adminPassword=? where adminEmailId=? and adminPassword=?";
		try {
			ps = con.prepareStatement(sqlQuery);
			ps.setString(1, newPassword);
			ps.setString(2, emailId);
			ps.setString(3, oldPassword);
			
			int i = ps.executeUpdate();
			if(i>0) {
				return true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
