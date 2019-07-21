package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class averageOfLevelsCountApproach {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	class Solution {
		public List<Double> averageOfLevels(TreeNode root) {
			List<Double> res = new ArrayList<>();
			LinkedList<TreeNode> q = new LinkedList<>();
			if (root == null)
				return res;
			q.add(root);
			// Count approach
			while (q.size() > 0) {
				int count = q.size();
				long sum = 0;
				int numOfNodes = count;
				while (count-- > 0) {
					TreeNode front = q.removeFirst();
					sum += front.val;
					if (front.left != null) {
						q.addLast(front.left);
					}
					if (front.right != null) {
						q.addLast(front.right);
					}
				}
				res.add((sum * 1.0) / numOfNodes);
			}
			return res;
		}
	}
}
