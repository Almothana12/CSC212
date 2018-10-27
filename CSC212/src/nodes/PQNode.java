package nodes;


import enums.Priority;

public class PQNode<T>{
	public T data;
	public Priority priority;
	public PQNode<T> next;
	
	public PQNode() {}
	
	public PQNode(T e, Priority p) {
		data = e;
		priority = p;
	}
	
}