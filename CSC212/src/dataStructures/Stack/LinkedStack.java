package dataStructures.Stack;

import nodes.Node;

public class LinkedStack<T> {
	//private
	public Node<T> top;
	
	
	public void push(T e) {
		Node<T> temp = new Node<T>(e);
		temp.next = top;
		top = temp;
	}

	
	public T pop() {
		T temp = top.data;
		top = top.next;
		return temp;
	}

	
	public boolean empty() {
		return top == null;
	}

	
	public boolean full() {
		return false;
	}

	
	public int multiPush(T[] els, int k) {
		int l=0;
		
		for(int i=0; i<k && i<els.length; i++) {
			push(els[i]);
//			els[i] = els[k+l];
			l++;
		}
		return l;
	}

	
	public int multiPop(T[] els, int k) {
		int l=0;
		
		for(int i=0; i<k && !empty(); i++) {
			els[i] = pop();
		}
		return l;
	}
	

}
