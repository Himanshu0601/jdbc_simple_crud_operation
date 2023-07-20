
package com.jspider.jdbc_crud.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentInsertController {

	

	public static void main(String[] args) {
		Connection con=null;
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
			String insertStudentQuery = "select * from student";
			st.execute(insertStudentQuery);
			System.out.println("====================Record inserted==============");
			
			
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
