package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ITERATIVE_Inorder_Print {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	class Solution {
		public List<Integer> inorderTraversal(TreeNode root) {
			List<Integer> list = new ArrayList<>();
			Stack<TreeNode> stack = new Stack<>();
			// left node right : In-order sequence
			while (stack.size() > 0 || root != null) {
				while (root != null) {
					stack.push(root);
					root = root.left; // go to the extreme left
				}
				root = stack.pop();
				list.add(root.val);
				root = root.right; // now go the right of the node popped as it can be parent as well
			}
			return list;
		}
	}
}
