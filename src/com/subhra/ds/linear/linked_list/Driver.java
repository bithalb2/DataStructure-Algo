package com.subhra.ds.linear.linked_list;

public class Driver {

	public static void main(String[] args) {
		
		SinglyLinkedList list = new SinglyLinkedList();
		
		/*list.add(10);
		list.addAtEnd(20);
		list.addAtEnd(30);
		list.addAtEnd(40);
		list.addAtEnd(50);
		list.addAtEnd(60);*/
		/*list.add(70);
		list.add(60);
		list.add(55);
		list.add(80);
		list.add(90);
		list.add(30);
		list.add(1);*/
		
		
		/*
		 * System.out.println(list.length());
		 * 
		 * list.display();
		 * 
		 * System.out.println(list.search(10)); System.out.println(list.search(20));
		 * System.out.println(list.deleteIfExist(10));
		 * System.out.println(list.search(10));
		 */
		list.createLoop();
		
		//list.display();
		
		System.out.println(list.detectLoop());
		
		System.out.println(list.startNodeOfLoop());
		
		list.removeLoop();
		
		System.out.println(list.detectLoop());
		
		list.display();
		
		//System.out.println(list.replace(80,45));
		
		//list.display();
		
		//System.out.println(list.middleNode());

	}

}
