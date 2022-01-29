package com.revature.phil_wentworth.services;

import com.revature.phil_wentworth.models.MyCharacter;

/*
 * generateMyCharacter, dumpStatistic, compareMyCharacters, 
 * isCharacterNameValid, rollStatistic, isStatisticValid, printCharacterStatisticsLine
 * */
public class MyCharacterService {
	public static int nextCharacterID = 0;
	
	// Load all MyCharacter objects from DAO so that nextCharacterID can be set appropriately
	static {
		
	}
	
	// done
	public MyCharacter generateMyCharacter(int userID, String characterName) {
		MyCharacter c = new MyCharacter(nextCharacterID, userID, characterName);
		nextCharacterID++;
		return c;
	}
	
	public boolean dumpStatistic(MyCharacter c, int fromID, int toID, int value) {
		return false;
	}
	
	// done
	public void compareMyCharacters(MyCharacter a, MyCharacter b) {
		int[] statsA = a.getStatistics();
		int[] statsB = b.getStatistics();
		for (int i=0; i<statsA.length; i++) {
			if (statsA[i] == statsB[i]) {
				System.out.println(a.getCharacterName() + " is equal to " + b.getCharacterName() + " in " + MyCharacter.statisticNames[i]);
			}
			else if (statsA[i] > statsB[i]) {
				System.out.println(a.getCharacterName() + " is greater than " + b.getCharacterName() + " in " + MyCharacter.statisticNames[i]);
			}
			else {
				System.out.println(b.getCharacterName() + " is greater than " + a.getCharacterName() + " in " + MyCharacter.statisticNames[i]);
			}
		}
	}
	
	public boolean isCharacterNameValid(String characterName) {
		return true;
	}
	
	public int rollStatistic() {
		return 0;
	}
	
	public boolean isStatisticValid(int statistic) {
		if (statistic >= 3 && statistic <= 18) {
			return true;
		}
		return false;
	}
	
	// done
	public void printCharacterStatisticLine(MyCharacter c) {
		int[] stats = c.getStatistics();
		for (int i=0; i<stats.length; i++) {
			System.out.print(stats[i] + "\t");
		}
		System.out.print("\n");
	}
}
