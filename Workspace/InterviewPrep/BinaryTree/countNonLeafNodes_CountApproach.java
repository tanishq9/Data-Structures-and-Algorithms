package BinaryTree;

import java.util.LinkedList;

public class countNonLeafNodes_CountApproach {
	class TreeNode {
		int data;
		TreeNode left, right;

		TreeNode(int key) {
			data = key;
			left = right = null;
		}
	}

	public static int countNonLeafNodes(TreeNode node) {
		// write your code here.
		LinkedList<TreeNode> q = new LinkedList<>();
		q.add(node);
		int nonLeaf = 0;
		while (q.size() > 0) {
			int count = q.size();
			while (count-- > 0) {
				TreeNode front = q.removeFirst();
				boolean hasLeft = false, hasRight = false;
				if (front.left != null) {
					q.addLast(front.left);
					hasLeft = true;
				}
				if (front.right != null) {
					q.addLast(front.right);
					hasRight = true;
				}
				if (!(hasLeft == false && hasRight == false)) {
					nonLeaf++;
				}
			}
		}
		return nonLeaf;
	}
}
