package BinaryTree;

public class imageMultiplication {
	class TreeNode {
		TreeNode left, right;
		int data;

		TreeNode(int d) {
			data = d;
			left = right = null;
		}

	}

	int ans = 0;

	public int imagemultiplication(TreeNode node) {
		ans = 0;
		return node.data * node.data + ans;
	}

	void helper(TreeNode node1, TreeNode node2) {
		ans += node1.data * node2.data;
		if (node1 != null && node2 != null) {
			helper(node1.left, node2.right);
			helper(node1.right, node2.left);
		}
	}
}
