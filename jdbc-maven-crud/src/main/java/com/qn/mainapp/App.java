package com.qn.mainapp;

import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main( String[] args ) throws SQLException
    {
       DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
       System.out.println("Connected");
       
    }
}
