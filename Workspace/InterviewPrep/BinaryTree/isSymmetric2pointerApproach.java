package BinaryTree;

import BinaryTree.levelOrderCountApproachInLove.TreeNode;

public class isSymmetric2pointerApproach {
	public static boolean isSymmetric(TreeNode root) {
		// write your code here.
		return helper(root.left, root.right);
	}

	static boolean helper(TreeNode r1, TreeNode r2) {
		if (r1 == null && r2 == null) {
			return true;
		}

		if (r1 == null && r2 != null) {
			return false;
		}

		if (r1 != null && r2 == null) {
			return false;
		}

		boolean l1r2 = helper(r1.left, r2.right);
		boolean l2r1 = helper(r1.right, r2.left);

		return l1r2 && l2r1;
	}
}
