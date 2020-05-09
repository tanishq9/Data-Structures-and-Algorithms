package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class EXHAUSTIVE_PATTERN_BOUNDARY_TRAVERSAL {
	class TreeNode {
		TreeNode left, right;
		int data;

		TreeNode(int d) {
			data = d;
			left = right = null;
		}

	}

	class BinaryTree {
		List<Integer> list = null;

		public List<Integer> boundaryOfBinaryTree(TreeNode root) {
			list = new ArrayList<>();
			list.add(root.data);
			leftView(root.left);
			leafs(root);
			rightView(root.right);
			return list;
		}

		// Follow exhaustive pattern
		void leftView(TreeNode root) {
			if (root == null) {
				return;
			}
			if (root.left == null && root.right == null) {
				// Don't print leaf node here
			} else if (root.left != null && root.right != null) {
				// Print in pre order
				list.add(root.data);
				leftView(root.left);
			} else if (root.left != null) {
				// Print in pre order
				list.add(root.data);
				leftView(root.left);
			} else if (root.right != null) {
				// Print in pre order
				list.add(root.data);
				leftView(root.right);
			} else {
				// Nothing
			}
		}

		void leafs(TreeNode root) {
			if (root == null) {
				return;
			}
			if (root.left == null && root.right == null) {
				list.add(root.data);
			}
			leafs(root.left);
			leafs(root.right);
		}

		void rightView(TreeNode root) {
			if (root == null) {
				return;
			}
			if (root.left == null && root.right == null) {
				// Nothing
			} else if (root.left != null && root.right != null) {
				rightView(root.right);
				// Print in post order
				list.add(root.data);
			} else if (root.left != null) {
				rightView(root.left);
				// Print in post order
				list.add(root.data);
			} else if (root.right != null) {
				rightView(root.right);
				// Print in post order
				list.add(root.data);
			} else {
				// Nothing
			}

		}
	}
}