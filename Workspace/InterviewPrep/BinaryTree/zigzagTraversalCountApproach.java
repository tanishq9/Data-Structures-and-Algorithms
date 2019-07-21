package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class zigzagTraversalCountApproach {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	class Solution {
		public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
			List<List<Integer>> res = new ArrayList<>();
			if (root == null) {
				return res;
			}
			LinkedList<TreeNode> q = new LinkedList<>();
			boolean flag = false;
			q.add(root);
			while (q.size() > 0) {
				int count = q.size();
				List<Integer> temp = new ArrayList<>();
				while (count-- > 0) {
					TreeNode front = q.removeFirst();
					if (flag == false) {
						temp.add(front.val);
					} else {
						temp.add(0, front.val);
					}
					if (front.left != null) {
						q.addLast(front.left);
					}
					if (front.right != null) {
						q.addLast(front.right);
					}
				}
				res.add(temp);
				flag = !flag;
			}
			return res;
		}
	}
}
