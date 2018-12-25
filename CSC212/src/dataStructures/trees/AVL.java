package dataStructures.trees;



enum Balance {
	mTWO(-2), mONE(-1), ZERO(0), pONE(1), pTWO(2);
	
	int value;
	
	private Balance(int value) {
		this.value = value;
	}
	
	int combareTo(Balance b1, Balance b2) {
		return b1.value - b2.value;
	}
	
}

class Node<T> {
	public int key;
	public T data;
	public Balance bal;
	public Node<T> left, right;
	 
	public Node(int key, T data) {
		this.key = key;
		this.data = data;
		bal = Balance.ZERO;
		left = right = null;
	}
}


public class AVL<T extends Comparable<T>> extends BST<T> {

	private Node<T> root;
	private Node<T> current;
	
	public boolean insert(int key, T data) {
		if(super.insert(key, data)) {
			rebalance(root);
			return true;
		}
		return false;
	}
	
	
	public boolean remove(int key) {
		return false;
	}
	
	public Node<T> rebalance(Node<T> n) {
		
		int heightDifference = getHeightDifference(n);
		
		if (heightDifference > 1) {
			// Left subtree is taller by more than 1
			// addition was in left tree
			if (getHeightDifference(n.left) > 0)
				// addition was in left subtree of left child
				n = rotateRight(n);
			else
				//addition was is left subtree of right child
				n = rotateLeftRight(n);
		}
		else if (heightDifference < -1) {
			if (getHeightDifference(n.right) < 0)
				// addition was in right subtree of right child
				n = rotateLeft(n);
			else
				// addition was in left subtree of right child
				n = rotateRightLeft(n);
		}
		//else n is balanced
		
		return n;
	}
	private Node<T> rotateRightLeft(Node<T> n) {
		// TODO Auto-generated method stub
		return null;
	}


	private Node<T> rotateLeftRight(Node<T> n) {
		// TODO Auto-generated method stub
		return null;
	}


	private Node<T> rotateRight(Node<T> n) {
		// TODO Auto-generated method stub
		return null;
	}


	private Node<T> rotateLeft(Node<T> n) {
		// TODO Auto-generated method stub
		return null;
	}

	private int getHeightDifference(Node<T> n) {
		// TODO Auto-generated method stub
		return 0;
	}


	
	
	
}





