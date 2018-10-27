package interfaces;

import nodes.PQElement;
import enums.Priority;

public interface PriorityQueue<T> {

	PQElement<T> serve();
	void enqueue(T e, Priority pty);
	
	int length();
	boolean full();
}


