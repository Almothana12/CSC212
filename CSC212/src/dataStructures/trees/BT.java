package dataStructures.trees;

import dataStructures.Stack.LinkedStack;
import enums.Relative;
import nodes.BTNode;

public class BT<T> {
	
	BTNode<T> root;
	BTNode<T> current;
	
	public boolean empty() {
		return root==null;
	}
	
	public T retrieve() {
		return current.data;
	}
	
	public void update(T val) {
		current.data = val;
	}
	
	public boolean insert(Relative rel, T val) {
		switch (rel) {
		case Root:
			if(!empty()) return false;
			current = root = new BTNode<T> (val);
			return true;	
		case LeftChild:
			if(current.left != null) return false;
			current.left = new BTNode<T>(val);
			current = current.left;
			return true;
		case RightChild:
			if(current.right != null) return false;
			current.right = new BTNode<T>(val);
			current = current.right;
			return true;
		default:
			return false;
		}
	}
	
	public void deleteSubtree() {
		if(current == root) {
			current = root = null;
			return;
		}
		BTNode<T> p = current;
		find(Relative.Parent);
		if(current.left == p)
			current.left = null;
		else
			current.right = null;
		current = root;
	}

	public boolean find(Relative rel) {
		switch (rel) {
		case Root:
			current = root;
			return true;
		case Parent:
			if(current == root) return false;
			current = findparent(current, root);
			return true;
		case LeftChild:
			if(current.left == null) return false;
			current = current.left;
			return true;
		case RightChild:
			if(current.right == null) return false;
			current = current.right;
			return true;
		default:
			return false;
		}
		
	}
	
	// Non-recursive version of findparent – uses pre-order traversal
	private BTNode<T> findparent(BTNode<T> currnet, BTNode<T> root) {
		
		if(root == null) // if tree is empty;
			return null;
		
		LinkedStack<BTNode<T>> stack = new LinkedStack<>();
		
		BTNode<T> q = root;
		while(q.right != current || q.left != current) {
			if(q.right != null) 
				stack.push(q.right);
			
			if(q.left != null)
				q = q.left;
			else
				q = stack.pop();
		}
		return q;
	}
	
	@SuppressWarnings("unused")
	private BTNode<T> findparentREC(BTNode<T> p, BTNode<T> t) {
		if (t == null) // if tree is empty
			return null;
		if(t.left ==null && t.right == null) // if t is a leaf
			return null;
		if(t.left == p || t.right == p) // if found (t is a parent of p)
			return t;
		
		BTNode<T> q = findparentREC(p, t.left);
		if(q != null) // if found
			return q;
		return findparentREC(p, t.right);
	}
			

}
