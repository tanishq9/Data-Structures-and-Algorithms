package BinaryTree;

import java.util.LinkedList;

public class isFullBinaryTree {
	boolean isFullTree(TreeNode node) {
		// Write your code here.
		LinkedList<TreeNode> q = new LinkedList<>();
		q.add(node);
		while (q.size() > 0) {
			int c = q.size();
			while (c-- > 0) {
				TreeNode front = q.removeFirst();
				if (front.left == null && front.right != null) {
					return false;
				}
				if (front.left != null && front.right == null) {
					return false;
				}
				if (front.left != null) {
					q.addLast(front.left);
				}
				if (front.right != null) {
					q.addLast(front.right);
				}
			}
		}
		return true;
	}
}
