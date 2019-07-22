package BinaryTree;

public class PairTemplate_CountUniValueSubtrees {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = right = null;
		}
	}

	static class US {
		int count;
		int val;
		boolean uni;
	}

	public static int countUnivalSubtrees(TreeNode root) {
		// write your code here.
		return helper(root).count;
	}

	static US helper(TreeNode root) {
		if (root == null) {
			US base = new US();
			base.count = 0;
			base.uni = true;
			base.val = Integer.MIN_VALUE;
			return base;
		}

		US left = helper(root.left);
		US right = helper(root.right);
		US parent = new US();
		parent.val = root.val;
		parent.uni = (left.uni == true && right.uni == true && (left.val == root.val || left.val == Integer.MIN_VALUE)
				&& (root.val == right.val || right.val == Integer.MIN_VALUE));

		parent.count = left.count + right.count + (parent.uni == true ? 1 : 0);
		return parent;
	}
}
