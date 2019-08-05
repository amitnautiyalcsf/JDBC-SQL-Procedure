package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyJDBCTest {

	public static void main(String[] args)  {
		
		String url="jdbc:mysql://localhost:3306/jdbctest";
		String u="root";
		String p="";
		
		
	try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection(url,u,p);
			Statement stmt=con.createStatement();
			ResultSet rs =stmt.executeQuery("select * from emp");
			
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+ "," + rs.getString(2) + "," + rs.getInt(3) + "," +rs.getString(4));	
			}
			
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		

}
}
