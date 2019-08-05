package com.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class MyProcedureTest 
{
	
	public static void main(String[] args) {
		
		String url="jdbc:mysql://localhost:3306/jdbctest";
		String u="root";
		String p="";
		
		
	try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
	
			Connection con= DriverManager.getConnection(url,u,p);
			
			CallableStatement stmt = con.prepareCall("call myproc(?,?)");
			int id =111;
			stmt.setInt(1, id);
			stmt.registerOutParameter(2, Types.INTEGER);// here we are registering the out parameter
			stmt.execute();
            int allow = stmt.getInt(2);
			System.out.println("Allowance of "+id+ " : " + allow);
		}
	
	catch(Exception e)
	{

		e.printStackTrace();
		
	}
	
	}

}
