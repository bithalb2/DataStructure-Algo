package com.subhra.ds.linear.dynamic.heap.impl;

import java.util.EmptyStackException;

import com.subhra.ds.linear.dynamic.heap.Heap;

public class MaxHeap implements Heap {

	private static final int DEFAULT_CAPACITY = 10;

	private Integer[] array;
	private int size;
	private int capacity;

	public MaxHeap() {
		this.array = new Integer[DEFAULT_CAPACITY + 1];
		this.capacity = DEFAULT_CAPACITY;
		this.size = 0;
	}

	public MaxHeap(int capacity) {
		this.array = new Integer[capacity + 1];
		this.capacity = capacity;
		this.size = 0;
	}

	public MaxHeap(Integer[] array) {
		if (array.length <= 0) {
			throw new NegativeArraySizeException();
		}
		this.capacity = array.length;
		this.array = new Integer[this.capacity + 1];
		for (Integer i : array)
			if (i != null)
				this.array[++this.size] = i;

		for (int i = this.size / 2; i >= 1; i--)
			this.heapify(i);
	}

	private Integer[] reSizeArray() {
		int newCapacity = this.capacity * 2;
		Integer[] newArray = new Integer[newCapacity + 1];
		for (int i = 1; i <= this.capacity; i++) {
			newArray[i] = this.array[i];
		}
		this.capacity = newCapacity;
		return newArray;
	}

	@Override
	public void add(Integer element) {
		if (this.isFull())
			this.array = this.reSizeArray();
		this.array[++this.size] = element;
		this.swim(size);
	}

	private void swim(int size) {
		while (size > 1 && this.array[size / 2] < this.array[size]) {
			swap(size, size / 2);
			size /= 2;
		}
	}

	private void swimRecursive(int size) {
		if (size <= 1)
			return;
		if (this.array[size] > this.array[size / 2]) {
			swap(size, size / 2);
			swimRecursive(size / 2);
		}
	}

	private void swap(int i, int j) {
		Integer temp = this.array[i];
		this.array[i] = this.array[j];
		this.array[j] = temp;
	}

	@Override
	public void display() {
		for (int i = 1; i <= size; i++)
			System.out.print(array[i] + "  ");
		System.out.println();
	}

	@Override
	public Integer remove() {
		if (this.isEmpty())
			throw new EmptyStackException();
		swap(1, this.size);
		this.size--;
		this.sink(1);
		return this.array[this.size + 1];
	}

	private void sinkRecursive(int size) {
		if ((size * 2) > this.size)
			return;
		int temp = (size * 2);
		if (temp < this.size && this.array[temp + 1] > this.array[temp])
			temp++;
		if (this.array[temp] > this.array[size]) {
			swap(temp, size);
			sinkRecursive(temp);
		}
	}

	private void sink(int size) {
		while ((size * 2) <= this.size) {
			int temp = size * 2;
			if (temp < this.size && this.array[temp + 1] > this.array[temp])
				temp++;
			if (this.array[temp] > this.array[size]) {
				swap(temp, size);
				size = temp;
			} else {
				break;
			}
		}
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean isFull() {
		return size == capacity;
	}

	@Override
	public int capacity() {
		return this.capacity;
	}

	@Override
	public void heapify(int index) {
		int largest = index;
		int leftChild = index * 2;
		int rightChild = (index * 2) + 1;

		if (leftChild <= this.size && this.array[leftChild] > this.array[largest])
			largest = leftChild;

		if (rightChild <= this.size && this.array[rightChild] > this.array[largest])
			largest = rightChild;

		if (index != largest) {
			swap(index, largest);
			heapify(largest);
		}
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public Integer top() {
		return this.size >= 1 ? this.array[1] : null;
	}

}
