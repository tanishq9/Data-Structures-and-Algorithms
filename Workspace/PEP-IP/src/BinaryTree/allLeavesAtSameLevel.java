package BinaryTree;

import java.util.LinkedList;

import BinaryTree.addOneRowToTree.TreeNode;

public class allLeavesAtSameLevel {
	public static boolean check(TreeNode root) {
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int lvl = 0;
		int deepestLevel = Integer.MAX_VALUE;
		while (queue.size() > 0) {
			int count = queue.size();
			while (count-- > 0) {
				TreeNode front = queue.removeFirst();
				if (front.left != null) {
					queue.addLast(front.left);
					if (front.left.left == null && front.left.right == null) {
						if (deepestLevel == Integer.MAX_VALUE) {
							deepestLevel = lvl + 1;
						} else {
							if ((lvl + 1) != deepestLevel) {
								return false;
							}
						}
					}
				}
				if (front.right != null) {
					queue.addLast(front.right);
					if (front.right.left == null && front.right.right == null) {
						if (deepestLevel == Integer.MAX_VALUE) {
							deepestLevel = lvl + 1;
						} else {
							if ((lvl + 1) != deepestLevel) {
								return false;
							}
						}
					}
				}
			}
			lvl++;
		}
		return true;
	}
}
