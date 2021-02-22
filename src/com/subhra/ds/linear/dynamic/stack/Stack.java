package com.subhra.ds.linear.dynamic.stack;

public interface Stack<T> {
	void push(T element);
	T pop();
	T peek();
	boolean isEmpty();
	boolean isFull();
}
