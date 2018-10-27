package dataStructures.List;

import nodes.Node;

// TODO: Auto-generated Javadoc


/**
 * The Class LinkedList.
 *
 * @param <T> the generic type
 */
public class LinkedList<T> {
	
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
	
	/* (non-Javadoc)
	 * @see List#empty()
	 */
	
	public boolean empty() {
		return head == null;
	}
	
	/* (non-Javadoc)
	 * @see List#last()
	 */
	
	public boolean last() {
		return current.next == null;
	}
	
	/* (non-Javadoc)
	 * @see List#full()
	 */
	
	public boolean full() {
		return false;
	}
	
	/* (non-Javadoc)
	 * @see List#update(java.lang.Object)
	 */
	
	public void update(T e) {
		current.data = e;	
		}
	
	/* (non-Javadoc)
	 * @see List#findFirst()
	 */
	
	public void findFirst() {
		current = head;
	}
	
	/* (non-Javadoc)
	 * @see List#findNext()
	 */
	
	public void findNext() {
		current = current.next;
	}
	
	/* (non-Javadoc)
	 * @see List#retrieve()
	 */
	
	public T retrieve() {
		return current.data;
	}
	
	/* (non-Javadoc)
	 * @see List#remove()
	 */
	
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

	/* (non-Javadoc)
	 * @see List#insert(java.lang.Object)
	 */
	
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
