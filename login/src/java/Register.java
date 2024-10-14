package java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Register{

	public static void main(String[] args) throws Exception {
		System.out.println("1.New User(Register)");
		System.out.println("2.Login");
		System.out.println("Enter our choice");
		Scanner sc=new Scanner(System.in);
		int choice =sc.nextInt();
		switch(choice) {
		case 1:register();
		break;
		case 2:login();
		break;
		default:System.out.println("Invalid Choice");
		break;
		}
	}
	static void register() throws Exception{
	DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","root");
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter name");
	String name = sc.next();
	System.out.println("Enter Username");
	String username =sc.next();
	while(true) {
		String s="select* from user where username=?";
		PreparedStatement pstmt=con.prepareStatement(s);
		pstmt.setString(1,username);
		ResultSet res= pstmt.executeQuery();
		if(res.next()) {
			System.out.println("Username Already Exists Please Enter Another Username");
			username=sc.next();
		}
		else {
			break;
		}
	}
	String password;
	String Confirm;
	do {
	System.out.println("Enter Username");
	password=sc.next();
	System.out.println("Enter Username");
    Confirm=sc.next();
	}while(!password.equals(Confirm));
	System.out.println("Enter Username");
	String email=sc.next();
	String s1="insert into user values(?,?,?,?)";
	PreparedStatement pstmt1=con.prepareStatement(s1);
	pstmt1.setString(1,name);
	pstmt1.setString(2,username);
	pstmt1.setString(3,password);
	pstmt1.setString(4,email);
	pstmt1.executeUpdate();
 }
	static void login()throws Exception{
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","root");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Username");
		String username=sc.next();
		System.out.println("Enter Password");
		String password=sc.next();
		String s="select* from user wher username=?";
		PreparedStatement pstmt=con.prepareStatement(s);
		pstmt.setString(1,username);
		ResultSet res=pstmt.executeQuery();
		if(res.next()) {
			if(password.equals(res.getString(3))){
				System.out.println("Login Successful");
			}
			else {
				System.out.println("Invalid password");
			}
		}
		
	}

}
