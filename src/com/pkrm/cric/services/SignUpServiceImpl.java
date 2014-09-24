package com.pkrm.cric.services;

import com.pkrm.cric.dao.User;
import com.pkrm.cric.dao.UserDao;
import com.pkrm.cric.dao.UserDaoImpl;

public class SignUpServiceImpl implements SignUpService {

	private UserDao userDao;

	public boolean signUp(User user) {
		userDao = new UserDaoImpl();
		if (userDao.getUser(user.getId()) == null) {
			if (userDao.getUser(user.getUserName()) == null) {
				return userDao.insertUser(user);

			} else {
				throw new RuntimeException("UserName Alredy exist");
			}

		} else {
			throw new RuntimeException("UserId Alredy exist");
		}

	}

}
