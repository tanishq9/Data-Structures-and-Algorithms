package BinaryTree;

import java.util.LinkedList;

public class minDepth {
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int lh = minDepth(root.left);
		int rh = minDepth(root.right);
		if (lh == 0 || rh == 0) {
			return Math.max(lh, rh) + 1;
		} else {
			return Math.min(lh, rh) + 1;
		}
	}

	public int minDepth_BFS(TreeNode root) {
		// Write your code here.
		LinkedList<TreeNode> q = new LinkedList<>();
		q.add(root);
		int lvl = 1;
		while (q.size() > 0) {
			int c = q.size();
			while (c-- > 0) {
				TreeNode front = q.removeFirst();
				if (front.left == null && front.right == null) {
					return lvl;
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
		return lvl;
	}

}
