package midTerms;

import dataStructures.Queue.ArrayQueue;
import dataStructures.Stack.LinkedStack;
import interfaces.Queue;
import interfaces.Stack;

public class Spring2018 {

	public static void main(String[] args) {
		
		// testing swapAdj:
		Queue<Character> q = new ArrayQueue<Character>(5);
		Character a[] = {'A','B','C','D','E'};
		for(int i=0; i<5; i++)
			q.enqueue(a[i]);

		swapAdj(q);
//		q.display();
		
		
		//testing replace:
		Stack<Character> st = new LinkedStack<>();
		for(int i=0; i<5; i++)
			st.push(a[i]);
		
		Stack<Character> temp = replace(st, 'A', 'b');
//		temp.display();
//		st.display();
		
		
	}
	
	public static<T> void swapAdj(Queue<T> q) {
		
		for(int i=0; i<q.length()/2; i++) {
			
			T temp1 = q.serve();
			T temp2 = q.serve();
//			System.out.println("enqueueing: "+ temp2);
			q.enqueue(temp2);
//			System.out.println("enqueueing: "+ temp1);
			q.enqueue(temp1);
		}
	}
	
	public static Stack<Character> replace(Stack<Character> st, char a, char b){
		Stack<Character> newSt = new LinkedStack<Character>();
		Stack<Character> temp = new LinkedStack<Character>();

		while(!st.empty())
			temp.push(st.pop());
		
		while(!temp.empty()) {
			char e = temp.pop();
			st.push(e);
			if(e == a)
				newSt.push(b);
			else
				newSt.push(e);
		}
		
		return newSt;
	}
	
	

}
