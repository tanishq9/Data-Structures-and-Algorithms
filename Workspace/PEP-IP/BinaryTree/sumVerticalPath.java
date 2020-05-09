package BinaryTree;

import java.util.LinkedList;
import java.util.TreeMap;

public class sumVerticalPath {
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

	public void printVertical(TreeNode root) {
		// Write your code here.
		LinkedList<Pair> q = new LinkedList<>();
		TreeMap<Integer, Integer> map = new TreeMap<>();
		q.add(new Pair(root, 0));
		while (q.size() > 0) {
			Pair front = q.removeFirst();
			TreeNode node = front.node;
			int currlvl = front.lvl;
			if (map.containsKey(currlvl)) {
				map.put(currlvl, map.get(currlvl) + node.data);
			} else {
				map.put(currlvl, node.data);
			}
			if (node.left != null) {
				q.addLast(new Pair(node.left, currlvl - 1));
			}
			if (node.right != null) {
				q.addLast(new Pair(node.right, currlvl + 1));
			}
		}
		for (int key : map.keySet()) {
			System.out.print(map.get(key) + " ");
		}

	}
}
