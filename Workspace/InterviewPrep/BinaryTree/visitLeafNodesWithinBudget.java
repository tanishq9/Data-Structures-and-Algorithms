package BinaryTree;

import java.util.LinkedList;

public class visitLeafNodesWithinBudget {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = right = null;
		}
	}

	public static int getCount(TreeNode root, int bud) {
		// write your code here.
		LinkedList<TreeNode> q = new LinkedList<>();
		q.add(root);
		int res = 0, lvl = 1;
		while (q.size() > 0) {
			int count = q.size();
			while (count-- > 0) {
				TreeNode front = q.removeFirst();
				if (front.left == null && front.right == null) {
					if ((bud - lvl) >= 0) {
						bud -= lvl;
						res++;
					}
				}
				if (front.left != null) {
					q.addLast(front.left);
				}
				if (front.right != null) {
					q.addLast(front.right);
				}
			}
			lvl++;
		}
		return res;
	}
}
