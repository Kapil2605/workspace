package com.JDBC.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kapil.DBConnection;

public class FundTransfer {
	public void doFundTransfer(int from, int to, int amount) {

		Connection con = null;
		
		try {
			con = DBConnection.getConnection();
			con.setAutoCommit(false);
			String query = "Update user set balance=? where id=?";

			
			
			// debit functionality
			
			//Firstly i have to run select query to fetch the current balance
			String selectQuery="Select balance from user where id=?";
			
			PreparedStatement ps = con.prepareStatement(selectQuery);
			ps.setInt(1, from);
			
			ResultSet rs=ps.executeQuery();
			
			int fromDebitAccountBalance=0;
			while(rs.next()) {
				fromDebitAccountBalance=rs.getInt(1);
			}
			
			int debitbalance=fromDebitAccountBalance-amount;
			
			//now debit amount from account
			
			ps = con.prepareStatement(query);

			ps.setInt(1, debitbalance);
			ps.setInt(2, from);

			int result = ps.executeUpdate();

			if (result > 0) {
				System.out.println("Debit Account Initial balance: "+fromDebitAccountBalance+" | Debit amount: " + amount + " from id: " + from+" | Balance after deduction: "+debitbalance);
			}

			
			/*
			 * String st=null; st.length();
			 */
			
			
			// credit functionality
			
			//Firstly i have to run select query to fetch the current balance from credit account
			ps=con.prepareStatement(selectQuery);
			ps.setInt(1, to);
			
			rs=ps.executeQuery();
			
			int fromCreditAccountBalance=0;
			while(rs.next()) {
				fromCreditAccountBalance=rs.getInt(1);
			}
			
			int creditbalance=amount+fromCreditAccountBalance;
			
			
			ps = con.prepareStatement(query);

			ps.setInt(1, creditbalance);
			ps.setInt(2, to);

			result = ps.executeUpdate();

			if (result > 0) {
				System.out.println("Credit Account Initial balance: "+fromCreditAccountBalance+" | Credit amount: " + amount + " to id: " + to+" | Balance after deduction: "+creditbalance);
			}
			
			con.commit();

		} catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}
}
