package com.kapil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertQuery {

	public static void main(String[] args) {

		try {
			String query = "INSERT INTO student(id,name,phoneNo) values (?,?,?);";
			// Step2 Establish Connection
			Connection con = DBConnection.getConnection();

			// Step3 Create a statement
			PreparedStatement st = con.prepareStatement(query);
			
			int batchSize=50;
			for(int i=1;i<1000;i++) {
				st.setInt(1,1+i);
				st.setString(2, "Kapil"+i);
				st.setString(3, "93067"+i);
				
				st.addBatch();
				System.out.println("adding to batch");
				
				if(i%batchSize==0) {
					System.out.println("Executing the batch of "+i);
					st.executeBatch();
				}
			}
			System.out.println("Executing remaining batch");
			st.executeBatch();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
