package javapackage;

import java.sql.Connection;
import java.sql.DriverManager;

public class project1 {

	public static void main(String[] args) throws Exception{
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		System.out.println("Driver loaded Successfully");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost.3306/user","root","root");
				System.out.println("Connection Established successfully");
		

	}

}
