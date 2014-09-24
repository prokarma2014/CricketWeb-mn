package com.pkrm.cric.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class UserDaoImpl extends CommonDaoIMpl implements UserDao {

	private static final String GET_USER_FROM_USER_ID = "select * from user where user_id=?";
	private static final String GET_USER_FROM_USERNAME = "select * from user where user_name=?";
	private static final String INSERT_USER = "INSERT INTO user(USER_ID,FIRST_NAME,LAST_NAME,USER_NAME,ROLE,EMAIL,"
			+ "PASSWORD,CREATED_DATE,CREATED_BY,`ADMIN_LEVEL`)VALUES(?,?,?,?,?,?,?,?,?,?)";

	public User getUser(String username) {
		try {
			PreparedStatement statement = getConnection().prepareStatement(
					GET_USER_FROM_USERNAME);
			statement.setString(1, username);
			ResultSet resultSet = statement.executeQuery();
			getConnection().close();
			return getUser(resultSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public User getUser(int userId) {
		try {
			PreparedStatement statement = getConnection().prepareStatement(
					GET_USER_FROM_USER_ID);
			statement.setInt(1, userId);
			ResultSet resultSet = statement.executeQuery();
			getConnection().close();
			return getUser(resultSet);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private User getUser(ResultSet resultSet) {
		User user = null;
		try {
			if (resultSet != null && resultSet.next()) {
				user = new User();
				user.setFirstName(resultSet.getString("FIRST_NAME"));
				user.setId(resultSet.getInt("USER_ID"));
				user.setLastName(resultSet.getString("LAST_NAME"));
				user.setUserName(resultSet.getString("USER_NAME"));
				user.setEmail(resultSet.getString("EMAIL"));
				user.setPassword(resultSet.getString("PASSWORD"));
				user.setAdminLevel(resultSet.getInt("ADMIN_LEVEL"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;
	}

	public boolean insertUser(User user) {
		try {
			PreparedStatement statement = getConnection().prepareStatement(INSERT_USER);
			statement.setInt(1, user.getId());
			statement.setString(2,user.getFirstName() );
			statement.setString(3, user.getLastName());
			statement.setString(4,user.getUserName() );
			statement.setString(5,user.getRole() );
			statement.setString(6,user.getEmail() );
			statement.setString(7,user.getPassword() );
			statement.setTimestamp(8, new Timestamp(new Date().getTime()));
			statement.setInt(9, user.getId());
			statement.setInt(10, 4);
			return statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return false;

	}
}
