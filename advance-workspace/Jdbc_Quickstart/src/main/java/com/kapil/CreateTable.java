package com.kapil;

import java.sql.Connection;
import java.sql.Statement;


public class CreateTable {

	public static void main(String[] args) {
		String query =
		        "CREATE TABLE IF NOT EXISTS student (id int primary key auto_increment,name varchar(20) not null,phoneNo varchar(10))";

		        try {
		        	//Step2 Establish Connection
		            Connection con = DBConnection.getConnection();
		            
		            //Step3 Create a statement
		            Statement st = con.createStatement();

		            //Step4 Execute the query
		            st.executeUpdate(query);

		            System.out.println("Table created successfully");

		            st.close();
		            con.close();

		        } catch (Exception e) {
		            e.printStackTrace();
		        }
	}

}
