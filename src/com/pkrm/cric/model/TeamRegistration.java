package com.pkrm.cric.model;

import org.apache.struts.upload.FormFile;

public class TeamRegistration {

	private String teamName;
	private int teamID;
	private String captainName;
	private String viceCaptainName;
	private int captainID;
	private int viceCaptainID;
	private String selectPlayers;
	private String selectedPlayers;
	private FormFile teamLogo;

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getTeamID() {
		return teamID;
	}

	public void setTeamID(int teamID) {
		this.teamID = teamID;
	}

	public String getCaptainName() {
		return captainName;
	}

	public void setCaptainName(String captainName) {
		this.captainName = captainName;
	}

	public String getViceCaptainName() {
		return viceCaptainName;
	}

	public void setViceCaptainName(String viceCaptainName) {
		this.viceCaptainName = viceCaptainName;
	}

	public int getCaptainID() {
		return captainID;
	}

	public void setCaptainID(int captainID) {
		this.captainID = captainID;
	}

	public int getViceCaptainID() {
		return viceCaptainID;
	}

	public void setViceCaptainID(int viceCaptainID) {
		this.viceCaptainID = viceCaptainID;
	}

	public String getSelectPlayers() {
		return selectPlayers;
	}

	public void setSelectPlayers(String selectPlayers) {
		this.selectPlayers = selectPlayers;
	}


	public String getSelectedPlayers() {
		return selectedPlayers;
	}

	public void setSelectedPlayers(String selectedPlayers) {
		this.selectedPlayers = selectedPlayers;
	}

	public FormFile getTeamLogo() {
		return teamLogo;
	}

	public void setTeamLogo(FormFile teamLogo) {
		this.teamLogo = teamLogo;
	}

	

}
