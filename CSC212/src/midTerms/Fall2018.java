package midTerms;

import dataStructures.List.LinkedList;
import interfaces.List;
import interfaces.Queue;

/** mid-term exam, 28/Oct/2018 */
public class Fall2018 {
	
	boolean isOrdered(Queue<Integer> q) {
		
		boolean ordered = true;
		
		int cur;
		int pre = Integer.MIN_VALUE;
		
		for(int i=0; i<q.length(); i++) {
			cur = q.serve();
			if(cur<pre)
				ordered = false;
			pre = cur;
			q.enqueue(cur);
		}
	
		return ordered;
		
	}
	
	List<Character> concatenate(List<Character> l1, List<Character> l2){
		List<Character> l3 = new LinkedList<Character>();
		
		
		return l3;
	}

}
