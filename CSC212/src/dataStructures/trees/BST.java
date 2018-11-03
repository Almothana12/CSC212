package dataStructures.trees;

import nodes.BSTNode;

public class BST<T> {
	private BSTNode<T> root;
	private BSTNode<T> current;
	
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
		BSTNode<T> p = root;
		BSTNode<T> q = root; // the parent of p
		
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
		BSTNode<T> newNode;              // the new node to be inserted in tree
		BSTNode<T> oldCurrent = current; // save the current
		
		if(find(key)) { // if key is already in tree
			current = oldCurrent; // return the current to it's old state
			return false;
		}
		
		newNode = new BSTNode<T>(key, data);
		if(empty()) {
			root = current = newNode;
			return true;
		}
		
		if( key < current.key)
			current.left = newNode;
		else
			current.right = newNode;
		
		current = newNode;
		return true;
	}
	
	public boolean remove(int key) {
		Boolean removed = new Boolean(false);
		BSTNode<T> p;
		p = _remove(key, root, removed);
		current = root = p;
		return removed.booleanValue();
	}

	private BSTNode<T> _remove(int key, BSTNode<T> p, Boolean removed) {
		BSTNode<T> q;
		BSTNode<T> child = null;
		if(p==null)
			return null;
		if(key<p.key)
			p.left = _remove(key, p.left, removed);
		else if(key> p.key)
			p.right = _remove(key, p.right, removed);
		else {
			removed =true;
			if(p.left != null && p.right != null) {
				q = findMin(p.right);
				p.key = q.key;
				p.data = q.data;
				p.right = _remove(q.key, p.right, removed);
			} else {
				if (p.right == null)
					child = p.left;
				else if(p.right == null)
					child = p.right;
				return child;
			}
				
		}		
		return p;
	}

	private BSTNode<T> findMin(BSTNode<T> p) {
		if (p == null) 
			return null;

		while(p.left != null)
			p = p.left;
		
		return p;
	}
	
	public boolean update(int key, T data) {
		remove(current.key);
		return insert(key, data);
		
	}
}