package BinaryTree;

import java.util.LinkedList;

public class nodesAtOddLevelCountApproach {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = right = null;
		}
	}

	// This is a functional problem. You have to complete this function.
	// It takes as input the root node of the given tree. It should print the nodes
	// at odd levels.
	public static void nodeAtOdd(TreeNode root) {
		// write your code here.
		boolean flag = false;
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (queue.size() > 0) {
			int count = queue.size();
			while (count-- > 0) {
				TreeNode front = queue.removeFirst();
				if (flag == false) {
					System.out.print(front.val + " ");
				}
				if (front.left != null) {
					queue.addLast(front.left);
				}
				if (front.right != null) {
					queue.addLast(front.right);
				}
			}
			flag = !flag;
		}
	}
}
