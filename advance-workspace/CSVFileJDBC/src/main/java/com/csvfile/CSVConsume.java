package com.csvfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CSVConsume {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/27th_oct_batch";
		String username = "root";
		String password = "fighter";

		 String filePath="C:\\Users\\kapil\\OneDrive\\Customers.csv";

		int batchSize = 20;

		Connection connection = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection(jdbcUrl, username,
					password);

			String sql = "insert into customer_info(Customer_ID,First_Name,Last_Name,Email,Phone,City,State,Country,Signup_Date,Status) "
					+ "values(?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement statement = connection.prepareStatement(sql);

			BufferedReader lineReader = new BufferedReader(
					new FileReader(filePath));

			String lineText = null;

			int count = 0;

			lineReader.readLine(); // skip the header of csv
			
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

			while ((lineText = lineReader.readLine()) != null) {
				String[] data = lineText.split(",");

				String Customer_ID = data[0];
				String First_Name = data[1];
				String Last_Name = data[2];
				String Email = data[3];
				String Phone = data[4];
				String City = data[5];
				String State = data[6];
				String Country = data[7];
				String Signup_Date = data[8];
				String Status = data[9];
				
				LocalDate date = LocalDate.parse(Signup_Date, formatter);

				statement.setInt(1, Integer.parseInt(Customer_ID));
				statement.setString(2, First_Name);
				statement.setString(3, Last_Name);
				statement.setString(4, Email);
				statement.setString(5, Phone);
				statement.setString(6, City);
				statement.setString(7, State);
				statement.setString(8, Country);
				statement.setDate(9, Date.valueOf(date));
				statement.setString(10, Status);

				statement.addBatch();
				System.out.println("adding to batch");
				count++;

				if (count % batchSize == 0) {
					System.out.println("Executing the batch of " + count);
					statement.executeBatch();
				}
			}
			System.out.println("Executing remaining batch");
			statement.executeBatch();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
