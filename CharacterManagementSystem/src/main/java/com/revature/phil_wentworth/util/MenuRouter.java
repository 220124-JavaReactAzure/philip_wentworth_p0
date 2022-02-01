package com.revature.phil_wentworth.util;

import com.revature.phil_wentworth.menus.Menu;

public class MenuRouter {
	private final MyArrayList<Menu> menus;
	
	public MenuRouter() {
		menus = new MyArrayList<>();
	}
	
	public void addMenu(Menu menu) {
		menus.add(menu);
	}
	
	public void transfer(String route) throws Exception{
		for(int i = 0; i < menus.size(); i++) {
			Menu currentMenu = menus.get(i);
			if(currentMenu.getRoute().equals(route)) {
				currentMenu.render();
			}
		}
	}
	
}
