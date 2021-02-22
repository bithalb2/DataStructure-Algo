package com.subhra.ds.non_linear.tree.bst;

public class BinarySearchTreeDriver {

	public static void main(String[] args) {
		BinarySearchTree  tree = new BinarySearchTree();
		
		tree.add(20);
		tree.add(16);
		tree.add(24);
		tree.add(10);
		tree.add(5);
		tree.add(12);
		tree.add(18);
		tree.add(17);
		tree.add(22);
		tree.add(23);
		tree.add(26);
		
/*		tree.preOrderTraversal();
		tree.postOrderTraversal();
		tree.inOrderTraversal();
		tree.levelOrderTraversal();
		
		//for(int i = 0; i < 27; i++)
		//	System.out.println(i+ "   "+tree.search(i)+ "  "+tree.successor(i) + "  "+tree.predecessor(i));
		
		System.out.println(tree.findMaximum()+ "  "+ tree.findMinimum());
		
		System.out.println(tree.height());
		
		System.out.println(tree.search(5));
*/
		tree.levelOrderTraversal();
		
		tree.remove(22);
		
		tree.levelOrderTraversal();
		
		//tree.add(17);
		
		//tree.levelOrderTraversal();
	}

}
