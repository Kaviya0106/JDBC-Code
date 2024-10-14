package java;

//Program for accessing an individual student detail
//we use prepared statement for placeholders
//to get the value or to insert the value then we need to use pstmt that is prepared statement
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
public class Demo1{
public static void main(String args[]) throws Exception{
	DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
	System.out.println("Driver loaded Successfully");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost.3306/employee","root","root");
			System.out.println("Connection Established");
	String s="Select* from Student when id=?";
	PreparedStatement pstmt=con.prepareStatement(s);
	System.out.println("enter the id");
	Scanner sc=new Scanner(System.in);
	int id= sc.nextInt();
	ResultSet res= pstmt.executeQuery();
	if(res.next()) {
		id=res.getInt(1);
		String name=res.getString(2);
		int marks1=res.getInt(3);
		int marks2=res.getInt(4);
		int marks3=res.getInt(5);
		System.out.println(id+" "+name+" "+marks1+" "+marks2+" "+marks3);
}
	else {
		System.out.println("Invalid Id");
	}
}
}

