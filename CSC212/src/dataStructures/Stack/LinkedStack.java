package dataStructures.Stack;

import interfaces.Stack;
import nodes.Node;

public class LinkedStack<T> implements Stack<T>{
	//private
	public Node<T> top;
	
	@Override
	public void push(T e) {
		Node<T> temp = new Node<T>(e);
		temp.next = top;
		top = temp;
	}

	@Override
	public T pop() {
		T temp = top.data;
		top = top.next;
		return temp;
	}

	@Override
	public boolean empty() {
		return top == null;
	}

	@Override
	public boolean full() {
		return false;
	}
	@Override
	public void display() {
		Node<T> temp = top;
		while(temp!= null) {
			System.out.print(temp.data);
			temp = temp.next;
		}
		System.out.println();
		
	}

	

}
