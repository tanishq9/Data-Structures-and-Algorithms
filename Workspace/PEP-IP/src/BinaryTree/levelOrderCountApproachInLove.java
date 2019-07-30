package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class levelOrderCountApproachInLove {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	class Solution {
		public List<List<Integer>> levelOrder(TreeNode root) {
			List<List<Integer>> result = new ArrayList<>();
			if (root == null) {
				return result;
			}
			LinkedList<TreeNode> queue = new LinkedList<>();
			queue.add(root);
			while (queue.size() > 0) {
				int count = queue.size();
				List<Integer> temp = new ArrayList<>();
				while (count-- > 0) {
					TreeNode front = queue.removeFirst();
					// add to the list
					temp.add(front.val);
					if (front.left != null) {
						queue.addLast(front.left);
					}
					if (front.right != null) {
						queue.addLast(front.right);
					}
				}
				result.add(temp);
			}
			return result;
		}
	}
}
