package interfaces;

public interface Stack<T> {

	void push(T e);
	T pop();
	
	boolean empty();
	boolean full();

}
