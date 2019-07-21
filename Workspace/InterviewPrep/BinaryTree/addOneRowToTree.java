package BinaryTree;

import java.util.LinkedList;

public class addOneRowToTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
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

	class Solution {
		public TreeNode addOneRow(TreeNode root, int v, int d) {
			if (d == 1) {
				TreeNode newRoot = new TreeNode(v);
				newRoot.left = root;
				return newRoot;
			}
			LinkedList<Pair> q = new LinkedList<>();
			q.add(new Pair(root, 1));
			while (true) {
				Pair front = q.removeFirst();
				TreeNode currNode = front.node;
				int currlvl = front.lvl;
				if (currlvl == d - 1) {
					// Init new nodes
					TreeNode newLeft = new TreeNode(v);
					TreeNode newRight = new TreeNode(v);
					// Store previous nodes
					TreeNode prevLeft = (currNode.left != null) ? currNode.left : null;
					TreeNode prevRight = (currNode.right != null) ? currNode.right : null;
					// Assign new nodes to currnode
					currNode.left = newLeft;
					currNode.right = newRight;
					// Assign previous nodes to newNodes
					newLeft.left = prevLeft;
					newRight.right = prevRight;
				} else if (currlvl == d) {
					break;
				}
				// Add child nodes to queue
				if (currNode.left != null) {
					q.addLast(new Pair(currNode.left, currlvl + 1));
				}
				if (currNode.right != null) {
					q.addLast(new Pair(currNode.right, currlvl + 1));
				}
			}
			return root;
		}
	}
}
