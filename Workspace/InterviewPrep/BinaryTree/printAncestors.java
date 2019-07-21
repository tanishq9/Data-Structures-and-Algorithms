package BinaryTree;

import BinaryTree.addOneRowToTree.TreeNode;

public class printAncestors {
	public static boolean printAncestors(TreeNode node, int x) {
		if (node == null) {
			return false;
		}
		if (node.val == x) {
			return true;
		}
		boolean left = printAncestors(node.left, x);
		boolean right = printAncestors(node.right, x);
		if (left == true || right == true) {
			System.out.print(node.val + " ");
			return true;
		}
		return false;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
