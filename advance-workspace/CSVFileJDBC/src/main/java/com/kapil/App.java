package com.kapil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class App {

    public static void main(String args[]) {

        String filePath = "C:\\Users\\kapil\\OneDrive\\Customers.csv";

        int batchSize = 20;

        try {
            long starttime=System.currentTimeMillis();

            
            Connection connection = DBConnection.getConnection();
            connection.setAutoCommit(false);

            String cleanSQL = "INSERT INTO customer_info VALUES (?,?,?,?,?,?,?,?,?,?)";
            String invalidSQL = "INSERT INTO customer_info_invalid VALUES (?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement cleanStatement = connection.prepareStatement(cleanSQL);
            PreparedStatement invalidStatement = connection.prepareStatement(invalidSQL);

            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            String line;
            int count = 0;

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

            reader.readLine(); // skip header

            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()) continue;

                String[] data = line.split(",");

                if (data.length < 10) {

                    for (int i = 0; i < 10; i++) {

                        if (i < data.length)
                            invalidStatement.setString(i + 1, data[i]);
                        else
                            invalidStatement.setString(i + 1, null);
                    }

                    invalidStatement.setString(11, "Column count less than 10");
                    invalidStatement.addBatch();
                    continue;
                }

                String validation = CustomerValidator.validate(data);

                if (validation.equals("VALID")) {

                    LocalDate date = LocalDate.parse(data[8], formatter);

                    cleanStatement.setInt(1, Integer.parseInt(data[0]));
                    cleanStatement.setString(2, data[1]);
                    cleanStatement.setString(3, data[2]);
                    cleanStatement.setString(4, data[3]);
                    cleanStatement.setString(5, data[4]);
                    cleanStatement.setString(6, data[5]);
                    cleanStatement.setString(7, data[6]);
                    cleanStatement.setString(8, data[7]);
                    cleanStatement.setDate(9, Date.valueOf(date));
                    cleanStatement.setString(10, data[9]);

                    cleanStatement.addBatch();

                } else {

                    for (int i = 0; i < 10; i++) {
                        invalidStatement.setString(i + 1, data[i]);
                    }

                    invalidStatement.setString(11, validation);

                    invalidStatement.addBatch();
                }

                count++;

                if (count % batchSize == 0) {

                    cleanStatement.executeBatch();
                    invalidStatement.executeBatch();

                    System.out.println("Batch executed : " + count);
                }
            }

            cleanStatement.executeBatch();
            invalidStatement.executeBatch();

            connection.commit();

            reader.close();

            System.out.println("CSV Data Import Completed");
            
            long Finishtime=System.currentTimeMillis();
            
            long difference=Finishtime-starttime;
            System.out.println("Total time: "+difference);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}