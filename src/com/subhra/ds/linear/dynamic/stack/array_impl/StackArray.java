package com.subhra.ds.linear.dynamic.stack.array_impl;

import java.util.EmptyStackException;

import com.subhra.ds.linear.dynamic.stack.Stack;

public class StackArray<T> implements Stack<T> {

	private Object[] array;
	private int top;
	private int maxSize;
	
	public StackArray(int maxSize) {
		this.maxSize = maxSize;
		this.array = new Object[maxSize];
		this.top = -1;
	}
	
	private Object[] reSizeArray() {
		int newSize = this.maxSize * 2;
		Object[] newArray = new Object[newSize];
		for(int i = 0; i < this.maxSize; i++) {
			newArray[i] = this.array[i];
		}
		this.maxSize = newSize;
		return newArray;
	}
	
	@Override
	public void push(T element) {
		if(this.isFull()) {
			this.array = this.reSizeArray();
			this.array[++this.top] = element;
		} else {
			this.array[++this.top] = element;
		}
	}

	@Override
	public T pop() {
		if(this.isEmpty()) {
			throw new EmptyStackException();
		}
		return (T) this.array[this.top--];
	}

	@Override
	public T peek() {
		if(this.isEmpty()) {
			throw new EmptyStackException();
		}
		return (T) this.array[top];
	}

	@Override
	public boolean isEmpty() {
		return this.top == -1;
	}

	@Override
	public boolean isFull() {
		return this.top == this.maxSize - 1;
	}

}
