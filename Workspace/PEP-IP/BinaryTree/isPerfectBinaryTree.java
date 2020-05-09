package BinaryTree;

import java.util.LinkedList;

public class isPerfectBinaryTree {
	public static boolean isPerfect(TreeNode root) {
		// Last level should have 2^h nodes -> Logic
		// find max depth first
		int maxDepth = height(root);
		int numOfNodesOnLastLevel = (int) Math.pow(2, maxDepth - 1);
		// System.out.println(numOfNodesOnLastLevel);
		return levelOrder(root, maxDepth, numOfNodesOnLastLevel);
	}

	static int height(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int l = height(root.left);
		int r = height(root.right);
		return Math.max(l, r) + 1;
	}

	static boolean levelOrder(TreeNode root, int maxDepth, int num) {
		LinkedList<TreeNode> q = new LinkedList<>();
		q.add(root);
		int lvl = 1, total = 0;
		while (q.size() > 0) {
			int c = q.size();
			if (lvl == maxDepth) {
				total = c;
				break;
			}
			while (c-- > 0) {
				TreeNode front = q.removeFirst();
				if (front.left != null) {
					q.addLast(front.left);
				}
				if (front.right != null) {
					q.addLast(front.right);
				}
			}
			lvl++;
		}
		return total == num;
	}
}
