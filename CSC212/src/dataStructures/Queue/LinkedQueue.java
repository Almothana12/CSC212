package dataStructures.Queue;

import interfaces.Queue;
import nodes.Node;

public class LinkedQueue<T> implements Queue<T> {
	private Node<T> head;
	private Node<T> tail;
	private int size;
	
	public LinkedQueue() {}

	@Override
	public T serve() {
		Node<T> tmp = head;
		head = head.next;
		size--;
		if(size == 0)
			tail = null;
		return tmp.data;
	}

	@Override
	public void enqueue(T e) {
		if(head == null)
			head = tail  = new Node<T>(e);
		else {
			tail.next = new Node<T>(e);
			tail = tail.next;
			
		}
		size++;
	}

	@Override
	public int length() {
		return size;
	}

	@Override
	public boolean full() {
		return false;
	}
	
	public void display() {
		Node<T> temp = head;
		while(temp!=null) {
			System.out.print(temp);
			temp = temp.next;
		}
		System.out.println();
	}
	

}
