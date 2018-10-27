package tuturials;

import dataStructures.Stack.LinkedStack;
import interfaces.Stack;

public class Tut6 {
	
	public static <T> void replace(Stack<T> originalStack, T oldElem, T newElem) {
		if (originalStack.empty())
			return;

		LinkedStack<T> temp = new LinkedStack<T>();

		while (!originalStack.empty()) {
			T elem = originalStack.pop();
			if (elem.equals(oldElem))
				elem = newElem;
			temp.push(elem);
		}

		while (!temp.empty())
			originalStack.push(temp.pop());

	}

	public static <T> void insertAfter(Stack<T> originalStack, int index, T newElem) {
		LinkedStack<T> temp = new LinkedStack<T>();

		for (int i = 0; !originalStack.empty(); i++) {
			temp.push(originalStack.pop());
			if (i == index)
				temp.push(newElem);

		}

		while (!temp.empty())
			originalStack.push(temp.pop());
	}

	public static <T> void removeBottom(Stack<T> originalStack) {
		LinkedStack<T> temp = new LinkedStack<T>();
		while (!originalStack.empty())
			temp.push(originalStack.pop());

		temp.pop();

		while (!temp.empty())
			originalStack.push(temp.pop());

	}

}
