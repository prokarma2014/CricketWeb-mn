package com.pkrm.cric.services;

import java.util.ArrayList;
import java.util.List;

import com.pkrm.cric.model.MatchDetails;

public class ScoreDetailsServiceImpl implements ScoreDetailsService {

	public List<String> getPlaces(int year) {
		// TODO Auto-generated method stub
		List<String> places= new ArrayList<String>();
		if(year==2012){
			places.add("Hyderabad");
			places.add("Ohma");
		}else if (year==2013){
			places.add("Hyderabad");
			places.add("Chennai");	
		}
		return places;
	}

	public List<String> getMatches(int year, String place) {
		// TODO Auto-generated method stub
		List<String> matches= new ArrayList<String>();
		if(year==2012 && place.equals("Hyderabad")){
			matches.add("panthers Vs sixers");
			matches.add("panthers Vs blasters");
			matches.add("sixers Vs blasters");
		}else if (year==2012 && place.equals("Ohma")){
			
		}
		if(year==2013 && place.equals("Hyderabad")){
			matches.add("panthers Vs sixers");
			matches.add("panthers Vs blasters");
			matches.add("sixers Vs blasters");
		}else if (year==2013 && place.equals("Chennai")){
			matches.add("panthersC Vs sixersC");
			matches.add("panthersC Vs blastersC");
			matches.add("sixersC Vs blastersC");
		}
		
		return matches;

	}

	public MatchDetails getMatchDetails(int year, String place, String match) {
		// TODO Auto-generated method stub
		MatchDetails matchDetails=new MatchDetails();
		matchDetails.setComments("IT iS wonderfull Game");
		matchDetails.setMatchTitle(match);
		matchDetails.setResult(match.substring(match.indexOf("Vs ")+3)+ " WON MAtch");
		matchDetails.setFirstInningsScore("130/5 in 20 Overs");
		matchDetails.setSecondInningsScore("125/10 in 19.5 Overs");
		matchDetails.setManOfMatch("Player10");
		matchDetails.sethighScorrer("player3");
		matchDetails.setLeadingWicketTaker("player10");
		return matchDetails;
	}

	public List<Integer> getPlayedYears() {
		// TODO Auto-generated method stub
		// TODO Intgreating with dataBase 
		List<Integer> years=new ArrayList<Integer>();
		years.add(2012);
		years.add(2013);
		years.add(2014);
		return years;
	}

}
