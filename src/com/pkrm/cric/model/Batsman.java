package com.pkrm.cric.model;

public class Batsman {

	private String name;

	private String catchedBy;
	private String runOutBY;
	private int runs;
	private int fours;
	private int sixs;
	private float strikeRate;
	private String bowledBy;
	private String caatchedBy;
	private String lbwBy;
	private int balls;

	public final int getBalls() {
		return balls;
	}

	public final void setBalls(int balls) {
		this.balls = balls;
	}

	public final String getBowledBy() {
		return bowledBy;
	}

	public final void setBowledBy(String bowledBy) {
		this.bowledBy = bowledBy;
	}

	public final String getCaatchedBy() {
		return caatchedBy;
	}

	public final void setCaatchedBy(String caatchedBy) {
		this.caatchedBy = caatchedBy;
	}

	public final String getLbwBy() {
		return lbwBy;
	}

	public final void setLbwBy(String lbwBy) {
		this.lbwBy = lbwBy;
	}

	public final String getRunoutBY() {
		return runoutBY;
	}

	public final void setRunoutBY(String runoutBY) {
		this.runoutBY = runoutBY;
	}

	private String runoutBY;

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final String getCatchedBy() {
		return catchedBy;
	}

	public final void setCatchedBy(String catchedBy) {
		this.catchedBy = catchedBy;
	}

	public final String getRunOutBY() {
		return runOutBY;
	}

	public final void setRunOutBY(String runOutBY) {
		this.runOutBY = runOutBY;
	}

	public final int getRuns() {
		return runs;
	}

	public final void setRuns(int runs) {
		this.runs = runs;
	}

	public final int getFours() {
		return fours;
	}

	public final void setFours(int fours) {
		this.fours = fours;
	}

	public final int getSixs() {
		return sixs;
	}

	public final void setSixs(int sixs) {
		this.sixs = sixs;
	}

	public final float getStrikeRate() {
		return strikeRate;
	}

	public final void setStrikeRate(float strikeRate) {
		this.strikeRate = strikeRate;
	}
}
