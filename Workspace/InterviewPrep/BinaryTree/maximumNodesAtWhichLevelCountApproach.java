package BinaryTree;

import java.util.LinkedList;

public class maximumNodesAtWhichLevelCountApproach {

	class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	class BinaryTree {

		public int maxNodeLevel(Node root) {
			LinkedList<Node> queue = new LinkedList<>();
			queue.add(root);
			int lvl = 0;
			int bestLevel = 0;
			int maxCount = 0;
			while (queue.size() > 0) {
				int count = queue.size();
				if (maxCount < count) {
					bestLevel = lvl;
					maxCount = count;
				}
				while (count-- > 0) {
					Node front = queue.removeFirst();
					if (front.left != null) {
						queue.addLast(front.left);
					}
					if (front.right != null) {
						queue.addLast(front.right);
					}
				}
				lvl++;
			}
			return bestLevel;
		}
	}
}
