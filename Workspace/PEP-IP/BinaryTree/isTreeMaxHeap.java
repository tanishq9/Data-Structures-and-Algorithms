package BinaryTree;

import java.util.LinkedList;

public class isTreeMaxHeap {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	class Solution {
		public boolean isTreeMaxHeap(TreeNode root) {
			LinkedList<TreeNode> q = new LinkedList<>();
			q.add(root);
			boolean firstNull = false;
			while (q.size() > 0) {
				int count = q.size();
				while (count-- > 0) {
					TreeNode front = q.removeFirst();
					// Work to check if we encounter non null node after null node
					if (front != null && firstNull == true) {
						return false;
					}
					if (front == null) {
						if (firstNull == false) {
							firstNull = true;
						}
						continue;
					}
					// Work to check if it follows max heap property
					if (front.left != null) {
						if (front.val <= front.left.val) {
							return false;
						}
					}
					if (front.right != null) {
						if (front.val <= front.right.val) {
							return false;
						}
					}
					// Add the left and right child
					q.addLast(front.left);
					q.addLast(front.right);
				}
			}
			return true;
		}
	}
}
