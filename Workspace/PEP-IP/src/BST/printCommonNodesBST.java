package BST;

import java.util.Stack;

public class printCommonNodesBST {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// This is a functional problem. You have to complete this function.
	// It takes as input the root nodes of two BSTs. It should print the common
	// nodes in sorted order.
	public static void printCommon(TreeNode root1, TreeNode root2) {
		// write your code here.
		Stack<TreeNode> s1 = new Stack<>();
		fill(root1, s1);
		Stack<TreeNode> s2 = new Stack<>();
		fill(root2, s2);
		while (s1.size() > 0 && s2.size() > 0) {
			if (s1.peek().val == s2.peek().val) {
				System.out.print(s1.peek().val + " ");
				fill(s1.pop().right, s1);
				fill(s2.pop().right, s2);
			} else if (s1.peek().val > s2.peek().val) {
				fill(s2.pop().right, s2);
			} else {
				fill(s1.pop().right, s1);
			}
		}
	}

	static void fill(TreeNode root, Stack<TreeNode> s) {
		while (root != null) {
			s.push(root);
			root = root.left;
		}
	}
}
