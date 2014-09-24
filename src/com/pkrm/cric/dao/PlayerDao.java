package com.pkrm.cric.dao;

import com.pkrm.cric.model.Player;

public interface PlayerDao {

	public Player getPlayer(int employeeId);
	public boolean enroll(Player player);
}
