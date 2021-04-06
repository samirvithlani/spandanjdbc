package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private final static String username = "root";
	private final static String password = "root";
	private final static String url = "jdbc:mysql://localhost:3306/spandan";
	private final static String driverClass = "com.mysql.jdbc.Driver";

	public static Connection getConnection() {

		Connection conn = null;

		// 1st step
		try {
			//driver class will be loaded in class memory
			Class.forName(driverClass);
			//2nd step
			
			conn = DriverManager.getConnection(url, username, password);
			if(conn!=null) {
				
				
				System.out.println("connected to database...");
			}
			else {
				
				System.out.println("not connected to database..");
			}
			
			
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}

	public static void main(String[] args) {

		
		DBConnection.getConnection();
	}
}
