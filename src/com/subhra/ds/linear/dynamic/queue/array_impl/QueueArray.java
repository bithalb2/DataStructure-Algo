package com.subhra.ds.linear.dynamic.queue.array_impl;

import java.util.EmptyStackException;

import com.subhra.ds.linear.dynamic.queue.Queue;

public class QueueArray<T> implements Queue<T> {

	private Object[] array;
	private int front;
	private int rear;
	private int maxSize;
	
	public QueueArray(int maxSize) {
		this.maxSize = maxSize;
		this.array = new Object[maxSize];
		this.front = this.rear = -1;
	}
	
	private Object[] reSizeArray() {
		int newSize = this.maxSize * 2;
		Object[] newArray = new Object[newSize];
		for(int i = 0; i < this.maxSize; i++) {
			newArray[i] = this.array[this.front];
			this.front = (this.front + 1) % this.maxSize;
		}
		this.front = 0;
		this.rear = this.maxSize - 1;
		this.maxSize = newSize;
		return newArray;
	}
	
	@Override
	public void enqueue(T element) {
		if(this.isEmpty()) {
			this.front = this.rear = 0;
			this.array[front] = element;
		} else if(this.isFull()) {
			this.array = this.reSizeArray();
			this.rear = (this.rear + 1) % this.maxSize;
			this.array[this.rear] = element;
		} else {
			this.rear = (this.rear + 1) % this.maxSize;
			this.array[this.rear] = element;
		}
		
	}

	@Override
	public T dequeue() {
		if(this.isEmpty()) {
			throw new EmptyStackException();
		}
		
		Object newObject;
		if(this.front == this.rear) {
			newObject = this.array[this.front];
			this.front = this.rear = -1;
		} else {
			newObject = this.array[this.front];
			this.front = ((this.front + 1) % this.maxSize);
		}
		return (T) newObject;
	}

	@Override
	public T peek() {
		if(this.isEmpty()) {
			throw new EmptyStackException();
		}
		
		return (T) this.array[this.front];
	}

	@Override
	public boolean isEmpty() {
		if(this.front == -1 && this.rear == -1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {
		if((this.rear + 1) % this.maxSize == this.front) {
			return true;
		}
		return false;
	}

}
