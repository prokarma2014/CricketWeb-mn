package com.pkrm.cric.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnectionFactory {
	private MyConnectionFactory()
	{
		
	}

	public static Connection getConnection()throws SQLException
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/ppl", "root", "admin");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
