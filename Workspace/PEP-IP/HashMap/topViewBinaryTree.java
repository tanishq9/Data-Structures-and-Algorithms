package HashMap;

import java.util.HashSet;
import java.util.LinkedList;

public class topViewBinaryTree {
	class Node {
		int data;
		Node left, right;

		public Node(int key) {
			this.data = key;
			left = right = null;
		}
	}

	class Pair {
		Node node;
		int hd;

		Pair(Node node, int hd) {
			this.node = node;
			this.hd = hd;
		}
	}

	public void printTopView(Node root) {
		LinkedList<Pair> queue = new LinkedList<>();
		HashSet<Integer> dist = new HashSet<>();

		queue.add(new Pair(root, 0));

		while (queue.size() > 0) {
			Pair front = queue.removeFirst();
			int chd = front.hd;
			Node cn = front.node;
			if (!dist.contains(chd)) {
				System.out.print(cn.data + " ");
				dist.add(chd);
			}
			if (cn.left != null) {
				queue.addLast(new Pair(cn.left, chd - 1));
			}
			if (cn.right != null) {
				queue.addLast(new Pair(cn.right, chd + 1));
			}
		}
	}
}
