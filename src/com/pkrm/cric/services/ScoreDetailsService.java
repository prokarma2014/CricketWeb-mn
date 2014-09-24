package com.pkrm.cric.services;

import java.util.List;

import com.pkrm.cric.model.MatchDetails;

public interface ScoreDetailsService {

	List<String> getPlaces(int year);
	List<String> getMatches(int year,String place);
	MatchDetails getMatchDetails(int year,String place,String match);
	List<Integer>getPlayedYears();
}
