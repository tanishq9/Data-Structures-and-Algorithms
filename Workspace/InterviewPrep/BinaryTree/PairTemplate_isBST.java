package BinaryTree;

import BinaryTree.levelOrderCountApproachInLove.TreeNode;

public class PairTemplate_isBST {
	class BP {
		long max;
		long min;
		boolean isbst;
	}

	public boolean isValidBST(TreeNode root) {
		return helper(root).isbst;
	}

	// Post order mei kaam karegey
	BP helper(TreeNode root) {
		if (root == null) {
			BP base = new BP();
			base.max = Long.MIN_VALUE;
			base.min = Long.MAX_VALUE;
			base.isbst = true;
			return base;
		}
		BP left = helper(root.left);
		BP right = helper(root.right);
		BP parent = new BP();
		parent.max = Math.max(root.val, Math.max(left.max, right.max));
		parent.min = Math.min(root.val, Math.min(left.min, right.min));
		parent.isbst = (left.isbst == true && right.isbst == true && root.val > left.max && root.val < right.min);
		return parent;
	}
}
