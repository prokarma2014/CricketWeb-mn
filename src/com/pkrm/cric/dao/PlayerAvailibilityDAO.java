package com.pkrm.cric.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import com.pkrm.cric.action.MyConnectionFactory;
import com.pkrm.cric.action.MyDAOException;

public class PlayerAvailibilityDAO {
	
	
	
	public boolean updatePlayerAvailibility(Map<String, String> playerAvaliMap)
			throws MyDAOException {
		
		Connection con = null;
		try
		{
			con = MyConnectionFactory.getConnection();
			String inserQuery="UPDATE playeravailibility SET TUESDAYNETS=?,"
					+" THURSDAYNETS=?, SATURDAYMATCH=?, UPDATEDBY=?,"
					+" UPDATEDDATE=? WHERE PLAYER_NAME=?";
			PreparedStatement ps = con.prepareStatement(inserQuery);
			if(playerAvaliMap != null){
				ps.setString(1,playerAvaliMap.get("tuesdayNets"));
				ps.setString(2,playerAvaliMap.get("thursdayNets"));
				ps.setString(3,playerAvaliMap.get("saturdaymatch"));
				ps.setString(4,playerAvaliMap.get("currentPlayer"));
				
				
				java.sql.Date currentDate = new java.sql.Date(new java.util.Date().getTime());
				
				ps.setDate(5,currentDate);
				ps.setString(6,playerAvaliMap.get("playerName"));
			
			
			ps.executeUpdate();

			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			//System.out.println("**Exception**"+e.getMessage());
		}
		return true;
	}
	

}
