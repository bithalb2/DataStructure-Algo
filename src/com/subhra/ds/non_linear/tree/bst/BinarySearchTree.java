package com.subhra.ds.non_linear.tree.bst;

import com.subhra.ds.linear.dynamic.queue.Queue;
import com.subhra.ds.linear.dynamic.queue.array_impl.QueueArray;
import com.subhra.ds.non_linear.tree.Tree;

public class BinarySearchTree implements Tree {

	private class Node {
		Integer element;
		Node leftChild;
		Node rightChild;
		Node parent;
		
		public Node(Integer element) {
			this.element = element;
		}
	}
	
	private Node root;
	
	public BinarySearchTree() {
		this.root = null;
	}

	@Override
	public void add(Integer element) {
		this.root = insert(root, element);
	}
	
	private Node insert(Node temp, Integer element) {
		if(temp == null) {
			temp = new Node(element);
			return temp;
		}
		if(element <= temp.element) {
			temp.leftChild = insert(temp.leftChild, element);
			temp.leftChild.parent = temp;
		} else {
			temp.rightChild = insert(temp.rightChild, element);
			temp.rightChild.parent = temp;
		}
		return temp;
	}

	@Override
	public Integer remove(Integer element) {
		root = delete(root, element);
		return null;
	}
	
	private Node delete(Node temp, Integer element) {
		if(temp == null)
			return temp;
		else if(element < temp.element)
			temp.leftChild = delete(temp.leftChild, element);
		else if(element > temp.element)
			temp.rightChild = delete(temp.rightChild, element);
		else {
			if(temp.leftChild == null && temp.rightChild == null) {
				temp.parent = null;
				temp = null;
			} else if(temp.leftChild == null) {
				temp.rightChild.parent = temp.parent;
				temp.parent = null;
				Node x = temp;
				temp = temp.rightChild;
				x.rightChild = null;
			} else if(temp.rightChild == null) {
				temp.leftChild.parent = temp.parent;
				temp.parent = null;
				Node x = temp;
				temp = temp.leftChild;
				x.leftChild = null;
			} else {
				Node min = minElement(temp.rightChild);
				Integer data = temp.element;
				temp.element = min.element;
				min.element = data;
				
				temp.rightChild = delete(temp.rightChild, element);
			}
		}
		return temp;
	}

	@Override
	public boolean search(Integer element) {
		Node temp = find(root, element);
		return temp == null ? false : true;
		//return findIterative(element) == null ? false : true;
	}
	
	private Node find(Node temp, Integer element) {
		if(temp == null || temp.element == element)
			return temp;
		if(element < temp.element)
			return find(temp.leftChild, element);
		else
			return find(temp.rightChild, element);
	}
	
	private Node findIterative(Integer element) {
		Node temp = root;
		while(temp != null) {
			if(element == temp.element) {
				return temp;
			} else if(element < temp.element)
				temp = temp.leftChild;
			else
				temp = temp.rightChild;
		}
		return null;
	}
	
	@Override
	public boolean isEmpty() {
		if(this.root == null) {
			return true;
		}
		return false;
	}
	
	public Integer height() {
		return heightHelper(root);
	}

	private Integer heightHelper(Node temp) {
		if (temp == null)
			return -1;
		return (Math.max(heightHelper(temp.leftChild), heightHelper(temp.rightChild)) + 1);
	}
	
	public Integer findMinimum() {
		Node temp = minElement(root);
		return temp == null ? null : temp.element;
	}
	
	private Node minElement(Node temp) {
		if(temp == null)
			return null;
		while(temp.leftChild != null)
			temp = temp.leftChild;
		return temp;
	}
	
	public Integer findMaximum() {
		Node temp = maxElement(root);
		return temp == null ? null : temp.element;
	}
	
	private Node maxElement(Node temp) {
		if(temp == null)
			return null;
		while(temp.rightChild != null)
			temp = temp.rightChild;
		return temp;
	}
	
	public void preOrderTraversal() {
		preTraversal(root);
		System.out.println();
	}
	
	private void preTraversal(Node temp) {
		if(temp == null) {
			return;
		}
		System.out.print(temp.element+"  ");
		preTraversal(temp.leftChild);
		preTraversal(temp.rightChild);
	}
	
	public void postOrderTraversal() {
		postTraversal(root);
		System.out.println();
	}
	
	private void postTraversal(Node temp) {
		if(temp == null) {
			return;
		}
		postTraversal(temp.leftChild);
		postTraversal(temp.rightChild);
		System.out.print(temp.element+"  ");
	}

	public void inOrderTraversal() {
		inTraversal(root);
		System.out.println();
	}
	
	private void inTraversal(Node temp) {
		if(temp == null)
			return;
		inTraversal(temp.leftChild);
		System.out.print(temp.element+"  ");
		inTraversal(temp.rightChild);
	}
	
	public void levelOrderTraversal() {
		Queue<Node> queue = new QueueArray<Node>(10);
		queue.enqueue(root);

		while(!queue.isEmpty()) {
			Node temp = queue.dequeue();
			if(temp.leftChild != null)
				queue.enqueue(temp.leftChild);
			if(temp.rightChild != null)
				queue.enqueue(temp.rightChild);
			
			System.out.print(temp.element+"  ");
		}
		System.out.println();
	}
	
	public Integer successor(Integer element) {
		Node temp = successorHelper(findIterative(element));
		return temp == null ? null : temp.element;
	}
	
	private Node successorHelper(Node temp) {
		if(temp != null) {
			if(temp.rightChild != null) {
				temp = temp.rightChild;
				while(temp.leftChild != null) {
					temp = temp.leftChild;
				}
				return temp;
			} else if(temp.parent.leftChild == temp) {
					return temp.parent;
			} else {
				while(temp != null) {
					if(temp.parent != null) {
						if(temp.parent.rightChild == temp)
							temp = temp.parent;
						else
							break;
					} else {
						return null;
					}
				}
				return temp.parent;
			}
		} else {
			return null;
		}
	}
	
	public Integer predecessor(Integer element) {
		Node temp = predecessorHelper(findIterative(element));
		return temp == null ? null : temp.element;
	}

	private Node predecessorHelper(Node temp) {
		if(temp != null) {
			if(temp.leftChild != null) {
				temp = temp.leftChild;
				while(temp.rightChild != null) {
					temp = temp.rightChild;
				}
				return temp;
			} else if(temp.parent.rightChild == temp) {
					return temp.parent;
			} else {
				while(temp != null) {
					if(temp.parent != null) {
						if(temp.parent.leftChild == temp)
							temp = temp.parent;
						else
							break;
					} else {
						return null;
					}
				}
				return temp.parent;
			}
		} else {
			return null;
		}
	}

}
