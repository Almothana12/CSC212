package midTerms;


import dataStructures.List.*;
import dataStructures.Queue.ArrayQueue;
import interfaces.List;
import interfaces.Queue;

/** mid-term exam, 28/Oct/2018 */
public class Fall2018<T> {
	
	public static void main(String[] args) {
		
		// Testing isOrdered:
		// q1:
		int a[] = {1, 2, 3, 4, 5, 7, 9, 11, 13}; 
		Queue<Integer> q1 = new ArrayQueue<Integer>(a.length);
		for(int i=0; i<a.length; i++)
			q1.enqueue(a[i]);
		
		// q2:
		int b[] = {1, 3, 5, 4, 5, 4, 9, 1, 3}; 
		Queue<Integer> q2 = new ArrayQueue<Integer>(b.length);
		for(int i=0; i<b.length; i++)
			q2.enqueue(b[i]);
		
		System.out.println(isOrdered(q1)); // should print "true"
		System.out.println(isOrdered(q2)); // should print "false"
		System.out.println(isOrdered2(q1)); // should print "true"
		System.out.println(isOrdered2(q2)); // should print "false
		System.out.println();
		
		// Testing moveToEnd:
		Character c[] = {'A', 'B', 'C', 'D', 'E', 'F'};
		ArrayList<Character> l = new ArrayList<>(c.length+1);
		for(int i=0; i<c.length; i++)
			l.insert(c[i]); // inserting c[] to the ArrayList l
		
		l.diplay(); // should print: A B C D E F
		l.findFirst(); // current is on: A
		l.findNext(); // current is on: B
		l.moveToEnd(2); // move B and C to the end of the list
		l.diplay();// should print: A D E F B C

	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static boolean isOrdered(Queue<Integer> q) {
		
		boolean ordered = true;
		
		int cur;
		int pre = Integer.MIN_VALUE;  // the smallest possible integer (-2147483648)
		
		for(int i=0; i<q.length(); i++) {
			cur = q.serve();
			if(cur<pre)
				ordered = false;
			pre = cur;
			q.enqueue(cur);
		}
	
		return ordered;
	}
	// Or :
	public static boolean isOrdered2(Queue<Integer> q) {
		
		boolean ordered = true;
		
		int cur;
		int pre = q.serve();
		
		q.enqueue(pre);
		
		for(int i=0; i<q.length()-1; i++) {
			cur = q.serve();
			if(cur<pre)
				ordered = false;
			pre = cur;
			q.enqueue(cur);
		}
	
		return ordered;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
///////////////////////////////////////////////////////////////////////////////////
//	in class ArrayList.java	:      												 //
//	                                                                             //
//	public void moveToEnd(int k) {                                               //
//		                                                                         //
//		for(int i=0; i<k; i++) {                                                 //
//			nodes[size] = nodes[current];                                        //
//			for(int j=current; j<size; j++)                                      //
//				nodes[j] = nodes[j+1];                                           //
//		}                                                                        //
//		current = size - k;                                                      //
//	}                                                                            //
///////////////////////////////////////////////////////////////////////////////////			
	
	

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// l1={A B C D E}, l2={R S Q}, concatenate(l1, l2, 0) = {A S Q}, concatenate(l1, l2, 2) = {A B C idk i don't remember :( 
	public static List<Character> concatenate(List<Character> l1, List<Character> l2, int i){
		List<Character> l3 = new LinkedList<Character>();
		
		
		return l3;
	}

}
