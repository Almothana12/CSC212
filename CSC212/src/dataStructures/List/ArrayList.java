package dataStructures.List;

import interfaces.List;

/**
 * The Class ArrayList.
 *
 * @param <T> the generic type
 */
public class ArrayList<T> implements List<T> {
	
	/** The max size of the list. */
	private int maxSize;
	
	/** The actual number of element in the list. */
	private int size;
	
	/** The current. */
	private int current;
	
	/** The nodes. */
	private T[] nodes;
	
	 /**
 	 * Instantiates a new array list.
 	 *
 	 * @param n the n
 	 */
 	@SuppressWarnings("unchecked")
	public ArrayList(int n) {
		 current = -1;
		 nodes = (T[]) new Object[n];
	 }
	 
	/**
	 * @see List#findFirst()
	 */
	public void findFirst() {
		current = 0;
	}

	/**
	 * @see List#findNext()
	 */
	public void findNext() {
		current++;
	}

	/**
	 * @see List#retrieve()
	 */
	public T retrieve() {
		return nodes[current];
	}

	/**
	 * @see List#update(java.lang.Object)
	 */
	public void update(T e) {
		nodes[current] = e;
		
	}

	/**
	 * @see List#insert(java.lang.Object)
	 */
	
	public void insert(T e) {
		for(int i = size-1 ; i!=current ; i--)
			nodes[i+1] = nodes[i];
		current++;
		nodes[current] = e;
		size++;
	}
	 

	/**
	 * @see List#remove()
	 */
	public void remove() {

	for(int i = current ; i<size-1 ; i++)
		nodes[i] = nodes[i+1];
	size--;
	
	if(size == 0)
		current = -1;
	else if(current == size)
		current = 0;
	
	}

	/** 
	 * @see List#full()
	 */
	public boolean full() {
		return size == maxSize;
	}

	/** 
	 * @see List#empty()
	 */
	public boolean empty() {
		return size == 0;
	}

	/** 
	 * @see List#last()
	 */
	public boolean last() {
		return current == size-1;
	}
	
	public void diplay() {
		for(int i=0; i<size; i++)
			System.out.print(nodes[i]);
		System.out.println();
	}
	
	/** for mid-term exam Fall2018*/
	public void moveToEnd(int k) {
	
	for(int i=0; i<k; i++) {
		nodes[size] = nodes[current];
		for(int j=current; j<size; j++)
			nodes[j] = nodes[j+1];
	}
	current = size - k;
}
	
	
}
