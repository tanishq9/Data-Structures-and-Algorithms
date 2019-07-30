package BinaryTree;

public class PairTemplate_LargestBST {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = right = null;
		}
	}

	// This is a functional problem. You have to complete this function.
	// It takes as input the root node of the given tree. It should return the
	// number of
	// nodes in the largest subtree which is a BST.
	static class Pair {
		int max;
		int min;
		boolean isbst;
		int size;
		int root;
	}

	public static int largestBst(TreeNode node) {
		// write your code here.
		return helper(node).size;
	}

	static Pair helper(TreeNode node) {
		if (node == null) {
			Pair base = new Pair();
			base.max = Integer.MIN_VALUE;
			base.min = Integer.MAX_VALUE;
			base.isbst = true;
			base.size = 0;
			base.root = -1;
			return base;
		}
		Pair left = helper(node.left);
		Pair right = helper(node.right);
		// Work in Post Order : Only way possible
		Pair parent = new Pair();
		parent.max = Math.max(node.val, Math.max(left.max, right.max));
		parent.min = Math.min(node.val, Math.min(left.min, right.min));
		parent.isbst = (left.isbst == true && right.isbst == true && node.val > left.max && node.val < right.min);
		if (parent.isbst == true) {
			parent.size = left.size + right.size + 1;
			parent.root = node.val;
		} else {
			if (left.size > right.size) {
				parent.size = left.size;
				parent.root = left.root;
			} else {
				parent.size = right.size;
				parent.root = right.root;
			}
		}
		return parent;
	}

}
