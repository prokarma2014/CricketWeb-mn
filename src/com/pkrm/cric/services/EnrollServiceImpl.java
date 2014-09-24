package com.pkrm.cric.services;

import com.pkrm.cric.dao.PlayerDao;
import com.pkrm.cric.dao.PlayerDaoImpl;
import com.pkrm.cric.model.Player;

public class EnrollServiceImpl implements EnrollService {

	private PlayerDao playerDao;
	public Player getPlayerDetails(int employeeId) {
		playerDao=new PlayerDaoImpl();
		
		return playerDao.getPlayer(employeeId);
	}

	public boolean enrollPlayer(Player player) {
		playerDao=new PlayerDaoImpl();
		return playerDao.enroll(player);
	}

}
