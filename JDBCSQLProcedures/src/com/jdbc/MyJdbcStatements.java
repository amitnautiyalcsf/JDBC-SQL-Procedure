package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class MyJdbcStatements {

	public static void main(String[] args) 
	{
		
		String url="jdbc:mysql://localhost:3306/jdbctest";
		String u="root";
		String p="";
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection(url,u,p);
	//Prepared Statement is faster than the statement becoz using it database store cache of execution plans for previously executed statments
			PreparedStatement pstat= con.prepareStatement("Insert into emp(eid,ename,eage) values(?,?,?)");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter <EID>, <ENAME>, <EAGE>");
			pstat.setInt(1, sc.nextInt());
			pstat.setString(2, sc.next());
			pstat.setInt(3, sc.nextInt());
		
			
			int rows = pstat.executeUpdate();
			System.out.println("Record Added Rows Are: " + rows);
         }
		
		catch(Exception e)
		{
		
			System.out.println(e);
		
		}
		
		
		

}
}
