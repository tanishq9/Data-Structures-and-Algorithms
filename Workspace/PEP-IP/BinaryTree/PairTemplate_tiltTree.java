package BinaryTree;

public class PairTemplate_tiltTree {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	int tilt = 0;

	public int findTilt(TreeNode node) {
		tilt = 0;
		helper(node);
		return tilt;
	}

	int helper(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return root.val;
		}
		int left = helper(root.left);
		int right = helper(root.right);
		tilt += Math.abs(left - right);
		return left + right + root.val;
	}
}
