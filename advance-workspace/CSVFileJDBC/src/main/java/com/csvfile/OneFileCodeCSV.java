package com.csvfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OneFileCodeCSV {

    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/27th_oct_batch";
        String username = "root";
        String password = "fighter";

        String filePath = "C:\\Users\\kapil\\OneDrive\\Customers.csv";

        int batchSize = 20;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            connection.setAutoCommit(false);

            // SQL queries
            String cleanSQL = "INSERT INTO customer_info VALUES (?,?,?,?,?,?,?,?,?,?)";
            String invalidSQL = "INSERT INTO customer_info_invalid VALUES (?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement cleanStatement = connection.prepareStatement(cleanSQL);
            PreparedStatement invalidStatement = connection.prepareStatement(invalidSQL);

            BufferedReader lineReader = new BufferedReader(new FileReader(filePath));

            String lineText;
            int count = 0;

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

            lineReader.readLine(); // skip header

            while ((lineText = lineReader.readLine()) != null) {

                if (lineText.trim().isEmpty()) {
                    continue;
                }

                String[] data = lineText.split(",");

                // Handle rows with less than 10 columns
                if (data.length < 10) {

                    for (int i = 0; i < 10; i++) {
                        if (i < data.length) {
                            invalidStatement.setString(i + 1, data[i]);
                        } else {
                            invalidStatement.setString(i + 1, null);
                        }
                    }

                    invalidStatement.setString(11, "Column count less than 10");
                    invalidStatement.addBatch();

                    count++;

                    if (count % batchSize == 0) {
                        cleanStatement.executeBatch();
                        invalidStatement.executeBatch();
                        System.out.println("Batch executed: " + count);
                    }

                    continue;
                }

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

                boolean valid = true;
                String errorMessage = "";

                // Customer ID validation
                if (Customer_ID == null || Customer_ID.trim().isEmpty() || !Customer_ID.matches("\\d+")) {
                    valid = false;
                    errorMessage = "Invalid Customer ID";
                }

                // Name validation
                else if (First_Name == null || First_Name.trim().isEmpty()
                        || Last_Name == null || Last_Name.trim().isEmpty()
                        || !First_Name.matches("[a-zA-Z]+")
                        || !Last_Name.matches("[a-zA-Z]+")) {

                    valid = false;
                    errorMessage = "Invalid Name";
                }

                // Email validation
                else if (Email == null || Email.trim().isEmpty()
                        || !Email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {

                    valid = false;
                    errorMessage = "Invalid Email";
                }

                // Phone validation
                else if (Phone == null || Phone.trim().isEmpty()|| Phone.startsWith("91-") ||Phone.length()<10)  {
                    valid = false;
                    errorMessage = "Invalid Phone number";
                }

                // Address validation
                else if (City == null || City.trim().isEmpty()
                        || State == null || State.trim().isEmpty()
                        || Country == null || Country.trim().isEmpty()) {

                    valid = false;
                    errorMessage = "Address empty";
                }

                // Status validation
                else if (Status == null || Status.trim().isEmpty()) {
                    valid = false;
                    errorMessage = "Status empty";
                }

                if (valid) {

                    LocalDate date = LocalDate.parse(Signup_Date, formatter);

                    cleanStatement.setInt(1, Integer.parseInt(Customer_ID));
                    cleanStatement.setString(2, First_Name);
                    cleanStatement.setString(3, Last_Name);
                    cleanStatement.setString(4, Email);
                    cleanStatement.setString(5, Phone);
                    cleanStatement.setString(6, City);
                    cleanStatement.setString(7, State);
                    cleanStatement.setString(8, Country);
                    cleanStatement.setDate(9, Date.valueOf(date));
                    cleanStatement.setString(10, Status);

                    cleanStatement.addBatch();
                    
                    System.out.println("adding to valid data batch");


                } else {

                    invalidStatement.setString(1, Customer_ID);
                    invalidStatement.setString(2, First_Name);
                    invalidStatement.setString(3, Last_Name);
                    invalidStatement.setString(4, Email);
                    invalidStatement.setString(5, Phone);
                    invalidStatement.setString(6, City);
                    invalidStatement.setString(7, State);
                    invalidStatement.setString(8, Country);
                    invalidStatement.setString(9, Signup_Date);
                    invalidStatement.setString(10, Status);
                    invalidStatement.setString(11, errorMessage);

                    invalidStatement.addBatch();
                    System.out.println("adding to invalid data batch");
                }

                count++;

                if (count % batchSize == 0) {
                	
                    cleanStatement.executeBatch();
                    invalidStatement.executeBatch();
					System.out.println("Executing the batch of " + count);
                }
            }

            cleanStatement.executeBatch();
            invalidStatement.executeBatch();
			System.out.println("Executing remaining batch");

            connection.commit();

            lineReader.close();

            System.out.println("CSV Data Import Completed!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}