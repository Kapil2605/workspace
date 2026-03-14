package com.kapil;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() throws Exception {

        String jdbcUrl = "jdbc:mysql://localhost:3306/27th_oct_batch";
        String username = "root";
        String password = "fighter";

        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(jdbcUrl, username, password);
    }
}