package BinaryTree;

import java.util.LinkedList;

public class sumOfLeftLeavesCountApproach {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = right = null;
		}
	}

	public static int sumOfLeftLeaves(TreeNode root) {
		// write your code here.
		if (root == null) {
			return 0;
		}
		LinkedList<TreeNode> q = new LinkedList<>();
		q.add(root);
		int lsum = 0;
		while (q.size() > 0) {
			int count = q.size();
			while (count-- > 0) {
				TreeNode front = q.removeFirst();
				if (front.left != null) {
					if (front.left.left == null && front.left.right == null) {
						lsum += front.left.val;
					}
					q.addLast(front.left);
				}
				if (front.right != null) {
					q.addLast(front.right);
				}
			}
		}
		return lsum;
	}
}
