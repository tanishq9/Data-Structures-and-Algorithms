package BinaryTree;

import java.util.LinkedList;

public class leftMostAndrightMostNodesCountApproach {
	class TreeNode {
		TreeNode left, right;
		int val;

		TreeNode(int d) {
			val = d;
			left = right = null;
		}
	}

	public static void printCorner(TreeNode root) {
		// write your code here.
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (queue.size() > 0) {
			int count = queue.size();
			// Process the first node
			TreeNode front = queue.removeFirst();
			System.out.print(front.val + " ");
			if (front.left != null) {
				queue.addLast(front.left);
			}
			if (front.right != null) {
				queue.addLast(front.right);
			}
			count--;
			while (count > 0) {
				front = queue.removeFirst();
				// Process the last node
				if (count == 1) {
					System.out.print(front.val + " ");
				}
				if (front.left != null) {
					queue.addLast(front.left);
				}
				if (front.right != null) {
					queue.addLast(front.right);
				}
				count--;
			}

		}
	}

}
