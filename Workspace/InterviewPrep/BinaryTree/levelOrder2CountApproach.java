package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class levelOrder2CountApproach {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	class Solution {
		public List<List<Integer>> levelOrderBottom(TreeNode root) {
			List<List<Integer>> result = new ArrayList<>();
			if (root == null) {
				return result;
			}
			LinkedList<TreeNode> queue = new LinkedList<>();
			Stack<List<Integer>> stack = new Stack<>();
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
				stack.push(temp);
			}
			while (stack.size() > 0) {
				result.add(stack.pop());
			}
			return result;
		}
	}
}
