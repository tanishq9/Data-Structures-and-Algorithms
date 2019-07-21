package BST;

import BinaryTree.sumRootToLeafNumbers.TreeNode;

public class printBSTelementsINGivenRange {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void printNearNodes(TreeNode node, int lo, int hi) {
		// write your code here.
		if (node == null) {
			return;
		}
		if (node.val < lo) {
			printNearNodes(node.right, lo, hi);
		} else if (node.val > hi) {
			printNearNodes(node.left, lo, hi);
		} else {
			printNearNodes(node.left, lo, hi);
			System.out.print(node.val + " ");
			printNearNodes(node.right, lo, hi);
		}

	}
}
