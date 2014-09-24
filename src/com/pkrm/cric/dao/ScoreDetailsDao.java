package com.pkrm.cric.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pkrm.cric.model.Batsman;

public class ScoreDetailsDao extends CommonDaoIMpl {

	private static final String GET_BATSMAN_FROM_MATCH_AND_TEAM = " SELECT p.EMPLOYEE_NAME as name ,b.runs,b.fours,b.sixs,b.catched,b.runout,blowed,b.lbw,b.balls,b.strike_rate"
			+ "FROM batsman b , players p  where b.player_id=p.EMPLOYEE_ID and b.matchid=? and b.team_id=?";

	public void getScoreDetails() {
//		Innings firstInnings = new Innings();
//		Innings secondInnings = new Innings();
		getfirstInningsDetails();
	}

	public static void main(String[] args) {
		ScoreDetailsDao dao = new ScoreDetailsDao();
		dao.getListOfBatsman();
	}

	private void getfirstInningsDetails() {
//		Batsman batsman = new Batsman();
//		List<Batsman> batsmans = new ArrayList<Batsman>();
		getListOfBatsman();
	}

	private void getListOfBatsman() {
		// TODO Auto-generated method stub
		try {
			PreparedStatement statement = getConnection().prepareStatement(
					GET_BATSMAN_FROM_MATCH_AND_TEAM);
			int matchId = 1;
			int teamId = 1;
			statement.setInt(1, matchId);
			statement.setInt(2, teamId);
			ResultSet resultSet = statement.executeQuery();
			getConnection().close();
			getBatsmans(resultSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void getBatsmans(ResultSet resultSet) {
		// TODO Auto-generated method stub
		Batsman batsman = new Batsman();
		//List<Batsman> batsmans = new ArrayList<Batsman>();

		try {
			if (resultSet != null && resultSet.next()) {
				batsman.setName(resultSet.getString("name"));
				batsman.setRuns(resultSet.getInt("runs"));
				batsman.setFours(resultSet.getInt("fours"));
				batsman.setSixs(resultSet.getInt("sixs"));
				batsman.setBalls(resultSet.getInt("balls"));
				batsman.setCatchedBy(resultSet.getString("catched"));
				batsman.setRunoutBY(resultSet.getString("runout"));
				batsman.setBowledBy(resultSet.getString("blowed"));
				batsman.setLbwBy(resultSet.getString("lbw"));
				batsman.setStrikeRate(resultSet.getFloat("strike_rate"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
