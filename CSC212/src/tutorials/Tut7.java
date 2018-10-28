package tutorials;

import interfaces.Stack;

public class Tut7 {
	/*
	Write  the  recursive  static  method copyStackthat  takes  two  Stacks srcStack and destStack 
	and copies all the elements of srcStack into destStack in the same order while preserving srcStack.
	You can assume destStack can hold all srcStack elements. You are not allowed to use any auxiliary data structures.
	*/
	public static<T> void copyStack(Stack<T> srcStack, Stack<T> destStack) {
		if(srcStack.empty())
			return;
		T elem= srcStack.pop();
		copyStack(srcStack, destStack);
		srcStack.push(elem);
		destStack.push(elem);	
	}
	
	public static<T> boolean searchStack(Stack<T> stack, T elem) {
		if (stack.empty())  
			return false;
		T temp = stack.pop();
		boolean result;  
		if(temp.equals(elem))
			result = true;
		else
			result = searchStack(stack, elem);
		stack.push(temp);
		return result;

	}


}
