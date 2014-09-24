package com.pkrm.cric.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class TestClass extends CommonDaoIMpl {

	public static void main(String[] args) {
		/*
		 * UserDao dao=new UserDaoImpl(); PlayerDaoImpl dao2=new
		 * PlayerDaoImpl(); User user= dao.getUser(1975);
		 * System.out.println(user.getUserName()); Player
		 * player=dao2.getPlayer(1974);
		 * System.out.println(player.getPetName()+" hay pet"); Player
		 * player2=new Player(); player2.setEmployeeId(2000);
		 * player2.setBowlingBest("33/3"); player2.setDesignation("trainee");
		 * player2.setHavePlayed("YES"); player2.setName("Ashraff");
		 * player2.setPersonalHighscore("178*"); player2.setPetName("ashu");
		 * player2.setProjectName("UPRR");
		 * System.out.println(dao2.enroll(player2));
		 */

		TestClass class1=new TestClass();
		
		class1.testgetbattingDetails();
		System.out.println(new Date());
	}

	static void createUser() {
		//UserDao dao = new UserDaoImpl();
		User user = new User();
		for (int i = 1; i < 12; i++) {
			String fname = "player" + i;
			user.setAdminLevel(4);
			user.setFirstName(fname);
			user.setEmail(fname + "@prokarma.com");
			user.setPassword(fname);
			user.setUserName(fname);
			user.setRole("user");
		}
	}

	public   void testgetbattingDetails() {

		try {
			String QUERY="select battingdetails.matchId,match_stats.innings_id, battingdetails.team_id, battingdetails.player_id,"
					+"battingdetails.runs,battingdetails.fours,"
					+"battingdetails.sixs, battingdetails.catched,battingdetails.runout,battingdetails.blowed,battingdetails.lbw,battingdetails.balls,battingdetails.strike_rate,battingdetails.reason as playerfrom,players.EMPLOYEE_NAME as batsman"
					+"from players, battingdetails left join match_stats on match_stats.match_id=battingdetails.matchId and match_stats.team_id=battingdetails.team_id where (battingdetails.player_id=players.PLAYER_ID and match_stats.innings_id=? and  battingdetails.matchId=?)";
			PreparedStatement statement = getConnection().prepareStatement(
					QUERY);
			statement.setInt(1, 1);
			statement.setInt(2, 1);
			//ResultSet resultSet = statement.executeQuery();
			getConnection().close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
