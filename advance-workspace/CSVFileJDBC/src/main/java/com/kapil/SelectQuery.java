package com.kapil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectQuery {

    public static void main(String[] args) {

        String validQuery = "SELECT * FROM customer_info";
        String invalidQuery = "SELECT * FROM customer_info_invalid";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement validStmt = con.prepareStatement(validQuery);
            PreparedStatement invalidStmt = con.prepareStatement(invalidQuery);

            ResultSet rs1 = validStmt.executeQuery();
            ResultSet rs2 = invalidStmt.executeQuery();

            // ================= VALID TABLE =================
            System.out.println("\n========== VALID CUSTOMER DATA ==========\n");

            System.out.printf("%-5s %-10s %-10s %-30s %-12s %-12s %-12s %-10s %-12s %-10s\n",
                    "ID","FirstName","LastName","Email","Phone","City","State","Country","SignupDate","Status");

            System.out.println("--------------------------------------------------------------------------------------------------------------------");

            while (rs1.next()) {

                System.out.printf("%-5d %-10s %-10s %-30s %-12s %-12s %-12s %-10s %-12s %-10s\n",
                        rs1.getInt("Customer_ID"),
                        rs1.getString("First_Name"),
                        rs1.getString("Last_Name"),
                        rs1.getString("Email"),
                        rs1.getString("Phone"),
                        rs1.getString("City"),
                        rs1.getString("State"),
                        rs1.getString("Country"),
                        rs1.getDate("Signup_Date"),
                        rs1.getString("Status"));
            }

            // ================= INVALID TABLE =================
            System.out.println("\n========== INVALID CUSTOMER DATA ==========\n");

            System.out.printf("%-12s %-10s %-10s %-30s %-12s %-12s %-12s %-10s %-12s %-10s %-20s\n",
                    "CustomerID","FirstName","LastName","Email","Phone","City","State","Country","SignupDate","Status","Error");

            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");

            while (rs2.next()) {

                System.out.printf("%-12s %-10s %-10s %-30s %-12s %-12s %-12s %-10s %-12s %-10s %-20s\n",
                        rs2.getString("Customer_ID"),
                        rs2.getString("First_Name"),
                        rs2.getString("Last_Name"),
                        rs2.getString("Email"),
                        rs2.getString("Phone"),
                        rs2.getString("City"),
                        rs2.getString("State"),
                        rs2.getString("Country"),
                        rs2.getString("Signup_Date"),
                        rs2.getString("Status"),
                        rs2.getString("Error_Message"));
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}