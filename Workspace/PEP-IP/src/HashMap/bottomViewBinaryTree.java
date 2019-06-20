package HashMap;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class bottomViewBinaryTree {
	class Node {
		int data; // data of the node
		int hd; // horizontal distance of the node
		Node left, right; // left and right references

		public Node(int key) {
			data = key;
			hd = Integer.MAX_VALUE;
			left = right = null;
		}
	}

	class Pair {
		Node node;
		int hd;

		Pair(int ihd, Node in) {
			this.hd = ihd;
			this.node = in;
		}
	}

	// Should print bottom view of tree with given root
	public void bottomView(Node root) {
		LinkedList<Pair> q = new LinkedList<>();
		Map<Integer, Integer> map = new TreeMap<>();
		q.add(new Pair(0, root));
		while (q.size() > 0) {
			Pair front = q.removeFirst();
			Node cn = front.node;
			int cd = front.hd;
			// Add/Update
			map.put(cd, cn.data);
			if (cn.left != null) {
				q.addLast(new Pair(cd - 1, cn.left));
			}
			if (cn.right != null) {
				q.addLast(new Pair(cd + 1, cn.right));
			}
		}
		for (Integer d : map.keySet()) {
			System.out.print(map.get(d) + " ");
		}
	}
}
