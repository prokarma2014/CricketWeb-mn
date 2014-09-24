package com.pkrm.cric.TestClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class SaveImageInDB {

	public static void main(String[] args) {
		System.out.println("Insert Image Example!");
		String driverName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "ppl";
		String userName = "root";
		String password = "admin";
		Connection con = null;
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(url + dbName, userName, password);
			//Statement st = con.createStatement();
			File imgfile = new File("C:\\Users\\prokarma\\Desktop\\images.jpg");

			FileInputStream fin = new FileInputStream(imgfile);

			PreparedStatement pre = con
					.prepareStatement("insert into testimagesave values(?,?)");

			pre.setInt(1, 1);
			pre.setBinaryStream(2, (InputStream) fin, (int) imgfile.length());
			pre.executeUpdate();
			System.out
					.println("Successfully inserted the file into the database!");

			pre.close();
			con.close();
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		}
	}
}
