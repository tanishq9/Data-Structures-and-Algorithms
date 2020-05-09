package BinaryTree;

import java.util.LinkedList;
import java.util.Stack;

class TreeNode {
	int data;
	TreeNode left, right;

	TreeNode(int item) {
		data = item;
		left = right = null;
	}
}

public class reverseLevelOrderCountApproach {
	void reversePrint(TreeNode root) {
		// Write your code here.
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		Stack<Integer> stack = new Stack<>();
		while (queue.size() > 0) {
			int count = queue.size();
			while (count-- > 0) {
				TreeNode front = queue.removeFirst();
				stack.push(front.data);
				if (front.right != null) {
					queue.addLast(front.right);
				}
				if (front.left != null) {
					queue.addLast(front.left);
				}
			}
		}
		while (stack.size() > 0) {
			System.out.print(stack.pop() + " ");
		}
	}
}
