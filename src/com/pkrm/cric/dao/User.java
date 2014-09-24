package com.pkrm.cric.dao;

import java.sql.Timestamp;

public class User {

	private int id;
	private String firstName;
	private String lastName;
	private String userName;
	private String role;
	private String email;
	private String password;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp modifiedBY;
	private int teamId;
	private int adminLevel;

	public final int getId() {
		return id;
	}

	public final void setId(int id) {
		this.id = id;
	}

	public final String getFirstName() {
		return firstName;
	}

	public final void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public final String getLastName() {
		return lastName;
	}

	public final void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public final String getUserName() {
		return userName;
	}

	public final void setUserName(String userName) {
		this.userName = userName;
	}

	public final String getRole() {
		return role;
	}

	public final void setRole(String role) {
		this.role = role;
	}

	public final String getEmail() {
		return email;
	}

	public final void setEmail(String email) {
		this.email = email;
	}

	public final String getPassword() {
		return password;
	}

	public final void setPassword(String password) {
		this.password = password;
	}

	public final String getCreatedBy() {
		return createdBy;
	}

	public final void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public final Timestamp getCreatedDate() {
		return createdDate;
	}

	public final void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public final String getModifiedBy() {
		return modifiedBy;
	}

	public final void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public final Timestamp getModifiedBY() {
		return modifiedBY;
	}

	public final void setModifiedBY(Timestamp modifiedBY) {
		this.modifiedBY = modifiedBY;
	}

	public final int getTeamId() {
		return teamId;
	}

	public final void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public final int getAdminLevel() {
		return adminLevel;
	}

	public final void setAdminLevel(int adminLevel) {
		this.adminLevel = adminLevel;
	}

}
