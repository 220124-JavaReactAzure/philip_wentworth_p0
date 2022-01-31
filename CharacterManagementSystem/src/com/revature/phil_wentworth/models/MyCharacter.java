package com.revature.phil_wentworth.models;

public class MyCharacter {
	public static final String[] statisticNames = {"Strength", "Dexterity", "Constitution", "Intelligence", "Wisdom", "Charisma"};
	public static final String[] statisticAbbreviations = {"STR","DEX","CON","INT","WIS","CHA"};
	private int[] statistics;
	private int id;
	private int userID;
	private String characterName;
	
	public MyCharacter(int id, int userID, String characterName) {
		this.id = id;
		this.userID = userID;
		this.characterName = characterName;
		this.statistics = new int[6];
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
		StringBuilder returnString = new StringBuilder( characterName + ":\n");
		for (int i=0; i<statistics.length; i++) {
			returnString.append(statisticAbbreviations[i] + "\t");
		}
		returnString.append("\n");
		for (int i=0; i<statistics.length; i++) {
			returnString.append(statistics[i] + "\t");
		}
		return returnString.toString();
	}
	
	
}