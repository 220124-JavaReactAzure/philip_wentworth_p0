package com.revature.phil_wentworth.services;

import com.revature.phil_wentworth.daos.MyCharacterDAO;
import com.revature.phil_wentworth.exceptions.InvalidCharacterNameException;
import com.revature.phil_wentworth.exceptions.InvalidStatisticException;
import com.revature.phil_wentworth.models.MyCharacter;
import com.revature.phil_wentworth.util.MyArrayList;

public class MyCharacterService {
	
	private UserService userService;
	private MyCharacterDAO myCharacterDAO;
	private MyArrayList<MyCharacter> activeCharacters;
	public static final int min_dump_stat = 9;
	public static final int min_stat = 3;
	public static final int max_stat = 18;
	
	public MyCharacterService(MyCharacterDAO myCharacterDAO, UserService userService) {
		this.myCharacterDAO = myCharacterDAO;
		this.userService = userService;
	}
	
	public MyCharacter generateMyCharacter(String characterName) throws InvalidCharacterNameException {
		if (userService.getSessionUser() == null) {
			return null;
		}
		String userEmail = userService.getSessionUser().getEmail();
		if (!isCharacterNameValid(characterName)) {
			throw new InvalidCharacterNameException("Character names can only contain letters and spaces.");
		}
		int[] stats = new int[6];
		for (int i=0; i<stats.length; i++) {
			stats[i] = rollStatistic();
		}
		MyCharacter c = new MyCharacter(0, userEmail, characterName);
		c.setStatistics(stats);
		myCharacterDAO.create(c);
		return c;
	}
	
	public MyArrayList<MyCharacter> getCharactersForUser() {
		if (userService.getSessionUser() == null) {
			return null;
		}
		String userEmail = userService.getSessionUser().getEmail();
		activeCharacters = (MyArrayList<MyCharacter>) myCharacterDAO.getMyCharactersByEmail(userEmail);
		return activeCharacters;
	}
	
	public void dumpStatistic(MyCharacter c, int fromID, int toID, int value) throws InvalidStatisticException {
		if (value<0) {
			throw new InvalidStatisticException("Minimum dump value is 1.");
		}
		
		String[] statNames = MyCharacter.getStatisticNames();
		
		int newFromValue = c.getStatistic(fromID) - value;
		if ( (!isStatisticValid(newFromValue)) || newFromValue<min_dump_stat ) {
			throw new InvalidStatisticException(statNames[fromID] + " ends up too low, try dumping fewer points. You cannot dump a stat so that its new value is less than " + min_dump_stat + ".");
		}
		
		int newToValue = c.getStatistic(toID) + value;
		if (!isStatisticValid(newToValue)) {
			throw new InvalidStatisticException(statNames[toID] + " ends up too high, try dumping fewer points. You cannot pump a stat so that its new value is above" + max_stat + ".");
		}
		
		c.setStatistic(fromID, newFromValue);
		c.setStatistic(toID, newToValue);
		myCharacterDAO.update(c);
		
		System.out.println("Moved " + value + " points from " + statNames[fromID] + " to " + statNames[toID]);
	}

	
	public boolean compareMyCharacters(MyCharacter a, MyCharacter b) {
		int[] statsA = a.getStatistics();
		int[] statsB = b.getStatistics();
		String[] statNames = MyCharacter.getStatisticNames();
		for (int i=0; i<statsA.length; i++) {
			if (statsA[i] == statsB[i]) {
				System.out.println(a.getCharacterName() + " is equal to " + b.getCharacterName() + " in " + statNames[i]);
			}
			else if (statsA[i] > statsB[i]) {
				System.out.println(a.getCharacterName() + " is greater than " + b.getCharacterName() + " in " + statNames[i] + " by " + (statsA[i] - statsB[i]));
			}
			else {
				System.out.println(b.getCharacterName() + " is greater than " + a.getCharacterName() + " in " + statNames[i] + " by " + (statsB[i] - statsA[i]));
			}
		}
		return true;
	}
	
	public boolean isCharacterNameValid (String characterName){
		char[] letters = characterName.toCharArray();
		
		for (int i=0; i<letters.length; i++) {
			if (! ((letters[i] >= 'A' && letters[i] <= 'Z') || (letters[i] >= 'a' && letters[i] <= 'z') || letters[i]==' ') ) {
				return false;
			}
		}
		
		return true;
	}
	
	public int roll(int sides) {
		int result = (int) (Math.random() * sides) + 1;
		return result;
	}
	
	public int rollStatistic() {
		return roll(6) + roll(6) + roll(6);
	}
	
	public boolean isStatisticValid(int statistic) {
		if (statistic >= min_stat && max_stat <= 18) {
			return true;
		}
		return false;
	}
	
	public void printCharacterStatisticLine(MyCharacter c) {
		int[] stats = c.getStatistics();
		for (int i=0; i<stats.length; i++) {
			System.out.print(stats[i] + "\t");
		}
		System.out.print("\n");
	}
	
	public void logout() {
		activeCharacters = null;
		userService.logout();
	}
}
