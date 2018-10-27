package dataStructures.Queue;

import interfaces.Queue;

public class ArrayQueue<T> implements Queue<T>{
	private int maxSize;
	private int size;
	private int head, tail;
	private T[] nodes;
	
	@SuppressWarnings("unchecked")
	public ArrayQueue(int n) {
		maxSize = n;
		size=0;
		head=tail=0;
		nodes =(T[]) new Object[n];
	}

	@Override
	public void enqueue(T e) {
		nodes[tail] = e;
		tail = (tail+1) % maxSize;
		size++;
	}
	
	@Override
	public T serve() {
		T temp = nodes[head];
		head = ++head % maxSize;
		size--;
		return temp;
	}

	@Override
	public int length() {
		return size;
	}

	@Override
	public boolean full() {
		return size == maxSize;
	}

	
	@Override
	public void display() {
		for(int i=0; i<size; i++) {
			System.out.print(nodes[i]);
		}
		System.out.println();
	}

}
