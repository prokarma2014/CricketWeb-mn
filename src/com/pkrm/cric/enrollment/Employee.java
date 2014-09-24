package com.pkrm.cric.enrollment;

import java.io.Serializable;

public class Employee implements Serializable {

	private static final long serialVersionUID = 793013140046189979L;
	private String name;
	private String designation;
	private String projectName;
	private String havePlayed;
	private String personalHighscore;
	private String bowlingBest;
	private String petName;
	private int id;

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final String getDesignation() {
		return designation;
	}

	public final void setDesignation(String designation) {
		this.designation = designation;
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

	public final int getId() {
		return id;
	}

	public final void setId(int id) {
		this.id = id;
	}

}
