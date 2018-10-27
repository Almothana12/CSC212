package interfaces;

public interface List<T> {
	
	/**
	 * requires: list L is not empty.
	 * first element set as the current element.
	 */
	public void findFirst( );
	
	/**
	 * requires: list L is not empty.
	 * element following the current element is made the current element.
	 */
	public void findNext( );
	
	/**
	 * requires: list L is not empty
	 * current element is copied into T
	 * 
	 * @return the T
	 */
	public T retrieve( );
	
	/**
	 * requires: list L is not empty
	 * the element e is copied into the current node
	 * 
	 * @param element e
	 */
	public void update(T e);
	
	/**
	 * requires: list L is not full
	 * a new node containing element e is created and inserted after the current element 
	 * in the list. The new element e is made the current element. 
	 * If the list is empty e is also made the head element. 
	 * 
	 * @param element e
	 */
	public void insert(T e);
	
	/**
	 * requires: list L is not empty
	 * 
	 * the current element is removed from the list.  If the resulting list is 
	 * empty current is set to NULL. If successor of the deleted element 
	 * exists it is made the new current element otherwise first element 
	 * is made the new current element. 
	 */
	public void remove( );
	
	/**
	 * if the number of elements in the List has reached the maximum number allowed 
	 * then flag is set to true otherwise false
	 *
	 * @return true, if full
	 */
	public boolean full( );
	
	/**
	 * if the number of elements in the List is zero, then flag is set to true 
	 * otherwise false
	 *
	 * @return true, if empty
	 */
	public boolean empty( );
	
	/**
	 * if the last element is the current element then flag is set to true
	 * otherwise false.
	 *
	 * @return true, if current is last
	 * @return flase, otherwise
	 */
	public boolean last();


}
