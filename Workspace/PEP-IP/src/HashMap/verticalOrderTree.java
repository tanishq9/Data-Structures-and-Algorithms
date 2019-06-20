package HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class verticalOrderTree {

	// Class representing a node of a binary tree.
	private static class Node {
		int data;
		Node left;
		Node right;

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	static void verticalOrder(Node root) {
		LinkedList<Pair> q = new LinkedList<>();
		Map<Integer, ArrayList<Integer>> map = new HashMap<>();
		int minIndex = Integer.MAX_VALUE;
		int maxIndex = Integer.MIN_VALUE;
		q.add(new Pair(root, 0));
		while (q.size() > 0) {
			Pair top = q.removeFirst();
			minIndex = Math.min(minIndex, top.hd);
			maxIndex = Math.max(maxIndex, top.hd);
			if (map.get(top.hd) == null) {
				map.put(top.hd, new ArrayList<>());
				map.get(top.hd).add(top.node.data);
			} else {
				map.get(top.hd).add(top.node.data);
			}
			if (top.node.left != null) {
				q.addLast(new Pair(top.node.left, top.hd - 1));
			}
			if (top.node.right != null) {
				q.addLast(new Pair(top.node.right, top.hd + 1));
			}
		}
		List<List<Integer>> res = new ArrayList<>();
		for (int i = minIndex; i <= maxIndex; i++) {
			for (int ele : map.get(i)) {
				System.out.print(ele + " ");
			}
		}
	}

	static class Pair {
		Node node;
		int hd;

		Pair(Node node, int hd) {
			this.node = node;
			this.hd = hd;
		}
	}
}
