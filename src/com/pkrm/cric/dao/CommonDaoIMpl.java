package com.pkrm.cric.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class CommonDaoIMpl {

 

	private Connection connection;

	public final Connection getConnection(){

		
	try {
	
		Class.forName("com.mysql.jdbc.Driver");
		connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/ppl", "root", "admin");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return connection;
	  
	}
}
