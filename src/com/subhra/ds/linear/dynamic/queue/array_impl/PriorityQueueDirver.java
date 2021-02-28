package com.subhra.ds.linear.dynamic.queue.array_impl;

import com.subhra.ds.linear.dynamic.queue.array_impl.PriorityQueue.PriorityType;

public class PriorityQueueDirver {

	public static void main(String[] args) {
		
		PriorityQueue queue = new PriorityQueue(5, PriorityType.MAX);
		
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		queue.enqueue(60);
		queue.enqueue(70);
		
		queue.show();
		System.out.println(queue.dequeue());
		queue.show();

	}

}
