package com.revature.phil_wentworth.util;

public class MyArrayList<T> implements MyList<T> {
	private int maxSize;
	private int currentSize;
	private T[] elements;
	
	@SuppressWarnings("unchecked")
	public MyArrayList() {
		this.maxSize = 10;
		this.currentSize = 0;
		this.elements = (T[]) new Object[maxSize];
	}
	
	@SuppressWarnings("unchecked")
	public MyArrayList(int size) {
		if (size > 0) {
			this.maxSize = size;
			this.currentSize = 0;
			this.elements = (T[]) new Object[maxSize];
		}
		else {
			throw new IllegalArgumentException("Cannot create an ArrayList with initial size less than 1");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean add(T element) {
		if (currentSize > maxSize * .75 || currentSize == 1) {
			maxSize *= 2;
			T[] biggerArray = (T[]) new Object[maxSize];
			for (int i=0; i<currentSize; i++) {
				biggerArray[i] = elements[i];
			}
			elements = biggerArray;
		}
		elements[currentSize] = element;
		currentSize ++;
		return true;
	}

	@Override
	public boolean contains(T element) {
		for (int i=0; i<currentSize; i++) {
			if (elements[i].equals(element)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		if (this.currentSize == 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean remove(T element) {
		for (int i=0; i<currentSize; i++) {
			if (elements[i].equals(element)) {
				int numMoved = currentSize - i - 1;
				if (numMoved > 0) {
					System.arraycopy(elements, i+1, elements, i, numMoved);
				}
				elements[currentSize--] = null;
				return true;
			}
		}
		return false;
	}

	@Override
	public int size() {
		return this.currentSize;
	}
	
	@Override
	public T get(int index) {
		return elements[index];
	}
}
