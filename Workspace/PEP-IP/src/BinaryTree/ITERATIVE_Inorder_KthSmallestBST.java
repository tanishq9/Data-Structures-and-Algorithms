package BinaryTree;

import java.util.Stack;

public class ITERATIVE_Inorder_KthSmallestBST {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static int kthSmallest(TreeNode root, int k) {
		// Using Iterative In-order
		Stack<TreeNode> stack = new Stack<>();
		while (stack.size() > 0 || root != null) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop(); // extreme left
			// work
			if (--k == 0) {
				break;
			}
			root = root.right;
		}
		return root.val;
	}
}
