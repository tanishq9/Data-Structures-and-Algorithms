package BinaryTree;

import BinaryTree.levelOrderCountApproachInLove.TreeNode;

public class maxPathSumNodeToNode {
	int maxi = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		helper(root);
		return maxi;
	}

	int helper(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftTree = helper(root.left); // best path sum rooted at root left subtree
		int rightTree = helper(root.right); // best path sum rooted at root right subtree
		// a,ae,al for rv
		// a,ae,al,ae+al for max
		int rv = Math.max(root.val, Math.max(leftTree, rightTree) + root.val);
		maxi = Math.max(maxi, Math.max(rv, leftTree + root.val + rightTree));
		return rv;
	}
}
