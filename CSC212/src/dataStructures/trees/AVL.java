package dataStructures.trees;

import nodes.AVLNode;

public class AVL<T> {

	private AVLNode<T> root;
	private AVLNode<T> current;
	
	public boolean empty() {
		return root == null;
	}
	
	public boolean full() {
		return false;
	}
	
	public T retrieve() {
		return current.data;
	}
	
	public boolean find(int key) {
		AVLNode<T> p = root;
		AVLNode<T> q = root; // the parent of p
		
		if(empty())
			return false;
		
		while(p!=null) {
			q = p;
			if(p.key == key) {
				current = p;
				return true;
			}
			if(key < p.key)
				p = p.left;
			else
				p = p.right;
		}
		
		current = q;
		return false;
	}
	
	public boolean insert(int key, T data) {
		return false;
	}
	
	
	public boolean remove(int key) {
		return false;
	}
	
	
	
}


