package com.pkrm.cric.action;

public class MyDAOFactory {

	public static PlayerDAO getPlayerDAO()
	{
		return new PlayerDAOImplDB();
	}
}
