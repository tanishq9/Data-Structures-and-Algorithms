package BinaryTree;

import java.util.LinkedList;

public class isCompleteTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	class Solution {
		public boolean isCompleteTree(TreeNode root) {
			LinkedList<TreeNode> q = new LinkedList<>();
			q.add(root);
			boolean firstNull = false;
			while (q.size() > 0) {
				int count = q.size();
				while (count-- > 0) {
					TreeNode front = q.removeFirst();
					if (front != null && firstNull == true) {
						return false;
					}
					if (front == null) {
						if (firstNull == false) {
							firstNull = true;
						}
						continue;
					}
					q.addLast(front.left);
					q.addLast(front.right);
				}
			}
			return true;
		}
	}
}
