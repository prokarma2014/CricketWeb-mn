package com.pkrm.cric.services;

import com.pkrm.cric.dao.User;
import com.pkrm.cric.dao.UserDao;
import com.pkrm.cric.dao.UserDaoImpl;

public class LoginServiceImpl implements LoginService {

	private User user;
	private UserDao userDao;
	private boolean vaildUser;
	
	public boolean isvaildUser( String userName, String password){
		
		userDao=new UserDaoImpl();
		user=userDao.getUser(userName);
		if(user!=null && user.getPassword().equals(password)){
		vaildUser=true;
		}
		return vaildUser;
	}
	public String getFirstName(){
		if(vaildUser){
			return user.getFirstName();
		}else
		return null;
		
	}
	public int getEmployeeId() {
		if(vaildUser){
			return user.getId();
		}else
		
		return 0;
	}
}
