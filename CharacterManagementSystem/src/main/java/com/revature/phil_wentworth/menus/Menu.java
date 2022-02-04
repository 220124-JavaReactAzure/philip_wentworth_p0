package com.revature.phil_wentworth.menus;

import java.io.BufferedReader;

import com.revature.phil_wentworth.util.MenuRouter;
import com.revature.phil_wentworth.util.logging.Logger;

public abstract class Menu {
	
	protected String name;
	protected String route;
	protected BufferedReader consoleReader;
	protected MenuRouter router;
	protected Logger logger;
	
	
	public Menu(String name, String route, BufferedReader consoleReader, MenuRouter router) {
		super();
		this.name = name;
		this.route = route;
		this.consoleReader = consoleReader;
		this.router = router;
		this.logger = Logger.getLogger(false);
	}

	public String getName() {
		return name;
	}

	public String getRoute() {
		return route;
	}
	
	public abstract void render() throws Exception;

}
