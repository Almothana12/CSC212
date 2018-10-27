package dataStructures.List;


import nodes.DoubleNode;

public class DoubleLinkedList<T> {

	private DoubleNode<T> head;
	private DoubleNode<T> current;



	public void findFirst() {
		current = head;
	}

	public void findNext() {
		current = current.next;
	}

	public void findPrevious() {
		current = current.previous;
	}

	public T retrieve() {
		return current.data;
	}

	public void update(T e) {
		current.data = e;
	}

	public void insert(T e) {
		DoubleNode<T> newNode = new DoubleNode<T>(e);
		if (empty())
			current = head = newNode;
		else {
			newNode.previous = current;
			newNode.next = current.next;
			if (current.next != null)
				current.next.previous = newNode;
			current.next = newNode;
			current = newNode;
		}

	}


	public void remove() {
		if (head == current) {
			current = current.next;
			head = head.next;
			if (head != null)
				head.previous = null;
		} else {
			current.previous.next = current.next;
			if (last())
				current = head;
			else { // if Not last
				current.next.previous = current.previous;
				current = current.next;
			}
		}
	}



	public boolean full() {
		return false;
	}

	public boolean empty() {
		return head == null;
	}
	
	public boolean first(){
		return current == head;
	}

	public boolean last() {
		return current.next == null;
	}
	
	public void display() {
		DoubleNode<T> temp = head;
		while(temp!= null) {
			System.out.print(temp.data);
			temp = temp.next;
		}
		System.out.println();
	}

}
