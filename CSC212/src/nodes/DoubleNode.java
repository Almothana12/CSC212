package nodes;


public class DoubleNode<T> {
	
	public T data;
	public DoubleNode<T> next;
	public DoubleNode<T> previous;
	
	public DoubleNode() {}
	
	public DoubleNode (T val) {
		data = val;
	}

}