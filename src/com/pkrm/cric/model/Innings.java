package com.pkrm.cric.model;

import java.util.List;

public class Innings {

	private List<Batsman> batsmans;
	private List<Blower> blowers;
	private int wides;
	private int byes;
	private int legByes;
	private int noballs;
	private String totalRuns;
	private float totalOvers;
	private String battingTeamName;
	private String blowingTeamName;
	private String extras;
	private float runrate;

	public final List<Batsman> getBatsmans() {
		return batsmans;
	}

	public final void setBatsmans(List<Batsman> batsmans) {
		this.batsmans = batsmans;
	}

	public final List<Blower> getBlowers() {
		return blowers;
	}

	public final void setBlowers(List<Blower> blowers) {
		this.blowers = blowers;
	}

	public final int getWides() {
		return wides;
	}

	public final void setWides(int wides) {
		this.wides = wides;
	}

	public final int getByes() {
		return byes;
	}

	public final void setByes(int byes) {
		this.byes = byes;
	}

	public final int getLegByes() {
		return legByes;
	}

	public final void setLegByes(int legByes) {
		this.legByes = legByes;
	}

	public final int getNoballs() {
		return noballs;
	}

	public final void setNoballs(int noballs) {
		this.noballs = noballs;
	}

	public final String getTotalRuns() {
		return totalRuns;
	}

	public final void setTotalRuns(String totalRuns) {
		this.totalRuns = totalRuns;
	}

	public final float getTotalOvers() {
		return totalOvers;
	}

	public final void setTotalOvers(float totalOvers) {
		this.totalOvers = totalOvers;
	}

	public final String getBattingTeamName() {
		return battingTeamName;
	}

	public final void setBattingTeamName(String battingTeamName) {
		this.battingTeamName = battingTeamName;
	}

	public final String getBlowingTeamName() {
		return blowingTeamName;
	}

	public final void setBlowingTeamName(String blowingTeamName) {
		this.blowingTeamName = blowingTeamName;
	}

	public final String getExtras() {
		return extras;
	}

	public final void setExtras(String extras) {
		this.extras = extras;
	}

	public final float getRunrate() {
		return runrate;
	}

	public final void setRunrate(float runrate) {
		this.runrate = runrate;
	}
}
