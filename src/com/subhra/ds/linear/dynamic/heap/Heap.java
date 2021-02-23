package com.subhra.ds.linear.dynamic.heap;

public interface Heap {
	void add(Integer element);
	Integer remove();
	Integer top();
	boolean isEmpty();
	boolean isFull();
	int capacity();
	int size();
	void display();
	void heapify(int index);
}
