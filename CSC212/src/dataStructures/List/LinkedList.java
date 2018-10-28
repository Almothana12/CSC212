package dataStructures.List;

import interfaces.List;
import nodes.Node;

// TODO: Auto-generated Javadoc


/**
 * The Class LinkedList.
 *
 * @param <T> the generic type
 */
public class LinkedList<T> implements List<T> {
	
	/** The head. */
	private Node<T> head;
	
	/** The current. */
	private Node<T> current;

	/**
	 * Instantiates a new linked list.
	 */
	public LinkedList() {
		head = current = null;
	}
	
	/**
	 * @see List#empty()
	 */
	@Override
	public boolean empty() {
		return head == null;
	}
	
	/**
	 * @see List#last()
	 */
	@Override
	public boolean last() {
		return current.next == null;
	}
	
	/**
	 * @see List#full()
	 */
	@Override
	public boolean full() {
		return false;
	}
	
	/**
	 * @see List#update(java.lang.Object)
	 */
	@Override
	public void update(T e) {
		current.data = e;	
		}
	
	/**
	 * @see List#findFirst()
	 */
	@Override
	public void findFirst() {
		current = head;
	}
	
	/**
	 * @see List#findNext()
	 */
	@Override
	public void findNext() {
		current = current.next;
	}
	
	/**
	 * @see List#retrieve()
	 */
	
	public T retrieve() {
		return current.data;
	}
	
	/**
	 * @see List#remove()
	 */
	@Override
	public void remove() {
		Node<T> temp = head;

		if (current == head) {
			head = current.next;
			current = head;
		} else {
			while (temp.next != current)
				temp = temp.next;
			temp.next = current.next;
			current = current.next;
		}

		if (current == null)
			current = head;
	}

	/* *
	 * @see List#insert(java.lang.Object)
	 */
	@Override
	public void insert(T e) {
		Node<T> theNewNode = new Node<T>(e);
		Node<T> temp = current.next;

		if (head == null) {
			current = theNewNode;
			head = theNewNode;
		} else {
			current.next = theNewNode;
			theNewNode.next = temp;
			current = theNewNode;

		}

	}

}
