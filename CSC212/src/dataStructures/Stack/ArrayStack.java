package dataStructures.Stack;

import interfaces.Stack;

public class ArrayStack<T> implements Stack<T> {
	private int top;
	private int maxsize;
	private T[] nodes;
	
	@SuppressWarnings("unchecked")
	public  ArrayStack(int n) {
		maxsize=n;
		top=-1;
		nodes = (T[]) new Object[n];
	}
	

	@Override
	public void push(T e) {
		nodes[++top] = e;
	}

	@Override
	public T pop() {
		
		return nodes[top--];
	}

	@Override
	public boolean empty() {
		return top == -1;
	}

	@Override
	public boolean full() {
		return top == maxsize-1;
	}
	
	public void display() {
		for(int i=0; i<=top; i++) 
			System.out.print(nodes[i]);
		System.out.println();
		
	}



}
