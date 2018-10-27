package dataStructures.List;

import interfaces.List;

// TODO: Auto-generated Javadoc
/**
 * The Class ArrayList.
 *
 * @param <T> the generic type
 */
public class ArrayList<T> implements List<T> {
	
	/** The max size. */
	public int maxSize;
	
	/** The size. */
	public int size;
	
	/** The current. */
	public int current;
	
	/** The nodes. */
	public T[] nodes;
	
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
	 
	/* (non-Javadoc)
	 * @see List#findFirst()
	 */
	public void findFirst() {
		current = 0;
	}

	/* (non-Javadoc)
	 * @see List#findNext()
	 */
	public void findNext() {
		current++;
	}

	/* (non-Javadoc)
	 * @see List#retrieve()
	 */
	public T retrieve() {
		return nodes[current];
	}

	/* (non-Javadoc)
	 * @see List#update(java.lang.Object)
	 */
	public void update(T e) {
		nodes[current] = e;
		
	}

	/* (non-Javadoc)
	 * @see List#insert(java.lang.Object)
	 */
	
	public void insert(T e) {
		for(int i = size-1 ; i!=current ; i--)
			nodes[i+1] = nodes[i];
		current++;
		nodes[current] = e;
		size++;
	}
	 

	/* (non-Javadoc)
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

	/* (non-Javadoc)
	 * @see List#full()
	 */
	public boolean full() {
		return size == maxSize;
	}

	/* (non-Javadoc)
	 * @see List#empty()
	 */
	public boolean empty() {
		return size == 0;
	}

	/* (non-Javadoc)
	 * @see List#last()
	 */
	public boolean last() {
		return current == size;
	}
	

}
