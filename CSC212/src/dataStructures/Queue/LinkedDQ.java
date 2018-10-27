package dataStructures.Queue;

import interfaces.Deque;
import nodes.DoubleNode;;

public class LinkedDQ<T> implements Deque<T>{
	
	private int size;

	private DoubleNode<T> tail;
	private DoubleNode<T> head;

	
	@Override
	public void addFirst(T e) {
		DoubleNode<T> temp = new DoubleNode<T>(e);
		if(size==0) {
			head = tail = temp;
		}
		else {
			temp.next=head;
			head = temp;
		}
		size++;
		
	}

	@Override
	public void addLast(T e) {
		DoubleNode<T> newNode = new DoubleNode<T>(e);
		if(size==0) {
			head = tail = newNode;
		}
		else {
			tail.next = newNode;
			tail = newNode;
		}
		size++;
		
	}

	@Override
	public T removeFirst() {
		T temp = head.data;
		head = head.next;
		size--;
		return temp;
	}

	@Override
	public T removeLast() {
		T temp = tail.data;
		tail = tail.previous;
		size--;
		return temp;
	}

	@Override
	public T getFirst() {
		return head.data;
	}

	@Override
	public T getLast() {
		return tail.data;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

}
