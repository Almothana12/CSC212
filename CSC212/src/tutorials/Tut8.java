package tutorials;

import enums.Relative;
import nodes.BTNode;

/* before you try and solve a problem in Binary Trees, you should determine if you want to solve it recursively or not.
 * to do this you should ask your self, "do I need to traverse across all the nodes in the tree?"
 * if the answer is yes, it's probably easier and better to solve it using recursion.
 * if the answer is no, it's probably easier and better to solve it without using recursion (iterative).
 */
public class Tut8 {

	// PROBLEM 3 :

	/** swaps the data of the left most node with the right most node. */
	public static <T> void swapMost(BT<T> bTree) {
		if(bTree.empty())
			return;
		
		bTree.find(Relative.Root);
		while(bTree.find(Relative.LeftChild)); // go to the left most node 
		T mostLeft = bTree.retrieve();         // save it
		
		bTree.find(Relative.Root);
		while(bTree.find(Relative.RightChild)); // go to the most right node
		T mostRight = bTree.retrieve();         // save it
		
		bTree.update(mostLeft);                 // right = left
		
		bTree.find(Relative.Root);
		while(bTree.find(Relative.LeftChild));  // again, go to the left most node
		
		bTree.update(mostRight);                // left = right
	}

	class BT<T> {

		// PROBLEM 1 :

		/** returns the number of leafs in the tree */
		public int countLeafNodes() {
			return countLeafNodes(root);
		}

		private int countLeafNodes(BTNode<T> p) {
			if (p == null)
				return 0;
			if (p.left == null && p.right == null)
				return 1;
			return countLeafNodes(p.left) + countLeafNodes(p.right);
		}

		// PROBLEM 2 :

		/** returns the height of the tree (the longest path from the root to a leaf). */
		public int getHeight() {
			return getHeight(root);
		}

		
		private int getHeight(BTNode<T> p) {
			if (p == null) 
				return 0;
			int leftHeight = getHeight(p.left);
			int rightHeight = getHeight(p.right);
			return leftHeight > rightHeight ? leftHeight+1 : rightHeight+1;
		}


		// END OF TUTORIAL
		
		
		private BTNode<T> root;
		private BTNode<T> current;

		public boolean empty() {
			return root == null;
		}

		public T retrieve() {
			return current.data;
		}

		public void update(T val) {
			current.data = val;
		}

		public boolean insert(Relative rel, T val) {
			switch (rel) {
			case Root:
				if (!empty())
					return false;
				current = root = new BTNode<T>(val);
				return true;
			case LeftChild:
				if (current.left != null)
					return false;
				current.left = new BTNode<T>(val);
				current = current.left;
				return true;
			case RightChild:
				if (current.right != null)
					return false;
				current.right = new BTNode<T>(val);
				current = current.right;
				return true;
			default:
				return false;
			}
		}

		public void deleteSubtree() {
			if (current == root) {
				current = root = null;
				return;
			}
			BTNode<T> p = current;
			find(Relative.Parent);
			if (current.left == p)
				current.left = null;
			else
				current.right = null;
			current = root;
		}

		public boolean find(Relative rel) {
			switch (rel) {
			case Root:
				current = root;
				return true;
			case LeftChild:
				if (current.left == null)
					return false;
				current = current.left;
				return true;
			case RightChild:
				if (current.right == null)
					return false;
				current = current.right;
				return true;
			default:
				return false;
			}

		}

	}
}
