package BinaryTree;

import java.util.LinkedList;

public class longestConsequetiveSequenceCountApproach {

	class TreeNode {
		int key;
		TreeNode left, right;

		public TreeNode(int key) {
			this.key = key;
			left = right = null;
		}
	}

	class Pair {
		TreeNode node;
		int len;

		Pair(TreeNode n, int l) {
			this.node = n;
			this.len = l;
		}
	}

	public int longestConsecutive(TreeNode root) {
		LinkedList<Pair> q = new LinkedList<>();
		q.add(new Pair(root, 1));
		int max = 0;
		while (q.size() > 0) {
			int count = q.size();
			while (count-- > 0) {
				Pair front = q.removeFirst();
				TreeNode currNode = front.node;
				int currLen = front.len;
				if (currNode.left != null) {
					int len = 1;
					if ((currNode.left.key - currNode.key) == 1) {
						len += currLen;
					}
					q.addLast(new Pair(currNode.left, len));
				}
				if (currNode.right != null) {
					int len = 1;
					if ((currNode.right.key - currNode.key) == 1) {
						len += currLen;
					}
					q.addLast(new Pair(currNode.right, len));
				}
				max = Math.max(max, currLen);
			}
		}
		return max == 1 ? -1 : max;
	}
}
