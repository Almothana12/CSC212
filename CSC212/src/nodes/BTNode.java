package nodes;

public class BTNode<T> {
	public T data;
	public BTNode<T> left;
	public BTNode<T> right;
	
	public BTNode(T data) {
		this.data = data;
	}
	
	public BTNode(T data, BTNode<T> left, BTNode<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

}
