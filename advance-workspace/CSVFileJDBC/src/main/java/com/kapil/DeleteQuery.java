package com.kapil;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteQuery {

	public static void main(String[] args) {
		
		String cleanSQL="Delete from customer_info";
		String invalidSQL="Delete from customer_info_invalid";
		
		
		try {
			Connection con=DBConnection.getConnection();
			
			PreparedStatement cleanStatement = con.prepareStatement(cleanSQL);
            PreparedStatement invalidStatement = con.prepareStatement(invalidSQL);
            
            int cleanData=cleanStatement.executeUpdate();
            int invalidData=invalidStatement.executeUpdate();
            
            System.out.println("Delete all rows from customer_info:"+cleanData);
            System.out.println("Delete all rows from customer_info_invalid:"+invalidData);
            
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
