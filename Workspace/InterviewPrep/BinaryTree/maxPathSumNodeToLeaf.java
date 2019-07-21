package BinaryTree;

import BinaryTree.maxPathSumLeafToLeaf.Node;

public class maxPathSumNodeToLeaf {
	class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	int max = 0;

	public int maxPathSum(Node root) {
		// Write your code here.
		max = 0;
		helper(root);
		return max;
	}

	private int helper(Node root) {
		if (root == null) {
			return 0;
		}
		int lc = helper(root.left); // max sum from subtree rooted at left node to leaf
		int rc = helper(root.right); // max sum from subtree rooted at right node to leaf
		int rv = Math.max(lc, rc) + root.data;
		max = Math.max(max, rv);
		return rv;
	}
}
