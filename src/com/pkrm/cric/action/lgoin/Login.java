package com.pkrm.cric.action.lgoin;

import com.pkrm.cric.services.LoginService;
import com.pkrm.cric.services.LoginServiceImpl;

public class Login {

	private String userName;
	private String password;
	private String name;
	private int employeeId;
	private LoginService loginService=new LoginServiceImpl();
	
	public boolean isvalidUser(){

		return loginService.isvaildUser(userName, password);
		
	}

	public final String getUserName() {
		return userName;
	}

	public final void setUserName(String userName) {
		this.userName = userName;
	}

	public final String getPassword() {
		return password;
	}

	public final void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		this.name =loginService.getFirstName(); 
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEmployeeId() {
		this.employeeId = loginService.getEmployeeId();
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	
}
