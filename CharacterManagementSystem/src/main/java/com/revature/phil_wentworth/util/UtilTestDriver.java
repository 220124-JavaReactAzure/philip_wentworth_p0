package com.revature.phil_wentworth.util;

public class UtilTestDriver {

	public static void main(String[] args) {
		MyArrayList<String> t = new MyArrayList<>(1);
		for (int i=0; i<t.size(); i++) {
			System.out.println(t.get(i));
		}
		t.add("1");
		t.add("2");
		t.add("3");
		t.add("4");
		t.add("5");
		for (int i=0; i<t.size(); i++) {
			System.out.println(t.get(i));
		}
		t.remove("1");
		t.remove("3");
		t.remove("5");
		for (int i=0; i<t.size(); i++) {
			System.out.println(t.get(i));
		}
	}

}
