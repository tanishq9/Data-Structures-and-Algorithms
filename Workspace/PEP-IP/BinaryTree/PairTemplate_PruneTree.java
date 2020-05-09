package BinaryTree;

public class PairTemplate_PruneTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// This is a functional problem. You have to complete this function.
	// It takes as input the root node of the given tree. It should return the root
	// of the pruned tree.
	public static TreeNode pruneTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		root.left = pruneTree(root.left);
		root.right = pruneTree(root.right);

		if (root.left == null && root.right == null && root.val != 1) {
			return null;
		} else {
			return root;
		}
	}
}
