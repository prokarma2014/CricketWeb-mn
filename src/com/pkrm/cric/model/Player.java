package com.pkrm.cric.model;

public class Player {
	private int id;
	private String name;
	private int employeeId;
	private String designation;
	private String projectName;
	private String havePlayed;
	private String personalHighscore;
	private String bowlingBest;
	private String petName;
	public final String getPersonalHighscore() {
		return personalHighscore;
	}

	public final void setPersonalHighscore(String personalHighscore) {
		this.personalHighscore = personalHighscore;
	}

	public final String getBowlingBest() {
		return bowlingBest;
	}

	public final void setBowlingBest(String bowlingBest) {
		this.bowlingBest = bowlingBest;
	}

	public final String getPetName() {
		return petName;
	}

	public final void setPetName(String petName) {
		this.petName = petName;
	}

	private int teamId;

	public final int getTeamId() {
		return teamId;
	}

	public final void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public final int getId() {
		return id;
	}

	public final void setId(int id) {
		this.id = id;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final int getEmployeeId() {
		return employeeId;
	}

	public final void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public final String getDesignation() {
		return designation;
	}

	public final void setDesignation(String destignation) {
		this.designation = destignation;
	}

	public final String getProjectName() {
		return projectName;
	}

	public final void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public final String getHavePlayed() {
		return havePlayed;
	}

	public final void setHavePlayed(String havePlayed) {
		this.havePlayed = havePlayed;
	}




}
