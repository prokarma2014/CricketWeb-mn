package com.pkrm.cric.dao;

public interface UserDao {

	User getUser(String username);

	User getUser(int userId);

	boolean insertUser(User user);
}
