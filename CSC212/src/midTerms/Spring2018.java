package midTerms;

import dataStructures.Queue.ArrayQueue;
import dataStructures.Stack.LinkedStack;
import interfaces.Queue;
import interfaces.Stack;

public class Spring2018 {

	public static void main(String[] args) {
		
		// testing swapAdj:
		Character a[] = {'A', 'a', 'B', 'b', 'C', 'c', 'D'};
		Queue<Character> q = new ArrayQueue<Character>(a.length);
		for(int i=0; i<a.length; i++)
			q.enqueue(a[i]);

		System.out.print("Before swapping: ");
		q.display();
		swapAdj(q);
		System.out.print("After  swapping: ");
		q.display();
		
		
		//testing replace:
		Character b[] = {'A', 'B', 'C', 'D', 'E'};
		Stack<Character> st = new LinkedStack<>();
		for(int i=0; i<b.length; i++)
			st.push(b[i]);
		
		
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
