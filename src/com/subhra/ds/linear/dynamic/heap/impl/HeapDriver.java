package com.subhra.ds.linear.dynamic.heap.impl;

public class HeapDriver {

	public static void main(String[] args) {
		
		Integer[] array = new Integer[10];
		
		for(int i = 0; i < 10; i++)
			array[i] = 10 - i;
			
		MinHeap heap = new MinHeap(array);
		
		//for(int i = 1; i <= 10; i++)
		heap.add(0);
		
		
		System.out.println(heap.capacity());
		System.out.println(heap.size());
		heap.display();
		
		System.out.println(heap.remove());
		
		heap.display();
		
		//for(int i = 10; i >= 1; i--) {
			//System.out.println(heap.remove());
			//heap.display();
		//}

	}

}
