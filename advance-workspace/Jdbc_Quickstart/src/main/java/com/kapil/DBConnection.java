package com.kapil;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private static final String URL = "jdbc:mysql://localhost:3306/27th_oct_batch";
	private static final String USER = "root";
	private static final String PASSWORD = "fighter";

	public static Connection getConnection() {

		Connection con = null;

		try {
			// Step1 load mysql Type4 Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step2 Establish connection
			con = DriverManager.getConnection(URL, USER, PASSWORD);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
