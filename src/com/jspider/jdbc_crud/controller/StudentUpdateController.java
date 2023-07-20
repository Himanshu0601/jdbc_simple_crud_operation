package com.jspider.jdbc_crud.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentUpdateController {
	public static void main(String[] args) {
		Connection con=null;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter id of student :");
		int id=sc.nextInt();
		System.out.println("Enter new email :");
		String email=sc.next();
		try {
			//step 1 load/register driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//step 2 create connection;
			String url="jdbc:mysql://localhost:3306/jfssrd-m3";
			String pass="root";
			String user="root";
			con = DriverManager.getConnection(url, user, pass);
			//step 3 create statement
			
			Statement st=con.createStatement();
			
			// step 4 execute query
			String insertStudentQuery = "update student set email='"+email+"' where id="+id;
			int a=st.executeUpdate(insertStudentQuery);
			if(a==1) {
				System.out.println("====================Record updated==============");
				
			}else {
				System.out.println("Given id is not present");
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
}
}
