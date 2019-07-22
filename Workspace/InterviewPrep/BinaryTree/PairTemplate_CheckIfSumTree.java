package BinaryTree;

public class PairTemplate_CheckIfSumTree {
	class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	class ST {
		int sum;
		boolean isST;
	}

	boolean isSumTree(Node node) {
		return helper(node).isST;
	}

	ST helper(Node node) {
		if (node == null) {
			ST base = new ST();
			base.sum = 0;
			base.isST = true;
			return base;
		}
		if (node.left == null && node.right == null) {
			ST base = new ST();
			base.sum = node.data;
			base.isST = true;
			return base;
		}
		ST left = helper(node.left);
		ST right = helper(node.right);
		// work done in post order
		ST parent = new ST();
		parent.sum = left.sum + right.sum + node.data;
		parent.isST = (left.isST == true && right.isST == true && (left.sum + right.sum) == node.data);
		return parent;
	}
}
