package BinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ITERATIVE_Inorder_Closest_K_values {

	class TreeNode {
		TreeNode left, right;
		int data;

		TreeNode(int d) {
			data = d;
			left = right = null;
		}

	}

	public List<Integer> closestKValues(TreeNode root, double target, int k) {
		Stack<TreeNode> stack = new Stack<>();
		LinkedList<Integer> queue = new LinkedList<>();
		while (stack.size() > 0 || root != null) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if (queue.size() < k) {
				queue.addLast(root.data);
			} else {
				// Train jaise soch
				// aage vale ko lagana better hai kya? at the expense of the
				// the front vala banda
				float diffWithFirst = (float) Math.abs(queue.getFirst() - target);
				float diffWithPotentialLast = (float) Math.abs(root.data - target);
				if (diffWithFirst > diffWithPotentialLast) {
					queue.removeFirst();
					queue.addLast(root.data);
				} else {
					break; // if this cannot displace first node then
					// values which are greater than this obviously will never
				}
			}
			root = root.right;
		}
		return (List<Integer>) queue;
	}

}
