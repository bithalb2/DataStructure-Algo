package com.subhra.ds.linear.dynamic.linked_list;

public class DoublyLinkedList {
	
	private class Node {
		
		int data;
		Node previous;
		Node next;
		
		Node(int data) {
			super();
			this.data = data;
			this.next = null;
			this.previous = null;
		}
		
	}
	
	private Node head;
	private Node tail;
	
	public DoublyLinkedList() {
		super();
		this.head = null;
	}
	
	// This method will add new node at the start of the Linked List
	public void addAtBegin(int data) {
		Node newNode = new Node(data);
		
		if(head == null) {
			head = tail = newNode;
		} else {
			head.previous = newNode;
			newNode.next = head;
			head = newNode;
		}
	}

	// This method will add new node at the end of the Linked List
	public void addAtEnd(int data) {
		Node newNode = new Node(data);
		
		if(tail == null) {
			head = tail = newNode;
		} else {
			newNode.previous = tail;
			tail.next = newNode;
			tail = newNode;
		}
	}
	
	// This method will add new node at the given position
	public void addAtGivenPosition(int data, int position) {
		if(position < 1) {
			System.out.println("Invalid Position value... position cann't be ZERO or NEGATIVE");
			System.exit(0);
		}
		
		if(position == 1)
			addAtBegin(data);
		else if(position < (length() + 1)) {
			Node newNode = new Node(data);
			
			Node temp = head;
			while(--position != 1) {
				temp = temp.next;
			}
			
			newNode.next = temp.next;
			newNode.previous = temp;
			temp.next.previous = newNode;
			temp.next = newNode;
		}
		else
			addAtEnd(data);
	}
	
	// This method will delete first node from the Linked List
	public int deleteFirst() {
		if(head == null) {
			System.out.println("Cann't delete node as the Linked List is empty...");
			System.exit(0);
		}
		
		if(head.next == null) {
			int data = head.data;
			head = tail = null;
			return data;
		} else {
			int data = head.data;
			head = head.next;
			head.previous.next = null;
			head.previous = null;
			return data;
		}
	}
	
	// This method will delete last node from the Linked List
	public int deleteLast() {
		if(tail == null) {
			System.out.println("Cann't delete node as the Linked List is empty...");
			System.exit(0);
		}
		
		if(tail.previous == null) {
			int data = tail.data;
			head = tail = null;
			return data;
		} else {
			int data = tail.data;
			tail = tail.previous;
			tail.next.previous = null;
			tail.next = null;
			return data;
		}
	}
	
	// This method will delete the given node if exist
	public boolean deleteIfExist(int data) {
		if(head == null) {
			System.out.println("Cann't delete node as the Linked List is empty...");
			System.exit(0);
		}
		
		Node temp = head;
		while(temp != null) {
			if(temp.data == data) {
				if(temp == head) {
					deleteFirst();
					return true;
				}
				
				if(temp == tail) {
					deleteLast();
					return true;
				}
				
				temp.previous.next = temp.next;
				temp.next.previous = temp.previous;
				temp.previous = temp.next = null;
				return true;
			} else {
				temp = temp.next;
			}
		}
		return false;
	}
	
	// This method will search whether the node is present in Linked List or not
	public boolean search(int data) {
		if(head == null) {
			System.out.println("Cann't search node as the Linked List is empty...");
			System.exit(0);
		}
		
		Node temp = head;
		while(temp != null) {
			if(temp.data == data)
				return true;
			temp = temp.next;
		}
		return false;
	}
	
	// This method will find the middle element or element's of the Linked List
	public int middleNode() {
		if(head == null) {
			System.out.println("Cann't search node as the Linked List is empty...");
			System.exit(0);
		}
		
		Node tempHead = head, tempTail = tail;
		while(tempHead.next != tempTail && tempHead != tempTail) {
			tempHead = tempHead.next;
			tempTail = tempTail.previous;
		}
		return tempHead.data;
	}
	
	// This method will find the nth node from the start of the Linked List
	public int nthNodeFromStart(int position) {
		if(head == null) {
			System.out.println("Cann't search node as the Linked List is empty...");
			System.exit(0);
		}
		
		Node temp = head;
		while(position-- > 1) {
			if(temp.next == null) {
				System.out.println("Cann't find the position as the Linked List have less number of nodes...");
				System.exit(0);
			}
			temp = temp.next;
		}
		return temp.data;
	}
	
	// This method will find the nth node from the start of the Linked List
	public int nthNodeFromEnd(int position) {
		if(tail == null) {
			System.out.println("Cann't search node as the Linked List is empty...");
			System.exit(0);
		}
		
		Node temp = tail;
		while(position-- > 1) {
			if(temp.previous == null) {
				System.out.println("Cann't find the position as the Linked List have less number of nodes...");
				System.exit(0);
			}
			temp = temp.previous;
		}
		return temp.data;
	}
	
	// This method will replace one given node with new node
	public boolean replace(int oldNode, int newNode) {
		if(head == null) {
			return false;
		}
		
		Node temp = head;
		while(temp != null) {
			if(temp.data == oldNode) {
				temp.data = newNode;
				return true;
			}
			temp = temp.next;
		}
		return false;
	}
	
	// This method will remove the duplicate nodes from Sorted Linked List
	public void removeDuplicates() {
		if(head == null) {
			return;
		}
		
		Node previousPtr = head, currentPtr = head.next;
		while(currentPtr != null) {
			if(previousPtr.data != currentPtr.data) {
				previousPtr = currentPtr;
				currentPtr = currentPtr.next;
			} else {
				previousPtr.next = currentPtr.next;
				currentPtr = currentPtr.next;
			}
		}
	}
	
	// This method will display the Linked List
	public void display() {
		Node temp = head;
		
		while(temp != null) {
			System.out.print(temp.data+ " --> ");
			temp = temp.next;
		}
		System.out.println("null");
	}
	
	// This method will display the Linked List in reverse order
	public void displayReverse() {
		Node temp = tail;
			
		while(temp != null) {
			System.out.print(temp.data+ " --> ");
			temp = temp.previous;
		}
		System.out.println("null");
	}
	
	// This method will find the length of the Linked List
	public int length() {
		if(head == null)
			return 0;
		else {
			int count = 0;
			
			Node temp = head;
			while(temp != null) {
				count++;
				temp = temp.next;
			}
			return count;
		}
	}
	
}
