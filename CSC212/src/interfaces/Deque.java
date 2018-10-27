package interfaces;


/**
 * Double ended queue (or a deque) supports insertion and deletion at both the
 * front and the tail of the queue.
 *   
 * @param <T> the generic type
 */
public interface Deque<T> {

	
	/**
	 * Element e is added to DQ as first element.
	 *
	 * requires: DQ is not full.
	 * 
	 * @param e 
	 */
	void addFirst(T e);

	
	/**
	 * Element e is added to DQ as last element.
	 *
	 * requires: DQ is not full.  
	 *
	 * @param e
	 */
	void addLast(T e);

	
	/**
	 * Removes and returns the first element of DQ.
	 *
	 * requires: DQ is not empty.  
	 *
	 * @return the first element of DQ.
	 */
	T removeFirst();

	
	/**
	 * Removes and returns the last element of DQ.
	 *
	 * requires: DQ is not empty.  
	 *
	 * @return the the last element of DQ.
	 */
	T removeLast();

	
	/**    
	 *
	 * requires: DQ is not empty.  
	 * 
	 * @return the first element of DQ.
	 */
	T getFirst();

	
	/**
	 * Returns the last element of DQ. 
	 *
	 * requires: DQ is not empty.
	 * 
	 * @return the last.
	 */
	T getLast();

	
	/**
	 * Returns the number of elements in DQ. 
	 *
	 * @return the size of DQ.
	 */
	int size();

	
	/**
	 * Checks if DQ is empty.
	 *
	 * @return true, if empty
	 */
	boolean isEmpty();

}
