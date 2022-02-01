package com.revature.phil_wentworth.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.revature.phil_wentworth.menus.WelcomeMenu;

public class AppState {

	private static boolean isRunning;
	private final MenuRouter router;
	
	public AppState() {
		isRunning = true;
		router = new MenuRouter();
		BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
		router.addMenu(new WelcomeMenu(consoleReader, router));
	}
	
	public void startup() {
		try {
			while(isRunning) {
				router.transfer("/welcome");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void shutdown() {
		isRunning = false;
	}
	
}
