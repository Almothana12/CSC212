package dataStructures.Queue;

public class ArrayQueue<T> {
	private int maxSize;
	private int size;
	private int head, tail;
	private T[] nodes;
	
	@SuppressWarnings("unchecked")
	public ArrayQueue(int n) {
		maxSize = n;
		size=0;
		head=tail=0;
		nodes =(T[]) new Object[n];
	}

	
	public void enqueue(T e) {
		nodes[tail] = e;
		tail = (tail+1) % maxSize;
		size++;
	}
	
	
	public T serve() {
		T temp = nodes[head];
		head = ++head % maxSize;
		size--;
		return temp;
	}

	
	public int length() {
		return size;
	}

	
	public boolean full() {
		return size == maxSize;
	}

	
	public int multiEnqueue(T[] els, int k) {
		int l=0;
	
		for(int i=0; i<k && !full() ; i++) {
				enqueue(els[i]);
				l++;
		}
		return l;
	}

	
	public int multiServe(T[] els, int k) {
		int l=0;
		
		for(int i=0; i<k && (length()!=0); i++) {
				els[i] = serve();
				l++;
		}
		return l;
	}
	
	public void display() {
		for(int i=0; i<size; i++) {
			System.out.print(nodes[i]);
		}
		System.out.println();
	}

}
