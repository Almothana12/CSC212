package nodes;

import enums.Priority;

public class PQElement<T> {
	public T data;
	public Priority priority;

	public PQElement() {
	}

	public PQElement(T e, Priority p) {
		data = e;
		priority = p;
	}
}
