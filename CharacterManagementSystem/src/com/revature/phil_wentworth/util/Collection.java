package com.revature.phil_wentworth.util;

public interface Collection<T> {
	boolean add(T element);
	boolean contains(T element);
	boolean isEmpty();
	boolean remove(T element);
	int size();
}
