package com.pkrm.cric.action;

import java.util.List;

import com.pkrm.cric.model.TeamRegistration;


public interface PlayerDAO {
	List<String> getPlayerDetailsByName(String player_Name)throws MyDAOException;
	public boolean insertTeamDetails(TeamRegistration teamRegistration)throws MyDAOException;
}
