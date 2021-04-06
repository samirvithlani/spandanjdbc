package com.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.util.DBConnection;

public class StudentDao {

	public void addStudent() {

		// connection
		Connection conn = DBConnection.getConnection();
		if (conn != null) {

			try {
				Statement stmt = conn.createStatement();
				String insertSQL = "insert into student(sname,sage)values('spandan',32)";
				int res = stmt.executeUpdate(insertSQL);
				if (res > 0) {

					System.out.println("recored inserted");
				} else {

					System.out.println("record not inserted..");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void delteData() {

		// connection
		Connection conn = DBConnection.getConnection();
		if (conn != null) {
			Scanner sc = new Scanner(System.in);
			// statement
			try {
				Statement stmt = conn.createStatement();
				System.out.println("eneter student name to delete");
				String sname = sc.next();
				String deleteSQL = "delete from student where sname ='" + sname + "'";
				int res = stmt.executeUpdate(deleteSQL);
				if (res > 0) {
					System.out.println("raws deleted");
				} else {

					System.out.println("raws not deleted..");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void updateStudent() throws SQLException {

		// connection
		Connection conn = DBConnection.getConnection();
		Scanner sc = new Scanner(System.in);

		if (conn != null) {

			Statement stmt = conn.createStatement();
			System.out.println("enter student name to update");
			String sname = sc.next();
			System.out.println("enter student age to update");
			int sage = sc.nextInt();
			System.out.println("enter student id");
			int sid = sc.nextInt();
			
			String updateSQL = "update student set sname = '" + sname + "',sage =" + sage + " where sid = " + sid + "";
			
			int res = stmt.executeUpdate(updateSQL);
			if(res>0) {
				System.out.println("reord updated..");
			}
			else {
				
				System.out.println("record not updated..");
			}
			
					
		}

	}

	public static void main(String[] args) throws SQLException {

		StudentDao studentDao = new StudentDao();
		//studentDao.addStudent();
		// studentDao.delteData();
		studentDao.updateStudent();
		
		
	}
}
