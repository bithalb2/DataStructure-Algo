package com.subhra.ds.linear.linked_list;

public class SinglyLinkedList {
	
	private class Node {
		
		int data;
		Node next;
		
		Node(int data) {
			super();
			this.data = data;
			this.next = null;
		}
		
	}
	
	private Node head;
	
	public SinglyLinkedList() {
		super();
		this.head = null;
	}
	
	// This method will add new node based on natural sorting order
	public void add(int data) {
		Node newNode = new Node(data);
		
		if(head == null) {
			head = newNode;
		} else if(head.data >= data){
			newNode.next = head;
			head = newNode;
		} else {
			Node temp = null, currentPtr = head;
			while(currentPtr != null && currentPtr.data < data) {
				temp = currentPtr;
				currentPtr = currentPtr.next;
			}
			temp.next = newNode;
			newNode.next = currentPtr;
		}
	}
	
	// This method will add new node at the start of the Linked List
	public void addAtBegin(int data) {
		Node newNode = new Node(data);
		
		newNode.next = head;
		head = newNode;
	}
	
	// This method will add new node at the end of the Linked List
	public void addAtEnd(int data) {
		Node newNode = new Node(data);
		
		if(head == null)
			head = newNode;
		else {
			Node temp = head;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
	}
	
	// This method will add new node at the given position negative 
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
			
			Node fwd = temp.next;
			newNode.next = fwd;
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
		
		int data = head.data;
		Node temp = head.next;
		head.next = null;
		head = temp;
		return data;
	}
	
	// This method will delete last node from the Linked List
	public int deleteLast() {
		if(head == null) {
			System.out.println("Cann't delete node as the Linked List is empty...");
			System.exit(0);
		}
		
		if(head.next == null) {
			int data = head.data;
			head = null;
			return data;
		} else {
			Node temp = head;
			while(temp.next.next != null) {
				temp = temp.next;
			}
			int data = temp.next.data;
			temp.next = null;
			return data;
		}
	}
	
	// This method will delete the given node if exist
	public boolean deleteIfExist(int data) {
		if(head == null) {
			System.out.println("Cann't delete node as the Linked List is empty...");
			System.exit(0);
		}
		
		if(head.data == data) {
			Node temp = head.next;
			head.next = null;
			head = temp;
			return true;
		} else {
			Node current = head.next, temp = head;
			while(current != null) {
				if(current.data == data) {
					Node fwd = current.next;
					current.next = null;
					temp.next = fwd;
					return true;
				}
				temp = current;
				current = current.next;
			}
			return false;
		}
		
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
		
		Node slowPtr = head, fastPtr = head.next;
		while(fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
		}
		return slowPtr.data;
	}
	
	// This method will reverse the Linked List
	public void reverse() {
		if(head == null || head.next == null) {
			return;
		}
		
		Node previousPtr = null, currentPtr = head, nextPtr = null;
		while(currentPtr != null) {
			nextPtr = currentPtr.next;
			currentPtr.next = previousPtr;
			previousPtr = currentPtr;
			currentPtr = nextPtr;
		}
		head = previousPtr;
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
	
	// This method will find the nth node from the end of the Linked List
	public int nthNodeFromEnd(int position) {
		if(head == null) {
			System.out.println("Cann't search node as the Linked List is empty...");
			System.exit(0);
		}
		
		Node currentPtr = head, nextPtr = head;
		while(position-- > 0) {
			if(nextPtr != null) {
				nextPtr = nextPtr.next;
			} else {
				System.out.println("Cann't find the position as the Linked List have less number of nodes...");
				System.exit(0);
			}
		}
		while(nextPtr != null) {
			nextPtr = nextPtr.next;
			currentPtr = currentPtr.next;
		}
		return currentPtr.data;
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
		if(head != null) {
			Node temp = head;
			repeat(temp);
		}
		System.out.println("null");
	}
	// This is the helper method for "displayReverse()" method
	private void repeat(Node temp) {
		if(temp == null) {
			return;
		} else {
			repeat(temp.next);
			System.out.print(temp.data + " --> ");
		}
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
	
	// This method will create a Linked List with Loop
	public void createLoop() {
		Node first = new Node(10);
		Node second = new Node(20);
		Node third = new Node(30);
		Node fourth = new Node(40);
		Node fifth = new Node(50);
		Node sixth = new Node(60);
		
		this.head = first;
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = sixth;
		sixth.next = first;
	}
	
	// This method will detect the Loop in Linked List
	public boolean detectLoop() {
		if(head == null) {
			return false;
		}
		
		Node slowPtr = head, fastPtr = head;
		while(fastPtr.next != null && fastPtr.next.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
			if(slowPtr == fastPtr) {
				return true;
			}
		}
		return false;
	}
	
	// This method will find the Start Node of the loop in Linked List
	public Integer startNodeOfLoop() {
		if(head == null) {
			return null;
		}
		
		Node slowPtr = head, fastPtr = head;
		while(fastPtr.next != null && fastPtr.next.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
			if(slowPtr == fastPtr) {
				return getStartNode(slowPtr).data;
			}
		}
		return null;
	}
	
	// This is the helper method for 'startNodeOfLoop()' method
	private Node getStartNode(Node slowPtr) {
		Node temp = head;
		while(temp != slowPtr) {
			temp = temp.next;
			slowPtr = slowPtr.next;
		}
		return temp;
	}
	
	// This method will remove Loop from the Linked List
	public void removeLoop() {
		if(head == null) {
			return;
		}
		
		Node slowPtr = head, fastPtr = head;
		while(fastPtr.next != null && fastPtr.next.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
			if(slowPtr == fastPtr) {
				removeLink(slowPtr);
				return;
			}
		}
	}
	
	private void removeLink(Node slowPtr) {
		Node temp = head;
		
		while(temp.next != slowPtr.next) {
			temp = temp.next;
			slowPtr = slowPtr.next;
		}
		
		if(slowPtr == head) {
			temp = head;
			while(temp.next != head) {
				temp = temp.next;
			}
			temp.next = null;
		} else {
			slowPtr.next = null;
		}
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
