package com.pkrm.cric.services;

public interface LoginService {

	 boolean isvaildUser( String userName, String password);
	 String getFirstName();
	 int getEmployeeId();
}
