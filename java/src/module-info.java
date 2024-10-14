//Program for accessing an individual student detail
//we use prepared statement for placeholders
//to get the value or to insert the value then we need to use pstmt that is prepared statement
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.Scanner;
public static void main(String args[]) throws Exception{
	DriverManager.registerDriver(new com.mysql.cj.jdbc.driver());
	System.out.println("Driver loaded Successfully");
	Connection con=DriverManager.getconnection("jdbc:mysql://localhost.3306/june_2024","root","root")
			system.out.println("Connection Established");
	String S="Select* from Student when id=?");
	preparedStatement pstmt=con.preparestatement(s);
	System.out.println("enter the id");
	Scanner sc=new Scanner(System.in);
	int id=scan.nextInt();
	Resultset res= pstmt executequery();
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