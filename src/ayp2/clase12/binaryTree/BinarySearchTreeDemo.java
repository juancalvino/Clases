package ayp2.clase12.binaryTree;

import java.util.Iterator;

public class BinarySearchTreeDemo {
	
	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		
		
		Iterator<Integer> it;
		bst.insert(16);
		bst.insert(14);
		bst.insert(17);
		bst.insert(10);
		bst.insert(20);
		bst.insert(11);
		bst.insert(19);
		bst.insert(25);
		bst.insert(12);
		
		it = bst.inorderiterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		bst.remove(16);
		
		it = bst.inorderiterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	
	}

}
