/*
 * This class prints has two public methods.
 * The first one, "printTree", takes a node and prints it's sub tree.
 * The second method, "printPaths", takes a node and prints all the paths from the root to the leafs.
 */

package dataStructures.Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import nodes.BTNode;

public class PrintTree {

	public static <T> void printTree(BTNode<T> root) {
		int maxLevel = maxLevel(root);
		printNodeInternal(Collections.singletonList(root), 1, maxLevel);
	}

	private static <T> void printNodeInternal(List<BTNode<T>> nodes, int level, int maxLevel) {
		if (nodes.isEmpty() || isAllElementsNull(nodes))
			return;

		int floor = maxLevel - level;
		int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
		int firstSpaces = (int) Math.pow(2, (floor)) - 1;
		int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

		printWhitespaces(firstSpaces);

		List<BTNode<T>> newNodes = new ArrayList<BTNode<T>>();
		for (BTNode<T> node : nodes) {
			if (node != null) {
				System.out.print(node.data);
				newNodes.add(node.left);
				newNodes.add(node.right);
			} else {
				newNodes.add(null);
				newNodes.add(null);
				System.out.print(" ");
			}

			printWhitespaces(betweenSpaces);
		}
		System.out.println("");

		for (int i = 1; i <= endgeLines; i++) {
			for (int j = 0; j < nodes.size(); j++) {
				printWhitespaces(firstSpaces - i);
				if (nodes.get(j) == null) {
					printWhitespaces(endgeLines + endgeLines + i + 1);
					continue;
				}

				if (nodes.get(j).left != null)
					System.out.print("/");
				else
					printWhitespaces(1);

				printWhitespaces(i + i - 1);

				if (nodes.get(j).right != null)
					System.out.print("\\");
				else
					printWhitespaces(1);

				printWhitespaces(endgeLines + endgeLines - i);
			}

			System.out.println();
		}

		printNodeInternal(newNodes, level + 1, maxLevel);
	}

	private static void printWhitespaces(int count) {
		for (int i = 0; i < count; i++)
			System.out.print(" ");
	}

	private static <T> int maxLevel(BTNode<T> node) {
		if (node == null)
			return 0;

		return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
	}

	private static <T> boolean isAllElementsNull(List<T> list) {
		for (Object object : list) {
			if (object != null)
				return false;
		}

		return true;
	}
	
	////////////////////////////////////////////////////////////////////
	
	
	public void printPaths(BTNode<Integer> node)  { 
        int path[] = new int[1000]; 
        printPathsRecur(node, path, 0); 
    } 
   
    /* Recursive helper function -- given a node, and an array containing 
       the path from the root node up to but not including this node, 
       print out all the root-leaf paths. */
   private void printPathsRecur(BTNode<Integer> node, int path[], int pathLen)  { 
        if (node == null) 
            return; 
   
        /* append this node to the path array */
        path[pathLen] = node.data; 
        pathLen++; 
   
        /* it's a leaf, so print the path that led to here */
        if (node.left == null && node.right == null) 
            printArray(path, pathLen); 
        else{  
            /* otherwise try both subtrees */
            printPathsRecur(node.left, path, pathLen); 
            printPathsRecur(node.right, path, pathLen); 
        }
    } 
   
    /* Utility that prints out an array on a line */
   private void printArray(int ints[], int len)  {
        for (int i = 0; i < len; i++)  
            System.out.print(ints[i] + " "); 
        System.out.println(""); 
    }
}
