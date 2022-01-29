package com.revature.phil_wentworth.models;

import java.util.Arrays;

public class MyCharacter {
	private int[] statistics;
	private int id;
	private int userID;
	private String characterName;
	
	public MyCharacter(int id, int userID, String characterName) {
		this.id = id;
		this.userID = userID;
		this.characterName = characterName;
	}
	
	public int[] getStatistics() {
		return statistics;
	}
	
	public void setStatistics(int[] statistics) {
		this.statistics = statistics;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getUserID() {
		return userID;
	}
	
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public String getCharacterName() {
		return characterName;
	}
	
	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	@Override
	public String toString() {
		return characterName + ": " + Arrays.toString(statistics);
	}
	
	
}
