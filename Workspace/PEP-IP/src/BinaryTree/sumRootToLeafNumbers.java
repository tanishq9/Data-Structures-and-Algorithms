package BinaryTree;

public class sumRootToLeafNumbers {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int sumNumbers(TreeNode root) {
		return helper(root, 0);
	}

	int helper(TreeNode root, int sum) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			sum = sum * 10 + root.val;
			return sum;
		}
		int l = helper(root.left, sum * 10 + root.val);
		int r = helper(root.right, sum * 10 + root.val);
		return l + r;
	}
}
