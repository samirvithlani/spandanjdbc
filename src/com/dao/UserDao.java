package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.util.DBConnection;

public class UserDao {

	// instance

	public void addUser() {

		Connection conn = DBConnection.getConnection();
		Scanner sc = new Scanner(System.in);

		System.out.println("enter username");

		String uName = sc.next();
		System.out.println("enter user age");
		int uAge = sc.nextInt();

		if (conn != null) {

			try {
				Statement stmt = conn.createStatement();

				String insertSQL = "insert into user(uname,uage)values('" + uName + "'," + uAge + ")";
				// submit db
				int res = stmt.executeUpdate(insertSQL);

				if (res > 0) {

					System.out.println("record inserted..");
				} else {

					System.out.println("no record inserted..");

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void deleteUser() {

		Connection conn = DBConnection.getConnection();
		Scanner sc = new Scanner(System.in);

		System.out.println("enter username to delete");

		String uName = sc.next();

		if (conn != null) {

			try {
				Statement stmt = conn.createStatement();

				String deleteSQL = "delete from user where uname = '" + uName + "'";
				// String deleteSQL = "delete from user where uid = " + uId + "";
				// String deleteSQL = "delete from user where uage = '" + uAge + "'";

				// submit db
				int res = stmt.executeUpdate(deleteSQL);

				if (res > 0) {

					System.out.println("record deleted..");
				} else {

					System.out.println("no record deleted..");

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void updateUser() {

		Connection conn = DBConnection.getConnection();
		Scanner sc = new Scanner(System.in);

		System.out.println("enter username");
		String uName = sc.next();
		System.out.println("enter user age");
		int uAge = sc.nextInt();
		System.out.println("enter id to update");
		int uId = sc.nextInt();

		if (conn != null) {

			try {
				Statement stmt = conn.createStatement();

				String insertSQL = "update user set uName ='" + uName + "',uage = " + uAge + " where uid = " + uId + "";
				// submit db
				int res = stmt.executeUpdate(insertSQL);

				if (res > 0) {

					System.out.println("record updated..");
				} else {

					System.out.println("no record updated..");

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void fetchUsers() {

		Connection conn = DBConnection.getConnection();

		if (conn != null) {

			try {
				Statement stmt = conn.createStatement();

				String selectSQL = "select * from user";

				ResultSet rs = stmt.executeQuery(selectSQL);

				// next -->boolean
				while (rs.next()) {

					System.out.println();
					System.out.print(" "+rs.getInt("uid"));
					System.out.print(" "+rs.getString("uname"));
					System.out.print(" "+rs.getInt("uage"));
					

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public static void main(String[] args) {

		UserDao userDao = new UserDao();
//		 userDao.addUser();
		// userDao.deleteUser();
		//userDao.updateUser();
		userDao.fetchUsers();

	}
}
