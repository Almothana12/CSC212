package nodes;

public class BSTNode<T> {
	public int key;
	public T data;
	public BSTNode<T> left;
	public BSTNode<T> right;
	
	public BSTNode(int key, T data) {
		this.key = key;
		this.data = data;
	}
	
	public BSTNode(int key, T data, BSTNode<T> left, BSTNode<T> right) {
		this.key = key;
		this.data = data;
		this.left = left;
		this.right = right;
	}
}
