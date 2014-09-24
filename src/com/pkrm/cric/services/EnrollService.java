package com.pkrm.cric.services;

import com.pkrm.cric.model.Player;

public interface EnrollService {

	Player getPlayerDetails(int employeeId );
	
	boolean enrollPlayer(Player player);
}
