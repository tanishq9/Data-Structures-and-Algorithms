package BinaryTree;

import java.util.LinkedList;

public class sumOfNodesAtMinLeafLevel_CountApproach {
	class TreeNode {
		int data;
		TreeNode left, right;

		TreeNode(int key) {
			data = key;
			left = right = null;
		}
	}

	public int minLeafSum(TreeNode root) {
		// Write your code here.
		LinkedList<TreeNode> q = new LinkedList<>();
		q.add(root);
		int sum = 0;
		int lvl = 0;
		int minLevel = Integer.MAX_VALUE;
		while (q.size() > 0) {
			int count = q.size();
			while (count-- > 0) {
				TreeNode front = q.removeFirst();
				if (front.left != null) {
					q.addLast(front.left);
				}
				if (front.right != null) {
					q.addLast(front.right);
				}
				if (front.left == null && front.right == null && minLevel == Integer.MAX_VALUE) {
					minLevel = lvl;
				}
				// as soon as we get the first leaf node
				if (lvl == minLevel) {
					if (front.left == null && front.right == null) {
						sum += front.data;
					}
				}
			}
			lvl++;
		}
		return sum;
	}
}
