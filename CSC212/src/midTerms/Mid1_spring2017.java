package midTerms;

import dataStructures.List.ArrayList;
import dataStructures.List.DoubleLinkedList;
import interfaces.List;

public class Mid1_spring2017 {
	
	public static void main(String[] args) {
		
		// testing lastIndex:
		ArrayList<Character> arr = new ArrayList<>(6);
		Character a[] = {'A','B','C','A','B','D'};
		for(int i=0; i<a.length; i++)
			arr.insert(a[i]);
		
		int index = lastIndex(arr, 'D');
		System.out.println(index);
		
		
		// testing reverseCopy:
		DoubleLinkedList<Character> d1 = new DoubleLinkedList<>();
		for(int i=0; i<a.length; i++)
			d1.insert(a[i]);
		
		DoubleLinkedList<Character> d2 = new DoubleLinkedList<>();
		reverseCopy(d1, d2);
		d2.display(); // should be: a[] in reverse

	
		
 	}
	
	
	
	/** returns the index of the last occurrence of e in l, or -1 if e does not exist.
	 *  the first element has index 0
     */
	public static<T> int lastIndex(List<T> l, T e) {
		if (e == null) 
			return -1;
		
		int index = -1;
		int i;
		
		l.findFirst();
		
		for( i=0; !l.last(); l.findNext(), i++) {
			if(e.equals(l.retrieve()))
				index=i;
		}
		
		// checking the last element
		if(e.equals(l.retrieve()))
			index = i;
		
		return index;
	}
	
	/** 
	 * copies the elements of l1 to l2 in reverse order.
	 * the list l2 is unchanged.
	 * 
	 * @param l1 : double linked list.
	 * @param l2 : an empty double linked list
	 */
	public static<T> void reverseCopy(DoubleLinkedList<T> l1, DoubleLinkedList<T> l2) {
		if(l1.empty())
			return;
		
		while(!l1.last())
			l1.findNext();
		// current is now the last element of l2.
		
		// inserting in reverse:
		while(!l1.first()) {
			l2.insert(l1.retrieve());
			l1.findPrevious();
		}
		l2.insert(l1.retrieve());
	}
	
	
}


