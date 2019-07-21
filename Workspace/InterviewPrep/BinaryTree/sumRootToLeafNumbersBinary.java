package BinaryTree;

public class sumRootToLeafNumbersBinary {
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
	// required sum.
	public static int sumRootToLeaf(TreeNode node) {
		// write your code here.
		return helper(node, 0);
	}

	static int helper(TreeNode root, int curr) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return root.val == 0 ? curr * 2 : curr * 2 + 1;
		}
		int left = helper(root.left, root.val == 0 ? curr * 2 : curr * 2 + 1);
		int right = helper(root.right, root.val == 0 ? curr * 2 : curr * 2 + 1);
		return left + right;
	}
}
