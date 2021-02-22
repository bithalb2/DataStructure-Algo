package com.subhra.ds.linear.dynamic.linked_list;

public class Driver {

	public static void main(String[] args) {
		
		DoublyLinkedList list = new DoublyLinkedList();
		
		list.addAtBegin(50);
		list.addAtBegin(40);
		list.addAtBegin(30);
		list.addAtBegin(20);
		//list.addAtBegin(10);
		
		list.display();
		
		System.out.println(list.nthNodeFromEnd(2));
		
		//list.display();
	}

}
