package com.zatch.toursandtravels.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static String url = "jdbc:mysql://localhost:3306/toursandtravels";
	private static String user = "root";
	private static String password = "3301";
	private static Connection con = null;

	// Don't allow to create object.
	private DBConnection() {
	}

	static {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public static Connection getCon() {

		return con;
	}
	
	public static void CloseConnection()
	{
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
