package dataStructures.Queue;

import enums.Priority;
import interfaces.PriorityQueue;
import nodes.PQElement;
import nodes.PQNode;



public class LinkedPriorityQueue<T> implements PriorityQueue<T>{
	private int size;
	private PQNode<T> head;
	
	@Override
	public PQElement<T> serve() {
//		PQNode<T> node = head;
		PQElement<T> pqe = new PQElement<T>(head.data, head.priority);
		head = head.next;
		size--;
		return pqe;
	}

	@Override
	public void enqueue(T e, Priority pty) {
		PQNode<T> temp = new PQNode<T>();

		if( size==0 || pty.compare(head.priority)>0) {
			temp.next = head;
			head = temp;
		}
		else {
			PQNode<T> p = head;
			PQNode<T> q = null;
			while(p!=null && pty.compare(p.priority) <=0) {
				q=p;
				p=p.next;
			}
			temp.next = p;
			q.next = temp;
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
	

}
