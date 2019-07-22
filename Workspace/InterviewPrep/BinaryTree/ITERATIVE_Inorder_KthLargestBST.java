package BinaryTree;

import java.util.Stack;

public class ITERATIVE_Inorder_KthLargestBST {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static int kthLargest(TreeNode root, int k) {
		// write your code here.
		Stack<TreeNode> stack = new Stack<>();
		while (stack.size() > 0 || root != null) {
			// go to the extreme right
			while (root != null) {
				stack.push(root);
				root = root.right;
			}
			root = stack.pop();
			if (--k == 0) {
				break;
			}
			// if the popped node is a parent node then go its left child
			// easy logic ^
			root = root.left;
		}
		return root.val;
	}
}
