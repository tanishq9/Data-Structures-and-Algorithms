package BST;

import BST.MORRIS_INORDER.Node;

public class MORRIS_PREORDER {
	static Node root;

	static Node fun(Node node) {
		Node lkram = node.left;
		while (lkram.right != null && lkram.right != node) {
			lkram = lkram.right;
		}
		return lkram;
	}

	// PRINT L R ( N L R )
	public static void main(String[] args) {
		Node node = root;
		while (node != null) {
			if (node.left != null) {
				Node lkram = fun(node);
				if (lkram.right == null) {
					// setting it for the first time
					System.out.println(node.data);
					lkram.right = node;
					node = node.left;
				} else if (lkram.right == node) {
					// it means we are again visiting the leftmost node
					lkram.right = null;
					node = node.right;
				}
			} else {
				System.out.println(node.data);
				node = node.right;
			}
		}
	}
}
