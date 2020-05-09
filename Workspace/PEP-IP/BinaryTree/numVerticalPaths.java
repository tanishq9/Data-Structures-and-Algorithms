package BinaryTree;

import java.util.HashSet;
import java.util.LinkedList;

public class numVerticalPaths {
	class TreeNode {
		int data;
		TreeNode left, right;

		TreeNode(int key) {
			data = key;
			left = right = null;
		}
	}

	class Pair {
		TreeNode node;
		int lvl;

		Pair(TreeNode in, int il) {
			this.node = in;
			this.lvl = il;
		}
	}

	public int verticalWidth(TreeNode root) {
		// Write your code here
		HashSet<Integer> set = new HashSet<>();
		LinkedList<Pair> q = new LinkedList<>();
		q.add(new Pair(root, 0));
		while (q.size() > 0) {
			Pair front = q.removeFirst();
			if (!set.contains(front.lvl)) {
				set.add(front.lvl);
			}
			if (front.node.left != null) {
				q.addLast(new Pair(front.node.left, front.lvl - 1));
			}
			if (front.node.right != null) {
				q.addLast(new Pair(front.node.right, front.lvl + 1));
			}
		}
		return set.size();
	}
}
