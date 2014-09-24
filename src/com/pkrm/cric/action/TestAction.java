package com.pkrm.cric.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.pkrm.cric.model.Batsman;
import com.pkrm.cric.model.Blower;
import com.pkrm.cric.model.Innings;

public class TestAction extends Action {

	private List<Blower> blowers;
	private List<Batsman> batsmans;
	private Batsman batsman;
	private Blower blower;
	private Innings firstInnings;

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		
		firstInnings=new Innings();
		firstInnings.setWides(10);
		firstInnings.setByes(2);
		firstInnings.setTotalRuns("107/10");
		firstInnings.setBattingTeamName("team1");
		firstInnings.setBlowingTeamName("team2");
		firstInnings.setTotalOvers(17.2f);
		firstInnings.setExtras("12");
		firstInnings.setRunrate(5.2f);
		firstInnings.setBatsmans(batsmans);
		firstInnings.setBlowers(blowers);
	 batsmans=new ArrayList<Batsman>();
		blowers=new ArrayList<Blower>();
		getBatsmanDetails();
		getBowlerDetals();
		request.setAttribute("firstInnings", firstInnings);
		request.setAttribute("batsmans", batsmans);
		request.setAttribute("blowers", blowers);
		//second innings
		request.setAttribute("secondInnings", firstInnings);
		request.setAttribute("secondInningsBatsmans", batsmans);
		request.setAttribute("secondInningsBlowers", blowers);
				
		return mapping.findForward("testSuccess");
	}

	private void getBowlerDetals() {
		batsman=new Batsman();
		batsmans.add(batsman);
		batsman.setName("player1");
		batsman.setBowledBy("blower1");
		batsman.setRuns(20);
		batsman.setSixs(0);
		batsman.setFours(1);
		batsman.setStrikeRate( 120.2f);
		batsman=new Batsman();
		batsmans.add(batsman);
		batsman.setName("player2");
		batsman.setBowledBy("blower1");
		batsman.setRuns(30);
		batsman.setSixs(0);
		batsman.setFours(1);
		batsman.setSixs(4);
		batsman.setStrikeRate( 180.2f);
		
	}

	private void getBatsmanDetails() {
		blower= new Blower();
		blower.setName("blower1");
		blower.setOvers(4);
		blower.setMadiens(1);
		blower.setNoBall(0);
		blower.setWicket(2);
		blower.setWide(2);
		blower.setEconomy(5.0f);
		blower.setRuns(20);
		blowers.add(blower);
		blower= new Blower();
		blower.setName("blower2");
		blower.setOvers(4);
		blower.setMadiens(1);
		blower.setNoBall(0);
		blower.setWicket(2);
//		blower.setWide(2);
//		blower.setEconomy(5.0f);
		blower.setRuns(20);
		blowers.add(blower);
		
/*	
 *  selecting batting details of particular match innings batting details
 * 	select battingdetails.matchId,match_stats.innings_id, battingdetails.team_id, battingdetails.player_id,
		battingdetails.runs,battingdetails.fours,
		battingdetails.sixs, battingdetails.catched,battingdetails.runout,battingdetails.blowed,battingdetails.lbw,battingdetails.balls,battingdetails.strike_rate,battingdetails.reason as playerfrom,players.EMPLOYEE_NAME as batsman
		from players, battingdetails left join match_stats on match_stats.match_id=battingdetails.matchId and match_stats.team_id=battingdetails.team_id where (battingdetails.player_id=players.PLAYER_ID and match_stats.innings_id=1 );
*/
		
	}
}
