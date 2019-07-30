package BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GRAPH_closestBTBetterSoln {
	class TreeNode {
		TreeNode left, right;
		int data;

		TreeNode(int d) {
			data = d;
			left = right = null;
		}

	}

	class BinaryTree {

		public int findClosestLeaf(TreeNode root, int k) {
			Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
			DFS(graph, root, null);

			LinkedList<TreeNode> que = new LinkedList<>();
			HashSet<TreeNode> isVisited = new HashSet<>();

			for (TreeNode keys : graph.keySet()) {
				if (keys.data == k) {
					que.addLast(keys);
				}
			}

			while (que.size() != 0) {
				TreeNode curr = que.removeFirst();
				if (curr.left == null && curr.right == null) {
					return curr.data;
				}
				isVisited.add(curr);
				for (TreeNode node : graph.get(curr)) {
					if (!isVisited.contains(node)) {
						que.add(node);
					}
				}
			}

			return -1;
		}

		public void DFS(Map<TreeNode, List<TreeNode>> graph, TreeNode node, TreeNode parent) {
			if (node == null)
				return;

			if (!graph.containsKey(node))
				graph.put(node, new ArrayList<>());

			if (parent != null) {
				if (!graph.containsKey(parent))
					graph.put(node, new ArrayList<>());

				graph.get(node).add(parent);
				graph.get(parent).add(node);
			}

			DFS(graph, node.left, node);
			DFS(graph, node.right, node);
		}
	}

}
