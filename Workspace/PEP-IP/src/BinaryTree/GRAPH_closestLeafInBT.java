package BinaryTree;

import java.util.LinkedList;

public class GRAPH_closestLeafInBT {
	class TreeNode {
		TreeNode left, right;
		int data;

		TreeNode(int d) {
			data = d;
			left = right = null;
		}

	}

	class BinaryTree {

		class Pair {
			int val;
			int lvl;

			Pair(int iv, int il) {
				this.val = iv;
				this.lvl = il;
			}
		}

		int[][] graph = null;

		public int findClosestLeaf(TreeNode root, int k) {
			// create undirected graph from tree
			graph = new int[1001][1001];
			boolean[] visited = new boolean[1001];

			LinkedList<TreeNode> lvl = new LinkedList<>();
			lvl.add(root);
			while (lvl.size() > 0) {
				int count = lvl.size();
				while (count-- > 0) {
					TreeNode front = lvl.removeFirst();
					if (front.left != null) {
						graph[front.data][front.left.data] = 1;
						graph[front.left.data][front.data] = 1;
						lvl.addLast(front.left);
					}
					if (front.right != null) {
						graph[front.data][front.right.data] = 1;
						graph[front.right.data][front.data] = 1;
						lvl.addLast(front.right);
					}
					// if the leaf node is the closest node to itself
					/*
					 * if(front.left==null && front.right==null && front.data==k){ return
					 * front.data; }
					 */
				}
			}

			// Simple BFS
			LinkedList<Integer> q = new LinkedList<>();
			q.add(k);
			int r = root.data;
			while (q.size() > 0) {
				int front = q.removeFirst();

				if (visited[front] == true) {
					continue;
				} else {
					visited[front] = true;
				}

				boolean isleaf = true;
				for (int i = 1; i <= 1000; i++) {
					if (i != front && visited[i] == false && graph[front][i] == 1) {
						isleaf = false;
						q.addFirst(i);
					}
				}
				if (isleaf == true && front != r) {
					return front;
				}
			}
			return -1;
		}
	}
}
