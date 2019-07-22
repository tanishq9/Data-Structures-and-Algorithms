package BinaryTree;

import java.util.LinkedList;

public class PairTemplate_UnivaluedBT {
	public static class TreeNode {
		int val, data;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	class UBT {
		long val;
		boolean isubt;
	}

	public boolean isUnivalTree(TreeNode root) {
		return helper(root).isubt;
	}

	UBT helper(TreeNode root) {
		if (root == null) {
			UBT base = new UBT();
			base.val = Long.MIN_VALUE;
			base.isubt = true;
			return base;
		}
		if (root.left == null && root.right == null) {
			UBT base = new UBT();
			base.val = root.val;
			base.isubt = true;
			return base;
		}
		UBT left = helper(root.left);
		UBT right = helper(root.right);
		UBT parent = new UBT();
		parent.val = root.val;
		parent.isubt = (left.isubt == true && right.isubt == true
				&& (left.val == root.val || left.val == Long.MIN_VALUE)
				&& (root.val == right.val || right.val == Long.MIN_VALUE));
		return parent;
	}

	public boolean isUnivalTreeIterative(TreeNode root) {
		// Write your code here.
		LinkedList<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (q.size() > 0) {
			TreeNode front = q.removeFirst();
			if (front.data != root.data) {
				return false;
			}
			if (front.left != null) {
				q.addLast(front.left);
			}
			if (front.right != null) {
				q.addLast(front.right);
			}
		}
		return true;
	}
}
