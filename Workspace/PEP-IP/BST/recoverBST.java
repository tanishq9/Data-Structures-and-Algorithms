package BST;

import java.util.ArrayList;

public class recoverBST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public void recoverTree(TreeNode root) {
		ArrayList<Integer> nums = new ArrayList<>();
		inorder(root, nums);
		int x = -1, y = -1;
		for (int i = 0; i < nums.size() - 1; i++) {
			if (nums.get(i + 1) < nums.get(i)) {
				y = nums.get(i + 1);
				if (x == -1) {
					x = nums.get(i);
				}
			}
		}

		recover(root, x, y);

	}

	void recover(TreeNode root, int x, int y) {
		if (root == null) {
			return;
		}
		if (root.val == x) {
			root.val = y;
		} else if (root.val == y) {
			root.val = x;
		}
		recover(root.left, x, y);
		recover(root.right, x, y);
	}

	void inorder(TreeNode node, ArrayList<Integer> nums) {
		if (node == null) {
			return;
		}
		inorder(node.left, nums);
		nums.add(node.val);
		inorder(node.right, nums);
	}
}