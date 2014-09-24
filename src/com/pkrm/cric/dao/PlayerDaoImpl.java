package com.pkrm.cric.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.pkrm.cric.model.Player;

public class PlayerDaoImpl extends CommonDaoIMpl implements PlayerDao {

	private static final String GET_PLAYER_FROM_ID = "select * from players where employee_id=?";
	private static final String ENROLL_PLAYER = "INSERT INTO players(`PLAYER_ID`,`EMPLOYEE_NAME`,`EMPLOYEE_ID`,`DESIGNATION`,`PROJECT_NAME`,`HAVPLAYED`,`PERSONAL_HIGH_SCORE`,`BOWILING_BEST`,`PET_NAME`)VALUES(?,?,?,?,?,?,?,?,?)";
	private static final String GET_ID = "select (max(player_Id)+1 )from players";
	

	public Player getPlayer(int employeeId) {
		try {
			PreparedStatement statement = getConnection().prepareStatement(
					GET_PLAYER_FROM_ID);
			statement.setInt(1, employeeId);
			ResultSet resultSet = statement.executeQuery();
			getConnection().close();
			return getPlayer(resultSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private Player getPlayer(ResultSet resultSet) {
		Player player = null;
		try {
			if (resultSet != null && resultSet.next()) {
				player = new Player();
				player.setEmployeeId(resultSet.getInt("EMPLOYEE_ID"));
				player.setId(resultSet.getInt("PLAYER_ID"));
				player.setName(resultSet.getString("EMPLOYEE_NAME"));
				player.setDesignation(resultSet.getString("DESIGNATION"));
				player.setProjectName(resultSet.getString("PROJECT_NAME"));
				player.setHavePlayed(resultSet.getString("HAVPLAYED"));
				player.setPersonalHighscore(resultSet
						.getString("PERSONAL_HIGH_SCORE"));
				player.setBowlingBest(resultSet.getString("BOWILING_BEST"));
				player.setPetName(resultSet.getString("PET_NAME"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return player;
	}

	public boolean enroll(Player player) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement statement = getConnection().prepareStatement(
					ENROLL_PLAYER);
			Statement idStatment=getConnection().createStatement();
			ResultSet rs = idStatment.executeQuery(GET_ID);
			int id=0;
			if(rs.next()){
				id=rs.getInt(1);
			}
			statement.setInt(1, id);
			statement.setString(2,player.getName());
			statement.setInt(3,player.getEmployeeId() );
			statement.setString(4,player.getDesignation());
			statement.setString(5,player.getProjectName());
			statement.setString(6,player.getHavePlayed().equalsIgnoreCase("YES")?"Y":"N");
			statement.setString(7,player.getPersonalHighscore());
			statement.setString(8,player.getBowlingBest());
			statement.setString(9,player.getPetName());
			int i=statement.executeUpdate();
			if(i==1){
				System.out.println("true enrooled");
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// INSERT INTO
		// players(`PLAYER_ID`,`EMPLOYEE_NAME`,`EMPLOYEE_ID`,`DESIGNATION`,`PROJECT_NAME`,`HAVPLAYED`,`PERSONAL_HIGH_SCORE`,`BOWILING_BEST`,`PET_NAME`)VALUES(
		return false;
	}
}
