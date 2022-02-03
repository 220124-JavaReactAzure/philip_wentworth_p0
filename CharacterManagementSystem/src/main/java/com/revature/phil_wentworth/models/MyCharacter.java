package com.revature.phil_wentworth.models;

public class MyCharacter {
	private static final String[] statisticNames = {"Strength", "Dexterity", "Constitution", "Intelligence", "Wisdom", "Charisma"};
	private static final String[] statisticAbbreviations = {"STR","DEX","CON","INT","WIS","CHA"};
	private int[] statistics;
	private int id;
	private int userID;
	private String characterName;
	
	public MyCharacter() {
		
	}
	
	public MyCharacter(int id, int userID, String characterName) {
		this.id = id;
		this.userID = userID;
		this.characterName = characterName;
		this.statistics = new int[6];
	}
	
	public MyCharacter(int id, int userID, String characterName, int[] statistics) {
		this.id = id;
		this.userID = userID;
		this.characterName = characterName;
		this.statistics = statistics;
	}
	
	public int[] getStatistics() {
		return statistics;
	}
	
	public void setStatistics(int[] statistics) {
		this.statistics = statistics;
	}
	
	public int getStatistic(int stat) {
		return statistics[stat];
	}
	
	public void setStatistic(int stat, int value) {
		statistics[stat] = value;
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
	
	public static String[] getStatisticNames() {
		return statisticNames;
	}

	public static String[] getStatisticAbbreviations() {
		return statisticAbbreviations;
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
