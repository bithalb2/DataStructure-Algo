package com.subhra.ds.linear.dynamic.queue.array_impl;

import com.subhra.ds.linear.dynamic.heap.Heap;
import com.subhra.ds.linear.dynamic.heap.impl.MaxHeap;
import com.subhra.ds.linear.dynamic.heap.impl.MinHeap;

public class PriorityQueue {
	
	enum PriorityType {
		MAX,MIN;
	}

	private Heap heap;
	
	public PriorityQueue(PriorityType priorityType) {
		if(priorityType == PriorityType.MAX) 
			this.heap = new MaxHeap();
		else
			this.heap = new MinHeap();
	}
	
	public PriorityQueue(int capacity, PriorityType priorityType) {
		if(priorityType == PriorityType.MAX)
			this.heap = new MaxHeap(capacity);
		else
			this.heap = new MinHeap(capacity);
	}
	
	public PriorityQueue(Integer[] array, PriorityType priorityType) {
		if(priorityType == PriorityType.MAX)
			this.heap = new MaxHeap(array);
		else
			this.heap = new MinHeap(array);
	}
	
	void enqueue(Integer element) {
		heap.add(element);
	}
	
	Integer dequeue() {
		return heap.remove();
	}
	
	Integer peek() {
		return heap.top();
	}
	
	boolean isEmpty() {
		return heap.isEmpty();
	}
	
	boolean isFull() {
		return heap.isFull();
	}
	
	void show() {
		heap.display();
	}
}
